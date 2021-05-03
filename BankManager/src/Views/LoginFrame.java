package Views;

import Model.Login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginFrame extends JFrame
{


    private JPanel mainPane;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    private Image img_logo = new ImageIcon(LoginFrame.class.getResource("/Res/bank.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
    private Image img_username = new ImageIcon(LoginFrame.class.getResource("/Res/businessman.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_password = new ImageIcon(LoginFrame.class.getResource("/Res/padlock.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_log_in = new ImageIcon(LoginFrame.class.getResource("/Res/key.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_logo_bank = new ImageIcon(LoginFrame.class.getResource("/Res/logobank.png")).getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH);


    public LoginFrame()
    {
        // GUI login
        setUndecorated(true);
        setBounds(100, 100, 600, 400);
        mainPane = new JPanel();
        mainPane.setBackground(new Color(49, 47, 47));
        mainPane.setBorder(new EmptyBorder(0,0,0,0));
        mainPane.setLayout(null);
        mainPane.setFocusable(true); // khi Frame hiện ra sẽ k lấy cái nào làm tiêu điểm
        setContentPane(mainPane);

        //khung nội dung bên trái
        JPanel contentPaneLeft = new JPanel();
        contentPaneLeft.setBackground(Color.BLACK);
        contentPaneLeft.setBounds(2, 2, 298, 396);
        contentPaneLeft.setLayout(null);
        mainPane.add(contentPaneLeft);

        JLabel lblIconLogo = new JLabel("");
        lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconLogo.setBounds(30,35, 250, 111);
        lblIconLogo.setIcon(new ImageIcon(img_logo));
        contentPaneLeft.add(lblIconLogo);

        // Khung nội dung bên phải
        JPanel contentPaneRight = new JPanel();
        contentPaneRight.setBackground(new Color(21, 140, 180));
        contentPaneRight.setBounds(300, 2, 298,396);
        contentPaneRight.setLayout(null);
        mainPane.add(contentPaneRight);

        JLabel lblIconLogoBank = new JLabel("");
        lblIconLogoBank.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconLogoBank.setBounds(30, 42, 250, 111);
        lblIconLogoBank.setIcon(new ImageIcon(img_logo_bank));
        contentPaneRight.add(lblIconLogoBank);


        JPanel panelUsername = new JPanel();
        panelUsername.setBackground(new Color(21, 140, 180));
        panelUsername.setBounds(20, 167, 250, 40);
        panelUsername.setLayout(null);
        contentPaneRight.add(panelUsername);

        txtUsername = new JTextField();
        txtUsername.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtUsername.getText().equals("Username"))
                {
                    txtUsername.setText("");
                } else
                {
                    txtUsername.selectAll();
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent)
            {
                if (txtUsername.getText().equals(""))
                {
                    txtUsername.setText("Username");
                }
            }
        });
        txtUsername.setBackground(new Color(21, 140, 180));
        txtUsername.setForeground(Color.black);
        txtUsername.setBorder(null);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
        txtUsername.setText("Username");
        txtUsername.setBounds(10, 10, 170, 20);
        txtUsername.setColumns(10);
        panelUsername.add(txtUsername);

        JSeparator sptUsername = new JSeparator();
        sptUsername.setForeground(Color.black);
        sptUsername.setBounds(10,35,210,1);
        panelUsername.add(sptUsername);

        JLabel lblIconUsername = new JLabel("");
        lblIconUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconUsername.setBounds(210, 0, 40, 40);
        lblIconUsername.setIcon(new ImageIcon(img_username));
        panelUsername.add(lblIconUsername);

        JPanel panelPassword = new JPanel();
        panelPassword.setBackground(new Color(21, 140, 180));
        panelPassword.setBounds(20, 218, 250, 40);
        panelPassword.setLayout(null);
        contentPaneRight.add(panelPassword);

        txtPassword = new JPasswordField();
        txtPassword.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtPassword.getText().equals("Password"))
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
                    txtPassword.setText("Password");
                    txtPassword.setEchoChar((char) 0);
                }
            }
        });
        txtPassword.setBackground(new Color(21, 140, 180));
        txtPassword.setForeground(Color.black);
        txtPassword.setBorder(null);
        txtPassword.setEchoChar((char) 0);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 12));
        txtPassword.setText("Password");
        txtPassword.setBounds(10, 11, 170, 20);
        panelPassword.add(txtPassword);

        JSeparator sptPassword = new JSeparator();
        sptPassword.setForeground(Color.black);
        sptPassword.setBounds(10,35,210,1);
        panelPassword.add(sptPassword);

        JLabel lblIconPassword = new JLabel("");
        lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconPassword.setBounds(210, 0, 40, 40);
        lblIconPassword.setIcon(new ImageIcon(img_password));
        panelPassword.add(lblIconPassword);

        // Button Login
        JLabel lblLoginMessage = new JLabel("");
        lblLoginMessage.setForeground(new Color(128, 0, 0));
        lblLoginMessage.setFont(new Font("Arial", Font.PLAIN, 12));
        lblLoginMessage.setBounds(20, 269, 250, 18);
        setLocationRelativeTo(null);
        contentPaneRight.add(lblLoginMessage);

        JPanel pnlBtnLogin = new JPanel();
        pnlBtnLogin.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (new Login().CheckLogin(txtUsername.getText(), txtPassword.getText()))
                {
                    new MainFrame().setVisible(true);
                    LoginFrame.this.dispose();
                } else if (txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtUsername.getText().equals("Username") || txtPassword.getText().equals("Password"))
                    lblLoginMessage.setText("Please input all requirements!");
                else lblLoginMessage.setText("Username and Password didn't match!");
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent)
            {
                pnlBtnLogin.setBackground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent)
            {
                pnlBtnLogin.setBackground(new Color(21, 140, 180));
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent)
            {
                pnlBtnLogin.setBackground(Color.GRAY);
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent)
            {
                pnlBtnLogin.setBackground(Color.WHITE);
            }
        });
        pnlBtnLogin.setBackground(new Color(21, 140, 180));
        pnlBtnLogin.setBounds(20, 298, 250, 50);
        pnlBtnLogin.setBorder(new LineBorder(Color.BLACK, 2,true));
        pnlBtnLogin.setLayout(null);
        contentPaneRight.add(pnlBtnLogin);

        JLabel lblLogIn = new JLabel("LOG IN");
        lblLogIn.setForeground(Color.BLACK);
        lblLogIn.setFont(new Font("Arial", Font.BOLD, 14));
        lblLogIn.setBounds(120, 11, 64, 28);
        pnlBtnLogin.add(lblLogIn);

        JLabel lblIconLogin = new JLabel("");
        lblIconLogin.setHorizontalAlignment(SwingConstants.TRAILING);
        lblIconLogin.setBounds(56, 0, 50, 50);
        lblIconLogin.setIcon(new ImageIcon(img_log_in));
        pnlBtnLogin.add(lblIconLogin);

        JLabel lblX = new JLabel("X");
        lblX.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
                    LoginFrame.this.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent event)
            {
                lblX.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent event)
            {
                lblX.setForeground(Color.WHITE);
            }
        });
        lblX.setForeground(Color.WHITE);
        lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblX.setHorizontalAlignment(SwingConstants.CENTER);
        lblX.setBounds(280, 0, 20, 20);
        contentPaneRight.add(lblX);


        // Button create account
        JPanel pnlBtnSignup = new JPanel();
        pnlBtnSignup.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                new SignUpFrame().setVisible(true);
                LoginFrame.this.dispose(); // tắt Frame cũ
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent)
            {
                pnlBtnSignup.setBackground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent)
            {
                pnlBtnSignup.setBackground(new Color(21, 140, 180));
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent)
            {
                pnlBtnSignup.setBackground(Color.GRAY);
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent)
            {
                pnlBtnSignup.setBackground(Color.WHITE);
            }
        });
        pnlBtnSignup.setBackground(new Color(21, 140, 180));
        pnlBtnSignup.setBounds(70, 360, 150, 30);
        pnlBtnSignup.setBorder(new LineBorder(Color.BLACK, 2, true));
        pnlBtnSignup.setLayout(null);
        contentPaneRight.add(pnlBtnSignup);

        JLabel lblSignup = new JLabel("Create Account");
        lblSignup.setForeground(Color.BLACK);
        lblSignup.setFont(new Font("Arial", Font.BOLD, 15));
        lblSignup.setBounds(20,8,150,15);
        pnlBtnSignup.add(lblSignup);
    }
}