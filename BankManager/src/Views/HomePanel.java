package Views;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class HomePanel extends JPanel {

    private JLabel titleLabel;


    public HomePanel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Look and Feel not set");
        }
        this.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        mainPanel.add(this.northPanel(), "North");
        mainPanel.add(this.centerPanel(), "Center");
        mainPanel.add(this.southPanel(), "South");

        this.add((Component) mainPanel, "Center");
    }


    private JPanel northPanel() {
        JPanel overviewPanel = new JPanel();
        overviewPanel.setPreferredSize(new Dimension(50, 60));
        overviewPanel.setAlignmentY(SwingConstants.CENTER);
        GridBagLayout overviewPanelLayout = new GridBagLayout();
        int[] columnWidths = new int[5];
        columnWidths[0] = 34;
        columnWidths[1] = 238;
        overviewPanelLayout.columnWidths = columnWidths;

        int[] rowHeights = new int[5];
        rowHeights[0] = 29;
        overviewPanelLayout.rowHeights = rowHeights;
        overviewPanelLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        overviewPanelLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        overviewPanel.setLayout(overviewPanelLayout);

        this.titleLabel = new JLabel("OverView");
        this.titleLabel.setFont(new Font("Open Sans", 1, 20));
        this.titleLabel.setForeground(Color.BLACK);
        this.titleLabel.setIconTextGap(0);
        this.titleLabel.setHorizontalAlignment(0);
        this.titleLabel.setAlignmentX(1.0f);
        GridBagConstraints gbc_titleLabel = new GridBagConstraints();
        gbc_titleLabel.anchor = 17;
        gbc_titleLabel.fill = 3;
        gbc_titleLabel.gridwidth = 2;
        gbc_titleLabel.ipadx = 50;
        gbc_titleLabel.insets = new Insets(0, 0, 5, 5);
        gbc_titleLabel.gridx = 0;
        gbc_titleLabel.gridy = 1;
        overviewPanel.add((Component) this.titleLabel, gbc_titleLabel);


        return overviewPanel;
    }


    private JPanel centerPanel() {
        accountInfo main = new accountInfo();
        main.showData();
        return main;
    }

    private JPanel southPanel() {
        JPanel mainPanel = new JPanel();
        GridBagLayout mainLayout = new GridBagLayout();
        int[] columnWidths = new int[3];
        columnWidths[0] = 453;
        columnWidths[1] = 453;
        mainLayout.columnWidths = columnWidths;
        int[] rowHeights = new int[4];
        rowHeights[0] = 249;
        rowHeights[1] = 249;
        mainLayout.rowHeights = rowHeights;
        mainLayout.columnWeights = new double[]{1.0, 0.0, 1.0};
        mainLayout.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};

        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.gridwidth = 3;
        gridConstraints.ipady = 5;
        gridConstraints.ipadx = 5;
        gridConstraints.fill = 1;
        gridConstraints.insets = new Insets(0, 0, 5, 0);
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        lineChart chart = new lineChart();
        mainPanel.add((Component) chart, gridConstraints);
        return mainPanel;
    }
}
