package Views;

import javax.swing.*;
import java.awt.*;

public class _HomePanel extends JPanel {
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
        this.panelTitle.setIconTextGap(0);
        this.panelTitle.setHorizontalAlignment(0);
        this.panelTitle.setFont(new Font("Open Sans", Font.BOLD, 29));
        this.panelTitle.setAlignmentX(1.0f);
        GridBagConstraints TitleConstraints = new GridBagConstraints();
        TitleConstraints.anchor = 17;
        TitleConstraints.fill = 3;
        TitleConstraints.gridwidth = 2;
        TitleConstraints.ipadx = 50;
        TitleConstraints.insets = new Insets(0, 0, 5, 5);
        TitleConstraints.gridx = 0;
        TitleConstraints.gridy = 1;
        overViewPanel.add((Component)this.panelTitle, TitleConstraints);

        return overViewPanel;
    }

    private JPanel panel_center() {
        this.statistics = new _Statistics();
        return this.statistics;
    }

    private JPanel panel_south() {
        this.panel_South = new JPanel();
        GridBagLayout gbl_panel_center = new GridBagLayout();
        int[] arrn = new int[3];
        arrn[0] = 453;
        arrn[1] = 453;
        gbl_panel_center.columnWidths = arrn;
        int[] arrn2 = new int[4];
        arrn2[0] = 249;
        arrn2[1] = 249;
        gbl_panel_center.rowHeights = arrn2;
        gbl_panel_center.columnWeights = new double[]{1.0, 0.0, 1.0};
        gbl_panel_center.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
        this.panel_South.setLayout(gbl_panel_center);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 3;
        gbc.ipady = 5;
        gbc.ipadx = 5;
        gbc.fill = 1;
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.lineChart = new lineChart();
        this.panel_South.add((Component)((Object)this.lineChart), gbc);
        GridBagConstraints gbc_1 = new GridBagConstraints();
        gbc_1.fill = 1;
        gbc_1.insets = new Insets(0, 0, 5, 5);
        gbc_1.gridx = 0;
        gbc_1.gridy = 1;
        this.panel_South.add((Component)((Object)this.barChart), gbc_1);

        return this.panel_South;
    }

    public _HomePanel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.out.println("Look and Feel not set");
        }
        this.setLayout(new BorderLayout());
        JPanel pn = new JPanel(new BorderLayout(10, 10));
        JScrollPane js = new JScrollPane(pn);
        js.getVerticalScrollBar().setUnitIncrement(10);
        pn.add((Component)this.panel_north(), "North");
        pn.add((Component)this.panel_center(), "Center");
        this.barChart = new colunmChart();
        pn.add((Component)this.panel_south(), "South");
        this.add((Component)js, "Center");
    }



    private void updateBarCharts() {
        this.panel_South.remove((Component)((Object)this.barChart));
        GridBagConstraints gbc_1 = new GridBagConstraints();
        gbc_1.fill = 1;
        gbc_1.insets = new Insets(0, 0, 0, 5);
        gbc_1.gridx = 0;
        gbc_1.gridy = 1;
        this.barChart = new colunmChart();
        this.panel_South.add((Component)((Object)this.barChart), gbc_1);
    }

    private void updateLineChart() {
        this.panel_South.remove((Component)((Object)this.lineChart));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 3;
        gbc.ipady = 5;
        gbc.ipadx = 5;
        gbc.fill = 1;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.lineChart = new lineChart();
        this.panel_South.add((Component)((Object)this.lineChart), gbc);
    }

}
