package Views;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class _Statistics extends JPanel {

    static JLabel accountBalanceLabelValue;
    static JLabel totalSpendingValue;
    static JLabel totalReceivedValue;

public _Statistics(){
    this.Views();
}

    private void Views() {
        this.setLayout(new GridLayout(0, 3, 5, 5));
        JPanel accountBalancePanel = new JPanel();
        accountBalancePanel.setBorder(new EtchedBorder(1, null, Color.DARK_GRAY));
        accountBalancePanel.setBackground(Color.WHITE);
        this.add(accountBalancePanel);
        accountBalancePanel.setLayout(new BorderLayout(0, 0));
        JLabel accountBalanceLabelTitle = new JLabel("Số Dư Hiện Tại");
        accountBalanceLabelTitle.setVerticalTextPosition(3);
        accountBalanceLabelTitle.setIconTextGap(15);
        accountBalanceLabelTitle.setIcon(new ImageIcon("src/Res/monney.png"));
        accountBalanceLabelTitle.setBackground(Color.WHITE);
        accountBalanceLabelTitle.setHorizontalAlignment(0);
        accountBalanceLabelTitle.setFont(new Font("Open Sans", Font.PLAIN, 18));
        accountBalancePanel.add((Component)accountBalanceLabelTitle, "South");
        accountBalanceLabelValue = new JLabel("0");
        accountBalanceLabelValue.setHorizontalAlignment(0);
        accountBalanceLabelValue.setFont(new Font("Open Sans", Font.PLAIN, 20));
        accountBalancePanel.add((Component)accountBalanceLabelValue, "Center");

        JPanel totalSpendingPanel = new JPanel();
        totalSpendingPanel.setBorder(new EtchedBorder(1, null, Color.DARK_GRAY));
        totalSpendingPanel.setBackground(Color.WHITE);
        totalSpendingPanel.setLayout(new BorderLayout(0, 0));
        this.add(totalSpendingPanel);
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

        JPanel totalReceivedPanel = new JPanel();
        totalReceivedPanel.setBorder(new EtchedBorder(1, null, Color.DARK_GRAY));
        totalReceivedPanel.setBackground(Color.WHITE);
        totalReceivedPanel.setLayout(new BorderLayout(0, 5));
        this.add(totalReceivedPanel);
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

    }
}
