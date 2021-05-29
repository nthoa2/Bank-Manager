package Views;

import Controller.LoginController;
import Model.Login;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpFrame extends JFrame
{
    private JPanel contentPane;
    private JTextField txtCMND;
    private JTextField txtFullname;
    private JTextField txtGender;
    private JTextField txtPhoneNumber;
    private String birthDay;
    private JTextField txtAddress;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPasswordField txtPasswordConfirm;
    private JLabel lblLoginMessage;
    private JPanel pnlBtnSignUp;
    private com.toedter.calendar.JDateChooser calendar;

    private Image img_CMND = new ImageIcon(SignUpFrame.class.getResource("/Res/CMND.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Fullname = new ImageIcon(SignUpFrame.class.getResource("/Res/fullname.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Gender = new ImageIcon(SignUpFrame.class.getResource("/Res/gender.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Phone_Number = new ImageIcon(SignUpFrame.class.getResource("/Res/phonenumber.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Birth_Day = new ImageIcon(SignUpFrame.class.getResource("/Res/birthday.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Address = new ImageIcon(SignUpFrame.class.getResource("/Res/address.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Username = new ImageIcon(SignUpFrame.class.getResource("/Res/businessman.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_hide_password = new ImageIcon(LoginFrame.class.getResource("/Res/hide_password.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_show_password = new ImageIcon(LoginFrame.class.getResource("/Res/show_password.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_logo_bank = new ImageIcon(SignUpFrame.class.getResource("/Res/bank.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);

    private int count1 = 0;
    private int count2 = 0;

    public SignUpFrame()
    {
        setUndecorated(true);
        setBounds(100, 100, 600, 500);
        setLocationRelativeTo(null);
        contentPane = new LinearGradient(0);
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
        contentPane.setLayout(null);
        contentPane.setFocusable(true);
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel();
        lblTitle.setText("Signup Form");
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setBounds(220, 10, 200, 30);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        contentPane.add(lblTitle);

        JLabel lblIconLogoBank = new JLabel("");
        lblIconLogoBank.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconLogoBank.setBounds(280, 60, 300, 150);
        lblIconLogoBank.setIcon(new ImageIcon(img_logo_bank));
        contentPane.add(lblIconLogoBank);

        lblLoginMessage = new JLabel("");
        lblLoginMessage.setForeground(Color.RED);
        lblLoginMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoginMessage.setFont(new Font("Arial", Font.BOLD, 12));
        lblLoginMessage.setBounds(0, 380, 600, 18);
        setLocationRelativeTo(null);
        contentPane.add(lblLoginMessage);

        JPanel panelCMND = new RadiusAndShadow();
        panelCMND.setBackground(Color.WHITE);
        panelCMND.setBounds(20, 70, 260, 55);
        panelCMND.setLayout(null);
        contentPane.add(panelCMND);


        txtCMND = new JTextField();
        txtCMND.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if (txtCMND.getText().length() >= 12)
                    e.consume();
            }
        });
        txtCMND.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtCMND.getText().equals("Citizen identification number"))
                {
                    txtCMND.setText("");
                    ((AbstractDocument) txtCMND.getDocument()).setDocumentFilter(new DocumentFilter()
                    {
                        Pattern regEx = Pattern.compile("\\d*");

                        @Override
                        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
                        {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches())
                            {
                                lblLoginMessage.setText("Enter only numeric digits(0-9)");
                                return;
                            }
                            lblLoginMessage.setText("");
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                } else txtCMND.selectAll(); // cho phép chọn text và nhập số sửa lun k cần nhấn nút xóa
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (txtCMND.getText().equals(""))
                {
                    ((AbstractDocument) txtCMND.getDocument()).setDocumentFilter(new DocumentFilter()
                    {
                        Pattern regEx = Pattern.compile("\\D*");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
                        {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches())
                            {
                                return;
                            }
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                    txtCMND.setText("Citizen identification number");
                }
            }
        });
        txtCMND.setBackground(Color.WHITE);
        txtCMND.setForeground(Color.GRAY);
        txtCMND.setBorder(null);
        txtCMND.setFont(new Font("Arial", Font.PLAIN, 12));
        txtCMND.setText("Citizen identification number");
        txtCMND.setBounds(10, 10, 170, 20);
        txtCMND.setColumns(10);
        panelCMND.add(txtCMND);

        JSeparator sptCMND = new JSeparator();
        sptCMND.setForeground(Color.GRAY);
        sptCMND.setBounds(10, 35, 210, 1);
        panelCMND.add(sptCMND);

        JLabel lblIconCMND = new JLabel("");
        lblIconCMND.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconCMND.setBounds(210, 0, 40, 40);
        lblIconCMND.setIcon(new ImageIcon(img_CMND));
        panelCMND.add(lblIconCMND);

        JPanel panelFullname = new RadiusAndShadow();
        panelFullname.setBackground(Color.WHITE);
        panelFullname.setBounds(20, 120, 260, 55);
        panelFullname.setLayout(null);
        contentPane.add(panelFullname);

        txtFullname = new JTextField();
        txtFullname.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if (txtFullname.getText().length() >= 30)
                    e.consume();
            }
        });
        txtFullname.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtFullname.getText().equals("Full Name"))
                {
                    txtFullname.setText("");
                    ((AbstractDocument) txtFullname.getDocument()).setDocumentFilter(new DocumentFilter()
                    {
                        Pattern regEx = Pattern.compile("[\\p{L}\\s]");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
                        {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches())
                            {
                                lblLoginMessage.setText("Enter only text");
                                return;
                            }
                            lblLoginMessage.setText("");
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
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
                    ((AbstractDocument) txtFullname.getDocument()).setDocumentFilter(new DocumentFilter()
                    {
                        Pattern regEx = Pattern.compile("\\D*");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
                        {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches())
                            {
                                return;
                            }
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                    txtFullname.setText("Full Name");
                }
            }
        });
        txtFullname.setBackground(Color.WHITE);
        txtFullname.setForeground(Color.GRAY);
        txtFullname.setBorder(null);
        txtFullname.setFont(new Font("Arial", Font.PLAIN, 12));
        txtFullname.setText("Full Name");
        txtFullname.setBounds(10, 10, 170, 20);
        txtFullname.setColumns(10);
        panelFullname.add(txtFullname);

        JSeparator sptFullname = new JSeparator();
        sptFullname.setForeground(Color.GRAY);
        sptFullname.setBounds(10, 35, 210, 1);
        panelFullname.add(sptFullname);

        JLabel lblIconFullname = new JLabel("");
        lblIconFullname.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconFullname.setBounds(210, 0, 40, 40);
        lblIconFullname.setIcon(new ImageIcon(img_Fullname));
        panelFullname.add(lblIconFullname);

        JPanel panelGender = new RadiusAndShadow();
        panelGender.setBackground(Color.WHITE);
        panelGender.setBounds(20, 170, 260, 55);
        panelGender.setLayout(null);
        contentPane.add(panelGender);

        txtGender = new JTextField();
        txtGender.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if (txtGender.getText().length() >= 3)
                    e.consume();
            }

        });
        txtGender.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtGender.getText().equals("Gender"))
                {
                    txtGender.setText("");
                    ((AbstractDocument) txtGender.getDocument()).setDocumentFilter(new DocumentFilter()
                    {
                        Pattern regEx = Pattern.compile("[\\p{L}\\s]");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
                        {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches())
                            {
                                lblLoginMessage.setText("Enter only 'nam' or 'nữ'");
                                return;
                            }
                            lblLoginMessage.setText("");
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
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
                    ((AbstractDocument) txtGender.getDocument()).setDocumentFilter(new DocumentFilter()
                    {
                        Pattern regEx = Pattern.compile("\\D*");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
                        {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches())
                            {
                                return;
                            }
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                    txtGender.setText("Gender");
                }
            }
        });
        txtGender.setBackground(Color.WHITE);
        txtGender.setForeground(Color.GRAY);
        txtGender.setBorder(null);
        txtGender.setFont(new Font("Arial", Font.PLAIN, 12));
        txtGender.setText("Gender");
        txtGender.setBounds(10, 10, 170, 20);
        txtGender.setColumns(10);
        panelGender.add(txtGender);

        JSeparator sptGender = new JSeparator();
        sptGender.setForeground(Color.GRAY);
        sptGender.setBounds(10, 35, 210, 1);
        panelGender.add(sptGender);

        JLabel lblIconGender = new JLabel("");
        lblIconGender.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconGender.setBounds(210, 0, 40, 40);
        lblIconGender.setIcon(new ImageIcon(img_Gender));
        panelGender.add(lblIconGender);

        JPanel panelPhoneNumber = new RadiusAndShadow();
        panelPhoneNumber.setBackground(Color.WHITE);
        panelPhoneNumber.setBounds(20, 220, 260, 55);
        panelPhoneNumber.setLayout(null);
        contentPane.add(panelPhoneNumber);

        txtPhoneNumber = new JTextField();
        txtPhoneNumber.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if (txtPhoneNumber.getText().length() >= 10)
                    e.consume();
            }
        });
        txtPhoneNumber.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtPhoneNumber.getText().equals("Phone number"))
                {
                    txtPhoneNumber.setText("");
                    ((AbstractDocument) txtPhoneNumber.getDocument()).setDocumentFilter(new DocumentFilter()
                    {
                        Pattern regEx = Pattern.compile("\\d*");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
                        {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches())
                            {
                                lblLoginMessage.setText("Enter only numeric digits(0-9)");
                                return;
                            }
                            lblLoginMessage.setText("");
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                } else txtPhoneNumber.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (txtPhoneNumber.getText().equals(""))
                {
                    ((AbstractDocument) txtPhoneNumber.getDocument()).setDocumentFilter(new DocumentFilter()
                    {
                        Pattern regEx = Pattern.compile("\\D*");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
                        {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches())
                            {
                                return;
                            }
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                    txtPhoneNumber.setText("Phone number");
                }
            }
        });
        txtPhoneNumber.setBackground(Color.WHITE);
        txtPhoneNumber.setForeground(Color.GRAY);
        txtPhoneNumber.setBorder(null);
        txtPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 12));
        txtPhoneNumber.setText("Phone number");
        txtPhoneNumber.setBounds(10, 10, 170, 20);
        txtPhoneNumber.setColumns(10);
        panelPhoneNumber.add(txtPhoneNumber);

        JSeparator sptPhoneNumber = new JSeparator();
        sptPhoneNumber.setForeground(Color.GRAY);
        sptPhoneNumber.setBounds(10, 35, 210, 1);
        panelPhoneNumber.add(sptPhoneNumber);

        JLabel lblIconPhoneNumber = new JLabel("");
        lblIconPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconPhoneNumber.setBounds(210, 0, 40, 40);
        lblIconPhoneNumber.setIcon(new ImageIcon(img_Phone_Number));
        panelPhoneNumber.add(lblIconPhoneNumber);

        JPanel panelBirthDay = new RadiusAndShadow();
        panelBirthDay.setBackground(Color.WHITE);
        panelBirthDay.setBounds(20, 270, 260, 55);
        panelBirthDay.setLayout(null);
        contentPane.add(panelBirthDay);

        /// Calendar
        Date dateMin = new Date(01/01/1970);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -18);
        cal.add(Calendar.DATE, -1);
        Date dateMax = cal.getTime();

        calendar = new com.toedter.calendar.JDateChooser(null,"dd-MM-yyyy");
        calendar.setBounds(10,7,235,28);
        calendar.setSelectableDateRange(dateMin, dateMax);
        calendar.setFont(new Font("Arial", Font.PLAIN, 12));
        calendar.setIcon(new ImageIcon(img_Birth_Day));
        calendar.getDateEditor().setEnabled(false);
        calendar.getDateEditor().getUiComponent().setBackground(Color.WHITE);
        calendar.getDateEditor().getUiComponent().setBorder(null);
        calendar.getCalendarButton().setBorder(null);
        calendar.getCalendarButton().setBackground(Color.WHITE);
        calendar.setDate(dateMin);
        panelBirthDay.add(calendar);
        ///

        JSeparator sptBirthDay = new JSeparator();
        sptBirthDay.setForeground(Color.GRAY);
        sptBirthDay.setBounds(10, 35, 210, 1);
        panelBirthDay.add(sptBirthDay);

        JPanel panelAddress = new RadiusAndShadow();
        panelAddress.setBackground(Color.WHITE);
        panelAddress.setBounds(20, 320, 260, 55);
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
                    ((AbstractDocument) txtAddress.getDocument()).setDocumentFilter(new DocumentFilter()
                    {
                        Pattern regEx = Pattern.compile("[Z0-9-\\p{L}\\s]");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
                        {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches())
                            {
                                lblLoginMessage.setText("Not enter char special");
                                return;
                            }
                            lblLoginMessage.setText("");
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
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
                    ((AbstractDocument) txtAddress.getDocument()).setDocumentFilter(new DocumentFilter()
                    {
                        Pattern regEx = Pattern.compile("\\D*");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
                        {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches())
                            {
                                return;
                            }
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                    txtAddress.setText("Address");
                }
            }
        });
        txtAddress.setBackground(Color.WHITE);
        txtAddress.setForeground(Color.GRAY);
        txtAddress.setBorder(null);
        txtAddress.setFont(new Font("Arial", Font.PLAIN, 12));
        txtAddress.setText("Address");
        txtAddress.setBounds(10, 10, 170, 20);
        txtAddress.setColumns(10);
        panelAddress.add(txtAddress);

        JSeparator sptAddress = new JSeparator();
        sptAddress.setForeground(Color.GRAY);
        sptAddress.setBounds(10, 35, 210, 1);
        panelAddress.add(sptAddress);

        JLabel lblIconAddress = new JLabel("");
        lblIconAddress.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconAddress.setBounds(210, 0, 40, 40);
        lblIconAddress.setIcon(new ImageIcon(img_Address));
        panelAddress.add(lblIconAddress);

        JPanel panelUsername = new RadiusAndShadow();
        panelUsername.setBackground(Color.WHITE);
        panelUsername.setBounds(300, 220, 260, 55);
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
        txtUsername.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                lblLoginMessage.setText("");
            }
        });
        txtUsername.setBackground(Color.WHITE);
        txtUsername.setForeground(Color.GRAY);
        txtUsername.setBorder(null);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
        txtUsername.setText("Username");
        txtUsername.setBounds(10, 10, 170, 20);
        txtUsername.setColumns(10);
        panelUsername.add(txtUsername);

        JSeparator sptUsername = new JSeparator();
        sptUsername.setForeground(Color.GRAY);
        sptUsername.setBounds(10, 35, 210, 1);
        panelUsername.add(sptUsername);

        JLabel lblIconUsername = new JLabel("");
        lblIconUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconUsername.setBounds(210, 0, 40, 40);
        lblIconUsername.setIcon(new ImageIcon(img_Username));
        panelUsername.add(lblIconUsername);

        JPanel panelPassword = new RadiusAndShadow();
        panelPassword.setBackground(Color.WHITE);
        panelPassword.setBounds(300, 270, 260, 55);
        panelPassword.setLayout(null);
        contentPane.add(panelPassword);

        txtPassword = new JPasswordField();
        txtPassword.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (SignUpFrame.this.count1 % 2 == 0)
                {
                    if (txtPassword.getText().equals("Password"))
                    {
                        txtPassword.setEchoChar('*');
                        txtPassword.setText("");
                    } else
                    {
                        txtPassword.selectAll();
                    }
                } else
                {
                    if (txtPassword.getText().equals("Password"))
                    {
                        txtPassword.setEchoChar((char) 0);
                        txtPassword.setText("");
                    } else
                    {
                        txtPassword.selectAll();
                    }
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
        txtPassword.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                lblLoginMessage.setText("");
            }
        });
        txtPassword.setBackground(Color.WHITE);
        txtPassword.setForeground(Color.GRAY);
        txtPassword.setBorder(null);
        txtPassword.setEchoChar((char) 0);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 12));
        txtPassword.setText("Password");
        txtPassword.setBounds(10, 11, 170, 20);
        panelPassword.add(txtPassword);

        JSeparator sptPassword = new JSeparator();
        sptPassword.setForeground(Color.GRAY);
        sptPassword.setBounds(10, 35, 210, 1);
        panelPassword.add(sptPassword);

        JLabel lblIconPassword = new JLabel("");
        lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconPassword.setBounds(210, 0, 40, 40);
        lblIconPassword.setIcon(new ImageIcon(img_hide_password));
        lblIconPassword.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (SignUpFrame.this.count1 % 2 == 0)
                {
                    SignUpFrame.this.count1++;
                    lblIconPassword.setIcon(new ImageIcon(img_show_password));
                    txtPassword.setEchoChar((char) 0);
                } else
                {
                    SignUpFrame.this.count1++;
                    lblIconPassword.setIcon(new ImageIcon(img_hide_password));
                    if (!txtPassword.getText().equals("Password"))
                        txtPassword.setEchoChar('*');
                }
            }
        });
        panelPassword.add(lblIconPassword);

        JPanel panelPasswordConfirm = new RadiusAndShadow();
        panelPasswordConfirm.setBackground(Color.WHITE);
        panelPasswordConfirm.setBounds(300, 320, 260, 55);
        panelPasswordConfirm.setLayout(null);
        contentPane.add(panelPasswordConfirm);

        txtPasswordConfirm = new JPasswordField();
        txtPasswordConfirm.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (SignUpFrame.this.count2 % 2 == 0)
                {
                    if (txtPasswordConfirm.getText().equals("Password confirm"))
                    {
                        txtPasswordConfirm.setEchoChar('*');
                        txtPasswordConfirm.setText("");
                    } else
                    {
                        txtPasswordConfirm.selectAll();
                    }
                } else
                {
                    if (txtPasswordConfirm.getText().equals("Password confirm"))
                    {
                        txtPasswordConfirm.setEchoChar((char) 0);
                        txtPasswordConfirm.setText("");
                    } else
                    {
                        txtPasswordConfirm.selectAll();
                    }
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
        txtPasswordConfirm.setBackground(Color.WHITE);
        txtPasswordConfirm.setForeground(Color.GRAY);
        txtPasswordConfirm.setBorder(null);
        txtPasswordConfirm.setEchoChar((char) 0);
        txtPasswordConfirm.setFont(new Font("Arial", Font.PLAIN, 12));
        txtPasswordConfirm.setText("Password confirm");
        txtPasswordConfirm.setBounds(10, 11, 170, 20);
        panelPasswordConfirm.add(txtPasswordConfirm);

        JSeparator sptPasswordConfirm = new JSeparator();
        sptPasswordConfirm.setForeground(Color.GRAY);
        sptPasswordConfirm.setBounds(10, 35, 210, 1);
        panelPasswordConfirm.add(sptPasswordConfirm);

        JLabel lblIconPasswordConfirm = new JLabel("");
        lblIconPasswordConfirm.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconPasswordConfirm.setBounds(210, 0, 40, 40);
        lblIconPasswordConfirm.setIcon(new ImageIcon(img_hide_password));
        lblIconPasswordConfirm.setIcon(new ImageIcon(img_hide_password));
        lblIconPasswordConfirm.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (SignUpFrame.this.count2 % 2 == 0)
                {
                    SignUpFrame.this.count2++;
                    lblIconPasswordConfirm.setIcon(new ImageIcon(img_show_password));
                    txtPasswordConfirm.setEchoChar((char) 0);
                } else
                {
                    SignUpFrame.this.count2++;
                    lblIconPasswordConfirm.setIcon(new ImageIcon(img_hide_password));
                    if (!txtPasswordConfirm.getText().equals("Password confirm"))
                        txtPasswordConfirm.setEchoChar('*');
                }
            }
        });
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
                lblBack.setForeground(Color.BLACK);
            }
        });
        lblBack.setForeground(Color.black);
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
                lblX.setForeground(Color.BLACK);
            }
        });
        lblX.setForeground(Color.BLACK);
        lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblX.setHorizontalAlignment(SwingConstants.CENTER);
        lblX.setBounds(580, 0, 20, 20);
        contentPane.add(lblX);

        pnlBtnSignUp = new RadiusAndShadow();
        pnlBtnSignUp.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton() == 1)
                    CheckSignUp();
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent)
            {
                pnlBtnSignUp.setBackground(new Color(21, 140, 180));
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent)
            {
                pnlBtnSignUp.setBackground(Color.WHITE);
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
        AddEventEnter(contentPane);
        AddEventEnter(txtCMND);
        AddEventEnter(txtFullname);
        AddEventEnter(txtGender);
        AddEventEnter(txtPhoneNumber);
        AddEventEnter(txtAddress);
        AddEventEnter(txtUsername);
        AddEventEnter(txtPassword);
        AddEventEnter(txtPasswordConfirm);
        pnlBtnSignUp.setBackground(Color.WHITE);
        pnlBtnSignUp.setBounds(165, 400, 250, 50);
        pnlBtnSignUp.setLayout(null);
        contentPane.add(pnlBtnSignUp);

        JLabel lblSignUp = new JLabel("Register");
        lblSignUp.setForeground(Color.BLACK);
        lblSignUp.setFont(new Font("Arial", Font.BOLD, 15));
        lblSignUp.setBounds(100, 6, 64, 28);
        pnlBtnSignUp.add(lblSignUp);

    }

    private void CheckSignUp()
    {
        String accountNumber = LoginController.Random(0, 9, 10);
        // obj.replaceAll("\\s+","") xóa tất cả các khoảng trắng và các ký tự không nhìn thấy (ví dụ: tab, \n).
        // obj.replaceAll("[^a-zA-Z0-9]", "") xóa tất cả ký tự đặc biệt và thay bằng khoảng trắng
        // [^\p{L}\s] xóa các ký tự đặc biệt trừ dấu tiếng Việt
        if (txtCMND.getText().equals("") || txtFullname.getText().equals("") || txtGender.getText().equals("") || txtPhoneNumber.getText().equals("") ||  txtAddress.getText().equals("") || txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtPasswordConfirm.getText().equals("")
                || txtCMND.getText().equals("Citizen identification number") || txtFullname.getText().equals("Full Name") || txtGender.getText().equals("Gender") || txtPhoneNumber.getText().equals("Phone number") ||  txtAddress.getText().equals("Year") || txtAddress.getText().equals("Address") || txtUsername.getText().equals("Username") || txtPassword.getText().equals("Password") || txtPasswordConfirm.getText().equals("Password confirm"))
            lblLoginMessage.setText("Please input all requirements!");
        else if (txtCMND.getText().length() < 12)
            lblLoginMessage.setText("Invalid citizen identification number");
        else if (txtPhoneNumber.getText().length() < 10)
            lblLoginMessage.setText("Invalid phone number");
        else if (txtUsername.getText().length() < 6)
            lblLoginMessage.setText("Username must be 6 characters or more");
        else if (txtPassword.getText().length() < 8)
            lblLoginMessage.setText("Password must be 8 characters or more");
        else if (LoginController.CheckSignUpTenTK(txtUsername.getText()))
            lblLoginMessage.setText("Username already exists, please enter another name!");
        else if (!txtPassword.getText().equals(txtPasswordConfirm.getText()))
            lblLoginMessage.setText("Password confirm is not correct!");
        else if (LoginController.CheckCMND(txtCMND.getText()))
        {
            pnlBtnSignUp.setBackground(new Color(21, 140, 180));
            while (LoginController.CheckSignUpSoTK(accountNumber))
                accountNumber = LoginController.Random(0, 9, 10);
            LoginController.InsertDataTAIKHOAN(accountNumber, txtUsername.getText(), txtPassword.getText(), txtCMND.getText());
            lblLoginMessage.setText("");
            JOptionPane.showMessageDialog(null, "SignUp Successful");
            new LoginFrame().setVisible(true);
            SignUpFrame.this.dispose();
        } else
        {
            pnlBtnSignUp.setBackground(new Color(21, 140, 180));
            birthDay = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getDate());
            LoginController.InsertDataKHACHHANG(txtCMND.getText(), txtFullname.getText(), txtPhoneNumber.getText(), txtGender.getText(), birthDay, txtAddress.getText());
            while (LoginController.CheckSignUpSoTK(accountNumber))
                accountNumber = LoginController.Random(0, 9, 10);
            LoginController.InsertDataTAIKHOAN(accountNumber, txtUsername.getText(), txtPassword.getText(), txtCMND.getText());
            lblLoginMessage.setText("");
            JOptionPane.showMessageDialog(null, "SignUp Successful");
            new LoginFrame().setVisible(true);
            SignUpFrame.this.dispose();
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
                    CheckSignUp();
            }
        });
    }
}