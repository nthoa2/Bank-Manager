package Views;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ColumnChartPanel
        extends JFXPanel
{



    public BarChart createChart(double spending, double receives)
    {

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("vnd");
        XYChart.Series dataSpendingSeries = new XYChart.Series();
        dataSpendingSeries.setName("Spending");
        dataSpendingSeries.getData().add((Object) new XYChart.Data((Object) "Spending", (Object) (spending)));
        XYChart.Series dataReceivedSeries = new XYChart.Series();
        dataReceivedSeries.setName("Received");
        dataReceivedSeries.getData().add((Object) new XYChart.Data((Object) "Received", (Object) receives));
        BarChart chart = new BarChart((Axis) xAxis, (Axis) yAxis);
        chart.getData().addAll(new Object[]{dataSpendingSeries});
        chart.getData().addAll(new Object[]{dataReceivedSeries});
        return chart;
    }

    private Scene createScene(double spending, double receives)
    {
        BorderPane root = new BorderPane();
        Scene scene = new Scene((Parent) root, (Paint) Color.ALICEBLUE);
        root.setCenter((Node) this.createChart(spending, receives));
        return scene;
    }

    public ColumnChartPanel(double spending, double receives)
    {
        this.setScene(this.createScene(spending, receives));
        this.setFont(new Font("Open Sans", Font.BOLD, 20));
        this.setBorder(new TitledBorder(new EtchedBorder(1, null, null), "Total receive and spend in month", TitledBorder.CENTER, TitledBorder.TOP, new Font("Open Sans", Font.PLAIN, 16), new java.awt.Color(0, 0, 0)));
    }
}
