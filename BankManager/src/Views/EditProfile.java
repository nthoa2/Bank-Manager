package Views;

import Controller.LoginController;
import Model.Login;

import javax.swing.*;
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


public class EditProfile extends JDialog
{
    private String birthDay;
    private JLabel lblLoginMessage;
    private JTextField txtFullname;
    private JTextField txtGender;
    private JTextField txtPhoneNumber;
    private com.toedter.calendar.JDateChooser calendar;
    private JTextField txtAddress;
    private JPanel panelConfirm;

    private Image img_Birth_Day = new ImageIcon(SignUpFrame.class.getResource("/Res/birthday.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

    public EditProfile()
    {
        this.setModal(true);
        this.setBackground(Color.WHITE);
        this.setUndecorated(true);
        this.setBounds(825, 350, 500, 500);
        JPanel mainPane = new LinearGradient(1);
        mainPane.setLayout(null);
        mainPane.setFocusable(true);
        mainPane.setBorder(null);
        this.setContentPane(mainPane);

        JLabel lblTitle = new JLabel("Edit Profile");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
        lblTitle.setBounds(0, 50, 500, 50);
        mainPane.add(lblTitle);

        lblLoginMessage = new JLabel("");
        lblLoginMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoginMessage.setForeground(Color.RED);
        lblLoginMessage.setFont(new Font("Arial", Font.BOLD, 12));
        lblLoginMessage.setBounds(0, 380, 500, 18);
        mainPane.add(lblLoginMessage);

        JPanel panelFullname = new RadiusAndShadow();
        panelFullname.setBackground(Color.WHITE);
        panelFullname.setBounds(120, 120, 260, 45);
        panelFullname.setLayout(null);
        mainPane.add(panelFullname);

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
        txtFullname.setBounds(10, 7, 170, 20);
        txtFullname.setColumns(10);
        panelFullname.add(txtFullname);

        JPanel panelGender = new RadiusAndShadow();
        panelGender.setBackground(Color.WHITE);
        panelGender.setBounds(120, 170, 260, 45);
        panelGender.setLayout(null);
        mainPane.add(panelGender);

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
        txtGender.setBounds(10, 7, 170, 20);
        txtGender.setColumns(10);
        panelGender.add(txtGender);

        JPanel panelPhoneNumber = new RadiusAndShadow();
        panelPhoneNumber.setBackground(Color.WHITE);
        panelPhoneNumber.setBounds(120, 220, 260, 45);
        panelPhoneNumber.setLayout(null);
        mainPane.add(panelPhoneNumber);

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
        txtPhoneNumber.setBounds(10, 7, 170, 20);
        txtPhoneNumber.setColumns(10);
        panelPhoneNumber.add(txtPhoneNumber);

        JPanel panelBirthDay = new RadiusAndShadow();
        panelBirthDay.setBackground(Color.WHITE);
        panelBirthDay.setBounds(120, 270, 260, 45);
        panelBirthDay.setLayout(null);

        mainPane.add(panelBirthDay);

        /// Calendar
        Date dateMin = new Date(01/01/1970);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -18);
        cal.add(Calendar.DATE, -1);
        Date dateMax = cal.getTime();

        calendar = new com.toedter.calendar.JDateChooser(null,"dd-MM-yyyy");
        calendar.setBounds(10,5,235,25);
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


        JPanel panelAddress = new RadiusAndShadow();
        panelAddress.setBackground(Color.WHITE);
        panelAddress.setBounds(120, 320, 260, 45);
        panelAddress.setLayout(null);
        mainPane.add(panelAddress);

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
        txtAddress.setBounds(10, 7, 170, 20);
        txtAddress.setColumns(10);
        panelAddress.add(txtAddress);

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
                    EditProfile.this.dispose();
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
        panelCancel.setBounds(90, 400, 150, 50);
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
                    CheckEditProfile();
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
        AddEventEnter(txtFullname);
        AddEventEnter(txtGender);
        AddEventEnter(txtPhoneNumber);
        AddEventEnter(txtAddress);
        AddEventEnter(mainPane);
        panelConfirm.setLayout(null);
        panelConfirm.setBounds(270, 400, 150, 50);
        mainPane.add(panelConfirm);
    }

    private void CheckEditProfile()
    {
        birthDay = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getDate());;
        if (txtFullname.getText().equals("") || txtGender.getText().equals("") || txtPhoneNumber.getText().equals("") || txtAddress.getText().equals("")
                || txtFullname.getText().equals("Full Name") || txtGender.getText().equals("Gender") || txtPhoneNumber.getText().equals("Phone number")  || txtAddress.getText().equals("Address"))
            lblLoginMessage.setText("Please input all requirements!");
        else if (txtPhoneNumber.getText().length() < 10)
            lblLoginMessage.setText("Invalid phone number");
        else
        {
            panelConfirm.setBackground(new Color(216, 53, 65));
            JOptionPane.showMessageDialog(null, "Save Successful");
            EditProfile.this.dispose();
            LoginController.UpdateProfile(txtFullname.getText(), txtGender.getText(), txtPhoneNumber.getText(), birthDay, txtAddress.getText(), LoginFrame.username);
            LoginController.getUserData(LoginFrame.username);
            if (LoginController.CheckGender(LoginFrame.username))
                PanelProfile.lblAvatar.setIcon(new ImageIcon(PanelProfile.img_man));
            else PanelProfile.lblAvatar.setIcon(new ImageIcon(PanelProfile.img_woman));

            MainFrame.btnProfile.setText(LoginController.fullname);

            PanelProfile.lblFullName.setText(LoginController.fullname);
            PanelProfile.lblGender.setText(LoginController.gender);
            PanelProfile.lblPhone.setText(LoginController.phone);
            PanelProfile.lblBirthday.setText(LoginController.born);
            PanelProfile.lblAddress.setText(LoginController.address);
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
                    CheckEditProfile();
            }
        });
    }
}
