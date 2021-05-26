package Views;

import Controller.LoginController;
import Model.Login;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

public class PanelWithdraw extends JPanel
{
    private GridBagConstraints gbc3;
    private JFormattedTextField txtAmount;
    private JTextArea txtContent;
    private JLabel lblBalanceData = new JLabel(LoginController.balance);

    public PanelWithdraw()
    {
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
        JTextField txtAccountNumber = new JTextField();
        txtAccountNumber.setEnabled(false);
        txtAccountNumber.setText(LoginController.accountNumber);
        txtAccountNumber.setBackground(Color.WHITE);
        txtAccountNumber.setBorder(null);
        txtAccountNumber.setColumns(20);
        txtAccountNumber.setFont(new Font("Arial", Font.PLAIN, 15));
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
        txtAmount.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
                {
                    txtAccountNumber.setEditable(true);
                    PanelService.lblMessage.setText("");
                } else
                {
                    txtAccountNumber.setEditable(false);
                    PanelService.lblMessage.setText("Enter only numeric digits(0-9)");
                }
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
                {
                    if (txtAmount.getText().length() == 1)
                    {
                        txtAmount.setText("0");
                    }
                }
            }

            @Override
            public void keyTyped(KeyEvent e)
            {
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
        panelGBLEast.setLayout(new GridLayout(10, 1, 20, 0));


        JLabel lblName = new JLabel(LoginController.fullname);
        lblName.setForeground(Color.RED);
        lblName.setFont(new Font("Arial", Font.BOLD, 20));
        JPanel panelName = new JPanel();
        panelName.add(lblName);
        panelName.setBackground(Color.WHITE);
        panelGBLEast.add(panelName);


        JLabel lblAccountNumber = new JLabel("Account Number: ");
        lblAccountNumber.setFont(new Font("Arial", Font.BOLD, 15));
        JPanel panelAccountNumber = new JPanel();
        panelAccountNumber.setBackground(Color.WHITE);
        panelAccountNumber.add(lblAccountNumber);
        panelAccountNumber.add(new JLabel(LoginController.accountNumber));
        panelGBLEast.add(panelAccountNumber);


        JLabel lblBalance = new JLabel("Balance: ");
        lblBalance.setFont(new Font("Arial", Font.BOLD, 15));
        JPanel panelBalance = new JPanel();
        panelBalance.setBackground(Color.WHITE);
        panelBalance.add(lblBalance);
        panelBalance.add(lblBalanceData);
        panelBalance.add(new JLabel("VNĐ"));
        panelGBLEast.add(panelBalance);


        this.add(panelGBLEast, "East");
        this.add(new JPanel(), "West");


        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        this.add(panelCenter, "Center");

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(new JLabel("Account number received"), "Center");

        panelCenter.add(panel1);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCenter.add(accountNumber);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(new JLabel("Amount"), "Center");

        panelCenter.add(panel2);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCenter.add(amount);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.add(new JLabel("Content"), "Center");

        panelCenter.add(panel3);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCenter.add(content);
    }

    public String check()
    {
        if (this.txtAmount.getText().equals("0") || this.txtContent.getText().equals(""))
            return "Please input full";
        else if(!LoginController.updateWithDrawAndRecharge("Rút tiền", LoginController.accountNumber, Double.parseDouble(txtAmount.getText().replaceAll("[^Z0-9]", "")), txtContent.getText()))
            return "Balance enough";
        else
        {
            LoginController.getUserData(LoginFrame.username);
            this.lblBalanceData.setText(LoginController.balance);
            PanelProfile.lblBalance.setText(LoginController.balance);
            return "Success";
        }
    }
}
