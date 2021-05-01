/**
 * Copyright 2006, 2007
 * Dirk Lemmermann Software & Consulting
 * http://www.dlsc.com
 */
package com.dlsc.flexgantt.examples.jumpstart;

import com.dlsc.flexgantt.model.TimeSpan;
import com.dlsc.flexgantt.model.gantt.DefaultGanttChartModel;
import com.dlsc.flexgantt.model.gantt.DefaultGanttChartNode;
import com.dlsc.flexgantt.model.gantt.DefaultTimelineObject;
import com.dlsc.flexgantt.model.gantt.ILayer;
import com.dlsc.flexgantt.model.gantt.Layer;
import com.dlsc.flexgantt.model.treetable.DefaultColumnModel;
import com.dlsc.flexgantt.swing.GanttChart;
import com.dlsc.flexgantt.swing.GanttChartFrame;
import com.dlsc.flexgantt.swing.treetable.TreeTable;

import javax.swing.JFrame;
import javax.swing.tree.TreePath;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * One of the steps used for the 'Jumpstart' tutorial. The step will create a
 * new column model for the Gantt chart and add a couple of columns to it.
 * 
 * @author Dirk Lemmermann
 */
public class Step5_Column_Model {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Create a basic Gantt chart, which will use the default Gantt chart
		 * model. The default model itself will use the default Gantt chart node
		 * as a root object.
		 */
		GanttChart gc = new GanttChart();

		/*
		 * Retrieve the default model and node from the Gantt chart.
		 */
		DefaultGanttChartModel model = (DefaultGanttChartModel) gc.getModel();
		DefaultGanttChartNode root = (DefaultGanttChartNode) model.getRoot();

		/*
		 * Create a single timeline object, add it to the root node, and set its
		 * time span in such a way that it begins one week after the model
		 * starts and ends after 14 days.
		 */
		TimeSpan span = (TimeSpan) gc.getTimeSpan();
		Calendar start = span.getStartCalendar(TimeZone.getDefault());
		start.add(Calendar.DAY_OF_YEAR, 7); // one week after model starts
		Calendar end = span.getStartCalendar(TimeZone.getDefault());
		end.add(Calendar.DAY_OF_YEAR, 21); // fourteen days later
		DefaultTimelineObject<String> tlo = new DefaultTimelineObject<String>(
				"Root TLO", new TimeSpan(start, end));
		ILayer layer = new Layer("My Layer");
		model.addLayer(layer);
		root.addTimelineObject(layer, tlo);

		/*
		 * Add new nodes to the model and trigger an event so that the UI will
		 * update its state.
		 */
		DefaultGanttChartNode node1 = new DefaultGanttChartNode("Node 1");
		DefaultGanttChartNode node2 = new DefaultGanttChartNode("Node 2");
		DefaultGanttChartNode node3 = new DefaultGanttChartNode("Node 3");
		node1.setKey("Key 1");
		node2.setKey("Key 2");
		node3.setKey("Key 3");
		root.add(node1);
		root.add(node2);
		root.add(node3);
		model.nodeStructureChanged(root); // the event

		/*
		 * Add more nodes to node2.
		 */
		DefaultGanttChartNode node21 = new DefaultGanttChartNode("Node 21");
		DefaultGanttChartNode node22 = new DefaultGanttChartNode("Node 22");
		DefaultGanttChartNode node23 = new DefaultGanttChartNode("Node 23");
		DefaultGanttChartNode node24 = new DefaultGanttChartNode("Node 24");
		DefaultGanttChartNode node25 = new DefaultGanttChartNode("Node 25");
		node21.setKey("Key 21");
		node22.setKey("Key 22");
		node23.setKey("Key 23");
		node24.setKey("Key 24");
		node25.setKey("Key 25");
		node2.add(node21);
		node2.add(node22);
		node2.add(node23);
		node2.add(node24);
		node2.add(node25);
		model.nodeStructureChanged(node2); // another event

		/*
		 * Create a new column model. Initialize it with 
		 */
		DefaultColumnModel colModel = new DefaultColumnModel(new String[] {
				"Start", "End" });
		gc.setColumnModel(colModel);
		root.setColumnValue(span.getStartDate(), 0);
		root.setColumnValue(span.getEndDate(), 1);

		/*
		 * Make sure that the children of node2 are also initially visible.
		 */
		TreePath path = new TreePath(new Object[] { root, node2 });
		TreeTable table = gc.getTreeTable();
		table.expandPath(path);
		gc.optimizeColumnWidth(-1);
		
		/*
		 * Add the Gantt chart to a specialized frame class. The frame will
		 * automatically add a status bar and a glass pane (used for updating
		 * the cursor when commands get executed).
		 */
		GanttChartFrame<GanttChart> frame = new GanttChartFrame<GanttChart>(
				"Step 5", gc);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * Show the frame. The split panel inside the Gantt chart will adjust to
		 * the preferred size of the left-hand side (the tree table).
		 */
		frame.setVisible(true);
		gc.resetToPreferredSizes();
	}
}
