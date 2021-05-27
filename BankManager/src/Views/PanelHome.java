package Views;

import javax.swing.*;
import java.awt.*;

<<<<<<< HEAD
public class PanelHome extends JPanel {
    private JLabel panelTitle;
    private _Statistics statistics;
    private colunmChart barChart;
    private JPanel panel_South;
    private lineChart lineChart;


    private JPanel panel_north() {
        JPanel overViewPanel = new JPanel();
        overViewPanel.setPreferredSize(new Dimension(50, 70));
        GridBagLayout overViewPanelLayout = new GridBagLayout();
        int[] columnWidths = new int[5];
        columnWidths[0] = 34;
        columnWidths[1] = 238;
        overViewPanelLayout.columnWidths = columnWidths;
        int[] rowHeights = new int[5];
        rowHeights[0] = 29;
        overViewPanelLayout.rowHeights = rowHeights;
        overViewPanelLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        overViewPanelLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        overViewPanel.setLayout(overViewPanelLayout);

        this.panelTitle = new JLabel("Tổng Quan");
        this.panelTitle.setFont(new Font("Open Sans", Font.BOLD, 29));

        JPanel panelText = new JPanel();
        panelText.add(panelTitle);

        GridBagConstraints TitleConstraints = new GridBagConstraints();
        TitleConstraints.weighty = 0.1;
        TitleConstraints.weightx = 0.1;
        TitleConstraints.fill = GridBagConstraints.BOTH;
        TitleConstraints.gridwidth = 2;
        TitleConstraints.ipadx = 50;
        TitleConstraints.insets = new Insets(0, 20, 5, 5);
        TitleConstraints.gridx = 0;
        TitleConstraints.gridy = 1;
        overViewPanel.add((Component)panelText, TitleConstraints);

        return overViewPanel;
    }

    private JPanel panel_center() {
        this.statistics = new _Statistics();
        return this.statistics;
    }

    private JPanel panel_south() {
        this.panel_South = new JPanel();
        GridBagLayout panelLayout = new GridBagLayout();
        int[] columnWidths = new int[3];
        columnWidths[0] = 453;
        columnWidths[1] = 453;
        panelLayout.columnWidths = columnWidths;
        int[] rowHeights = new int[4];
        rowHeights[0] = 249;
        rowHeights[1] = 249;
        panelLayout.rowHeights = rowHeights;
        panelLayout.columnWeights = new double[]{1.0, 0.0, 1.0};
        panelLayout.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
        this.panel_South.setLayout(panelLayout);
        GridBagConstraints gbcLineChart = new GridBagConstraints();
        gbcLineChart.gridwidth = 3;
        gbcLineChart.ipady = 5;
        gbcLineChart.ipadx = 5;
        gbcLineChart.fill = 1;
        gbcLineChart.insets = new Insets(0, 0, 5, 0);
        gbcLineChart.gridx = 0;
        gbcLineChart.gridy = 0;
        this.lineChart = new lineChart();
        this.panel_South.add((Component)((Object)this.lineChart), gbcLineChart);
        GridBagConstraints gbcBarChart = new GridBagConstraints();
        gbcBarChart.fill = 1;
        gbcBarChart.insets = new Insets(0, 0, 5, 5);
        gbcBarChart.gridx = 0;
        gbcBarChart.gridy = 1;
        this.panel_South.add((Component)((Object)this.barChart), gbcBarChart);

        return this.panel_South;
    }

    public PanelHome() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        this.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        mainPanel.add((Component)this.panel_north(), "North");
        mainPanel.add((Component)this.panel_center(), "Center");
        this.barChart = new colunmChart();
        mainPanel.add((Component)this.panel_south(), "South");
        this.add((Component)scrollPane, "Center");
    }

// viett them ham update để khi cập nhật lại dư liêu thì tự động vẽ lại

    private void updateBarCharts() {
        this.panel_South.remove((Component)((Object)this.barChart));
        GridBagConstraints barChartConstraints = new GridBagConstraints();
        barChartConstraints.fill = 1;
        barChartConstraints.insets = new Insets(0, 0, 0, 5);
        barChartConstraints.gridx = 0;
        barChartConstraints.gridy = 1;
        this.barChart = new colunmChart();
        this.panel_South.add((Component)((Object)this.barChart), barChartConstraints);
    }

    private void updateLineChart() {
        this.panel_South.remove((Component)((Object)this.lineChart));
        GridBagConstraints lineChartConstraints = new GridBagConstraints();
        lineChartConstraints.gridwidth = 3;
        lineChartConstraints.ipady = 5;
        lineChartConstraints.ipadx = 5;
        lineChartConstraints.fill = 1;
        lineChartConstraints.insets = new Insets(0, 0, 5, 5);
        lineChartConstraints.gridx = 0;
        lineChartConstraints.gridy = 0;
        this.lineChart = new lineChart();
        this.panel_South.add((Component)((Object)this.lineChart), lineChartConstraints);
    }

=======
public class PanelHome extends JPanel
{
    public PanelHome()
    {
        this.setLayout(new BorderLayout(0,0));


        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));

        JPanel panelTitle = new RadiusAndShadow();
        panelTitle.setPreferredSize(new Dimension(200,70));
        panelTitle.setBackground(Color.WHITE);
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER,0,13));
        panelHeader.add(panelTitle);

        JLabel lblTitle = new JLabel();
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setText("WELCOME");
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
        panelTitle.add(lblTitle);

        this.add(panelHeader, "North");

        JPanel panelClock = new Clock(Color.WHITE);

        JPanel panelFooter = new JPanel();
        panelFooter.setLayout(new FlowLayout(FlowLayout.RIGHT,0,10));
        panelFooter.add(panelClock);

        this.add(panelFooter, "South");


        JPanel panelCenterMain = new JPanel();
        panelCenterMain.setLayout(new BorderLayout(10,0));
        panelCenterMain.add(new ScaleImg("/Res/img_home2.png"), "Center");
        panelCenterMain.setPreferredSize(new Dimension(150,0));
        this.add(panelCenterMain, "Center");

        this.add(new JPanel(), "East");



        JPanel panelNorth = new JPanel();
        panelNorth.setPreferredSize(new Dimension(100,20));
        panelCenterMain.add(panelNorth, "North");

        JPanel panelWest = new JPanel();
        panelWest.setPreferredSize(new Dimension(0,100));
        panelCenterMain.add(panelWest, "West");


        JPanel panelEast = new JPanel();
        panelEast.setLayout(new BoxLayout(panelEast, BoxLayout.Y_AXIS));
        panelEast.add(new ScaleImg("/Res/img_home1.png"));
        panelEast.add(Box.createRigidArea(new Dimension(0,10)));
        panelEast.add(new ScaleImg("/Res/img_home3.png"));
        panelCenterMain.add(panelEast, "East");
    }


>>>>>>> d2e46d3e0d2c5a129571a49107696bf933f86a89
}