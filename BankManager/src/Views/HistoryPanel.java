package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HistoryPanel extends JPanel {


    private JPanel headerPanel() {
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout(0, 0));
        JPanel headPanel = new JPanel(); // Title
        JLabel headerTitle = new JLabel("Lịch Sử Các Giao Dịch");
        headPanel.add(headerTitle);
        JPanel cardDetailsPanel = new JPanel(); // card details

        rootPanel.add((Component) headPanel, "North");
        rootPanel.add((Component) cardDetailsPanel, "Center");
        return rootPanel;
    }

    private JPanel contentPanel() {
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout(0, 0));

        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));
        JLabel filterLabel = new JLabel("Lọc Theo");
        filterLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
        JComboBox<String> comboBoxFilter = new JComboBox<String>();
        comboBoxFilter.setFont(new Font("Open Sans", Font.BOLD, 13));
        comboBoxFilter.setPreferredSize(new Dimension(150, 25));
        comboBoxFilter.setModel(new DefaultComboBoxModel<>(new String[]{"Mặc Định", "Loại Giao Dịch", "Ngày Giao Dịch"}));
        comboBoxFilter.setMaximumRowCount(10);

        filterPanel.add(filterLabel);
        filterPanel.add(comboBoxFilter);
        rootPanel.add((Component) filterPanel, "North");

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        JTable contentTable = new JTable();
        scrollPane.setViewportView(contentTable);
        contentTable.setSelectionMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Loại Giao Dịch", "Ngày Giao Dịch", "TK Thụ Hưởng", "Nội Dung", "Số Tiền"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        contentTable.setModel(tableModel);
        contentTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // hien thi chi tiet giao dịch
            }
        });
        contentTable.setFont(new Font("Open Sans", Font.PLAIN, 12));
        contentTable.setFillsViewportHeight(true);
        contentTable.setRowHeight(25);
        contentTable.getColumn("Số Tiền").setMinWidth(100);
        contentTable.getColumn("Số Tiền").setMaxWidth(200);
        contentTable.getColumn("Số Tiền").setCellRenderer(new DefaultTableCellRenderer() {

            @Override
            public void setHorizontalAlignment(int alignment) {
                super.setHorizontalAlignment(4);
            }
        });
        JTableHeader headerTable = contentTable.getTableHeader();
        headerTable.setFont(new Font("Open Sans", Font.BOLD, 13));
        headerTable.setBackground(new Color(240, 240, 240));
        headerTable.setOpaque(true);
        headerTable.setAlignmentY(SwingConstants.CENTER);
        headerTable.setPreferredSize(new Dimension(55, 35));


        rootPanel.add(scrollPane, "Center");
        return rootPanel;
    }


    public HistoryPanel() {
        this.setLayout(new BorderLayout(0, 0));
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setAlignmentY(SwingConstants.LEADING);


        this.add((Component) this.headerPanel(), "North");
        this.add((Component) this.contentPanel(), "Center");

    }


}
