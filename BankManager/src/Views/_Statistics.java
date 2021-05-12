package Views;


import javax.swing.*;
import java.awt.*;

public class _Statistics extends JPanel {

    static JLabel accountBalanceLabelValue;
    static JLabel totalSpendingValue;
    static JLabel totalReceivedValue;

    public _Statistics(){
        this.Views();
    }

    private void Views() {
        this.setLayout(new BorderLayout(0,0));

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(0, 3, 10, 5));
        this.add(panelCenter, "Center");

        JPanel panelWest = new JPanel();
        this.add(panelWest, "West");

        JPanel accountBalancePanel = new RadiusAndShadow();
        accountBalancePanel.setBackground(Color.WHITE);
        panelCenter.add(accountBalancePanel);
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

        JPanel totalSpendingPanel = new RadiusAndShadow();
        totalSpendingPanel.setBackground(Color.WHITE);
        totalSpendingPanel.setLayout(new BorderLayout(0, 0));
        panelCenter.add(totalSpendingPanel);
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
        panelCenter.add(totalReceivedPanel);
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
