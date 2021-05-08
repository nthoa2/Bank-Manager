package Views;


import Model.*;
import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

    private Image img_logo = new ImageIcon(Login.class.getResource("/Res/bank.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
    private Image img_home = new ImageIcon("src/Res/home.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_profile = new ImageIcon("src/Res/user.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
    private Image img_history = new ImageIcon("src/Res/history.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_service = new ImageIcon("src/Res/transfer.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_sign_out = new ImageIcon("src/Res/sign-out.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);

    private Image img_home_actived = new ImageIcon("src/Res/home-actived.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_history_actived = new ImageIcon("src/Res/history-actived.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_service_actived = new ImageIcon("src/Res/transfer-actived.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_sign_out_actived = new ImageIcon("src/Res/sign-out-actived.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);

    private Color exitedColor = new Color(56, 72, 97);
    private Color enteredColor = new Color(210, 220, 230);
    private Color clickedColor = new Color(60, 179, 113);
    private Dimension btnSize = new Dimension(230, 40);
    private JPanel contentPane;
    private JLabel Logo;
    private JToggleButton btnHome;
    private JToggleButton btnHistory;
    private JToggleButton btnService;
    private JToggleButton btnLogOut;

    private CardLayout cardPanelLayout;
    private JPanel cardPanelIndex;
    private JPanel cardPanel;
    private JPanel cardOverviewPanel;
    MetalToggleButtonUI metalToggleButton = new MetalToggleButtonUI() {
        @Override
        protected Color getSelectColor() {
            return MainFrame.this.clickedColor;
        }
    };

    public void run() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    MainFrame.this.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainFrame() {
        this.setDefaultCloseOperation(3);
//        this.setIconImage(new ImageIcon());
        this.setBounds(100, 100, 1383, 773);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        this.contentPane.setBackground(new Color(49, 47, 47));
        this.setContentPane(contentPane);

        JPanel menuPane = new JPanel();
        menuPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        menuPane.setFocusable(false);
        menuPane.setBackground(this.exitedColor);


        GridBagLayout menuLayout = new GridBagLayout();
        menuLayout.columnWidths = new int[2];
        menuLayout.rowHeights = new int[14];
        menuLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        menuLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        menuPane.setLayout(menuLayout);

        this.Logo = new JLabel();
        this.Logo.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.Logo.setHorizontalAlignment(SwingConstants.CENTER);
        this.Logo.setIcon(new ImageIcon(img_logo));

        GridBagConstraints logoConstraints = new GridBagConstraints();
        logoConstraints.insets = new Insets(15, 0, 50, 0);
        logoConstraints.fill = 1;
        logoConstraints.gridx = 0;
        logoConstraints.gridy = 0;
        menuPane.add((Component) this.Logo, logoConstraints);

        this.btnHome = new JToggleButton("Tổng Quan");
        this.btnHome.setUI(this.metalToggleButton);
        this.btnHome.setIconTextGap(10);
        this.btnHome.setIcon(new ImageIcon(img_home));
        this.btnHome.setFocusable(false);
        this.btnHome.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.btnHome.setForeground(Color.WHITE);
        this.btnHome.setBackground(this.exitedColor);
        this.btnHome.setFont(new Font("Open Sans", 1, 15));
        this.btnHome.setPreferredSize(this.btnSize);
        this.btnHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    MainFrame.this.showDetailsPanel("overview");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                MainFrame.this.btnHome.setBackground(MainFrame.this.enteredColor);
                MainFrame.this.btnHome.setIcon(new ImageIcon(img_home_actived));
                MainFrame.this.btnHome.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                MainFrame.this.btnHome.setBackground(MainFrame.this.exitedColor);
                MainFrame.this.btnHome.setIcon(new ImageIcon(img_home));
                MainFrame.this.btnHome.setForeground(Color.WHITE);
            }
        });

        GridBagConstraints btnHomeLayout = new GridBagConstraints();
        btnHomeLayout.anchor = GridBagConstraints.LINE_START;
        btnHomeLayout.fill = 2;
        btnHomeLayout.gridx = 0;
        btnHomeLayout.gridy = 2;
        menuPane.add((Component) btnHome, btnHomeLayout);

        this.btnHistory = new JToggleButton("Lịch Sử");
        this.btnHistory.setUI(this.metalToggleButton);
        this.btnHistory.setIconTextGap(25);
        this.btnHistory.setIcon(new ImageIcon(img_history));
        this.btnHistory.setFocusable(false);
        this.btnHistory.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.btnHistory.setPreferredSize(this.btnSize);
        this.btnHistory.setBackground(this.exitedColor);
        this.btnHistory.setForeground(Color.WHITE);
        this.btnHistory.setFont(new Font("Open Sans", 1, 15));
        this.btnHistory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // goi panel History
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                MainFrame.this.btnHistory.setBackground(MainFrame.this.enteredColor);
                MainFrame.this.btnHistory.setIcon(new ImageIcon(img_history_actived));
                MainFrame.this.btnHistory.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                MainFrame.this.btnHistory.setBackground(MainFrame.this.exitedColor);
                MainFrame.this.btnHistory.setIcon(new ImageIcon(img_history));
                MainFrame.this.btnHistory.setForeground(Color.WHITE);
            }
        });

        GridBagConstraints btnHistoryConstraints = new GridBagConstraints();
        btnHistoryConstraints.anchor = GridBagConstraints.LINE_START;
        btnHistoryConstraints.gridx = 0;
        btnHistoryConstraints.gridy = 5;
        menuPane.add((Component) this.btnHistory, btnHistoryConstraints);

        this.btnService = new JToggleButton("Giao Dịch");
        this.btnService.setUI(this.metalToggleButton);
        this.btnService.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.btnService.setIconTextGap(15);
        this.btnService.setIcon(new ImageIcon(img_service));
        this.btnService.setFocusable(false);
        this.btnService.setPreferredSize(this.btnSize);
        this.btnService.setForeground(Color.WHITE);
        this.btnService.setBackground(this.exitedColor);
        this.btnService.setFont(new Font("Open Sans", 1, 15));
        this.btnService.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    // goi layout service
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                MainFrame.this.btnService.setBackground(MainFrame.this.enteredColor);
                MainFrame.this.btnService.setIcon(new ImageIcon(img_service_actived));
                MainFrame.this.btnService.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                MainFrame.this.btnService.setBackground(MainFrame.this.exitedColor);
                MainFrame.this.btnService.setIcon(new ImageIcon(img_service));
                MainFrame.this.btnService.setForeground(Color.WHITE);
            }
        });

        GridBagConstraints btnServiceConstraints = new GridBagConstraints();
        btnServiceConstraints.gridx = 0;
        btnServiceConstraints.gridy = 3;
        menuPane.add((Component) this.btnService, btnServiceConstraints);


        this.btnLogOut = new JToggleButton("Đăng Xuất");
        this.btnLogOut.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.btnLogOut.setUI(this.metalToggleButton);
        this.btnLogOut.setIconTextGap(15);
        this.btnLogOut.setFocusable(false);
        this.btnLogOut.setIcon(new ImageIcon(img_sign_out));
        this.btnLogOut.setBackground(this.exitedColor);
        this.btnLogOut.setForeground(Color.WHITE);
        this.btnLogOut.setPreferredSize(this.btnSize);
        this.btnLogOut.setFont(new Font("Open Sans", 1, 15));
        this.btnLogOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    MainFrame.this.dispose();
                    LoginFrame login = new LoginFrame();
                    login.run();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                MainFrame.this.btnLogOut.setBackground(MainFrame.this.enteredColor);
                MainFrame.this.btnLogOut.setIcon(new ImageIcon(img_sign_out_actived));
                MainFrame.this.btnLogOut.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                MainFrame.this.btnLogOut.setBackground(MainFrame.this.exitedColor);
                MainFrame.this.btnLogOut.setIcon(new ImageIcon(img_sign_out));
                MainFrame.this.btnLogOut.setForeground(Color.WHITE);
            }
        });

        GridBagConstraints btnLogOutConstraints = new GridBagConstraints();
        btnLogOutConstraints.anchor = GridBagConstraints.LINE_START;
        btnLogOutConstraints.anchor = 15;
        btnLogOutConstraints.gridx = 0;
        btnLogOutConstraints.gridy = 15;
        menuPane.add((Component) this.btnLogOut, btnLogOutConstraints);

        JScrollPane scrollPane = new JScrollPane(menuPane);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane.setHorizontalScrollBarPolicy(31);
        this.contentPane.add((Component) scrollPane, "West");

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(this.btnHome);
        btnGroup.add(this.btnHistory);
        btnGroup.add(this.btnService);
        btnGroup.add(this.btnLogOut);


        JPanel detailsPanel = new JPanel();
        detailsPanel.setBackground(new Color(245, 249, 252));
        detailsPanel.setLayout(new BorderLayout(0, 0));
        this.contentPane.add((Component) detailsPanel, "Center");

        JPanel toolPanel = new JPanel();
        toolPanel.setLayout(new FlowLayout(2, 15, 0));
        toolPanel.setBackground(Color.WHITE);
        toolPanel.setBorder(null);
        detailsPanel.add((Component) toolPanel, "North");


        JLabel btnProfile = new JLabel();
        btnProfile.setIcon(new ImageIcon(img_profile));
        btnProfile.setFocusable(false);
        btnProfile.setHorizontalTextPosition(4);
        btnProfile.setBorder(null);
        btnProfile.setToolTipText("Thông tin cá nhân");
        btnProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnProfile.setBackground(Color.WHITE);
        btnProfile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    System.out.println("Hien thi thong tin ca nhan");
                }
            }
        });
        toolPanel.add((Component) btnProfile);

        this.cardPanelLayout = new CardLayout();
        this.cardPanel = new JPanel(this.cardPanelLayout);
        this.cardPanel.setBackground(Color.WHITE);

        this.cardPanelIndex = new JPanel();
        this.cardPanel.add((Component) this.cardPanelIndex, "index");

        this.cardOverviewPanel = new HomePanel();
        this.cardPanel.add((Component) this.cardOverviewPanel, "overview");

        detailsPanel.add((Component) this.cardPanel, "Center");

    }

    public void showDetailsPanel(String constraints) {
        this.cardPanelLayout.show(this.cardPanel, constraints);
    }
}
