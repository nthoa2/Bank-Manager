package Views;

import javax.swing.*;
import java.awt.*;

public class PanelHome extends JPanel
{

    private Image a1 = new ImageIcon(LoginFrame.class.getResource("/Res/avatar1.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
    private Image a2 = new ImageIcon(LoginFrame.class.getResource("/Res/avatar2.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
    private Image a3 = new ImageIcon(LoginFrame.class.getResource("/Res/avatar3.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
    private Image a4 = new ImageIcon(LoginFrame.class.getResource("/Res/avatar4.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);

    public PanelHome()
    {
        this.setLayout(new BorderLayout(0, 0));

        JPanel panelHeader = new LinearGradient(1);
        panelHeader.setBackground(Color.WHITE);
        panelHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));

        JPanel panelTitle = new RadiusAndShadow();
        panelTitle.setPreferredSize(new Dimension(200, 70));
        panelTitle.setBackground(Color.WHITE);
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 13));
        panelHeader.add(panelTitle);

        JLabel lblTitle = new JLabel();
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setText("WELCOME");
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
        panelTitle.add(lblTitle);

        this.add(panelHeader, "North");

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout(50, 0));
        panel.add(new JPanel(), "West");
        panel.add(new JPanel(), "East");

        JLabel l1 = new JLabel("");
        l1.setIcon(new ImageIcon(a1));
        JLabel l2 = new JLabel("");
        l2.setIcon(new ImageIcon(a2));
        JLabel l3 = new JLabel("");
        l3.setIcon(new ImageIcon(a3));
        JLabel l4 = new JLabel("");
        l4.setIcon(new ImageIcon(a4));

        JPanel panelFooter = new JPanel();
        panelFooter.setBackground(Color.WHITE);
        panelFooter.setLayout(new FlowLayout(FlowLayout.CENTER, 50,0));

        panelFooter.add(l1);
        panelFooter.add(l2);
        panelFooter.add(l3);
        panelFooter.add(l4);
        panelFooter.setPreferredSize(new Dimension(0, 100));
        panel.add(panelFooter, "Center");
        this.add(panel, "South");


        JPanel panelCenterMain = new JPanel();
        panelCenterMain.setBackground(Color.WHITE);
        panelCenterMain.setLayout(new BorderLayout(10, 0));
        panelCenterMain.add(new ScaleImg("/Res/img_home2.png"), "Center");
        panelCenterMain.setPreferredSize(new Dimension(150, 0));
        this.add(panelCenterMain, "Center");

        JPanel panelRight = new JPanel();
        panelRight.setBackground(Color.WHITE);
        this.add(panelRight, "East");


        JPanel panelNorth = new JPanel();
        panelNorth.setBackground(Color.WHITE);
        panelNorth.setPreferredSize(new Dimension(100, 20));
        panelCenterMain.add(panelNorth, "North");

        JPanel panelWest = new JPanel();
        panelWest.setBackground(Color.WHITE);
        panelWest.setPreferredSize(new Dimension(0, 100));
        panelCenterMain.add(panelWest, "West");


        JPanel panelEast = new JPanel();
        panelEast.setBackground(Color.WHITE);
        panelEast.setLayout(new BoxLayout(panelEast, BoxLayout.Y_AXIS));
        panelEast.add(new ScaleImg("/Res/img_home1.png"));
        panelEast.add(Box.createRigidArea(new Dimension(0, 10)));
        panelEast.add(new ScaleImg("/Res/img_home3.png"));
        panelCenterMain.add(panelEast, "East");
    }


}