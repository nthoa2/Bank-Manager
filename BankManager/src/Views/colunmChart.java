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

public class colunmChart
        extends JFXPanel
{
    private double received = 3000;
    private double spending = 3500;


    public BarChart createChart()
    {

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("vnd");
        XYChart.Series dataSpendingSeries = new XYChart.Series();
        dataSpendingSeries.setName("Chi Ra");
        dataSpendingSeries.getData().add((Object) new XYChart.Data((Object) "Chi ra", (Object) (this.spending)));
        XYChart.Series dataReceivedSeries = new XYChart.Series();
        dataReceivedSeries.setName("Nhận Vào");
        dataReceivedSeries.getData().add((Object) new XYChart.Data((Object) "Nhận vào", (Object) this.received));
        BarChart chart = new BarChart((Axis) xAxis, (Axis) yAxis);
        chart.getData().addAll(new Object[]{dataSpendingSeries});
        chart.getData().addAll(new Object[]{dataReceivedSeries});
        return chart;
    }

    private Scene createScene()
    {
        BorderPane root = new BorderPane();
        Scene scene = new Scene((Parent) root, (Paint) Color.ALICEBLUE);
        root.setCenter((Node) this.createChart());
        return scene;
    }

    public colunmChart()
    {
        this.setScene(this.createScene());
        this.setFont(new Font("Open Sans", Font.BOLD, 20));
        this.setBorder(new TitledBorder(new EtchedBorder(1, null, null), "Tổng Thu Chi Trong Tháng ", TitledBorder.CENTER, TitledBorder.TOP, new Font("Open Sans", Font.PLAIN, 16), new java.awt.Color(0, 0, 0)));
    }
}
