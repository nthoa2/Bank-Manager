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

public class lineChart extends JFXPanel {

    public lineChart(){
        this.setScene(this.createScene());
        this.setFont(new Font("Open Sans", Font.BOLD, 20));
        this.setBorder(new TitledBorder(new EtchedBorder(1, null, null), "Biêu Đồ", TitledBorder.LEADING, TitledBorder.TOP, new Font("Open Sans", Font.PLAIN, 16), new java.awt.Color(0, 0, 0)));
    }

    private LineChart createChart() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("vnd");
        LineChart lineChart = new LineChart(xAxis, yAxis);
        XYChart.Series series = new XYChart.Series();
        series.setName("Chi Tiêu");
        SimpleDateFormat simple = new SimpleDateFormat("d/M/yy");
        int d1 = 1;
        int m1 = 5;
        int y1 = 2021;
        String ngay1 = String.valueOf(d1) + "/" + m1 + "/" + y1;
        int d2 = 30;
        int m2 = 6;
        int y2 = 2021;
        String ngay2 = String.valueOf(d2) + "/" + m2 + "/" + y2;
        Calendar calendar = Calendar.getInstance();
        long tongngay = 0L;
        try {
            Date date1 = simple.parse(ngay1);
            Date date2 = simple.parse(ngay2);
            tongngay = date2.getTime() - date1.getTime();
            tongngay = tongngay / 1000L / 60L / 60L / 24L;
            calendar.setTime(date1);
            int i = 0;
            while ((long) i <= tongngay) {
                int d = calendar.get(5);
                int m = calendar.get(2) + 1;
                int y = calendar.get(1);
                double doanhthu = 100000;
                series.getData().add((Object) new XYChart.Data((Object) simple.format(calendar.getTime()), (Object) doanhthu));
                calendar.add(Calendar.DATE, 1);
                ++i;
            }
        } catch (ParseException parseException) {
            System.out.println(parseException.getMessage());
        }
        lineChart.getData().addAll((Object[]) new XYChart.Series[]{series});
        return lineChart;
    }

    private Scene createScene() {
        BorderPane root = new BorderPane();
        Scene scene = new Scene((Parent)root, (Paint) Color.ALICEBLUE);
        root.setCenter((Node)this.createChart());
        return scene;
    }

}
