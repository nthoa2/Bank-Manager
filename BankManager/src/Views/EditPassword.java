package Views;

import Controller.LoginController;
import Model.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditPassword extends JDialog
{

    private JPanel panelConfirm;
    private JLabel lblLoginMessage;
    private JPasswordField txtPasswordOld;
    private JPasswordField txtPassword;
    private JPasswordField txtPasswordConfirm;

    public EditPassword()
    {
        this.setModal(true);
        this.setBackground(Color.GRAY);
        this.setUndecorated(true);
        this.setBounds(875, 370, 400, 400);
        JPanel mainPane = new LinearGradient(1);
        mainPane.setLayout(null);
        mainPane.setFocusable(true);
        mainPane.setBorder(null);
        this.setContentPane(mainPane);
        JLabel lblTitle = new JLabel("Changes PassWord");

        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 20, 400, 50);
        mainPane.add(lblTitle);

        lblLoginMessage = new JLabel("");
        lblLoginMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoginMessage.setForeground(Color.RED);
        lblLoginMessage.setFont(new Font("Arial", Font.BOLD, 12));
        lblLoginMessage.setBounds(0, 270, 400, 18);
        mainPane.add(lblLoginMessage);

        JPanel panelPasswordOld = new RadiusAndShadow();
        panelPasswordOld.setBackground(Color.WHITE);
        panelPasswordOld.setBounds(80, 100, 260, 45);
        panelPasswordOld.setLayout(null);
        mainPane.add(panelPasswordOld);

        txtPasswordOld = new JPasswordField();
        txtPasswordOld.setBackground(Color.WHITE);
        txtPasswordOld.setForeground(Color.GRAY);
        txtPasswordOld.setBorder(null);
        txtPasswordOld.setEchoChar((char) 0);
        txtPasswordOld.setFont(new Font("Arial", Font.PLAIN, 12));
        txtPasswordOld.setText("Password old");
        txtPasswordOld.setBounds(10, 8, 170, 20);
        txtPasswordOld.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtPasswordOld.getText().equals("Password old"))
                {
                    txtPasswordOld.setEchoChar('*');
                    txtPasswordOld.setText("");
                } else
                {
                    txtPasswordOld.selectAll();
                }
            }

            @Override
            public void focusLost(FocusEvent fe)
            {
                if (txtPasswordOld.getText().equals(""))
                {
                    txtPasswordOld.setText("Password old");
                    txtPasswordOld.setEchoChar((char) 0);
                }
            }
        });
        txtPasswordOld.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                lblLoginMessage.setText("");
            }
        });
        panelPasswordOld.add(txtPasswordOld);

        JPanel panelPassword = new RadiusAndShadow();
        panelPassword.setBackground(Color.WHITE);
        panelPassword.setBounds(80, 150, 260, 45);
        panelPassword.setLayout(null);
        mainPane.add(panelPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBackground(Color.WHITE);
        txtPassword.setForeground(Color.GRAY);
        txtPassword.setBorder(null);
        txtPassword.setEchoChar((char) 0);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 12));
        txtPassword.setText("Password new");
        txtPassword.setBounds(10, 8, 170, 20);
        txtPassword.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtPassword.getText().equals("Password new"))
                {
                    txtPassword.setEchoChar('*');
                    txtPassword.setText("");
                } else
                {
                    txtPassword.selectAll();
                }
            }

            @Override
            public void focusLost(FocusEvent fe)
            {
                if (txtPassword.getText().equals(""))
                {
                    txtPassword.setText("Password new");
                    txtPassword.setEchoChar((char) 0);
                }
            }
        });
        txtPassword.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                lblLoginMessage.setText("");
            }
        });
        panelPassword.add(txtPassword);


        JPanel panelPasswordConfirm = new RadiusAndShadow();
        panelPasswordConfirm.setBackground(Color.WHITE);
        panelPasswordConfirm.setBounds(80, 200, 260, 45);
        panelPasswordConfirm.setLayout(null);
        mainPane.add(panelPasswordConfirm);

        txtPasswordConfirm = new JPasswordField();
        txtPasswordConfirm.setBackground(Color.WHITE);
        txtPasswordConfirm.setForeground(Color.GRAY);
        txtPasswordConfirm.setBorder(null);
        txtPasswordConfirm.setEchoChar((char) 0);
        txtPasswordConfirm.setFont(new Font("Arial", Font.PLAIN, 12));
        txtPasswordConfirm.setText("Password confirm");
        txtPasswordConfirm.setBounds(10, 8, 170, 20);
        txtPasswordConfirm.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtPasswordConfirm.getText().equals("Password confirm"))
                {
                    txtPasswordConfirm.setEchoChar('*');
                    txtPasswordConfirm.setText("");
                } else
                {
                    txtPasswordConfirm.selectAll();
                }
            }

            @Override
            public void focusLost(FocusEvent fe)
            {
                if (txtPasswordConfirm.getText().equals(""))
                {
                    txtPasswordConfirm.setText("Password confirm");
                    txtPasswordConfirm.setEchoChar((char) 0);
                }
            }
        });
        txtPasswordConfirm.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                lblLoginMessage.setText("");
            }
        });
        panelPasswordConfirm.add(txtPasswordConfirm);


        JLabel lblCancel = new JLabel("Cancel");
        lblCancel.setBounds(45, 10, 50, 20);
        lblCancel.setFont(new Font("Arial", Font.BOLD, 15));
        lblCancel.setForeground(Color.BLACK);

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
                    EditPassword.this.dispose();
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
        panelCancel.setLayout(null);
        panelCancel.setBounds(40, 300, 150, 50);
        mainPane.add(panelCancel);

        JLabel lblSave = new JLabel("Save");
        lblSave.setBounds(55, 10, 50, 20);
        lblSave.setFont(new Font("Arial", Font.BOLD, 15));
        lblSave.setForeground(Color.BLACK);

        panelConfirm = new RadiusAndShadow();
        panelConfirm.setBackground(Color.WHITE);
        panelConfirm.add(lblSave);
        panelConfirm.setOpaque(false);
        panelConfirm.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton() == 1)
                    CheckEditPassword();
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
        panelConfirm.setLayout(null);
        panelConfirm.setBounds(220, 300, 150, 50);
        mainPane.add(panelConfirm);
        AddEventEnter(mainPane);
        AddEventEnter(txtPasswordOld);
        AddEventEnter(txtPassword);
        AddEventEnter(txtPasswordConfirm);
    }

    private void CheckEditPassword()
    {
        if (txtPasswordOld.getText().equals("") || txtPassword.getText().equals("") || txtPasswordConfirm.getText().equals("") || txtPasswordOld.getText().equals("Password old") || txtPassword.getText().equals("Password new") || txtPasswordConfirm.getText().equals("Password confirm"))
            lblLoginMessage.setText("Please input all requirements!");
        else if (!LoginFrame.password.equals(txtPasswordOld.getText()))
            lblLoginMessage.setText("Password old incorrect!");
        else if (txtPasswordOld.getText().equals(txtPassword.getText()))
            lblLoginMessage.setText("Password new not same password old!");
        else if (!txtPassword.getText().equals(txtPasswordConfirm.getText()))
            lblLoginMessage.setText("Password confirm is not correct!");
        else if (txtPassword.getText().length() < 8)
            lblLoginMessage.setText("Password must be 8 characters or more!");
        else
        {
            panelConfirm.setBackground(new Color(216, 53, 65));
            JOptionPane.showMessageDialog(null, "Save Successful");
            EditPassword.this.dispose();
            LoginFrame.password = txtPassword.getText();
            LoginController.UpdatePassword(txtPassword.getText(), LoginFrame.username);
        }
    }

    private void AddEventEnter(JComponent item)
    {
        item.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    CheckEditPassword();
            }
        });
    }
}
