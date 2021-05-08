package Views;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class accountInfo extends JPanel {

    public accountInfo(){

        this.View();
    }

    public void showData(){

    }

    private void View(){
        this.setLayout(new GridLayout(0,4,5,5));
        JPanel accountBalancePanel = new JPanel();
        accountBalancePanel.setLayout(new BorderLayout(0,0));
        accountBalancePanel.setBorder(new EtchedBorder(1, null, Color.darkGray));
        JLabel lblAccountBalance = new JLabel("Account Balance");
        lblAccountBalance.setFont(new Font("Open Sans", Font.BOLD,14));
        lblAccountBalance.setVerticalTextPosition(3);
        lblAccountBalance.setHorizontalAlignment(SwingConstants.LEADING);
        lblAccountBalance.setBackground(Color.WHITE);
        lblAccountBalance.setIconTextGap(15);
        lblAccountBalance.setIcon(new ImageIcon("src/Res/monney.png"));
        accountBalancePanel.add((Component) lblAccountBalance, "North");
        JLabel lblAccountBalanceValue = new JLabel("0");
        lblAccountBalanceValue.setHorizontalAlignment(0);
        lblAccountBalanceValue.setFont(new Font("Open Sans", Font.BOLD, 12));
        accountBalancePanel.add((Component) lblAccountBalanceValue, "Center");
        this.add(accountBalancePanel);
    }
}
