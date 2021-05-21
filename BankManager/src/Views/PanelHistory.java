package Views;

import javax.swing.*;
import java.awt.*;

public class PanelHistory extends JPanel
{
    public PanelHistory()
    {
        setBounds(0,0,538,396);
        setLayout(null);


        JLabel lblSetting = new JLabel("THIS IS History");
        lblSetting.setForeground(new Color(0,100,0));
        lblSetting.setFont(new Font("Tahoma", Font.BOLD, 37));
        lblSetting.setBounds(150,139,327,112);
        this.add(lblSetting);
    }
}
