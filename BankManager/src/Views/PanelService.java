package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PanelService extends JPanel
{
    private FlowLayout flowLayout = new FlowLayout();
    public static CardLayout cardLayout = new CardLayout();
    public static JPanel panelForm;
    public static JPanel panelFooter;
    public static JLabel lblMessage;

    private PanelTransfer transfer;
    private PanelWithdraw withdraw;
    private PanelRecharge recharge;

    private JPanel panelTransfer;
    private JPanel panelRecharge;
    private JPanel panelWithdraw;

    private int count = 0;

    public PanelService()
    {
        this.setLayout(new BorderLayout(0, 0));

        flowLayout.setAlignment(FlowLayout.CENTER);
        flowLayout.setHgap(80);
        flowLayout.setVgap(40);

        JPanel panelHeader = new LinearGradient(1);
        panelHeader.setLayout(flowLayout);
        this.add(panelHeader, "North");

        panelFooter = new LinearGradient(1);
        panelFooter.setLayout(new BorderLayout(0, 0));
        panelFooter.setVisible(false);
        this.add(panelFooter, "South");


        panelForm = new JPanel();
        panelForm.setLayout(cardLayout);
        panelForm.add(new ScaleImg("/Res/img_service.jpg"), "4");
        this.add(panelForm, "Center");

        JPanel panelMessage = new JPanel();
        panelMessage.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        panelMessage.setPreferredSize(new Dimension(500, 30));
        panelFooter.add(panelMessage, "North");

        lblMessage = new JLabel("");
        lblMessage.setForeground(Color.RED);
        lblMessage.setFont(new Font("Aurella", Font.BOLD, 15));
        panelMessage.add(lblMessage);

        flowLayout.setVgap(10);
        JPanel footer = new LinearGradient(1);
        footer.setLayout(flowLayout);
        panelFooter.add(footer, "Center");

        JLabel lblCancel = new JLabel("Cancel");
        lblCancel.setFont(new Font("Aurella", Font.BOLD, 15));

        JPanel panelCancel = new RadiusAndShadow();
        panelCancel.setBackground(Color.WHITE);
        panelCancel.add(lblCancel);
        panelCancel.setOpaque(false);
        panelCancel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton() == 1)
                {
                    cardLayout.show(panelForm, "4");
                    panelFooter.setVisible(false);
                }
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
        panelCancel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        panelCancel.setPreferredSize(new Dimension(170, 50));
        footer.add(panelCancel);

        JLabel lblConfirm = new JLabel("Confirm");
        lblConfirm.setFont(new Font("Aurella", Font.BOLD, 15));

        JPanel panelConfirm = new RadiusAndShadow();
        panelConfirm.setBackground(Color.WHITE);
        panelConfirm.add(lblConfirm);
        panelConfirm.setOpaque(false);
        panelConfirm.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton() == 1)
                {
                    if (count == 1)
                    {
                        lblMessage.setText(transfer.check());
                        if(lblMessage.getText().equals("Success"))
                        {
                            transfer = new PanelTransfer();
                            panelForm.add(transfer, "1");
                            cardLayout.show(panelForm, "1");
                        }
                    }
                    else if (count == 2)
                    {
                        lblMessage.setText(recharge.check());
                        if(lblMessage.getText().equals("Success"))
                        {
                            recharge = new PanelRecharge();
                            panelForm.add(recharge, "2");
                            cardLayout.show(panelForm, "2");
                        }
                    }
                    else
                    {
                        lblMessage.setText(withdraw.check());
                        if(lblMessage.getText().equals("Success"))
                        {
                            withdraw = new PanelWithdraw();
                            panelForm.add(withdraw, "3");
                            cardLayout.show(panelForm, "3");
                        }
                    }
                }
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
        panelConfirm.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        panelConfirm.setPreferredSize(new Dimension(170, 50));
        footer.add(panelConfirm);

        JLabel lblTransfer = new JLabel("Transfer");
        lblTransfer.setForeground(Color.BLACK);
        lblTransfer.setFont(new Font("Aurella", Font.BOLD, 20));

        panelTransfer = new RadiusAndShadow();
        panelTransfer.setBackground(Color.WHITE);
        panelTransfer.add(lblTransfer);
        panelTransfer.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton() == 1)
                {
                    count = 1;
                    transfer = new PanelTransfer();
                    lblMessage.setText("");
                    panelForm.add(transfer, "1");
                    panelForm.setVisible(true);
                    cardLayout.show(panelForm, "1");
                    panelFooter.setVisible(true);
                }

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
        panelTransfer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        panelTransfer.setPreferredSize(new Dimension(170, 80));
        panelHeader.add(panelTransfer);

        JLabel lblRecharge = new JLabel("Recharge");
        lblRecharge.setForeground(Color.BLACK);
        lblRecharge.setFont(new Font("Aurella", Font.BOLD, 20));

        panelRecharge = new RadiusAndShadow();
        panelRecharge.setBackground(Color.WHITE);
        panelRecharge.add(lblRecharge);
        panelRecharge.setOpaque(false);
        panelRecharge.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton() == 1)
                {
                    count = 2;
                    recharge = new PanelRecharge();
                    lblMessage.setText("");
                    panelForm.add(recharge, "2");
                    panelForm.setVisible(true);
                    cardLayout.show(panelForm, "2");
                    panelFooter.setVisible(true);
                }
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
        panelRecharge.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        panelRecharge.setPreferredSize(new Dimension(170, 80));
        panelHeader.add(panelRecharge);

        JLabel lblWithdraw = new JLabel("Withdraw");
        lblWithdraw.setForeground(Color.BLACK);
        lblWithdraw.setFont(new Font("Aurella", Font.BOLD, 20));

        panelWithdraw = new RadiusAndShadow();
        panelWithdraw.setBackground(Color.WHITE);
        panelWithdraw.add(lblWithdraw);
        panelWithdraw.setOpaque(false);
        panelWithdraw.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton() == 1)
                {
                    count = 3;
                    withdraw = new PanelWithdraw();
                    lblMessage.setText("");
                    panelForm.add(withdraw, "3");
                    panelForm.setVisible(true);
                    cardLayout.show(panelForm, "3");
                    panelFooter.setVisible(true);
                }
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
        panelWithdraw.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        panelWithdraw.setPreferredSize(new Dimension(170, 80));
        panelHeader.add(panelWithdraw);

    }
}

