package Views;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class LineGraphPanel
        extends JFXPanel {
    private LocalDate today = LocalDate.now();
    private LocalDate lastDay = today.minusDays(30);

    private javafx.scene.chart.LineChart createChart() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("vnd");
        javafx.scene.chart.LineChart lineChart = new javafx.scene.chart.LineChart((Axis)xAxis, (Axis)yAxis);
        XYChart.Series spendingSeries = new XYChart.Series();
        spendingSeries.setName("Chi Tiêu");
        XYChart.Series receivedSeries = new XYChart.Series();
        receivedSeries.setName("Nhận Vào");
        SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy");
        String startDay = lastDay.getDayOfMonth() + "/" + lastDay.getMonthValue() + "/" + lastDay.getYear();
        String endDay = today.getDayOfMonth() + "/" + today.getMonthValue() + "/" + today.getYear();
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
        this.setBorder(new TitledBorder(new EtchedBorder(1, null, null), "Biến Động Thu Chi Trong Tháng", TitledBorder.LEADING, TitledBorder.TOP, new Font("Open Sans", Font.PLAIN, 16), new java.awt.Color(0, 0, 0)));
    }
}
