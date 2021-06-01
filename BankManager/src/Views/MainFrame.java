package Views;


import Controller.LoginController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame
{
    private Image img_logo = new ImageIcon(("src/Res/bank.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
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
    private JPanel toolPanel;
    private JLabel Logo;
    private JToggleButton btnHome;
    private JToggleButton btnHistory;
    private JToggleButton btnService;
    private JToggleButton btnLogOut;

    private JLabel lblHome;
    private JLabel lblTextHome;
    private JLabel lblHistory;
    private JLabel lblTextHistory;
    private JLabel lblService;
    private JLabel lblTextService;
    private JLabel lblLogOut;
    private JLabel lblTextLogOut;

    private CardLayout cardPanelLayout;
    private JPanel cardPanel;
    MetalToggleButtonUI metalToggleButton = new MetalToggleButtonUI()
    {
        @Override
        protected Color getSelectColor()
        {
            return MainFrame.this.clickedColor;
        }
    };

    public static JLabel btnProfile;

    public MainFrame()
    {
        try {
            Image img = new ImageIcon(("src/Res/icon_frame.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            this.setIconImage(img);
        }catch(Exception e){
            System.out.println("Application icon not found");
        }
        this.setTitle("Banking");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1383, 773);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        this.contentPane.setBackground(new Color(49, 47, 47));
        this.setLocationRelativeTo(null);
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
        this.Logo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.Logo.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(e.getButton() == 1)
                {
                    toolPanel.setVisible(true);
                    MainFrame.this.showDetailsPanel("home");
                }
            }
        });

        GridBagConstraints logoConstraints = new GridBagConstraints();
        logoConstraints.insets = new Insets(15, 0, 50, 0);
        logoConstraints.fill = 1;
        logoConstraints.gridx = 0;
        logoConstraints.gridy = 0;
        menuPane.add((Component) this.Logo, logoConstraints);

        this.lblHome = new JLabel("");
        this.lblHome.setIcon(new ImageIcon(img_home));
        this.lblTextHome = new JLabel("Overview");
        this.lblTextHome.setForeground(Color.WHITE);
        this.lblTextHome.setFont(new Font("Open Sans", 1, 15));
        this.btnHome = new JToggleButton();
        this.btnHome.setUI(this.metalToggleButton);
        this.btnHome.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 5));
        this.btnHome.add(lblHome);
        this.btnHome.add(lblTextHome);
        this.btnHome.setFocusable(false);
        this.btnHome.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.btnHome.setBackground(this.exitedColor);
        this.btnHome.setPreferredSize(this.btnSize);
        this.btnHome.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton() == 1)
                {
                    MainFrame.this.cardPanel.add(new PanelOverview(), "overview");
                    toolPanel.setVisible(true);
                    MainFrame.this.showDetailsPanel("overview");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                MainFrame.this.btnHome.setBackground(MainFrame.this.enteredColor);
                MainFrame.this.lblHome.setIcon(new ImageIcon(img_home_actived));
                MainFrame.this.lblTextHome.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                MainFrame.this.btnHome.setBackground(MainFrame.this.exitedColor);
                MainFrame.this.lblHome.setIcon(new ImageIcon(img_home));
                MainFrame.this.lblTextHome.setForeground(Color.WHITE);
            }
        });

        GridBagConstraints btnHomeLayout = new GridBagConstraints();
        btnHomeLayout.anchor = GridBagConstraints.LINE_START;
        btnHomeLayout.gridx = 0;
        btnHomeLayout.gridy = 2;
        menuPane.add((Component) this.btnHome, btnHomeLayout);


        this.lblService = new JLabel("");
        this.lblService.setIcon(new ImageIcon(img_service));
        this.lblTextService = new JLabel("Service");
        this.lblTextService.setForeground(Color.WHITE);
        this.lblTextService.setFont(new Font("Open Sans", 1, 15));
        this.btnService = new JToggleButton();
        this.btnService.setUI(this.metalToggleButton);
        this.btnService.setLayout(new FlowLayout(FlowLayout.LEADING,25,5));
        this.btnService.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.btnService.add(lblService);
        this.btnService.add(lblTextService);
        this.btnService.setFocusable(false);
        this.btnService.setPreferredSize(this.btnSize);
        this.btnService.setBackground(this.exitedColor);
        this.btnService.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton() == 1)
                {
                    toolPanel.setVisible(true);
                    MainFrame.this.showDetailsPanel("service");
                    PanelService.panelFooter.setVisible(false);
                    PanelService.cardLayout.show(PanelService.panelForm, "4");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                MainFrame.this.btnService.setBackground(MainFrame.this.enteredColor);
                MainFrame.this.lblService.setIcon(new ImageIcon(img_service_actived));
                MainFrame.this.lblTextService.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                MainFrame.this.btnService.setBackground(MainFrame.this.exitedColor);
                MainFrame.this.lblService.setIcon(new ImageIcon(img_service));
                MainFrame.this.lblTextService.setForeground(Color.WHITE);
            }
        });

        GridBagConstraints btnServiceConstraints = new GridBagConstraints();
        btnServiceConstraints.anchor = GridBagConstraints.LINE_START;
        btnServiceConstraints.gridx = 0;
        btnServiceConstraints.gridy = 3;
        menuPane.add((Component) this.btnService, btnServiceConstraints);


        this.lblHistory = new JLabel("");
        this.lblHistory.setIcon(new ImageIcon(img_history));
        this.lblTextHistory = new JLabel("History");
        this.lblTextHistory.setForeground(Color.WHITE);
        this.lblTextHistory.setFont(new Font("Open Sans", 1, 15));
        this.btnHistory = new JToggleButton();
        this.btnHistory.setUI(this.metalToggleButton);
        this.btnHistory.setLayout(new FlowLayout(FlowLayout.LEADING, 25,5));
        this.btnHistory.add(lblHistory);
        this.btnHistory.add(lblTextHistory);
        this.btnHistory.setFocusable(false);
        this.btnHistory.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.btnHistory.setPreferredSize(this.btnSize);
        this.btnHistory.setBackground(this.exitedColor);
        this.btnHistory.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(e.getButton() == 1)
                {
                    MainFrame.this.cardPanel.add(new PanelTradingsHistory(), "history");
                    toolPanel.setVisible(true);
                    MainFrame.this.showDetailsPanel("history");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                MainFrame.this.btnHistory.setBackground(MainFrame.this.enteredColor);
                MainFrame.this.lblHistory.setIcon(new ImageIcon(img_history_actived));
                MainFrame.this.lblTextHistory.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                MainFrame.this.btnHistory.setBackground(MainFrame.this.exitedColor);
                MainFrame.this.lblHistory.setIcon(new ImageIcon(img_history));
                MainFrame.this.lblTextHistory.setForeground(Color.WHITE);
            }
        });

        GridBagConstraints btnHistoryConstraints = new GridBagConstraints();
        btnHistoryConstraints.anchor = GridBagConstraints.LINE_START;
        btnHistoryConstraints.gridx = 0;
        btnHistoryConstraints.gridy = 4;
        menuPane.add((Component) this.btnHistory, btnHistoryConstraints);


        GridBagConstraints Clock = new GridBagConstraints();
        Clock.anchor = GridBagConstraints.LINE_START;
        Clock.gridx = 0;
        Clock.gridy = 12;
        menuPane.add(new Clock(Color.WHITE), Clock);

        this.lblLogOut = new JLabel("");
        this.lblLogOut.setIcon(new ImageIcon(img_sign_out));
        this.lblTextLogOut = new JLabel("Log out");
        this.lblTextLogOut.setForeground(Color.WHITE);
        this.lblTextLogOut.setFont(new Font("Open Sans", 1, 15));
        this.btnLogOut = new JToggleButton();
        this.btnLogOut.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.btnLogOut.setUI(this.metalToggleButton);
        this.btnLogOut.setLayout(new FlowLayout(FlowLayout.LEADING,25,5));
        this.btnLogOut.add(lblLogOut);
        this.btnLogOut.add(lblTextLogOut);
        this.btnLogOut.setFocusable(false);
        this.btnLogOut.setBackground(this.exitedColor);
        this.btnLogOut.setPreferredSize(this.btnSize);
        this.btnLogOut.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(e.getButton() == 1)
                {
                    new LoginFrame().setVisible(true);
                    MainFrame.this.setVisible(false);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                MainFrame.this.btnLogOut.setBackground(MainFrame.this.enteredColor);
                MainFrame.this.lblLogOut.setIcon(new ImageIcon(img_sign_out_actived));
                MainFrame.this.lblTextLogOut.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                MainFrame.this.btnLogOut.setBackground(MainFrame.this.exitedColor);
                MainFrame.this.lblLogOut.setIcon(new ImageIcon(img_sign_out));
                MainFrame.this.lblTextLogOut.setForeground(Color.WHITE);
            }
        });

        GridBagConstraints btnLogOutConstraints = new GridBagConstraints();
        btnLogOutConstraints.anchor = GridBagConstraints.LINE_START;
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


        JPanel detailsPanel = new JPanel();
        detailsPanel.setBackground(new Color(245, 249, 252));
        detailsPanel.setLayout(new BorderLayout(0, 0));
        this.contentPane.add((Component) detailsPanel, "Center");

        toolPanel = new LinearGradient(1);
        toolPanel.setLayout(new FlowLayout(2, 15, 0));
        toolPanel.setBackground(Color.WHITE);
        toolPanel.setBorder(null);
        detailsPanel.add((Component) toolPanel, "North");

        btnProfile = new JLabel(LoginController.fullname);
        btnProfile.setFont(new Font("Open San", Font.BOLD, 12));
        btnProfile.setIcon(new ImageIcon(img_profile));
        btnProfile.setFocusable(false);
        btnProfile.setHorizontalTextPosition(SwingConstants.LEADING);
        btnProfile.setBorder(null);
        btnProfile.setToolTipText("Profile");
        btnProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnProfile.setBackground(Color.WHITE);
        btnProfile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1)
                {
                    toolPanel.setVisible(false);
                    MainFrame.this.showDetailsPanel("profile");
                }
            }
        });
        toolPanel.add((Component) btnProfile);


        this.cardPanelLayout = new CardLayout();
        this.cardPanel = new JPanel(this.cardPanelLayout);
        this.cardPanel.setBackground(Color.WHITE);
        this.cardPanel.add(new PanelHome(), "home");
        this.cardPanelLayout.show(this.cardPanel, "home");
        this.cardPanel.add(new PanelTradingsHistory(), "history");
        this.cardPanel.add(new PanelOverview(), "overview");
        this.cardPanel.add(new PanelService(), "service");
        this.cardPanel.add(new PanelProfile(), "profile");

        detailsPanel.add((Component) this.cardPanel, "Center");

    }

    public void showDetailsPanel(String constraints)
    {
        this.cardPanelLayout.show(this.cardPanel, constraints);
    }

}