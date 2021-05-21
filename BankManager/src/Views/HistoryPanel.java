package Views;

import Controller.Control_Trading;
import Model.connection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class HistoryPanel extends JPanel {
    static JLabel accountDetailsName;
    static JLabel accountBalance;
    private JTable contentTable;

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

        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));
        JLabel filterLabel = new JLabel("Lọc   ");
        filterLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
        JComboBox<String> comboBoxFilter = new JComboBox<String>();
        comboBoxFilter.setFont(new Font("Open Sans", Font.BOLD, 13));
        comboBoxFilter.setPreferredSize(new Dimension(170, 25));
        comboBoxFilter.setModel(new DefaultComboBoxModel<>(new String[]{"Tất Cả", "Chuyển Khoản", "Nhận Chuyển Khoản"}));
        comboBoxFilter.setMaximumRowCount(10);
        comboBoxFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Control_Trading.uploadTradingByType(HistoryPanel.this.contentTable,(String)comboBoxFilter.getSelectedItem());
            }
        });
        filterPanel.add(filterLabel);
        filterPanel.add(comboBoxFilter);
        rootPanel.add((Component) filterPanel, "North");

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        contentTable = new JTable();
        scrollPane.setViewportView(contentTable);
        contentTable.setSelectionMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Loại Giao Dịch", "Ngày Giao Dịch", "Người Nhận", "Nội Dung", "Số Tiền"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        contentTable.setModel(tableModel);
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


    public HistoryPanel() {
        this.setLayout(new BorderLayout(0, 0));
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.add((Component) this.headerPanel(), "North");
        this.add((Component) this.dataPanel(), "Center");
        Control_Trading.uploadAllTradingData(this.contentTable);
    }


}
