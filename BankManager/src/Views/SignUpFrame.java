package Views;

import Model.Login;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUpFrame extends JFrame
{
    private JPanel contentPane;
    private JTextField txtCMND;
    private JTextField txtFullname;
    private JTextField txtGender;
    private JTextField txtPhoneNumber;
    private JTextField txtBirthDay;
    private JTextField txtAddress;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPasswordField txtPasswordConfirm;

    private Image img_CMND = new ImageIcon(SignUpFrame.class.getResource("/Res/CMND.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Fullname = new ImageIcon(SignUpFrame.class.getResource("/Res/fullname.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Gender = new ImageIcon(SignUpFrame.class.getResource("/Res/gender.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Phone_Number = new ImageIcon(SignUpFrame.class.getResource("/Res/phonenumber.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Birth_Day = new ImageIcon(SignUpFrame.class.getResource("/Res/birthday.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Address = new ImageIcon(SignUpFrame.class.getResource("/Res/address.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Username = new ImageIcon(SignUpFrame.class.getResource("/Res/businessman.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Password = new ImageIcon(SignUpFrame.class.getResource("/Res/padlock.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_logo_bank = new ImageIcon(LoginFrame.class.getResource("/Res/logobank.png")).getImage().getScaledInstance(240, 240, Image.SCALE_SMOOTH);

    public SignUpFrame()
    {
        setUndecorated(true);
        setBounds(100, 100, 600, 450);
        setLocationRelativeTo(null);
        contentPane = new JPanel();

        contentPane.setBackground(new Color(21, 140, 180));
        contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
        contentPane.setLayout(null);
        contentPane.setFocusable(true);
        setContentPane(contentPane);

        JLabel lblIconLogoBank = new JLabel("");
        lblIconLogoBank.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconLogoBank.setBounds(280, 40, 300, 150);
        lblIconLogoBank.setIcon(new ImageIcon(img_logo_bank));
        contentPane.add(lblIconLogoBank);

        JPanel panelCMND = new JPanel();
        panelCMND.setBackground(new Color(21, 140, 180));
        panelCMND.setBounds(20, 50, 250, 40);
        panelCMND.setLayout(null);
        contentPane.add(panelCMND);

        txtCMND = new JTextField();
        txtCMND.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtCMND.getText().equals("Citizen identification number"))
                {
                    txtCMND.setText("");
                } else
                {
                    txtCMND.selectAll();
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent)
            {
                if (txtCMND.getText().equals(""))
                {
                    txtCMND.setText("Citizen identification number");
                }
            }
        });
        txtCMND.setBackground(new Color(21, 140, 180));
        txtCMND.setBorder(null);
        txtCMND.setFont(new Font("Arial", Font.PLAIN, 12));
        txtCMND.setText("Citizen identification number");
        txtCMND.setBounds(10, 10, 170, 20);
        txtCMND.setColumns(10);
        panelCMND.add(txtCMND);

        JSeparator sptCMND = new JSeparator();
        sptCMND.setForeground(Color.black);
        sptCMND.setBounds(10, 35, 210, 1);
        panelCMND.add(sptCMND);

        JLabel lblIconCMND = new JLabel("");
        lblIconCMND.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconCMND.setBounds(210, 0, 40, 40);
        lblIconCMND.setIcon(new ImageIcon(img_CMND));
        panelCMND.add(lblIconCMND);

        JPanel panelFullname = new JPanel();
        panelFullname.setBackground(new Color(21, 140, 180));
        panelFullname.setBounds(20, 100, 250, 40);
        panelFullname.setLayout(null);
        contentPane.add(panelFullname);

        txtFullname = new JTextField();
        txtFullname.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtFullname.getText().equals("Full Name"))
                {
                    txtFullname.setText("");
                } else
                {
                    txtFullname.selectAll();
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent)
            {
                if (txtFullname.getText().equals(""))
                {
                    txtFullname.setText("Full Name");
                }
            }
        });
        txtFullname.setBackground(new Color(21, 140, 180));
        txtFullname.setBorder(null);
        txtFullname.setFont(new Font("Arial", Font.PLAIN, 12));
        txtFullname.setText("Full Name");
        txtFullname.setBounds(10, 10, 170, 20);
        txtFullname.setColumns(10);
        panelFullname.add(txtFullname);

        JSeparator sptFullname = new JSeparator();
        sptFullname.setForeground(Color.black);
        sptFullname.setBounds(10, 35, 210, 1);
        panelFullname.add(sptFullname);

        JLabel lblIconFullname = new JLabel("");
        lblIconFullname.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconFullname.setBounds(210, 0, 40, 40);
        lblIconFullname.setIcon(new ImageIcon(img_Fullname));
        panelFullname.add(lblIconFullname);

        JPanel panelGender = new JPanel();
        panelGender.setBackground(new Color(21, 140, 180));
        panelGender.setBounds(20, 150, 250, 40);
        panelGender.setLayout(null);
        contentPane.add(panelGender);

        txtGender = new JTextField();
        txtGender.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtGender.getText().equals("Gender"))
                {
                    txtGender.setText("");
                } else
                {
                    txtGender.selectAll();
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent)
            {
                if (txtGender.getText().equals(""))
                {
                    txtGender.setText("Gender");
                }
            }
        });
        txtGender.setBackground(new Color(21, 140, 180));
        txtGender.setBorder(null);
        txtGender.setFont(new Font("Arial", Font.PLAIN, 12));
        txtGender.setText("Gender");
        txtGender.setBounds(10, 10, 170, 20);
        txtGender.setColumns(10);
        panelGender.add(txtGender);

        JSeparator sptGender = new JSeparator();
        sptGender.setForeground(Color.black);
        sptGender.setBounds(10, 35, 210, 1);
        panelGender.add(sptGender);

        JLabel lblIconGender = new JLabel("");
        lblIconGender.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconGender.setBounds(210, 0, 40, 40);
        lblIconGender.setIcon(new ImageIcon(img_Gender));
        panelGender.add(lblIconGender);

        JPanel panelPhoneNumber = new JPanel();
        panelPhoneNumber.setBackground(new Color(21, 140, 180));
        panelPhoneNumber.setBounds(20, 200, 250, 40);
        panelPhoneNumber.setLayout(null);
        contentPane.add(panelPhoneNumber);

        txtPhoneNumber = new JTextField();
        txtPhoneNumber.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtPhoneNumber.getText().equals("Phone number"))
                {
                    txtPhoneNumber.setText("");
                } else
                {
                    txtPhoneNumber.selectAll();
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent)
            {
                if (txtPhoneNumber.getText().equals(""))
                {
                    txtPhoneNumber.setText("Phone number");
                }
            }
        });
        txtPhoneNumber.setBackground(new Color(21, 140, 180));
        txtPhoneNumber.setBorder(null);
        txtPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 12));
        txtPhoneNumber.setText("Phone number");
        txtPhoneNumber.setBounds(10, 10, 170, 20);
        txtPhoneNumber.setColumns(10);
        panelPhoneNumber.add(txtPhoneNumber);

        JSeparator sptPhoneNumber = new JSeparator();
        sptPhoneNumber.setForeground(Color.black);
        sptPhoneNumber.setBounds(10, 35, 210, 1);
        panelPhoneNumber.add(sptPhoneNumber);

        JLabel lblIconPhoneNumber = new JLabel("");
        lblIconPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconPhoneNumber.setBounds(210, 0, 40, 40);
        lblIconPhoneNumber.setIcon(new ImageIcon(img_Phone_Number));
        panelPhoneNumber.add(lblIconPhoneNumber);

        JPanel panelBirthDay = new JPanel();
        panelBirthDay.setBackground(new Color(21, 140, 180));
        panelBirthDay.setBounds(20, 250, 250, 40);
        panelBirthDay.setLayout(null);
        contentPane.add(panelBirthDay);

        txtBirthDay = new JTextField();
        txtBirthDay.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtBirthDay.getText().equals("Birth day"))
                {
                    txtBirthDay.setText("");
                } else
                {
                    txtBirthDay.selectAll();
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent)
            {
                if (txtBirthDay.getText().equals(""))
                {
                    txtBirthDay.setText("Birth day");
                }
            }
        });
        txtBirthDay.setBackground(new Color(21, 140, 180));
        txtBirthDay.setBorder(null);
        txtBirthDay.setFont(new Font("Arial", Font.PLAIN, 12));
        txtBirthDay.setText("Birth day");
        txtBirthDay.setBounds(10, 10, 170, 20);
        txtBirthDay.setColumns(10);
        panelBirthDay.add(txtBirthDay);

        JSeparator sptBirthDay = new JSeparator();
        sptBirthDay.setForeground(Color.black);
        sptBirthDay.setBounds(10, 35, 210, 1);
        panelBirthDay.add(sptBirthDay);

        JLabel lblIconBirthDay = new JLabel("");
        lblIconBirthDay.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconBirthDay.setBounds(210, 0, 40, 40);
        lblIconBirthDay.setIcon(new ImageIcon(img_Birth_Day));
        panelBirthDay.add(lblIconBirthDay);

        JPanel panelAddress = new JPanel();
        panelAddress.setBackground(new Color(21, 140, 180));
        panelAddress.setBounds(20, 300, 250, 40);
        panelAddress.setLayout(null);
        contentPane.add(panelAddress);

        txtAddress = new JTextField();
        txtAddress.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtAddress.getText().equals("Address"))
                {
                    txtAddress.setText("");
                } else
                {
                    txtAddress.selectAll();
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent)
            {
                if (txtAddress.getText().equals(""))
                {
                    txtAddress.setText("Address");
                }
            }
        });
        txtAddress.setBackground(new Color(21, 140, 180));
        txtAddress.setBorder(null);
        txtAddress.setFont(new Font("Arial", Font.PLAIN, 12));
        txtAddress.setText("Address");
        txtAddress.setBounds(10, 10, 170, 20);
        txtAddress.setColumns(10);
        panelAddress.add(txtAddress);

        JSeparator sptAddress = new JSeparator();
        sptAddress.setForeground(Color.black);
        sptAddress.setBounds(10, 35, 210, 1);
        panelAddress.add(sptAddress);

        JLabel lblIconAddress = new JLabel("");
        lblIconAddress.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconAddress.setBounds(210, 0, 40, 40);
        lblIconAddress.setIcon(new ImageIcon(img_Address));
        panelAddress.add(lblIconAddress);

        JPanel panelUsername = new JPanel();
        panelUsername.setBackground(new Color(21, 140, 180));
        panelUsername.setBounds(300, 200, 250, 40);
        panelUsername.setLayout(null);
        contentPane.add(panelUsername);

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
        txtUsername.setBorder(null);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
        txtUsername.setText("Username");
        txtUsername.setBounds(10, 10, 170, 20);
        txtUsername.setColumns(10);
        panelUsername.add(txtUsername);

        JSeparator sptUsername = new JSeparator();
        sptUsername.setForeground(Color.black);
        sptUsername.setBounds(10, 35, 210, 1);
        panelUsername.add(sptUsername);

        JLabel lblIconUsername = new JLabel("");
        lblIconUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconUsername.setBounds(210, 0, 40, 40);
        lblIconUsername.setIcon(new ImageIcon(img_Username));
        panelUsername.add(lblIconUsername);

        JPanel panelPassword = new JPanel();
        panelPassword.setBackground(new Color(21, 140, 180));
        panelPassword.setBounds(300, 250, 250, 40);
        panelPassword.setLayout(null);
        contentPane.add(panelPassword);

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
        txtPassword.setBorder(null);
        txtPassword.setEchoChar((char) 0);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 12));
        txtPassword.setText("Password");
        txtPassword.setBounds(10, 11, 170, 20);
        panelPassword.add(txtPassword);

        JSeparator sptPassword = new JSeparator();
        sptPassword.setForeground(Color.black);
        sptPassword.setBounds(10, 35, 210, 1);
        panelPassword.add(sptPassword);

        JLabel lblIconPassword = new JLabel("");
        lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconPassword.setBounds(210, 0, 40, 40);
        lblIconPassword.setIcon(new ImageIcon(img_Password));
        panelPassword.add(lblIconPassword);

        JPanel panelPasswordConfirm = new JPanel();
        panelPasswordConfirm.setBackground(new Color(21, 140, 180));
        panelPasswordConfirm.setBounds(300, 300, 250, 40);
        panelPasswordConfirm.setLayout(null);
        contentPane.add(panelPasswordConfirm);

        txtPasswordConfirm = new JPasswordField();
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
        txtPasswordConfirm.setBackground(new Color(21, 140, 180));
        txtPasswordConfirm.setBorder(null);
        txtPasswordConfirm.setEchoChar((char) 0);
        txtPasswordConfirm.setFont(new Font("Arial", Font.PLAIN, 12));
        txtPasswordConfirm.setText("Password confirm");
        txtPasswordConfirm.setBounds(10, 11, 170, 20);
        panelPasswordConfirm.add(txtPasswordConfirm);

        JSeparator sptPasswordConfirm = new JSeparator();
        sptPasswordConfirm.setForeground(Color.black);
        sptPasswordConfirm.setBounds(10, 35, 210, 1);
        panelPasswordConfirm.add(sptPasswordConfirm);

        JLabel lblIconPasswordConfirm = new JLabel("");
        lblIconPasswordConfirm.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconPasswordConfirm.setBounds(210, 0, 40, 40);
        lblIconPasswordConfirm.setIcon(new ImageIcon(img_Password));
        panelPasswordConfirm.add(lblIconPasswordConfirm);

        // Back
        JLabel lblBack = new JLabel("<");
        lblBack.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                new LoginFrame().setVisible(true);
                SignUpFrame.this.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent event)
            {
                lblBack.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent event)
            {
                lblBack.setForeground(Color.WHITE);
            }
        });
        lblBack.setForeground(Color.WHITE);
        lblBack.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblBack.setHorizontalAlignment(SwingConstants.CENTER);
        lblBack.setBounds(2, 0, 20, 20);
        contentPane.add(lblBack);

        JLabel lblX = new JLabel("X");
        lblX.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
                    SignUpFrame.this.dispose();
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
        lblX.setBounds(580, 0, 20, 20);
        contentPane.add(lblX);

        JLabel lblLoginMessage = new JLabel("");
        lblLoginMessage.setForeground(new Color(128, 0, 0));
        lblLoginMessage.setFont(new Font("Arial", Font.PLAIN, 12));
        lblLoginMessage.setBounds(165, 350, 250, 18);
        setLocationRelativeTo(null);
        contentPane.add(lblLoginMessage);

        JPanel pnlBtnSignUp = new JPanel();
        pnlBtnSignUp.addMouseListener(new MouseAdapter()
        {
            Login login = new Login();
            String accountNumber = login.Random(0, 9, 10);

            @Override
            public void mouseClicked(MouseEvent e)
            {
                // obj.replaceAll("\\s+","") xóa tất cả các khoảng trắng và các ký tự không nhìn thấy (ví dụ: tab, \n).
                // obj.replaceAll("[^a-zA-Z0-9]", "") xóa tất cả ký tự đặc biệt và thay bằng khoảng trắng
                txtCMND.setText(txtCMND.getText().replaceAll("\\s+", ""));
                txtCMND.setText(txtCMND.getText().replaceAll("[^Z0-9]", ""));

                // [^\p{L}\s] xóa các ký tự đặc biệt trừ dấu tiếng Việt
                txtFullname.setText(txtFullname.getText().replaceAll("[^\\p{L}\\s]", " "));
                txtFullname.setText(txtFullname.getText().replaceAll("\\s+", " "));

                txtGender.setText(txtGender.getText().replaceAll("\\s+", ""));
                txtGender.setText(txtGender.getText().replaceAll("[^\\p{L}\\s]", ""));

                txtPhoneNumber.setText(txtPhoneNumber.getText().replaceAll("\\s+", ""));
                txtPhoneNumber.setText(txtPhoneNumber.getText().replaceAll("[^Z0-9]", ""));

//                txtBirthDay.setText(txtBirthDay.getText().replaceAll("\\s+", ""));
//                txtBirthDay.setText(txtBirthDay.getText().replaceAll("[^a-zA-Z0-9 -]", ""));

                txtUsername.getText().replaceAll("\\s+", "");
                txtUsername.getText().replaceAll("[^a-zA-Z0-9]", "");

                txtPassword.getText().replaceAll("\\s+", "");
                txtPassword.getText().replaceAll("[^a-zA-Z0-9]", "");

                txtPasswordConfirm.getText().replaceAll("\\s+", "");
                txtPasswordConfirm.getText().replaceAll("[^a-zA-Z0-9]", "");

                if (txtCMND.getText().equals("") || txtFullname.getText().equals("") || txtGender.getText().equals("") || txtPhoneNumber.getText().equals("") || txtBirthDay.getText().equals("") || txtAddress.getText().equals("") || txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtPasswordConfirm.getText().equals("")
                        || txtCMND.getText().equals("Citizen identification number") || txtFullname.getText().equals("Full Name") || txtGender.getText().equals("Gender") || txtPhoneNumber.getText().equals("Phone number") || txtBirthDay.getText().equals("Birth day") || txtAddress.getText().equals("Address") || txtUsername.getText().equals("Username") || txtPassword.getText().equals("Password") || txtPasswordConfirm.getText().equals("Password confirm"))
                    lblLoginMessage.setText("Please input all requirements!");
                else if(!txtPassword.getText().equals(txtPasswordConfirm.getText()))
                    lblLoginMessage.setText("Password confirm is not correct!");
//                else if (!StringUtils.isNumeric(txtCMND.getText()))
//                    lblLoginMessage.setText("Citizen identification number must be numeric");
                else if (login.CheckCMND(txtCMND.getText()))
                {
                    while (login.CheckSignUpSoTK(accountNumber))
                        accountNumber = login.Random(0, 9, 10);
                    if (!login.CheckSignUpTenTK(txtUsername.getText()))
                    {
                        login.InsertDataTAIKHOAN(accountNumber, txtUsername.getText(), txtPassword.getText(), txtCMND.getText());
                        lblLoginMessage.setText("");
                        JOptionPane.showMessageDialog(null, "SignUp Successful");
                        new LoginFrame().setVisible(true);
                        SignUpFrame.this.dispose();
                    } else
                        lblLoginMessage.setText("Username already exists, please enter another name!");
                } else
                {
                    login.InsertDataKHACHHANG(txtCMND.getText(), txtFullname.getText(), txtPhoneNumber.getText(), txtGender.getText(), txtBirthDay.getText(), txtAddress.getText());
                    while (login.CheckSignUpSoTK(accountNumber))
                        accountNumber = login.Random(0, 9, 10);
                    if (!login.CheckSignUpTenTK(txtUsername.getText()))
                    {
                        login.InsertDataTAIKHOAN(accountNumber, txtUsername.getText(), txtPassword.getText(), txtCMND.getText());
                        lblLoginMessage.setText("");
                        JOptionPane.showMessageDialog(null, "SignUp Successful");
                        new LoginFrame().setVisible(true);
                        SignUpFrame.this.dispose();
                    } else
                        lblLoginMessage.setText("Username already exists, please enter another name!");
                }
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent)
            {
                pnlBtnSignUp.setBackground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent)
            {
                pnlBtnSignUp.setBackground(new Color(21, 140, 180));
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent)
            {
                pnlBtnSignUp.setBackground(Color.GRAY);
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent)
            {
                pnlBtnSignUp.setBackground(Color.WHITE);
            }
        });
        pnlBtnSignUp.setBackground(new Color(21, 140, 180));
        pnlBtnSignUp.setBounds(165, 380, 250, 50);
        pnlBtnSignUp.setBorder(new LineBorder(Color.BLACK, 2, true));
        pnlBtnSignUp.setLayout(null);
        contentPane.add(pnlBtnSignUp);

        JLabel lblSignUp = new JLabel("SIGN UP");
        lblSignUp.setForeground(Color.BLACK);
        lblSignUp.setFont(new Font("Arial", Font.BOLD, 14));
        lblSignUp.setBounds(100, 11, 64, 28);
        pnlBtnSignUp.add(lblSignUp);

    }

}