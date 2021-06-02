package Views;


import Controller.AccountController;
import Controller.LoginController;
import Controller.TransactionsController;
import Controller.UserController;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

public class PanelTrading extends JPanel {
    private GridBagConstraints gbc3;
    public static JTextField txtAccountNumber;
    public static JFormattedTextField txtAmount;
    public static JTextArea txtContent;
    private JLabel lblAccountReceived;
    public static JLabel lblBalanceData = new JLabel(UserController.BalanceFormat.format(UserController.AccountBalance));
    private Image img_transfer = new ImageIcon(("src/Res/img_transfer.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
    private Image img_recharge = new ImageIcon(("src/Res/img_recharge.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
    private Image img_withdraw = new ImageIcon(("src/Res/img_withdraw.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
    private JLabel lblIcon = new JLabel("");

    public PanelTrading(String typeTrade) {
        this.setLayout(new BorderLayout(40, 0));
        gbc3 = new GridBagConstraints();
        gbc3.insets = new Insets(10, 10, 10, 10);
        gbc3.weightx = 1;
        gbc3.weighty = 1;
        gbc3.fill = GridBagConstraints.BOTH;


        JPanel panelGBLHeader = new JPanel();
        panelGBLHeader.setPreferredSize(new Dimension(200, 100));
        this.add(panelGBLHeader, "North");

        JPanel panelGBLFooter = new JPanel();
        panelGBLFooter.setPreferredSize(new Dimension(200, 100));
        this.add(panelGBLFooter, "South");


        JPanel accountNumber = new RadiusAndShadow();
        accountNumber.setBackground(Color.white);
        accountNumber.setLayout(new GridBagLayout());
        if (typeTrade.equals("Transfer")) {
            lblIcon.setIcon(new ImageIcon(img_transfer));
            lblAccountReceived = new JLabel("Số Tài Khoản Người Nhận");
            txtAccountNumber = new JTextField();
            txtAccountNumber.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                        txtAccountNumber.setEditable(true);
                        PanelService.lblMessage.setText("");
                    } else {
                        txtAccountNumber.setEditable(false);
                        PanelService.lblMessage.setText("Vui Lòng Chỉ Nhập Số");
                    }
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    if (txtAccountNumber.getText().length() >= 10)
                        e.consume();
                }
            });
            txtAccountNumber.setBackground(Color.WHITE);
            txtAccountNumber.setBorder(null);
            txtAccountNumber.setColumns(20);
            txtAccountNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        } else {
            if (typeTrade.equals("Recharge")) {
                lblAccountReceived = new JLabel("Nạp Vào Số Tài Khoản");
                lblIcon.setIcon(new ImageIcon(img_recharge));
            } else {
                lblAccountReceived = new JLabel("Rút Từ Số Tài Khoản");
                lblIcon.setIcon(new ImageIcon(img_withdraw));
            }
            txtAccountNumber = new JTextField();
            txtAccountNumber.setEnabled(false);
            txtAccountNumber.setText(LoginController.AccountNumber);
            txtAccountNumber.setBackground(Color.WHITE);
            txtAccountNumber.setBorder(null);
            txtAccountNumber.setColumns(20);
            txtAccountNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        }
        accountNumber.add(txtAccountNumber, gbc3);


        JPanel amount = new RadiusAndShadow();
        amount.setBackground(Color.WHITE);
        amount.setLayout(new GridBagLayout());

        JPanel panelAmount = new JPanel();
        panelAmount.setBackground(Color.WHITE);
        panelAmount.setLayout(new BoxLayout(panelAmount, BoxLayout.X_AXIS));
        amount.add(panelAmount, gbc3);

        JPanel panelVND = new JPanel();
        panelVND.setBackground(Color.WHITE);
        panelVND.setLayout(new BoxLayout(panelVND, BoxLayout.X_AXIS));

        JSeparator sptVND = new JSeparator();
        sptVND.setPreferredSize(new Dimension(10, 0));
        sptVND.setForeground(Color.GRAY);
        sptVND.setOrientation(SwingConstants.VERTICAL);
        panelVND.add(sptVND);

        JLabel lblVND = new JLabel("VNĐ");
        lblVND.setForeground(Color.GRAY);
        lblVND.setFont(new Font("Arial", Font.BOLD, 15));
        panelVND.add(lblVND);

        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(0);
        NumberFormatter numberFormat = new NumberFormatter(format);
        numberFormat.setAllowsInvalid(false);
        txtAmount = new JFormattedTextField(numberFormat);
        txtAmount.setFont(new Font("Arial", Font.PLAIN, 15));
        txtAmount.setBorder(null);
        txtAmount.setText("0");
        txtAmount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    txtAccountNumber.setEditable(true);
                    PanelService.lblMessage.setText("");
                } else {
                    txtAccountNumber.setEditable(false);
                    PanelService.lblMessage.setText("Vui Lòng Chỉ Nhập Số");
                }
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    if (txtAmount.getText().length() == 1) {
                        txtAmount.setText("0");
                    }
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (txtAmount.getText().length() == 27)
                    e.consume();
            }
        });
        panelAmount.add(txtAmount);
        panelAmount.add(Box.createHorizontalGlue());
        panelAmount.add(panelVND);


        gbc3.ipady = 70;
        JPanel content = new RadiusAndShadow();
        content.setBackground(Color.WHITE);
        content.setLayout(new GridBagLayout());
        txtContent = new JTextArea();
        txtContent.setBackground(Color.WHITE);
        txtContent.setLineWrap(true);
        txtContent.setBorder(null);
        txtContent.setRows(10);
        txtContent.setColumns(20);
        txtContent.setFont(new Font("Arial", Font.PLAIN, 15));
        content.add(txtContent, gbc3);


        JPanel panelGBLEast = new RadiusAndShadow();
        panelGBLEast.setPreferredSize(new Dimension(500, 200));
        panelGBLEast.setBackground(Color.WHITE);
        panelGBLEast.setLayout(new GridLayout(4, 1, 0, 0));


        JLabel lblName = new JLabel(UserController.userFullName);
        lblName.setForeground(Color.RED);
        lblName.setFont(new Font("Aurella", Font.BOLD, 20));
        JPanel panelName = new JPanel();
        panelName.add(lblName);
        panelName.setBackground(Color.WHITE);
        panelGBLEast.add(panelName);


        JLabel lblAccountNumber = new JLabel("Số Tài Khoản: " + LoginController.AccountNumber);
        lblAccountNumber.setFont(new Font("Aurella", Font.BOLD, 15));
        JPanel panelAccountNumber = new JPanel();
        panelAccountNumber.setBackground(Color.WHITE);
        panelAccountNumber.add(lblAccountNumber);
        panelGBLEast.add(panelAccountNumber);


        JLabel lblBalance = new JLabel("Số Dư Hiện Tại: ");
        lblBalance.setFont(new Font("Aurella", Font.BOLD, 15));
        lblBalanceData.setFont(new Font("Aurella", Font.BOLD, 15));
        JLabel lblvnd = new JLabel("VNĐ");
        lblvnd.setFont(new Font("Aurella", Font.BOLD, 15));
        JPanel panelBalance = new JPanel();
        panelBalance.setBackground(Color.WHITE);
        panelBalance.add(lblBalance);
        panelBalance.add(lblBalanceData);
        panelBalance.add(lblvnd);
        panelGBLEast.add(panelBalance);


        JPanel pnlIcon = new JPanel();
        pnlIcon.setBackground(Color.WHITE);
        pnlIcon.add(lblIcon);
        panelGBLEast.add(pnlIcon);

        this.add(panelGBLEast, "East");
        this.add(new JPanel(), "West");


        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        this.add(panelCenter, "Center");

        lblAccountReceived.setFont(new Font("Aurella", Font.BOLD, 15));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(lblAccountReceived, "Center");

        panelCenter.add(panel1);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCenter.add(accountNumber);

        JLabel lblAmount = new JLabel("Số Tiền");
        lblAmount.setFont(new Font("Aurella", Font.BOLD, 15));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(lblAmount, "Center");

        panelCenter.add(panel2);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCenter.add(amount);

        JLabel lblContent = new JLabel("Nội Dung");
        lblContent.setFont(new Font("Aurella", Font.BOLD, 15));

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.add(lblContent, "Center");

        panelCenter.add(panel3);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCenter.add(content);
    }

    public static void validatedTransaction(String TransactionType) {
        if (txtAccountNumber.getText().equals("") || txtAmount.getText().equals("0") || PanelTrading.txtContent.getText().equals(""))
            PanelService.lblMessage.setText("Vui Lòng Nhập Đầy Đủ Thông Tin");
        if (TransactionType.equals("Chuyển Khoản")) {
            if (LoginController.AccountNumber.equals(PanelTrading.txtAccountNumber.getText()))
                PanelService.lblMessage.setText("Số Tài Khoản Nhận Phải Khác Số Tài Khoản Chuyển");
            if (!AccountController.searchAccountNumber(txtAccountNumber.getText()))
                PanelService.lblMessage.setText("Số Tài Khoản Người Nhận Không Tồn Tại");
        }
        TransactionsController.initTransaction(TransactionType, Double.parseDouble(PanelTrading.txtAmount.getText().replaceAll("[^Z0-9]", "")), LoginController.AccountNumber, txtAccountNumber.getText(), txtContent.getText());
        UserController.setUserData(LoginController.UserName);
        lblBalanceData.setText(UserController.BalanceFormat.format(UserController.AccountBalance));
        PanelProfile.lblBalance.setText(UserController.BalanceFormat.format(UserController.AccountBalance));
        PanelProfile.lblBalance.setText("Số Dư Hiện Tại: " + UserController.BalanceFormat.format(UserController.AccountBalance));
        Main.cardPanel.add(new OverviewPanel(),"overview");
        TransactionsController.uploadAllTradingData(TradingsHistoryPanel.contentTable, LoginController.AccountNumber);

    }
}

