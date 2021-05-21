package Views;

import javax.swing.*;
import java.awt.*;

public class PanelIndex extends JPanel
{
    public PanelIndex()
    {
        this.setLayout(new BorderLayout(0,0));


        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));

        JPanel panelTitle = new RadiusAndShadow();
        panelTitle.setPreferredSize(new Dimension(200,70));
        panelTitle.setBackground(Color.WHITE);
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER,0,13));
        panelHeader.add(panelTitle);

        JLabel lblTitle = new JLabel();
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setText("WELCOME");
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
        panelTitle.add(lblTitle);

        this.add(panelHeader, "North");

        JPanel panelClock = new Clock(Color.WHITE);

        JPanel panelFooter = new JPanel();
        panelFooter.setLayout(new FlowLayout(FlowLayout.RIGHT,0,10));
        panelFooter.add(panelClock);

        this.add(panelFooter, "South");


        JPanel panelCenterMain = new JPanel();
        panelCenterMain.setLayout(new BorderLayout(10,0));
        panelCenterMain.add(new ScaleImg("/Res/img_home2.png"), "Center");
        panelCenterMain.setPreferredSize(new Dimension(150,0));
        this.add(panelCenterMain, "Center");

        this.add(new JPanel(), "East");



        JPanel panelNorth = new JPanel();
        panelNorth.setPreferredSize(new Dimension(100,20));
        panelCenterMain.add(panelNorth, "North");

        JPanel panelWest = new JPanel();
        panelWest.setPreferredSize(new Dimension(0,100));
        panelCenterMain.add(panelWest, "West");


        JPanel panelEast = new JPanel();
        panelEast.setLayout(new BoxLayout(panelEast, BoxLayout.Y_AXIS));
        panelEast.add(new ScaleImg("/Res/img_home1.png"));
        panelEast.add(Box.createRigidArea(new Dimension(0,10)));
        panelEast.add(new ScaleImg("/Res/img_home3.png"));
        panelCenterMain.add(panelEast, "East");
    }


}
