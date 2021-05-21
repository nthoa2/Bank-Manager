package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PanelService extends JPanel
{
    private FlowLayout flowLayout = new FlowLayout();
    private CardLayout cardLayout = new CardLayout();
    public static JLabel lblMessage;

    public PanelService()
    {
        this.setLayout(new BorderLayout(0, 0));


        flowLayout.setAlignment(FlowLayout.CENTER);
        flowLayout.setHgap(80);
        flowLayout.setVgap(40);

        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(flowLayout);
        this.add(panelHeader, "North");

        JPanel panelFooter = new JPanel();
        panelFooter.setLayout(new BorderLayout(0,0));
        panelFooter.setVisible(false);
        this.add(panelFooter, "South");


        JPanel panelForm = new JPanel();
        panelForm.setLayout(cardLayout);
        panelForm.add(new ScaleImg("/Res/img_service.jpg"), "4");
        cardLayout.show(panelForm,"4");
        this.add(panelForm, "Center");

        JPanel panelMessage = new JPanel();
        panelMessage.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
        panelMessage.setPreferredSize(new Dimension(500,30));
        panelFooter.add(panelMessage, "North");

        lblMessage = new JLabel("");
        lblMessage.setForeground(Color.RED);
        lblMessage.setFont(new Font("Arial", Font.BOLD, 12));
        panelMessage.add(lblMessage);

        flowLayout.setVgap(10);
        JPanel footer = new JPanel();
        footer.setLayout(flowLayout);
        panelFooter.add(footer, "Center");

        JPanel panelCancel = new RadiusAndShadow();
        panelCancel.setBackground(Color.WHITE);
        panelCancel.add(new JLabel("Cancel"));
        panelCancel.setOpaque(false);
        panelCancel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                cardLayout.show(panelForm, "4");
                panelFooter.setVisible(false);
            }
            @Override
            public void mouseEntered(MouseEvent e)
            {
                panelCancel.setBackground(new Color(162, 85, 113));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                panelCancel.setBackground(Color.WHITE);
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                panelCancel.setBackground(new Color(216, 53, 65));
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                panelCancel.setBackground(Color.WHITE);
            }
        });
        panelCancel.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
        panelCancel.setPreferredSize(new Dimension(170, 50));
        footer.add(panelCancel);

        JPanel panelConfirm = new RadiusAndShadow();
        panelConfirm.setBackground(Color.WHITE);
        panelConfirm.add(new JLabel("Confirm"));
        panelConfirm.setOpaque(false);
        panelConfirm.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
            }
            @Override
            public void mouseEntered(MouseEvent e)
            {
                panelConfirm.setBackground(new Color(162, 85, 113));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                panelConfirm.setBackground(Color.WHITE);
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                panelConfirm.setBackground(new Color(216, 53, 65));
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                panelConfirm.setBackground(Color.WHITE);
            }
        });
        panelConfirm.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
        panelConfirm.setPreferredSize(new Dimension(170, 50));
        footer.add(panelConfirm);

        JPanel panelTransfer = new RadiusAndShadow();
        panelTransfer.setBackground(Color.WHITE);
        panelTransfer.add(new JLabel("Transfer"));
        panelTransfer.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                lblMessage.setText("");
                panelForm.add(new PanelTransfer(), "1");
                panelForm.setVisible(true);
                cardLayout.show(panelForm, "1");
                panelFooter.setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e)
            {
                panelTransfer.setBackground(new Color(162, 85, 113));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                panelTransfer.setBackground(Color.WHITE);
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                panelTransfer.setBackground(new Color(216, 53, 65));
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                panelTransfer.setBackground(Color.WHITE);
            }
        });
        panelTransfer.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
        panelTransfer.setPreferredSize(new Dimension(170, 80));
        panelHeader.add(panelTransfer);

        JPanel panelRecharge = new RadiusAndShadow();
        panelRecharge.setBackground(Color.WHITE);
        panelRecharge.add(new JLabel("Recharge"));
        panelRecharge.setOpaque(false);
        panelRecharge.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                lblMessage.setText("");
                panelForm.add(new PanelRecharge(), "2");
                panelForm.setVisible(true);
                cardLayout.show(panelForm, "2");
                panelFooter.setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e)
            {
                panelRecharge.setBackground(new Color(162, 85, 113));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                panelRecharge.setBackground(Color.WHITE);
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                panelRecharge.setBackground(new Color(216, 53, 65));
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                panelRecharge.setBackground(Color.WHITE);
            }
        });
        panelRecharge.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
        panelRecharge.setPreferredSize(new Dimension(170, 80));
        panelHeader.add(panelRecharge);

        JPanel panelWithdraw = new RadiusAndShadow();
        panelWithdraw.setBackground(Color.WHITE);
        panelWithdraw.add(new JLabel("Withdraw"));
        panelWithdraw.setOpaque(false);
        panelWithdraw.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                lblMessage.setText("");
                panelForm.add(new PanelWithdraw(), "3");
                panelForm.setVisible(true);
                cardLayout.show(panelForm, "3");
                panelFooter.setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e)
            {
                panelWithdraw.setBackground(new Color(162, 85, 113));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                panelWithdraw.setBackground(Color.WHITE);
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                panelWithdraw.setBackground(new Color(216, 53, 65));
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                panelWithdraw.setBackground(Color.WHITE);
            }
        });
        panelWithdraw.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
        panelWithdraw.setPreferredSize(new Dimension(170, 80));
        panelHeader.add(panelWithdraw);

    }
}

