package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HistoryPanel extends JPanel {


    private JPanel headerPanel() {
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout(0, 0));
        JPanel headPanel = new JPanel(); // Title

        JPanel cardDetailsPanel = new JPanel(); // card details

        rootPanel.add((Component) headPanel, "North");
        rootPanel.add((Component) cardDetailsPanel, "Center");
        return rootPanel;
    }

    private JPanel contentPanel() {
        JPanel rootPanel = new JPanel();
        JComboBox<String> tableFilter = new JComboBox<String>();
        JTable contentTable = new JTable();

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
