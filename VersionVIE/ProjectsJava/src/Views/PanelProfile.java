package Views;

import Controller.LoginController;
import Controller.UserController;
import Model.Login;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelProfile extends JPanel {
    public static Image img_woman = new ImageIcon("src/Res/avatar_woman.png").getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
    public static Image img_man = new ImageIcon("src/Res/avatar_man.png").getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
    public static JLabel lblAvatar, lblFullName, lblAccountNumber, lblBalance, lblDate, lblGender, lblBirthday, lblPhone, lblAddress;


    public void initComponent() {
        this.setLayout(new BorderLayout(0, 0));
        JPanel panelWest = new LinearGradient(0);
        panelWest.setPreferredSize(new Dimension(300, 0));
        JPanel panelEast = new LinearGradient(0);
        panelEast.setPreferredSize(new Dimension(300, 0));
        this.add(panelWest, "West");
        this.add(panelEast, "East");

        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.Y_AXIS));
        panelHeader.setBackground(Color.WHITE);

        JPanel panelAvatar = new JPanel();
        lblAvatar = new JLabel("");
        panelAvatar.setBackground(Color.WHITE);
        panelAvatar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        panelAvatar.add(lblAvatar);

        JLabel lblProfile = new JLabel("" + UserController.userFullName);
        lblProfile.setForeground(Color.BLACK);
        lblProfile.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel panelProfile = new JPanel();
        panelProfile.setBackground(Color.WHITE);
        panelProfile.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelProfile.add(lblProfile);
        panelHeader.add(panelAvatar);
        panelHeader.add(Box.createRigidArea(new Dimension(20, 20)));
        panelHeader.add(panelProfile);

        JPanel panelMain = new JPanel();
        panelMain.setBackground(Color.WHITE);
        panelMain.setLayout(new BorderLayout(50, 25));
        panelMain.add(panelHeader, "North");
        this.add(panelMain, "Center");

        JPanel panelLeft = new JPanel();
        panelLeft.setBackground(Color.WHITE);
        panelMain.add(panelLeft, "West");
        JPanel panelRight = new JPanel();
        panelRight.setBackground(Color.WHITE);
        panelMain.add(panelRight, "East");

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(2, 0));
        panelCenter.setBackground(Color.WHITE);
        panelMain.add(panelCenter, "Center");

        JPanel panelInformation1 = new RadiusAndShadow();
        panelInformation1.setBackground(Color.WHITE);
        panelInformation1.setLayout(new GridBagLayout());
        panelCenter.add(panelInformation1);
        lblFullName = new JLabel("Tên Đăng Nhập: " + LoginController.UserName);
        lblFullName.setForeground(Color.BLACK);
        lblFullName.setFont(new Font("Arial", Font.BOLD, 15));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelInformation1.add(lblFullName, gbc);

        lblAccountNumber = new JLabel("Số Tài Khoản: " + LoginController.AccountNumber);
        lblAccountNumber.setForeground(Color.BLACK);
        lblAccountNumber.setFont(new Font("Arial", Font.BOLD, 15));
        gbc.gridy = 1;
        panelInformation1.add(lblAccountNumber, gbc);

        JPanel pnlBalance = new JPanel();
        pnlBalance.setBackground(Color.WHITE);
        pnlBalance.setLayout(new BoxLayout(pnlBalance, BoxLayout.X_AXIS));
        gbc.gridy = 2;
        panelInformation1.add(pnlBalance, gbc);

        lblBalance = new JLabel("Số Dư Hiện Tại: " + UserController.BalanceFormat.format(UserController.AccountBalance));
        lblBalance.setForeground(Color.black);
        lblBalance.setFont(new Font("Arial", Font.BOLD, 15));
        pnlBalance.add(lblBalance);
        pnlBalance.add(Box.createHorizontalGlue());
        JLabel lblVND = new JLabel("VNĐ");
        lblVND.setForeground(Color.BLACK);
        lblVND.setFont(new Font("Arial", Font.BOLD, 15));
        pnlBalance.add(lblVND);

        lblDate = new JLabel("Ngày Đăng Ký: " + UserController.userDateSignUp);
        lblDate.setForeground(Color.black);
        lblDate.setFont(new Font("Arial", Font.BOLD, 15));
        gbc.gridy = 3;
        panelInformation1.add(lblDate, gbc);

        JPanel panelInformation2 = new RadiusAndShadow();
        panelInformation2.setBackground(Color.WHITE);
        panelInformation2.setLayout(new BoxLayout(panelInformation2, BoxLayout.Y_AXIS));
        panelCenter.add(panelInformation2);

        lblGender = new JLabel("Giới Tính: " + UserController.userGender);
        lblGender.setForeground(Color.black);
        lblGender.setFont(new Font("Arial", Font.BOLD, 15));
        panelInformation2.add(Box.createRigidArea(new Dimension(5, 10)));
        panelInformation2.add(lblGender);

        lblBirthday = new JLabel("Ngày Sinh: " + UserController.userBirthday);
        lblBirthday.setForeground(Color.black);
        lblBirthday.setFont(new Font("Arial", Font.BOLD, 15));
        panelInformation2.add(Box.createVerticalGlue());
        panelInformation2.add(lblBirthday);

        lblPhone = new JLabel("Số Điện Thoại: " + UserController.userPhoneNumber);
        lblPhone.setForeground(Color.black);
        lblPhone.setFont(new Font("Arial", Font.BOLD, 15));
        panelInformation2.add(Box.createVerticalGlue());
        panelInformation2.add(lblPhone);

        lblAddress = new JLabel("Địa Chỉ: " + UserController.userAddress);
        lblAddress.setForeground(Color.black);
        lblAddress.setFont(new Font("Arial", Font.BOLD, 15));
        panelInformation2.add(Box.createVerticalGlue());
        panelInformation2.add(lblAddress);
        panelInformation2.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel panelFooter = new JPanel();
        panelFooter.setLayout(new GridBagLayout());
        panelFooter.setBackground(Color.WHITE);
        panelFooter.setPreferredSize(new Dimension(0, 100));
        panelMain.add(panelFooter, "South");

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.insets = new Insets(0, 50, 40, 50);
        gridBagConstraints.weighty = 1;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        JPanel panelEditPassword = new RadiusAndShadow();
        JDialog editPassword = new JDialog();
        editPassword.setModal(true);
        editPassword.setBackground(Color.GRAY);
        editPassword.setUndecorated(true);
        editPassword.setBounds(875, 370, 400, 400);


        JLabel lblEditpassword = new JLabel("Chỉnh sửa mật khẩu");
        lblEditpassword.setForeground(Color.black);
        lblEditpassword.setFont(new Font("Arial", Font.BOLD, 15));
        panelEditPassword.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
        panelEditPassword.add(lblEditpassword);
        panelEditPassword.setBackground(Color.WHITE);
        panelEditPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new EditPassword().setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panelEditPassword.setBackground(new Color(162, 85, 113));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelEditPassword.setBackground(Color.WHITE);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                panelEditPassword.setBackground(new Color(216, 53, 65));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                panelEditPassword.setBackground(Color.WHITE);
            }
        });
        panelFooter.add(panelEditPassword, gridBagConstraints);

    }

    public PanelProfile() {
        initComponent();
        UserController.setUserData(LoginController.AccountNumber);
        UserController.setGenderIcon(UserController.userGender);
    }
}
