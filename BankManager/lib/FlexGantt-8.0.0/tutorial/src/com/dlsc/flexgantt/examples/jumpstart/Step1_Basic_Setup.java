/**
 * Copyright 2006, 2007
 * Dirk Lemmermann Software & Consulting
 * http://www.dlsc.com
 */
package com.dlsc.flexgantt.examples.jumpstart;

import com.dlsc.flexgantt.swing.GanttChart;
import com.dlsc.flexgantt.swing.GanttChartFrame;

import javax.swing.JFrame;

/**
 * One of the steps used for the 'Jumpstart' tutorial. The step will create a
 * basic Gantt chart. The chart will be populated with a default model and a
 * single default node, which displays a default value as its key.
 * 
 * @author Dirk Lemmermann
 */
public class Step1_Basic_Setup {

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
		 * Add the Gantt chart to a specialized frame class. The frame will
		 * automatically add a status bar and a glass pane (used for updating
		 * the cursor when commands get executed).
		 */
		GanttChartFrame<GanttChart> frame = new GanttChartFrame<GanttChart>(
				"Step 1", gc);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * Show the frame. The split panel inside the Gantt chart will adjust to
		 * the preferred size of the left-hand side (the tree table).
		 */
		frame.setVisible(true);
	}
}
