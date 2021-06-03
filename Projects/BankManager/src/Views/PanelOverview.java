package Views;

<<<<<<< HEAD:Projects/BankManager/src/Views/OverviewPanel.java
import Controller.AccountController;
import Controller.LoginController;
import Controller.TransactionsController;
import Controller.UserController;
import Model.Accounts;
import Model.User;
=======
import Controller.LoginController;
import Controller.TradingsController;
import Controller.UserController;
>>>>>>> Long:Projects/BankManager/src/Views/PanelOverview.java

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PanelOverview extends JPanel
{

<<<<<<< HEAD:Projects/BankManager/src/Views/OverviewPanel.java
public class OverviewPanel extends JPanel {
    public static double totalSpending = 0.0;
    public static double totalReceived = 0.0;
    private JLabel accountBalanceValue;
    private JTable recentTransactionsTable;
    private ColumnChartPanel barChart;
    private LineGraphPanel lineChart;
=======
    public static JLabel accountBalanceLabelValue;
    static JLabel totalSpendingValue;
    static JLabel totalReceivedValue;
    private ColumnChartPanel barChart;
    private LineGraphPanel lineChart;
    private JTable recentTransactionsTable;
>>>>>>> Long:Projects/BankManager/src/Views/PanelOverview.java

    private Image img_monney = new ImageIcon(PanelOverview.class.getResource("/Res/monney.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

    private JPanel northPanel()
    {
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
        JLabel panelTitle = new JLabel("Overview");
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

    private JPanel centerPanel()
    {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 3, 5, 5));

        JPanel accountBalancePanel = new RadiusAndShadow();
        accountBalancePanel.setBackground(Color.WHITE);
        accountBalancePanel.setLayout(new BorderLayout(0, 0));
<<<<<<< HEAD:Projects/BankManager/src/Views/OverviewPanel.java
        JLabel accountBalanceLabelTitle = new JLabel("Số Dư Hiện Tại");
        accountBalanceLabelTitle.setVerticalTextPosition(SwingConstants.CENTER);
=======
        JLabel accountBalanceLabelTitle = new JLabel("Balance");
        accountBalanceLabelTitle.setVerticalTextPosition(3);
>>>>>>> Long:Projects/BankManager/src/Views/PanelOverview.java
        accountBalanceLabelTitle.setIconTextGap(15);
        accountBalanceLabelTitle.setIcon(new ImageIcon(img_monney));
        accountBalanceLabelTitle.setBackground(Color.WHITE);
        accountBalanceLabelTitle.setHorizontalAlignment(0);
        accountBalanceLabelTitle.setFont(new Font("Open Sans", Font.PLAIN, 18));
<<<<<<< HEAD:Projects/BankManager/src/Views/OverviewPanel.java
        accountBalancePanel.add((Component) accountBalanceLabelTitle, "North");
        accountBalanceValue = new JLabel(UserController.BalanceFormat.format(UserController.AccountBalance) + "  VNĐ");
        accountBalanceValue.setHorizontalAlignment(0);
        accountBalanceValue.setFont(new Font("Open Sans", Font.PLAIN, 20));
        accountBalancePanel.add((Component) accountBalanceValue, "Center");
=======
        accountBalancePanel.add((Component) accountBalanceLabelTitle, "South");
        accountBalanceLabelValue = new JLabel(UserController.balance);
        accountBalanceLabelValue.setHorizontalAlignment(0);
        accountBalanceLabelValue.setFont(new Font("Open Sans", Font.PLAIN, 20));
        accountBalancePanel.add((Component) accountBalanceLabelValue, "Center");
>>>>>>> Long:Projects/BankManager/src/Views/PanelOverview.java

        JPanel totalSpendingPanel = new RadiusAndShadow();
        totalSpendingPanel.setBackground(Color.WHITE);
        totalSpendingPanel.setLayout(new BorderLayout(0, 0));
<<<<<<< HEAD:Projects/BankManager/src/Views/OverviewPanel.java
        JLabel totalSpendingTitle = new JLabel("Tổng Chi Trong Tháng");
        totalSpendingTitle.setFont(new Font("Arial", 0, 18));
        totalSpendingTitle.setVerticalTextPosition(SwingConstants.CENTER);
        totalSpendingTitle.setIcon(new ImageIcon("src/Res/monney.png"));
=======
        JLabel totalSpendingTitle = new JLabel("Total spend in month");
        totalSpendingTitle.setFont(new Font("Arial", 0, 18));
        totalSpendingTitle.setVerticalTextPosition(3);
        totalSpendingTitle.setIcon(new ImageIcon(img_monney));
>>>>>>> Long:Projects/BankManager/src/Views/PanelOverview.java
        totalSpendingTitle.setIconTextGap(15);
        totalSpendingTitle.setHorizontalTextPosition(SwingConstants.RIGHT);
        totalSpendingTitle.setHorizontalAlignment(0);
<<<<<<< HEAD:Projects/BankManager/src/Views/OverviewPanel.java
        totalSpendingPanel.add((Component) totalSpendingTitle, "North");
        JLabel totalSpendingValue = new JLabel(UserController.BalanceFormat.format(totalSpending) + "  VNĐ");
=======
        totalSpendingPanel.add((Component) totalSpendingTitle, "South");


        totalSpendingValue = new JLabel(String.format("%,.0f", TradingsController.totalSpendingValue));
>>>>>>> Long:Projects/BankManager/src/Views/PanelOverview.java
        totalSpendingValue.setHorizontalAlignment(0);
        totalSpendingValue.setFont(new Font("Arial", Font.PLAIN, 20));
        totalSpendingPanel.add((Component) totalSpendingValue, "Center");

        JPanel totalReceivedPanel = new RadiusAndShadow();
        totalReceivedPanel.setBackground(Color.WHITE);
        totalReceivedPanel.setLayout(new BorderLayout(0, 5));
<<<<<<< HEAD:Projects/BankManager/src/Views/OverviewPanel.java
        JLabel totalReceivedTitle = new JLabel("Tổng Thu Trong Tháng");
        totalReceivedTitle.setIcon(new ImageIcon("src/Res/monney.png"));
        totalReceivedTitle.setVerticalTextPosition(SwingConstants.CENTER);
=======
        JLabel totalReceivedTitle = new JLabel("Total received in month");
        totalReceivedTitle.setIcon(new ImageIcon(img_monney));
        totalReceivedTitle.setVerticalTextPosition(3);
>>>>>>> Long:Projects/BankManager/src/Views/PanelOverview.java
        totalReceivedTitle.setVerticalAlignment(3);
        totalReceivedTitle.setIconTextGap(15);
        totalReceivedTitle.setHorizontalAlignment(0);
        totalReceivedTitle.setFont(new Font("Open Sans", Font.PLAIN, 18));
<<<<<<< HEAD:Projects/BankManager/src/Views/OverviewPanel.java
        totalReceivedPanel.add((Component) totalReceivedTitle, "North");
        JLabel totalReceivedValue = new JLabel(UserController.BalanceFormat.format(totalReceived) + "  VNĐ");
=======
        totalReceivedPanel.add((Component) totalReceivedTitle, "South");
        totalReceivedValue = new JLabel(String.format("%,.0f", TradingsController.totalReceivedValue));
>>>>>>> Long:Projects/BankManager/src/Views/PanelOverview.java
        totalReceivedValue.setHorizontalAlignment(0);
        totalReceivedValue.setFont(new Font("Open Sans", Font.PLAIN, 20));
        totalReceivedPanel.add((Component) totalReceivedValue, "Center");


        mainPanel.add(accountBalancePanel);
        mainPanel.add(totalSpendingPanel);
        mainPanel.add(totalReceivedPanel);
        return mainPanel;
    }

    private JPanel southPanel()
    {
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
<<<<<<< HEAD:Projects/BankManager/src/Views/OverviewPanel.java
        this.lineChart = new LineGraphPanel();
=======
>>>>>>> Long:Projects/BankManager/src/Views/PanelOverview.java
        mainPanel.add((Component) ((Object) this.lineChart), gbcLineChart);
        GridBagConstraints gbcBarChart = new GridBagConstraints();
        gbcBarChart.fill = 1;
        gbcBarChart.insets = new Insets(0, 0, 5, 5);
        gbcBarChart.gridx = 0;
        gbcBarChart.gridy = 1;
        mainPanel.add((Component) ((Object) this.barChart), gbcBarChart);


        JPanel recentTransactionsPanel = new JPanel();
<<<<<<< HEAD:Projects/BankManager/src/Views/OverviewPanel.java
        recentTransactionsPanel.setBorder(new TitledBorder(new EtchedBorder(1, null, null), "Giao Dịch Gần Đây", TitledBorder.CENTER, TitledBorder.TOP, new Font("Open Sans", Font.PLAIN, 16), null));
=======
        recentTransactionsPanel.setBorder(new TitledBorder(new EtchedBorder(1, null, null), "Recent Transactions", TitledBorder.CENTER, TitledBorder.TOP, new Font("Open Sans", Font.PLAIN, 16), null));
>>>>>>> Long:Projects/BankManager/src/Views/PanelOverview.java
        recentTransactionsPanel.setLayout(new BorderLayout(0, 0));
        recentTransactionsPanel.setPreferredSize(new Dimension(100, 265));
        recentTransactionsTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(recentTransactionsTable);
        recentTransactionsPanel.add(scrollPane);
        recentTransactionsTable.setFillsViewportHeight(true);
        recentTransactionsTable.setSelectionMode(0);
<<<<<<< HEAD:Projects/BankManager/src/Views/OverviewPanel.java
        recentTransactionsTable.setFont(new Font("Open Sans", Font.BOLD, 12));
        recentTransactionsTable.setModel(new DefaultTableModel(new Object[0][], new String[]{"Người Nhận/Chuyển", "Nội Dung", "Số Tiền"}) {
=======
        recentTransactionsTable.setFont(new Font("Open Sans", Font.PLAIN, 12));
        recentTransactionsTable.setModel(new DefaultTableModel(new Object[0][], new String[]{"Receiver/Sender", "Content", "Amount"})
        {
>>>>>>> Long:Projects/BankManager/src/Views/PanelOverview.java
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        });
        recentTransactionsTable.getColumnModel().getColumn(0).setPreferredWidth(70);
        recentTransactionsTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        recentTransactionsTable.getColumnModel().getColumn(2).setPreferredWidth(70);
        recentTransactionsTable.setRowHeight(30);
        recentTransactionsTable.getColumn("Content").setCellRenderer(new DefaultTableCellRenderer()
        {
            @Override
<<<<<<< HEAD:Projects/BankManager/src/Views/OverviewPanel.java
            public void setHorizontalAlignment(int alignment) {
=======
            public void setHorizontalAlignment(int alignment)
            {
>>>>>>> Long:Projects/BankManager/src/Views/PanelOverview.java
                super.setHorizontalAlignment(SwingConstants.LEFT);
            }
        });
        recentTransactionsTable.getColumn("Amount").setCellRenderer(new DefaultTableCellRenderer()
        {
            @Override
<<<<<<< HEAD:Projects/BankManager/src/Views/OverviewPanel.java
            public void setHorizontalAlignment(int alignment) {
                super.setHorizontalAlignment(SwingConstants.RIGHT);
=======
            public void setHorizontalAlignment(int alignment)
            {
                super.setHorizontalAlignment(SwingConstants.LEFT);
>>>>>>> Long:Projects/BankManager/src/Views/PanelOverview.java
            }
        });
        JTableHeader headerTable = recentTransactionsTable.getTableHeader();
        headerTable.setFont(new Font("Open Sans", Font.BOLD, 14));
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

<<<<<<< HEAD:Projects/BankManager/src/Views/OverviewPanel.java
    public OverviewPanel() {
        try {
=======
    public PanelOverview()
    {
        try
        {
>>>>>>> Long:Projects/BankManager/src/Views/PanelOverview.java
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        this.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        mainPanel.add((Component) this.northPanel(), "North");
        AccountController.uploadDataToOverView(LoginController.AccountNumber,LineGraphPanel.startDay,LineGraphPanel.endDay);
        mainPanel.add((Component) this.centerPanel(), "Center");
<<<<<<< HEAD:Projects/BankManager/src/Views/OverviewPanel.java
        this.barChart = new ColumnChartPanel();
        mainPanel.add((Component) this.southPanel(), "South");
        this.add((Component) scrollPane, "Center");
        TransactionsController.uploadTradingDataOverview(recentTransactionsTable, LoginController.AccountNumber);
=======
        this.barChart = new ColumnChartPanel(TradingsController.totalSpendingValue, TradingsController.totalReceivedValue);
        this.lineChart = new LineGraphPanel();
        mainPanel.add((Component) this.southPanel(), "South");
        this.add((Component) scrollPane, "Center");
        TradingsController.uploadTradingDataOverview(recentTransactionsTable, UserController.accountNumber);
>>>>>>> Long:Projects/BankManager/src/Views/PanelOverview.java
    }
}
