package Views;

import Controller.LoginController;
import Controller.TransactionsController;
import Controller.UserController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.PatternSyntaxException;

public class TradingsHistoryPanel extends JPanel {
    public JLabel accountDetailsName;
    public JLabel accountBalance;
    public static JTable contentTable;
    private Image img_search = new ImageIcon("src/Res/search_icon.png").getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);

    DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Loại Giao Dịch", "Ngày Giao Dịch", "Người Gửi/Nhận", "Nội Dung", "Số Tiền"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);

    private JPanel headerPanel() {
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout(5, 0));
        rootPanel.setPreferredSize(new Dimension(50, 90));
        JPanel headerPanel = new JPanel(); // Title
        GridBagLayout headerPanelLayout = new GridBagLayout();
        int[] columnWidths = new int[5];
        columnWidths[0] = 34;
        columnWidths[1] = 238;
        headerPanelLayout.columnWidths = columnWidths;
        int[] rowHeights = new int[5];
        rowHeights[0] = 29;
        headerPanelLayout.rowHeights = rowHeights;
        headerPanelLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        headerPanelLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        headerPanel.setLayout(headerPanelLayout);
        JLabel headerTitle = new JLabel("Lịch Sử Giao Dịch");
        headerTitle.setFont(new Font("Open Sans", Font.BOLD, 29));
        headerTitle.setIconTextGap(0);
        headerTitle.setHorizontalAlignment(SwingConstants.CENTER);
        headerTitle.setAlignmentX(1.0f);
        GridBagConstraints TitleConstraints = new GridBagConstraints();
        TitleConstraints.anchor = 17;
        TitleConstraints.fill = 3;
        TitleConstraints.gridwidth = 2;
        TitleConstraints.ipadx = 50;
        TitleConstraints.insets = new Insets(0, 0, 5, 5);
        TitleConstraints.gridx = 0;
        TitleConstraints.gridy = 1;
        headerPanel.add(headerTitle, TitleConstraints);

        rootPanel.add((Component) headerPanel, "North");
        return rootPanel;
    }

    private JPanel dataPanel() {
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout(0, 0));

        JPanel toolsPanel = new JPanel();
        GridBagLayout toolsPanelLayout = new GridBagLayout();
        toolsPanelLayout.columnWidths = new int[2];
        toolsPanelLayout.rowHeights = new int[14];
        toolsPanelLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        toolsPanelLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        toolsPanel.setLayout(toolsPanelLayout);

        JPanel filterPanel = new JPanel();
        GridBagConstraints gbc_filter = new GridBagConstraints();
        gbc_filter.fill = 1;
        gbc_filter.gridx = 0;
        gbc_filter.gridy = 0;
        filterPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));
        JLabel filterLabel = new JLabel("Xem Theo: ");
        filterLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
        JComboBox<String> comboBoxFilter = new JComboBox<String>();
        comboBoxFilter.setFont(new Font("Open Sans", Font.BOLD, 13));
        comboBoxFilter.setPreferredSize(new Dimension(170, 25));
        comboBoxFilter.setModel(new DefaultComboBoxModel<>(new String[]{"Tất Cả", "Nạp Tiền", "Rút Tiền", "Chuyển Tiền", "Nhận Tiền"}));
        comboBoxFilter.setMaximumRowCount(10);
        comboBoxFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransactionsController.uploadTradingByType(contentTable,LoginController.AccountNumber,comboBoxFilter.getSelectedIndex());
            }
        });
        filterPanel.add(filterLabel);
        filterPanel.add(comboBoxFilter);
        toolsPanel.add((Component) filterPanel, gbc_filter);

        JPanel searchPanel = new JPanel();
        GridBagConstraints gbc_search = new GridBagConstraints();
        gbc_search.insets = new Insets(0, 0, 5, 0);
        gbc_search.fill = 1;
        gbc_filter.gridx = 0;
        gbc_search.gridy = 1;
        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));
        JLabel searchTitle = new JLabel("Tìm Kiếm: ");
        searchTitle.setFont(new Font("Open Sans", Font.BOLD, 14));
        searchPanel.add(searchTitle);
        JPanel panelText = new RadiusAndShadow();
        panelText.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelText.setBackground(Color.WHITE);
        JTextField searchText = new JTextField();
        searchText.setText("Nột Dung Tìm Kiếm ...");
        searchText.setHorizontalAlignment(SwingConstants.LEFT);
        searchText.setFont(new Font("Open Sans", Font.PLAIN, 13));
        searchText.setColumns(30);
        searchText.setBorder(null);
        searchText.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if(searchText.getText().equals("Nột Dung Tìm Kiếm ..."))
                    searchText.setText("");
                else
                    searchText.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if(searchText.getText().equals(""))
                    searchText.setText("Nột Dung Tìm Kiếm ...");
            }
        });
        panelText.add(searchText);
        JLabel lblIcon = new JLabel("");
        lblIcon.setIcon(new ImageIcon(img_search));
        panelText.add(lblIcon);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
        searchText.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyReleased(KeyEvent e)
            {
                String text = searchText.getText();
                if(text.equals("Nột Dung Tìm Kiếm ..."))
                    return;
                if (text.length() == 0)
                {
                    sorter.setRowFilter(null);
                } else
                {
                    try
                    {
                        sorter.setRowFilter(RowFilter.regexFilter(text));
                    } catch (PatternSyntaxException patternException)
                    {
                        System.out.println("Bad regex pattern");
                    }
                }
            }
        });

        searchPanel.add(panelText);
        toolsPanel.add(searchPanel, gbc_search);

        rootPanel.add((Component) toolsPanel, "North");
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        contentTable = new JTable();
        scrollPane.setViewportView(contentTable);
        contentTable.setSelectionMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        contentTable.setModel(tableModel);
        contentTable.setRowSorter(sorter);
        contentTable.setFont(new Font("Open Sans", Font.BOLD, 13));
        contentTable.setFillsViewportHeight(true);
        contentTable.setRowHeight(25);
        contentTable.getColumnModel().getColumn(0).setPreferredWidth(15);
        contentTable.getColumnModel().getColumn(1).setPreferredWidth(5);
        contentTable.getColumn("Số Tiền").setCellRenderer(new DefaultTableCellRenderer() {

            @Override
            public void setHorizontalAlignment(int alignment) {
                super.setHorizontalAlignment(4);
            }
        });
        JTableHeader headerTable = contentTable.getTableHeader();
        headerTable.setFont(new Font("Open Sans", Font.BOLD, 14));
        headerTable.setBackground(new Color(240, 240, 240));
        headerTable.setOpaque(true);
        headerTable.setAlignmentY(SwingConstants.CENTER);
        headerTable.setPreferredSize(new Dimension(50, 30));
        headerTable.setReorderingAllowed(false);


        rootPanel.add(scrollPane, "Center");
        return rootPanel;
    }


    public TradingsHistoryPanel() {
        this.setLayout(new BorderLayout(0, 0));
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.add((Component) this.headerPanel(), "North");
        this.add((Component) this.dataPanel(), "Center");
        TransactionsController.uploadAllTradingData(contentTable, LoginController.AccountNumber);
    }


}
