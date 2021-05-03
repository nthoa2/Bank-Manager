package Views;

import javax.swing.*;
import java.awt.*;

public class PanelHome extends JPanel
{
    public PanelHome()
    {
        setBounds(0, 0, 558, 420);
        setLayout(null);


        JLabel lblHome = new JLabel("THIS IS HOME");
        lblHome.setForeground(new Color(0,100,0));
        lblHome.setFont(new Font("Tahoma", Font.BOLD, 37));
        lblHome.setBounds(150,139,327,112);
        this.add(lblHome);
    }
}
