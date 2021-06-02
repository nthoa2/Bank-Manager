package Views;

import Controller.LoginController;
import Controller.SignUpController;
import Controller.TransactionsController;
import Controller.UserController;
import Model.Login;
import RadiusAndShadow.image.Gradient;
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

public class SignUpFrame extends JFrame {
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

    private Image img_CMND = new ImageIcon("src/Res/CMND.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Fullname = new ImageIcon("src/Res/fullname.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Gender = new ImageIcon("src/Res/gender.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Phone_Number = new ImageIcon("src/Res/phonenumber.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Birth_Day = new ImageIcon("src/Res/birthday.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Address = new ImageIcon("src/Res/address.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_Username = new ImageIcon("src/Res/login_username.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_hide_password = new ImageIcon("src/Res/hide_password.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_show_password = new ImageIcon("src/Res/show_password.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_logo_bank = new ImageIcon("src/Res/bank.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);

    private int count1 = 0;
    private int count2 = 0;

    public SignUpFrame() {
        try {
            Image img = new ImageIcon(("src/Res/icon_frame.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            this.setIconImage(img);
        } catch (Exception e) {
            System.out.println("Application icon not found");
        }

        setUndecorated(true);
        setBounds(100, 100, 600, 600);
        setLocationRelativeTo(null);
        contentPane = new LinearGradient(0);
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
        contentPane.setLayout(null);
        contentPane.setFocusable(true);
        setContentPane(contentPane);


        JLabel lblIconLogoBank = new JLabel("");
        lblIconLogoBank.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconLogoBank.setBounds(280, 100, 300, 150);
        lblIconLogoBank.setIcon(new ImageIcon(img_logo_bank));
        contentPane.add(lblIconLogoBank);

        lblLoginMessage = new JLabel("");
        lblLoginMessage.setForeground(Color.RED);
        lblLoginMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoginMessage.setFont(new Font("Arial", Font.BOLD, 12));
        lblLoginMessage.setBounds(0, 490, 600, 18);
        setLocationRelativeTo(null);
        contentPane.add(lblLoginMessage);

        JPanel panelCMND = new RadiusAndShadow();
        panelCMND.setBackground(Color.WHITE);
        panelCMND.setBounds(20, 100, 260, 55);
        panelCMND.setLayout(null);
        contentPane.add(panelCMND);

        JSeparator sptCMND = new JSeparator();
        sptCMND.setForeground(Color.GRAY);
        sptCMND.setBounds(10, 35, 210, 1);
        panelCMND.add(sptCMND);

        txtCMND = new JTextField();
        txtCMND.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (txtCMND.getText().length() >= 12)
                    e.consume();
            }
        });
        txtCMND.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                sptCMND.setForeground(new Color(222, 97, 97));
                if (txtCMND.getText().equals("Số Căn Cước Công Dân")) {
                    txtCMND.setText("");
                    ((AbstractDocument) txtCMND.getDocument()).setDocumentFilter(new DocumentFilter() {
                        Pattern regEx = Pattern.compile("\\d*");

                        @Override
                        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches()) {
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
            public void focusLost(FocusEvent e) {
                sptCMND.setForeground(Color.GRAY);
                if (txtCMND.getText().equals("")) {
                    ((AbstractDocument) txtCMND.getDocument()).setDocumentFilter(new DocumentFilter() {
                        Pattern regEx = Pattern.compile("\\D*");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches()) {
                                return;
                            }
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                    txtCMND.setText("Số Căn Cước Công Dân");
                }
            }
        });
        txtCMND.setBackground(Color.WHITE);
        txtCMND.setForeground(Color.GRAY);
        txtCMND.setBorder(null);
        txtCMND.setFont(new Font("Arial", Font.PLAIN, 12));
        txtCMND.setText("Số Căn Cước Công Dân");
        txtCMND.setBounds(10, 10, 170, 20);
        txtCMND.setColumns(10);
        panelCMND.add(txtCMND);


        JLabel lblIconCMND = new JLabel("");
        lblIconCMND.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconCMND.setBounds(210, 0, 40, 40);
        lblIconCMND.setIcon(new ImageIcon(img_CMND));
        panelCMND.add(lblIconCMND);

        JPanel panelFullname = new RadiusAndShadow();
        panelFullname.setBackground(Color.WHITE);
        panelFullname.setBounds(20, 165, 260, 55);
        panelFullname.setLayout(null);
        contentPane.add(panelFullname);

        JSeparator sptFullname = new JSeparator();
        sptFullname.setForeground(Color.GRAY);
        sptFullname.setBounds(10, 35, 210, 1);
        panelFullname.add(sptFullname);

        txtFullname = new JTextField();
        txtFullname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (txtFullname.getText().length() >= 30)
                    e.consume();
            }
        });
        txtFullname.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                sptFullname.setForeground(new Color(222, 97, 97));
                if (txtFullname.getText().equals("Họ và Tên")) {
                    txtFullname.setText("");
                    ((AbstractDocument) txtFullname.getDocument()).setDocumentFilter(new DocumentFilter() {
                        Pattern regEx = Pattern.compile("[\\p{L}\\s]");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches()) {
                                lblLoginMessage.setText("Enter only text");
                                return;
                            }
                            lblLoginMessage.setText("");
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                } else {
                    txtFullname.selectAll();
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                sptFullname.setForeground(Color.gray);
                if (txtFullname.getText().equals("")) {
                    ((AbstractDocument) txtFullname.getDocument()).setDocumentFilter(new DocumentFilter() {
                        Pattern regEx = Pattern.compile("\\D*");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches()) {
                                return;
                            }
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                    txtFullname.setText("Họ và Tên");
                }
            }
        });
        txtFullname.setBackground(Color.WHITE);
        txtFullname.setForeground(Color.GRAY);
        txtFullname.setBorder(null);
        txtFullname.setFont(new Font("Arial", Font.PLAIN, 12));
        txtFullname.setText("Họ và Tên");
        txtFullname.setBounds(10, 10, 170, 20);
        txtFullname.setColumns(10);
        panelFullname.add(txtFullname);


        JLabel lblIconFullname = new JLabel("");
        lblIconFullname.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconFullname.setBounds(210, 0, 40, 40);
        lblIconFullname.setIcon(new ImageIcon(img_Fullname));
        panelFullname.add(lblIconFullname);

        JPanel panelGender = new RadiusAndShadow();
        panelGender.setBackground(Color.WHITE);
        panelGender.setBounds(20, 230, 260, 55);
        panelGender.setLayout(null);
        contentPane.add(panelGender);

        JSeparator sptGender = new JSeparator();
        sptGender.setForeground(Color.GRAY);
        sptGender.setBounds(10, 35, 210, 1);
        panelGender.add(sptGender);

        txtGender = new JTextField();
        txtGender.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (txtGender.getText().length() >= 3)
                    e.consume();
            }

        });
        txtGender.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                sptGender.setForeground(new Color(222, 97, 97));
                if (txtGender.getText().equals("Giới Tính")) {
                    txtGender.setText("");
                    ((AbstractDocument) txtGender.getDocument()).setDocumentFilter(new DocumentFilter() {
                        Pattern regEx = Pattern.compile("[\\p{L}\\s]");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches()) {
                                lblLoginMessage.setText("Chỉ Nhập 'Nam' Hay 'Nữ'");
                                return;
                            }
                            lblLoginMessage.setText("");
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                } else {
                    txtGender.selectAll();
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                sptGender.setForeground(Color.GRAY);
                if (txtGender.getText().equals("")) {
                    ((AbstractDocument) txtGender.getDocument()).setDocumentFilter(new DocumentFilter() {
                        Pattern regEx = Pattern.compile("\\D*");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches()) {
                                return;
                            }
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                    txtGender.setText("Giới Tính");
                }
            }
        });
        txtGender.setBackground(Color.WHITE);
        txtGender.setForeground(Color.GRAY);
        txtGender.setBorder(null);
        txtGender.setFont(new Font("Arial", Font.PLAIN, 12));
        txtGender.setText("Giới Tính");
        txtGender.setBounds(10, 10, 170, 20);
        txtGender.setColumns(10);
        panelGender.add(txtGender);


