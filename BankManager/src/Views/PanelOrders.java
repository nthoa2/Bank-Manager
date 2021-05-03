package Views;

import javax.swing.*;
import java.awt.*;

public class PanelOrders extends JPanel
{
    public PanelOrders()
    {
        setBounds(0, 0, 558, 420);
        setLayout(null);


        JLabel lblOrders = new JLabel("THIS IS ORDERS");
        lblOrders.setForeground(new Color(0,100,0));
        lblOrders.setFont(new Font("Tahoma", Font.BOLD, 37));
        lblOrders.setBounds(150,139,327,112);
        this.add(lblOrders);
    }
}
