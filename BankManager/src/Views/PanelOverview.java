package Views;

import Controller.LoginController;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class PanelOverview extends JPanel {
    public static JLabel accountBalanceLabelValue;
    static JLabel totalSpendingValue;
    static JLabel totalReceivedValue;
    private ColumnChartPanel barChart;
    private LineGraphPanel lineChart;


    private JPanel northPanel() {
        JPanel rootPanel = new LinearGradient(1);
        rootPanel.setPreferredSize(new Dimension(50, 70));
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
        rootPanel.setLayout(overViewPanelLayout);
        JLabel panelTitle = new JLabel("Tổng Quan");
        panelTitle.setIconTextGap(0);
        panelTitle.setHorizontalAlignment(0);
        panelTitle.setFont(new Font("Open Sans", Font.BOLD, 29));
        panelTitle.setAlignmentX(1.0f);
        GridBagConstraints TitleConstraints = new GridBagConstraints();
        TitleConstraints.anchor = GridBagConstraints.CENTER;
        TitleConstraints.weightx = 1;
        TitleConstraints.weighty = 1;
        TitleConstraints.fill = GridBagConstraints.HORIZONTAL;
        TitleConstraints.gridwidth = 2;
        TitleConstraints.ipadx = 50;
        TitleConstraints.insets = new Insets(0, 0, 5, 5);
        TitleConstraints.gridx = 0;
        TitleConstraints.gridy = 0;
        rootPanel.add((Component) panelTitle, TitleConstraints);

        return rootPanel;
    }

    private JPanel centerPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 3, 5, 5));

        JPanel accountBalancePanel = new RadiusAndShadow();
        accountBalancePanel.setBackground(Color.WHITE);
        accountBalancePanel.setLayout(new BorderLayout(0, 0));
        JLabel accountBalanceLabelTitle = new JLabel("Số Dư Hiện Tại");
        accountBalanceLabelTitle.setVerticalTextPosition(3);
        accountBalanceLabelTitle.setIconTextGap(15);
        accountBalanceLabelTitle.setIcon(new ImageIcon("src/Res/monney.png"));
        accountBalanceLabelTitle.setBackground(Color.WHITE);
        accountBalanceLabelTitle.setHorizontalAlignment(0);
        accountBalanceLabelTitle.setFont(new Font("Open Sans", Font.PLAIN, 18));
        accountBalancePanel.add((Component)accountBalanceLabelTitle, "South");
        accountBalanceLabelValue = new JLabel(LoginController.balance);
        accountBalanceLabelValue.setHorizontalAlignment(0);
        accountBalanceLabelValue.setFont(new Font("Open Sans", Font.PLAIN, 20));
        accountBalancePanel.add((Component)accountBalanceLabelValue, "Center");

        JPanel totalSpendingPanel = new RadiusAndShadow();
        totalSpendingPanel.setBackground(Color.WHITE);
        totalSpendingPanel.setLayout(new BorderLayout(0, 0));
        JLabel totalSpendingTitle = new JLabel("Tổng Chi Trong Tháng");
        totalSpendingTitle.setFont(new Font("Arial", 0, 18));
        totalSpendingTitle.setVerticalTextPosition(3);
        totalSpendingTitle.setIcon(new ImageIcon("src/Res/monney.png"));
        totalSpendingTitle.setIconTextGap(15);
        totalSpendingTitle.setHorizontalTextPosition(4);
        totalSpendingTitle.setHorizontalAlignment(0);
        totalSpendingPanel.add((Component)totalSpendingTitle, "South");
        totalSpendingValue = new JLabel("0");
        totalSpendingValue.setHorizontalAlignment(0);
        totalSpendingValue.setFont(new Font("Arial", Font.PLAIN, 20));
        totalSpendingPanel.add((Component)totalSpendingValue, "Center");

        JPanel totalReceivedPanel = new RadiusAndShadow();
        totalReceivedPanel.setBackground(Color.WHITE);
        totalReceivedPanel.setLayout(new BorderLayout(0, 5));
        JLabel totalReceivedTitle = new JLabel("Tổng Thu Trong Tháng");
        totalReceivedTitle.setIcon(new ImageIcon("src/Res/monney.png"));
        totalReceivedTitle.setVerticalTextPosition(3);
        totalReceivedTitle.setVerticalAlignment(3);
        totalReceivedTitle.setIconTextGap(15);
        totalReceivedTitle.setHorizontalAlignment(0);
        totalReceivedTitle.setFont(new Font("Open Sans", Font.PLAIN, 18));
        totalReceivedPanel.add((Component)totalReceivedTitle, "South");
        totalReceivedValue = new JLabel("0");
        totalReceivedValue.setHorizontalAlignment(0);
        totalReceivedValue.setFont(new Font("Open Sans", Font.PLAIN, 20));
        totalReceivedPanel.add((Component)totalReceivedValue, "Center");


        mainPanel.add(accountBalancePanel);
        mainPanel.add(totalSpendingPanel);
        mainPanel.add(totalReceivedPanel);
        return mainPanel;
    }

    private JPanel southPanel() {
        JPanel mainPanel = new JPanel();
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
        mainPanel.setLayout(panelLayout);
        GridBagConstraints gbcLineChart = new GridBagConstraints();
        gbcLineChart.gridwidth = 3;
        gbcLineChart.ipady = 5;
        gbcLineChart.ipadx = 5;
        gbcLineChart.fill = 1;
        gbcLineChart.insets = new Insets(0, 0, 5, 0);
        gbcLineChart.gridx = 0;
        gbcLineChart.gridy = 0;
        this.lineChart = new LineGraphPanel();
        mainPanel.add((Component) ((Object) this.lineChart), gbcLineChart);
        GridBagConstraints gbcBarChart = new GridBagConstraints();
        gbcBarChart.fill = 1;
        gbcBarChart.insets = new Insets(0, 0, 5, 5);
        gbcBarChart.gridx = 0;
        gbcBarChart.gridy = 1;
        mainPanel.add((Component) ((Object) this.barChart), gbcBarChart);


        JPanel recentTransactionsPanel = new JPanel();
        recentTransactionsPanel.setBorder(new TitledBorder(new EtchedBorder(1, null, null), "Giao Dịch Gần Đây", TitledBorder.CENTER, TitledBorder.TOP, new Font("Open Sans", Font.PLAIN, 16), null));
        recentTransactionsPanel.setLayout(new BorderLayout(0, 0));
        recentTransactionsPanel.setPreferredSize(new Dimension(100, 265));
        JTable recentTransactionsTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(recentTransactionsTable);
        recentTransactionsPanel.add(scrollPane);
        recentTransactionsTable.setFillsViewportHeight(true);
        recentTransactionsTable.setSelectionMode(0);
        recentTransactionsTable.setFont(new Font("Open Sans", Font.PLAIN, 12));
        recentTransactionsTable.setModel(new DefaultTableModel(new Object[0][], new String[]{"Người Nhận/Chuyển", "Nội Dung", "Số Tiền"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        recentTransactionsTable.getColumnModel().getColumn(0).setPreferredWidth(70);
        recentTransactionsTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        recentTransactionsTable.getColumnModel().getColumn(2).setPreferredWidth(70);
        recentTransactionsTable.setRowHeight(30);
        recentTransactionsTable.getColumn("Nội Dung").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public void setHorizontalAlignment(int alignment) {
                super.setHorizontalAlignment(SwingConstants.CENTER);
            }
        });
        recentTransactionsTable.getColumn("Số Tiền").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public void setHorizontalAlignment(int alignment) {
                super.setHorizontalAlignment(SwingConstants.RIGHT);
            }
        });
        JTableHeader headerTable = recentTransactionsTable.getTableHeader();
        headerTable.setFont(new Font("Open Sans", Font.BOLD, 13));
        headerTable.setBackground(new Color(240, 240, 240));
        headerTable.setOpaque(true);
        headerTable.setAlignmentY(SwingConstants.CENTER);
        headerTable.setPreferredSize(new Dimension(50, 25));
        GridBagConstraints gbcRecentTransactions = new GridBagConstraints();
        gbcRecentTransactions.gridwidth = 2;
        gbcRecentTransactions.insets = new Insets(0, 5, 5, 0);
        gbcRecentTransactions.fill = 1;
        gbcRecentTransactions.gridx = 1;
        gbcRecentTransactions.gridy = 1;
        mainPanel.add(recentTransactionsPanel, gbcRecentTransactions);

        return mainPanel;
    }

    public PanelOverview() {
        System.out.println("Lần nữa");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        mainPanel.add((Component) this.northPanel(), "North");
        mainPanel.add((Component) this.centerPanel(), "Center");
        this.barChart = new ColumnChartPanel();
        mainPanel.add((Component) this.southPanel(), "South");
        this.add((Component) scrollPane, "Center");
    }
}
