package Views;

import javax.swing.*;
import java.awt.*;

public class PanelProfits extends JPanel
{
    public PanelProfits()
    {
        setBounds(0, 0, 558, 420);
        setLayout(null);


        JLabel lblProfits = new JLabel("THIS IS PROFITS");
        lblProfits.setForeground(new Color(0,100,0));
        lblProfits.setFont(new Font("Tahoma", Font.BOLD, 37));
        lblProfits.setBounds(150,139,327,112);
        this.add(lblProfits);
    }
}
