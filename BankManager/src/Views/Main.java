package Views;


import Model.connection;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    public static connection connect = new connection();
    private Image img_logo = new ImageIcon("src/Res/bank.png").getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
    private Image img_overview = new ImageIcon("src/Res/overview.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_profile = new ImageIcon("src/Res/user.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
    private Image img_history = new ImageIcon("src/Res/history.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_service = new ImageIcon("src/Res/transfer.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_sign_out = new ImageIcon("src/Res/sign-out.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);

    private Image img_overview_actived = new ImageIcon("src/Res/overview-active.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_history_actived = new ImageIcon("src/Res/history-active.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_service_actived = new ImageIcon("src/Res/transfer-active.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_sign_out_actived = new ImageIcon("src/Res/sign-out-active.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);

    private Color exitedColor = new Color(56, 72, 97);
    private Color enteredColor = new Color(210, 220, 230);
    private Color clickedColor = new Color(56, 165, 111);
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
    private JPanel cardHistoryPanel;
    MetalToggleButtonUI metalToggleButton = new MetalToggleButtonUI() {
        @Override
        protected Color getSelectColor() {
            return Main.this.clickedColor;
        }
    };

    public void run() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    Main.this.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Main() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        this.btnHome.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 5));
        this.btnHome.setUI(this.metalToggleButton);
        this.btnHome.setIconTextGap(10);
        this.btnHome.setIcon(new ImageIcon(img_overview));
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
                    Main.this.showDetailsPanel("overview");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.this.btnHome.setBackground(Main.this.enteredColor);
                Main.this.btnHome.setIcon(new ImageIcon(img_overview_actived));
                Main.this.btnHome.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.this.btnHome.setBackground(Main.this.exitedColor);
                Main.this.btnHome.setIcon(new ImageIcon(img_overview));
                Main.this.btnHome.setForeground(Color.WHITE);
            }
        });

        GridBagConstraints btnHomeLayout = new GridBagConstraints();
        btnHomeLayout.anchor = GridBagConstraints.LINE_START;
        btnHomeLayout.fill = 2;
        btnHomeLayout.gridx = 0;
        btnHomeLayout.gridy = 2;
        menuPane.add((Component) btnHome, btnHomeLayout);

        this.btnHistory = new JToggleButton("Lịch Sử");
        this.btnHistory.setLayout(new FlowLayout(FlowLayout.LEADING,25,5));
        this.btnHistory.setUI(this.metalToggleButton);
        this.btnHistory.setIconTextGap(10);
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
                if (e.getButton() == 1) {
                    Main.this.showDetailsPanel("history");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.this.btnHistory.setBackground(Main.this.enteredColor);
                Main.this.btnHistory.setIcon(new ImageIcon(img_history_actived));
                Main.this.btnHistory.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.this.btnHistory.setBackground(Main.this.exitedColor);
                Main.this.btnHistory.setIcon(new ImageIcon(img_history));
                Main.this.btnHistory.setForeground(Color.WHITE);
            }
        });

        GridBagConstraints btnHistoryConstraints = new GridBagConstraints();
        btnHistoryConstraints.anchor = GridBagConstraints.LINE_START;
        btnHistoryConstraints.gridx = 0;
        btnHistoryConstraints.gridy = 5;
        menuPane.add((Component) this.btnHistory, btnHistoryConstraints);

        this.btnService = new JToggleButton("Giao Dịch");
        this.btnService.setLayout(new FlowLayout(FlowLayout.LEADING,25,5));
        this.btnService.setUI(this.metalToggleButton);
        this.btnService.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.btnService.setIconTextGap(10);
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
                Main.this.btnService.setBackground(Main.this.enteredColor);
                Main.this.btnService.setIcon(new ImageIcon(img_service_actived));
                Main.this.btnService.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.this.btnService.setBackground(Main.this.exitedColor);
                Main.this.btnService.setIcon(new ImageIcon(img_service));
                Main.this.btnService.setForeground(Color.WHITE);
            }
        });

        GridBagConstraints btnServiceConstraints = new GridBagConstraints();
        btnServiceConstraints.gridx = 0;
        btnServiceConstraints.gridy = 3;
        menuPane.add((Component) this.btnService, btnServiceConstraints);


        this.btnLogOut = new JToggleButton("Đăng Xuất");
        this.btnLogOut.setLayout(new FlowLayout(FlowLayout.LEADING,25,5));
        this.btnLogOut.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.btnLogOut.setUI(this.metalToggleButton);
        this.btnLogOut.setIconTextGap(10);
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
                    Main.this.dispose();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.this.btnLogOut.setBackground(Main.this.enteredColor);
                Main.this.btnLogOut.setIcon(new ImageIcon(img_sign_out_actived));
                Main.this.btnLogOut.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.this.btnLogOut.setBackground(Main.this.exitedColor);
                Main.this.btnLogOut.setIcon(new ImageIcon(img_sign_out));
                Main.this.btnLogOut.setForeground(Color.WHITE);
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

        this.cardOverviewPanel = new OverviewPanel();
        this.cardPanel.add((Component) this.cardOverviewPanel, "overview");

        this.cardHistoryPanel = new TradingsHistoryPanel();
        this.cardPanel.add((Component) this.cardHistoryPanel, "history");

        detailsPanel.add((Component) this.cardPanel, "Center");

    }

    public void showDetailsPanel(String constraints) {
        this.cardPanelLayout.show(this.cardPanel, constraints);
    }
}
