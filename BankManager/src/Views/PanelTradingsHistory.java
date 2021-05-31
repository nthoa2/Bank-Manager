package Views;

import Controller.LoginController;
import Controller.TradingsController;
import Model.TradingsData;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.PatternSyntaxException;

public class PanelTradingsHistory extends JPanel
{
    static JLabel accountDetailsName;
    static JLabel accountBalance;
    public static JTable contentTable;
    DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Loại Giao Dịch", "Ngày Giao Dịch", "Người Nhận/Gửi", "Nội Dung", "Số Tiền"}, 0)
    {
        @Override
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    };

    private JPanel headerPanel()
    {

        JPanel rootPanel = new LinearGradient(1);
        rootPanel.setPreferredSize(new Dimension(50, 70));
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
        TitleConstraints.anchor = GridBagConstraints.CENTER;
        TitleConstraints.weightx = 1;
        TitleConstraints.weighty = 1;
        TitleConstraints.fill = GridBagConstraints.HORIZONTAL;
        TitleConstraints.gridwidth = 2;
        TitleConstraints.ipadx = 50;
        TitleConstraints.insets = new Insets(0, 0, 5, 5);
        TitleConstraints.gridx = 0;
        TitleConstraints.gridy = 0;
        rootPanel.add(headerTitle, TitleConstraints);

        return rootPanel;
    }

    private JPanel dataPanel()
    {
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
        comboBoxFilter.setModel(new DefaultComboBoxModel<>(new String[]{"Tất Cả", "Nạp tiền", "Rút tiền", "Chuyển tiền"}));
        comboBoxFilter.setMaximumRowCount(10);
        comboBoxFilter.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                TradingsController.uploadTradingByType(PanelTradingsHistory.this.contentTable, (String) comboBoxFilter.getSelectedItem(), LoginController.accountNumber);
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
        JLabel searchTitle = new JLabel("Tìm Kiếm:  ");
        searchTitle.setFont(new Font("Open Sans", Font.BOLD, 14));
        JTextField searchText = new JTextField();
        searchText.setHorizontalAlignment(SwingConstants.LEFT);
        searchText.setFont(new Font("Open Sans", Font.PLAIN, 13));
        searchText.setColumns(30);
        Button searchButton = new Button("Tìm Kiếm");
        searchButton.setBackground(new Color(205, 205, 205));
        searchButton.setFont(new Font("Open Sans", Font.BOLD, 14));
        searchButton.setPreferredSize(new Dimension(100, 25));
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setFocusable(false);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
        searchText.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyReleased(KeyEvent e)
            {
                String text = searchText.getText();
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

        searchPanel.add(searchTitle);
        searchPanel.add(searchText);
        searchPanel.add(searchButton);
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
        contentTable.getColumn("Số Tiền").setCellRenderer(new DefaultTableCellRenderer()
        {

            @Override
            public void setHorizontalAlignment(int alignment)
            {
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


    public PanelTradingsHistory()
    {
        this.setLayout(new BorderLayout(0, 0));
        this.add((Component) this.headerPanel(), "North");
        this.add((Component) this.dataPanel(), "Center");
        TradingsController.uploadAllTradingData(PanelTradingsHistory.contentTable, LoginController.accountNumber);
    }
}