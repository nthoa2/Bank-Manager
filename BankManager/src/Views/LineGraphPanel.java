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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LineGraphPanel
        extends JFXPanel {
    private int d1 = 1;
    private int m1 = 5;
    private int y1 = 2021;
    private int d2 = 5;
    private int m2 = 6;
    private int y2 = 2021;


    private LineChart createChart() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("vnd");
        LineChart lineChart = new LineChart((Axis)xAxis, (Axis)yAxis);
        XYChart.Series spendingSeries = new XYChart.Series();
        spendingSeries.setName("Chi Tiêu");
        XYChart.Series receivedSeries = new XYChart.Series();
        receivedSeries.setName("Nhận Vào");
        SimpleDateFormat simple = new SimpleDateFormat("d/M/yy");
        String startDay = String.valueOf(this.d1) + "/" + this.m1 + "/" + this.y1;
        String endDay = String.valueOf(this.d2) + "/" + this.m2 + "/" + this.y2;
        Calendar calendar = Calendar.getInstance();
        long totalDays = 0L;
        try {
            Date startDayFormat = simple.parse(startDay);
            Date endDayFormat = simple.parse(endDay);
            totalDays = endDayFormat.getTime() - startDayFormat.getTime();
            totalDays = totalDays / 1000L / 60L / 60L / 24L;
            calendar.setTime(startDayFormat);
            long i = 0;
            while (i <= totalDays) {
                int day = calendar.get(Calendar.DATE);
                int month = calendar.get(Calendar.MONTH) + 1;
                int year = calendar.get(Calendar.YEAR);
                double Spending = 1000; // đổ dữ liệu
                spendingSeries.getData().add((Object)new XYChart.Data((Object)simple.format(calendar.getTime()), (Object)Spending));
                double receives = 3000;// đổ dữ liệu
                receivedSeries.getData().add((Object)new XYChart.Data((Object)simple.format(calendar.getTime()), (Object)receives));
                calendar.add(Calendar.DATE, 1);
                ++i;
            }
        }
        catch (ParseException parseException) {
            System.out.println(parseException.getMessage());
        }
        lineChart.getData().addAll((Object[])new XYChart.Series[]{spendingSeries, receivedSeries});
        return lineChart;
    }

    private Scene createScene() {
        BorderPane root = new BorderPane();
        Scene scene = new Scene((Parent)root, (Paint)Color.ALICEBLUE);
        root.setCenter((Node)this.createChart());
        return scene;
    }

    public LineGraphPanel() {
        this.setScene(this.createScene());
        this.setFont(new Font("Open Sans", Font.BOLD, 20));
        this.setBorder(new TitledBorder(new EtchedBorder(1, null, null), "Biến Động Thu Chi Trong Tháng", TitledBorder.CENTER, TitledBorder.TOP, new Font("Open Sans", Font.PLAIN, 16), new java.awt.Color(0, 0, 0)));
    }
}