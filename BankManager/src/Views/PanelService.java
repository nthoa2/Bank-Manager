package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;


public class PanelService extends JPanel
{
    private FlowLayout flowLayout = new FlowLayout();
    private CardLayout cardLayout = new CardLayout();

    public PanelService()
    {
        this.setLayout(new BorderLayout(20, 0));




        this.add(new ScaleImg("/Res/img_service.png"), "East");


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

        PanelTransfer transfer = new PanelTransfer();
        PanelRecharge recharge = new PanelRecharge();
        PanelWithdraw withdraw = new PanelWithdraw();

        JPanel panelForm = new JPanel();
        panelForm.setLayout(cardLayout);
        panelForm.add(transfer, "1");
        panelForm.add(recharge, "2");
        panelForm.add(withdraw, "3");
        panelForm.setVisible(false);
        this.add(panelForm, "Center");

        JPanel panelMessage = new JPanel();
        panelMessage.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
        panelMessage.setBackground(Color.WHITE);
        panelMessage.setPreferredSize(new Dimension(500,30));
        panelFooter.add(panelMessage, "North");

        JLabel lblMessage = new JLabel("Số tài khoản không tồn tại");
        lblMessage.setForeground(Color.RED);
        lblMessage.setFont(new Font("Arial", Font.BOLD, 12));
        lblMessage.setVisible(false);
        panelMessage.add(lblMessage);


        flowLayout.setVgap(10);
        JPanel footer = new JPanel();
        footer.setBackground(Color.WHITE);
        footer.setLayout(flowLayout);
        panelFooter.add(footer, "Center");


        JPanel panelCancel = new RadiusAndShadow();
        panelCancel.setBackground(new Color(86, 109, 184));
        panelCancel.add(new JLabel("Cancel"));
        panelCancel.setOpaque(false);
        panelCancel.addMouseListener(new PanelButtonMouseAdapter(panelCancel, 86, 109, 184)
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                panelForm.setVisible(false);
                panelFooter.setVisible(false);
            }
        });
        panelCancel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelCancel.setPreferredSize(new Dimension(170, 50));
        footer.add(panelCancel);

        JPanel panelConfirm = new RadiusAndShadow();
        panelConfirm.setBackground(new Color(55, 119, 34));
        panelConfirm.add(new JLabel("Confirm"));
        panelConfirm.setOpaque(false);
        panelConfirm.addMouseListener(new PanelButtonMouseAdapter(panelConfirm,55, 119, 34)
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                lblMessage.setVisible(true);
            }
        });
        panelConfirm.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelConfirm.setPreferredSize(new Dimension(170, 50));
        footer.add(panelConfirm);


        JPanel panelTransfer = new RadiusAndShadow();
        panelTransfer.setBackground(new Color(222, 123, 77));
        panelTransfer.add(new JLabel("Transfer"));
        panelTransfer.addMouseListener(new PanelButtonMouseAdapter(panelTransfer, 222, 123, 77)
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                lblMessage.setVisible(false);
                panelForm.setVisible(true);
                cardLayout.show(panelForm, "1");
                panelFooter.setVisible(true);
            }
        });
        panelTransfer.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelTransfer.setPreferredSize(new Dimension(170, 80));
        panelHeader.add(panelTransfer);

        JPanel panelRecharge = new RadiusAndShadow();
        panelRecharge.setBackground(new Color(58, 206, 132));
        panelRecharge.add(new JLabel("Recharge"));
        panelRecharge.setOpaque(false);
        panelRecharge.addMouseListener(new PanelButtonMouseAdapter(panelRecharge, 58, 206, 132)
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                lblMessage.setVisible(false);
                panelForm.setVisible(true);
                cardLayout.show(panelForm, "2");
                panelFooter.setVisible(true);
            }
        });
        panelRecharge.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelRecharge.setPreferredSize(new Dimension(170, 80));
        panelHeader.add(panelRecharge);

        JPanel panelWithdraw = new RadiusAndShadow();
        panelWithdraw.setBackground(new Color(217, 77, 131));
        panelWithdraw.add(new JLabel("Withdraw"));
        panelWithdraw.setOpaque(false);
        panelWithdraw.addMouseListener(new PanelButtonMouseAdapter(panelWithdraw, 217, 77, 131)
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                lblMessage.setVisible(false);
                panelForm.setVisible(true);
                cardLayout.show(panelForm, "3");
                panelFooter.setVisible(true);
            }
        });
        panelWithdraw.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelWithdraw.setPreferredSize(new Dimension(170, 80));
        panelHeader.add(panelWithdraw);

    }
}

