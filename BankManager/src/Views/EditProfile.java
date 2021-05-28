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
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EditProfile extends JDialog
{
    private String birthDay;

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
        lblTitle.setBounds(0,50,500,50);
        mainPane.add(lblTitle);

        JLabel lblLoginMessage = new JLabel("");
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

        JTextField txtFullname = new JTextField();
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

        JPanel panelGender = new RadiusAndShadow();
        panelGender.setBackground(Color.WHITE);
        panelGender.setBounds(120, 170, 260, 45);
        panelGender.setLayout(null);
        mainPane.add(panelGender);

        JTextField txtGender = new JTextField();
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

        JPanel panelPhoneNumber = new RadiusAndShadow();
        panelPhoneNumber.setBackground(Color.WHITE);
        panelPhoneNumber.setBounds(120, 220, 260, 45);
        panelPhoneNumber.setLayout(null);
        mainPane.add(panelPhoneNumber);

        JTextField txtPhoneNumber = new JTextField();
        txtPhoneNumber.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if (txtPhoneNumber.getText().length() >= 11)
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

        JPanel panelBirthDay = new RadiusAndShadow();
        panelBirthDay.setBackground(Color.WHITE);
        panelBirthDay.setBounds(120, 270, 260, 45);
        panelBirthDay.setLayout(null);

        mainPane.add(panelBirthDay);

        JTextField txtDay = new JTextField();
        txtDay.setColumns(2);
        txtDay.setBackground(Color.WHITE);
        txtDay.setForeground(Color.GRAY);
        txtDay.setText("Day");
        txtDay.setFont(new Font("Arial", Font.PLAIN, 12));
        txtDay.setBounds(10, 10, 30, 20);
        txtDay.setBorder(null);
        txtDay.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if (txtDay.getText().length() >= 2) // limit to 3 characters
                    e.consume();
            }
        });
        txtDay.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtDay.getText().equals("Day"))
                {
                    txtDay.setText("");
                    ((AbstractDocument) txtDay.getDocument()).setDocumentFilter(new DocumentFilter()
                    {
                        Pattern regEx = Pattern.compile("\\d*");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
                        {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches())
                            {
                                lblLoginMessage.setText("Enter only numeric digits(1-31)");
                                return;
                            }
                            lblLoginMessage.setText("");
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                } else txtDay.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (txtDay.getText().equals(""))
                {
                    ((AbstractDocument) txtDay.getDocument()).setDocumentFilter(new DocumentFilter()
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
                    txtDay.setText("Day");
                }
            }
        });
        panelBirthDay.add(txtDay);

        JSeparator sptMonth = new JSeparator();
        sptMonth.setForeground(Color.GRAY);
        sptMonth.setOrientation(SwingConstants.VERTICAL);
        sptMonth.setBounds(40, 12, 10, 15);
        panelBirthDay.add(sptMonth);

        JTextField txtMonth = new JTextField();
        txtMonth.setColumns(2);
        txtMonth.setBackground(Color.WHITE);
        txtMonth.setForeground(Color.GRAY);
        txtMonth.setText("Month");
        txtMonth.setFont(new Font("Arial", Font.PLAIN, 12));
        txtMonth.setBounds(50, 10, 40, 20);
        txtMonth.setBorder(null);
        txtMonth.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if (txtMonth.getText().length() >= 2)
                    e.consume();
            }
        });
        txtMonth.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtMonth.getText().equals("Month"))
                {
                    txtMonth.setText("");
                    ((AbstractDocument) txtMonth.getDocument()).setDocumentFilter(new DocumentFilter()
                    {
                        Pattern regEx = Pattern.compile("\\d*");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
                        {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches())
                            {
                                lblLoginMessage.setText("Enter only numeric digits(1-12)");
                                return;
                            }
                            lblLoginMessage.setText("");
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                } else txtMonth.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (txtMonth.getText().equals(""))
                {
                    ((AbstractDocument) txtMonth.getDocument()).setDocumentFilter(new DocumentFilter()
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
                    txtMonth.setText("Month");
                }
            }
        });
        panelBirthDay.add(txtMonth);

        JSeparator sptYear = new JSeparator();
        sptYear.setForeground(Color.GRAY);
        sptYear.setOrientation(SwingConstants.VERTICAL);
        sptYear.setBounds(90, 12, 10, 15);
        panelBirthDay.add(sptYear);

        JTextField txtYear = new JTextField();
        txtYear.setColumns(4);
        txtYear.setBackground(Color.WHITE);
        txtYear.setForeground(Color.GRAY);
        txtYear.setText("Year");
        txtYear.setFont(new Font("Arial", Font.PLAIN, 12));
        txtYear.setBounds(120, 10, 50, 20);
        txtYear.setBorder(null);
        txtYear.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if (txtYear.getText().length() >= 4)
                    e.consume();
            }
        });
        txtYear.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (txtYear.getText().equals("Year"))
                {
                    txtYear.setText("");
                    ((AbstractDocument) txtYear.getDocument()).setDocumentFilter(new DocumentFilter()
                    {
                        Pattern regEx = Pattern.compile("\\d*");

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
                        {
                            Matcher matcher = regEx.matcher(text);
                            if (!matcher.matches())
                            {
                                lblLoginMessage.setText("Enter only numeric digits(1920-2003)");
                                return;
                            }
                            lblLoginMessage.setText("");
                            super.replace(fb, offset, length, text, attrs);
                        }
                    });
                } else txtYear.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (txtYear.getText().equals(""))
                {
                    ((AbstractDocument) txtYear.getDocument()).setDocumentFilter(new DocumentFilter()
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
                    txtYear.setText("Year");
                }
            }
        });
        panelBirthDay.add(txtYear);


        JPanel panelAddress = new RadiusAndShadow();
        panelAddress.setBackground(Color.WHITE);
        panelAddress.setBounds(120, 320, 260, 45);
        panelAddress.setLayout(null);
        mainPane.add(panelAddress);

        JTextField txtAddress = new JTextField();
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

        JLabel lblCancel = new JLabel("Cancel");
        lblCancel.setBounds(45,10,50,20);
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
        panelCancel.setBounds(90,400,150,50);
        mainPane.add(panelCancel);

        JLabel lblSave = new JLabel("Save");
        lblSave.setBounds(55,10,50,20);
        lblSave.setFont(new Font("Arial", Font.BOLD, 15));
        lblSave.setForeground(Color.BLACK);

        JPanel panelConfirm = new RadiusAndShadow();
        panelConfirm.setBackground(Color.WHITE);
        panelConfirm.add(lblSave);
        panelConfirm.setOpaque(false);
        panelConfirm.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                birthDay = txtYear.getText() + "-" + txtMonth.getText() + "-" + txtDay.getText();
                if ( txtFullname.getText().equals("") || txtGender.getText().equals("") || txtPhoneNumber.getText().equals("") || txtDay.getText().equals("") || txtMonth.getText().equals("") || txtYear.getText().equals("") || txtAddress.getText().equals("")
                        || txtFullname.getText().equals("Full Name") || txtGender.getText().equals("Gender") || txtPhoneNumber.getText().equals("Phone number") || txtDay.getText().equals("Day") || txtMonth.getText().equals("Month") || txtYear.getText().equals("Year") || txtAddress.getText().equals("Address"))
                    lblLoginMessage.setText("Please input all requirements!");
                else if (txtPhoneNumber.getText().length() < 10)
                    lblLoginMessage.setText("Invalid phone number");
                else if (Integer.parseInt(txtDay.getText()) > 31 || Integer.parseInt(txtDay.getText()) == 0)
                    lblLoginMessage.setText("Invalid day");
                else if (Integer.parseInt(txtMonth.getText()) > 12 || Integer.parseInt(txtMonth.getText()) == 0)
                    lblLoginMessage.setText("Invalid month");
                else if (txtYear.getText().length() < 4)
                    lblLoginMessage.setText("Invalid year of birth");
                else if (Integer.parseInt(txtYear.getText()) >= 2003 || Integer.parseInt(txtYear.getText()) <= 1920)
                    lblLoginMessage.setText("Your year old must inside 18 - 100");
                else
                {
                    JOptionPane.showMessageDialog(null, "Save Successful");
                    EditProfile.this.dispose();
                    LoginController.UpdateProfile(txtFullname.getText(), txtGender.getText(), txtPhoneNumber.getText(), birthDay, txtAddress.getText(), LoginFrame.username);
                    LoginController.getUserData(LoginFrame.username);
                    if(LoginController.CheckGender(LoginFrame.username))
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
        panelConfirm.setBounds(270,400,150,50);
        mainPane.add(panelConfirm);
    }
}