        JLabel lblIconGender = new JLabel("");
        lblIconGender.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconGender.setBounds(210, 0, 40, 40);
        lblIconGender.setIcon(new ImageIcon(img_Gender));
        panelGender.add(lblIconGender);

        JPanel panelPhoneNumber = new RadiusAndShadow();
        panelPhoneNumber.setBackground(Color.WHITE);
        panelPhoneNumber.setBounds(20, 295, 260, 55);
        panelPhoneNumber.setLayout(null);
        contentPane.add(panelPhoneNumber);

        JSeparator sptPhoneNumber = new JSeparator();
        sptPhoneNumber.setForeground(Color.GRAY);
        sptPhoneNumber.setBounds(10, 35, 210, 1);
        panelPhoneNumber.add(sptPhoneNumber);

        txtPhoneNumber = new JTextField();
        txtPhoneNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (txtPhoneNumber.getText().length() >= 10)
                    e.consume();
            }
        });
        txtPhoneNumber.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                sptPhoneNumber.setForeground(new Color(222, 97, 97));
                if (txtPhoneNumber.getText().equals("Số Điện Thoại")) {
                    txtPhoneNumber.setText("");
                    ((AbstractDocument) txtPhoneNumber.getDocument()).setDocumentFilter(new DocumentFilter() {
                        Pattern regEx = Pattern.compile("\\d*");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches()) {
                                lblLoginMessage.setText("Vui Lòng Chỉ Nhập Chữ Số [0-9]");
                                return;
                            }
                            lblLoginMessage.setText("");
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                } else txtPhoneNumber.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
                sptPhoneNumber.setForeground(Color.GRAY);
                if (txtPhoneNumber.getText().equals("")) {
                    ((AbstractDocument) txtPhoneNumber.getDocument()).setDocumentFilter(new DocumentFilter() {
                        Pattern regEx = Pattern.compile("\\D*");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches()) {
                                return;
                            }
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                    txtPhoneNumber.setText("Số Điện Thoại");
                }
            }
        });
        txtPhoneNumber.setBackground(Color.WHITE);
        txtPhoneNumber.setForeground(Color.GRAY);
        txtPhoneNumber.setBorder(null);
        txtPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 12));
        txtPhoneNumber.setText("Số Điện Thoại");
        txtPhoneNumber.setBounds(10, 10, 170, 20);
        txtPhoneNumber.setColumns(10);
        panelPhoneNumber.add(txtPhoneNumber);


        JLabel lblIconPhoneNumber = new JLabel("");
        lblIconPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconPhoneNumber.setBounds(210, 0, 40, 40);
        lblIconPhoneNumber.setIcon(new ImageIcon(img_Phone_Number));
        panelPhoneNumber.add(lblIconPhoneNumber);

        JPanel panelBirthDay = new RadiusAndShadow();
        panelBirthDay.setBackground(Color.WHITE);
        panelBirthDay.setBounds(20, 360, 260, 55);
        panelBirthDay.setLayout(null);
        contentPane.add(panelBirthDay);

        /// Calendar
        Date dateMin = new Date(01 / 01 / 1970);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -18);
        cal.add(Calendar.DATE, -1);
        Date dateMax = cal.getTime();

        JSeparator sptBirthDay = new JSeparator();
        sptBirthDay.setForeground(Color.GRAY);
        sptBirthDay.setBounds(10, 35, 210, 1);
        panelBirthDay.add(sptBirthDay);

        calendar = new com.toedter.calendar.JDateChooser(null, "dd-MM-yyyy");
        calendar.setBounds(10, 7, 235, 28);
        calendar.setSelectableDateRange(dateMin, dateMax);
        calendar.setFont(new Font("Arial", Font.PLAIN, 12));
        calendar.setIcon(new ImageIcon(img_Birth_Day));
        calendar.getDateEditor().setEnabled(false);
        calendar.getDateEditor().getUiComponent().setBackground(Color.WHITE);
        calendar.getDateEditor().getUiComponent().setBorder(null);
        calendar.getCalendarButton().setBorder(null);
        calendar.getCalendarButton().setBackground(Color.WHITE);
        calendar.getCalendarButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        calendar.setDate(dateMin);
        calendar.getCalendarButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sptBirthDay.setForeground(new Color(222, 97, 97));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sptBirthDay.setForeground(Color.gray);
                super.mouseExited(e);
            }
        });
        panelBirthDay.add(calendar);
        ///

        JPanel panelAddress = new RadiusAndShadow();
        panelAddress.setBackground(Color.WHITE);
        panelAddress.setBounds(20, 425, 260, 55);
        panelAddress.setLayout(null);
        contentPane.add(panelAddress);

        JSeparator sptAddress = new JSeparator();
        sptAddress.setForeground(Color.GRAY);
        sptAddress.setBounds(10, 35, 210, 1);
        panelAddress.add(sptAddress);

        txtAddress = new JTextField();
        txtAddress.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                sptAddress.setForeground(new Color(222, 97, 97));
                if (txtAddress.getText().equals("Địa Chỉ")) {
                    txtAddress.setText("");
                    ((AbstractDocument) txtAddress.getDocument()).setDocumentFilter(new DocumentFilter() {
                        Pattern regEx = Pattern.compile("[Z0-9-\\p{L}\\s]");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches()) {
                                lblLoginMessage.setText("Địa Chỉ Không Hợp Lệ");
                                return;
                            }
                            lblLoginMessage.setText("");
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                } else {
                    txtAddress.selectAll();
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                sptAddress.setForeground(Color.GRAY);
                if (txtAddress.getText().equals("")) {
                    ((AbstractDocument) txtAddress.getDocument()).setDocumentFilter(new DocumentFilter() {
                        Pattern regEx = Pattern.compile("\\D*");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches()) {
                                return;
                            }
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                    txtAddress.setText("Địa Chỉ");
                }
            }
        });
        txtAddress.setBackground(Color.WHITE);
        txtAddress.setForeground(Color.GRAY);
        txtAddress.setBorder(null);
        txtAddress.setFont(new Font("Arial", Font.PLAIN, 12));
        txtAddress.setText("Địa Chỉ");
        txtAddress.setBounds(10, 10, 170, 20);
        txtAddress.setColumns(10);
        panelAddress.add(txtAddress);


        JLabel lblIconAddress = new JLabel("");
        lblIconAddress.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconAddress.setBounds(210, 0, 40, 40);
        lblIconAddress.setIcon(new ImageIcon(img_Address));
        panelAddress.add(lblIconAddress);

        JPanel panelUsername = new RadiusAndShadow();
        panelUsername.setBackground(Color.WHITE);
        panelUsername.setBounds(300, 295, 260, 55);
        panelUsername.setLayout(null);
        contentPane.add(panelUsername);

        JSeparator sptUsername = new JSeparator();
        sptUsername.setForeground(Color.GRAY);
        sptUsername.setBounds(10, 35, 210, 1);
        panelUsername.add(sptUsername);

        txtUsername = new JTextField();
        txtUsername.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                sptUsername.setForeground(new Color(222, 97, 97));
                if (txtUsername.getText().equals("Tên Đăng Nhập")) {
                    txtUsername.setText("");
                } else {
                    txtUsername.selectAll();
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                sptUsername.setForeground(Color.GRAY);
                if (txtUsername.getText().equals("")) {
                    txtUsername.setText("Tên Đăng Nhập");
                }
            }
        });
        txtUsername.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                lblLoginMessage.setText("");
            }
        });
        txtUsername.setBackground(Color.WHITE);
        txtUsername.setForeground(Color.GRAY);
        txtUsername.setBorder(null);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
        txtUsername.setText("Tên Đăng Nhập");
        txtUsername.setBounds(10, 10, 170, 20);
        txtUsername.setColumns(10);
        panelUsername.add(txtUsername);


        JLabel lblIconUsername = new JLabel("");
        lblIconUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconUsername.setBounds(210, 0, 40, 40);
        lblIconUsername.setIcon(new ImageIcon(img_Username));
        panelUsername.add(lblIconUsername);

        JPanel panelPassword = new RadiusAndShadow();
        panelPassword.setBackground(Color.WHITE);
        panelPassword.setBounds(300, 360, 260, 55);
        panelPassword.setLayout(null);
        contentPane.add(panelPassword);

        JSeparator sptPassword = new JSeparator();
        sptPassword.setForeground(Color.GRAY);
        sptPassword.setBounds(10, 35, 210, 1);
        panelPassword.add(sptPassword);

        txtPassword = new JPasswordField();
        txtPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                sptPassword.setForeground(new Color(222, 97, 97));
                if (SignUpFrame.this.count1 % 2 == 0) {
                    if (txtPassword.getText().equals("Mật Khẩu")) {
                        txtPassword.setEchoChar('*');
                        txtPassword.setText("");
                    } else {
                        txtPassword.selectAll();
                    }
                } else {
                    if (txtPassword.getText().equals("Mật Khẩu")) {
                        txtPassword.setEchoChar((char) 0);
                        txtPassword.setText("");
                    } else {
                        txtPassword.selectAll();
                    }
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                sptPassword.setForeground(Color.GRAY);
                if (txtPassword.getText().equals("")) {
                    txtPassword.setText("Mật Khẩu");
                    txtPassword.setEchoChar((char) 0);
                }
            }
        });
        txtPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                lblLoginMessage.setText("");
            }
        });
        txtPassword.setBackground(Color.WHITE);
        txtPassword.setForeground(Color.GRAY);
        txtPassword.setBorder(null);
        txtPassword.setEchoChar((char) 0);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 12));
        txtPassword.setText("Mật Khẩu");
        txtPassword.setBounds(10, 11, 170, 20);
        panelPassword.add(txtPassword);


        JLabel lblIconPassword = new JLabel("");
        lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconPassword.setBounds(210, 0, 40, 40);
        lblIconPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblIconPassword.setIcon(new ImageIcon(img_hide_password));
        lblIconPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SignUpFrame.this.count1 % 2 == 0) {
                    SignUpFrame.this.count1++;
                    lblIconPassword.setIcon(new ImageIcon(img_show_password));
                    txtPassword.setEchoChar((char) 0);
                } else {
                    SignUpFrame.this.count1++;
                    lblIconPassword.setIcon(new ImageIcon(img_hide_password));
                    if (!txtPassword.getText().equals("Mật Khẩu"))
                        txtPassword.setEchoChar('*');
                }
            }
        });
        panelPassword.add(lblIconPassword);

        JPanel panelPasswordConfirm = new RadiusAndShadow();
        panelPasswordConfirm.setBackground(Color.WHITE);
        panelPasswordConfirm.setBounds(300, 425, 260, 55);
        panelPasswordConfirm.setLayout(null);
        contentPane.add(panelPasswordConfirm);

        JSeparator sptPasswordConfirm = new JSeparator();
        sptPasswordConfirm.setForeground(Color.GRAY);
        sptPasswordConfirm.setBounds(10, 35, 210, 1);
        panelPasswordConfirm.add(sptPasswordConfirm);

        txtPasswordConfirm = new JPasswordField();
        txtPasswordConfirm.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                sptPasswordConfirm.setForeground(new Color(222, 97, 97));
                if (SignUpFrame.this.count2 % 2 == 0) {
                    if (txtPasswordConfirm.getText().equals("Xác Nhận Mật Khẩu")) {
                        txtPasswordConfirm.setEchoChar('*');
                        txtPasswordConfirm.setText("");
                    } else {
                        txtPasswordConfirm.selectAll();
                    }
                } else {
                    if (txtPasswordConfirm.getText().equals("Xác Nhận Mât Khẩu")) {
                        txtPasswordConfirm.setEchoChar((char) 0);
                        txtPasswordConfirm.setText("");
                    } else {
                        txtPasswordConfirm.selectAll();
                    }
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                sptPasswordConfirm.setForeground(Color.GRAY);
                if (txtPasswordConfirm.getText().equals("")) {
                    txtPasswordConfirm.setText("Xác Nhận Mật Khẩu");
                    txtPasswordConfirm.setEchoChar((char) 0);
                }
            }
        });
        txtPasswordConfirm.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                lblLoginMessage.setText("");
            }
        });
        txtPasswordConfirm.setBackground(Color.WHITE);
        txtPasswordConfirm.setForeground(Color.GRAY);
        txtPasswordConfirm.setBorder(null);
        txtPasswordConfirm.setEchoChar((char) 0);
        txtPasswordConfirm.setFont(new Font("Arial", Font.PLAIN, 12));
        txtPasswordConfirm.setText("Xác Nhận Mật Khẩu");
        txtPasswordConfirm.setBounds(10, 11, 170, 20);
        panelPasswordConfirm.add(txtPasswordConfirm);


        JLabel lblIconPasswordConfirm = new JLabel("");
        lblIconPasswordConfirm.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconPasswordConfirm.setBounds(210, 0, 40, 40);
        lblIconPasswordConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblIconPasswordConfirm.setIcon(new ImageIcon(img_hide_password));
        lblIconPasswordConfirm.setIcon(new ImageIcon(img_hide_password));
        lblIconPasswordConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SignUpFrame.this.count2 % 2 == 0) {
                    SignUpFrame.this.count2++;
                    lblIconPasswordConfirm.setIcon(new ImageIcon(img_show_password));
                    txtPasswordConfirm.setEchoChar((char) 0);
                } else {
                    SignUpFrame.this.count2++;
                    lblIconPasswordConfirm.setIcon(new ImageIcon(img_hide_password));
                    if (!txtPasswordConfirm.getText().equals("Xác Nhận Mật Khẩu"))
                        txtPasswordConfirm.setEchoChar('*');
                }
            }
        });
        panelPasswordConfirm.add(lblIconPasswordConfirm);

        // Back
        JLabel lblBack = new JLabel("<");
        lblBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginFrame().setVisible(true);
                SignUpFrame.this.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent event) {
                lblBack.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent event) {
                lblBack.setForeground(Color.BLACK);
            }
        });
        lblBack.setForeground(Color.black);
        lblBack.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        lblBack.setHorizontalAlignment(SwingConstants.CENTER);
        lblBack.setBounds(2, 0, 20, 25);
        contentPane.add(lblBack);

        JLabel lblX = new JLabel("X");
        lblX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Bạn Chắc Muốn Thoát Chương Trình?", "Thông báo", JOptionPane.YES_NO_OPTION) == 0)
                    SignUpFrame.this.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent event) {
                lblX.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent event) {
                lblX.setForeground(Color.BLACK);
            }
        });
        lblX.setForeground(Color.BLACK);
        lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lblX.setHorizontalAlignment(SwingConstants.CENTER);
        lblX.setBounds(580, 0, 20, 20);
        contentPane.add(lblX);

        pnlBtnSignUp = new RadiusAndShadow();
        pnlBtnSignUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1)
                    validateSignUp();
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                pnlBtnSignUp.setBackground(new Color(21, 140, 180));
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                pnlBtnSignUp.setBackground(Color.WHITE);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                pnlBtnSignUp.setBackground(Color.GRAY);
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
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
        pnlBtnSignUp.setBounds(180, 510, 250, 50);
        pnlBtnSignUp.setLayout(null);
        contentPane.add(pnlBtnSignUp);

        JLabel lblSignUp = new JLabel("Đăng Ký");
        lblSignUp.setForeground(Color.BLACK);
        lblSignUp.setFont(new Font("Arial", Font.BOLD, 15));
        lblSignUp.setBounds(100, 6, 64, 28);
        pnlBtnSignUp.add(lblSignUp);

    }


    private void validateSignUp() {
        birthDay = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getDate());

        if (txtCMND.getText().equals("") || txtFullname.getText().equals("") || txtGender.getText().equals("") || txtPhoneNumber.getText().equals("") || txtAddress.getText().equals("") || txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtPasswordConfirm.getText().equals("")
                || txtCMND.getText().equals("Số Căn Cước Công Dân") || txtFullname.getText().equals("Họ và Tên") || txtGender.getText().equals("Giới Tính") || txtPhoneNumber.getText().equals("Số Điện Thoại") || txtAddress.getText().equals("Địa Chỉ") || txtUsername.getText().equals("Tên Đăng Nhập") || txtPassword.getText().equals("Mật Khẩu") || txtPasswordConfirm.getText().equals("Xác Nhận Mật Khẩu")) {
            lblLoginMessage.setText("Vui Lòng Điền Đầy Đủ Thông Tin");
        } else {
            if (txtCMND.getText().length() == 12) {
                if (txtPhoneNumber.getText().length() == 10) {
                    if (!LoginController.searchingLoginAccount(txtUsername.getText())) {
                        if (txtPassword.getText().length() >= 5) {
                            if (!UserController.searchingUser(txtCMND.getText())) {
                                if (!LoginController.searchingLoginAccount(txtUsername.getText())) {
                                    if (txtGender.getText().toLowerCase().equals("nam")) {
                                        SignUpController.initialSignUp(txtCMND.getText(), txtFullname.getText().trim(), 0, birthDay, txtAddress.getText(), txtPhoneNumber.getText(), txtUsername.getText(), txtPassword.getText());
                                        JOptionPane.showConfirmDialog(null, "Đăng Ký Thành Công!", "Thông Báo", JOptionPane.OK_OPTION);
                                    }else {
                                        SignUpController.initialSignUp(txtCMND.getText(), txtFullname.getText().trim(), 1, birthDay, txtAddress.getText(), txtPhoneNumber.getText(), txtUsername.getText(), txtPassword.getText());
                                        JOptionPane.showConfirmDialog(null, "Đăng Ký Khẩu Thành Công!", "Thông Báo", JOptionPane.OK_OPTION);
                                    }
                                } else {
                                    lblLoginMessage.setText("Tên Đăng Nhập Đã Tồn Tại!");
                                }
                            } else {
                                lblLoginMessage.setText("Căn Cước Đã Tồn Tại!");
                            }
                        } else {
                            lblLoginMessage.setText("Mật Khẩu Yếu!");
                        }
                    } else {
                        lblLoginMessage.setText("Tên Đăng Nhập Đã Tồn Tại!");
                    }
                } else {
                    lblLoginMessage.setText("Số Điện Thoại Không Hợp Lệ!");
                }
            } else {
                lblLoginMessage.setText("Số Căn Cước Không Hợp Lệ!");
            }
        }
    }


    private void AddEventEnter(JComponent item) {
        item.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    validateSignUp();
            }
        });
    }
}