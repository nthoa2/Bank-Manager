package Views;

import Model.Login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame
{

    private Image img_logo = new ImageIcon(Login.class.getResource("/Res/bank.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
    private Image img_home = new ImageIcon(Login.class.getResource("/Res/home.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_orders = new ImageIcon(Login.class.getResource("/Res/orders.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_service = new ImageIcon(Login.class.getResource("/Res/service.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private Image img_setting = new ImageIcon(Login.class.getResource("/Res/setting.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

    private JPanel contentPane;
    private JPanel detailsPanel;
    private Color exitedColor = new Color(56, 72, 97);
    private Color enteredColor = new Color(210, 220, 230);
    private Color clickedColor = new Color(60, 179, 113);
    private Dimension btnSize = new Dimension(250, 45);
    private JLabel Logo;
    private JToggleButton btnHome;
    private JToggleButton btnHistory;
    private JToggleButton btnService;
    private JToggleButton btnSetting;
    private JPopupMenu popupMenu;
    private JMenuItem itemSignOut;

    private static PanelHome home;
    private static PanelProfits profits;
    private static PanelOrders orders;
    private static PanelService service;
    private static PanelSetting setting;

    MetalToggleButtonUI metalToggleButton = new MetalToggleButtonUI()
    {
        @Override
        protected Color getSelectColor()
        {
            return MainFrame.this.clickedColor;
        }
    };

    MetalToggleButtonUI metalToggleButton2 = new MetalToggleButtonUI()
    {
        @Override
        protected Color getSelectColor()
        {
            return MainFrame.this.enteredColor;
        }
    };

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new MainFrame().setVisible(true);
            }
        });
    }

    public MainFrame()
    {
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 1383, 773);
        this.setLocationRelativeTo(null);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        this.contentPane.setBackground(new Color(49, 47, 47));
        this.setContentPane(contentPane);


        home = new PanelHome();
        profits = new PanelProfits();
        orders = new PanelOrders();
        service = new PanelService();
        setting = new PanelSetting();

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

        this.btnHome = new JToggleButton("Trang Chủ");
        this.btnHome.setIconTextGap(10);
        this.btnHome.setIcon(new ImageIcon(img_home));
        this.btnHome.setHorizontalTextPosition(4);
        this.btnHome.setFocusable(false);
        this.btnHome.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.btnHome.setForeground(Color.WHITE);
        this.btnHome.setBackground(this.exitedColor);
        this.btnHome.setFont(new Font("Open Sans", 1, 17));
        this.btnHome.setPreferredSize(this.btnSize);
        this.btnHome.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                MenuClicked(home);
                MainFrame.this.btnHome.setUI(MainFrame.this.metalToggleButton);
            }

            @Override
            public void mousePressed(MouseEvent e)
            {

                MainFrame.this.btnHome.setUI(MainFrame.this.metalToggleButton2);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                MainFrame.this.btnHome.setBackground(MainFrame.this.enteredColor);
                MainFrame.this.btnHome.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                MainFrame.this.btnHome.setBackground(MainFrame.this.exitedColor);
                MainFrame.this.btnHome.setForeground(Color.WHITE);
            }
        });

        GridBagConstraints btnHomeLayout = new GridBagConstraints();
        btnHomeLayout.fill = 2;
        btnHomeLayout.gridx = 0;
        btnHomeLayout.gridy = 2;
        menuPane.add((Component) btnHome, btnHomeLayout);

        this.btnHistory = new JToggleButton("Lịch Sử");
        this.btnHistory.setIconTextGap(10);
        this.btnHistory.setHorizontalTextPosition(4);
        this.btnHistory.setIcon(new ImageIcon(img_orders));
        this.btnHistory.setFocusable(false);
        this.btnHistory.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.btnHistory.setPreferredSize(this.btnSize);
        this.btnHistory.setBackground(this.exitedColor);
        this.btnHistory.setForeground(Color.WHITE);
        this.btnHistory.setFont(new Font("Open Sans", 1, 17));
        this.btnHistory.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                MenuClicked(orders);
                MainFrame.this.btnHistory.setUI(MainFrame.this.metalToggleButton);
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                MainFrame.this.btnHistory.setUI(MainFrame.this.metalToggleButton2);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                MainFrame.this.btnHistory.setBackground(MainFrame.this.enteredColor);
                MainFrame.this.btnHistory.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                MainFrame.this.btnHistory.setBackground(MainFrame.this.exitedColor);
                MainFrame.this.btnHistory.setForeground(Color.WHITE);
            }
        });

        GridBagConstraints btnHistoryConstraints = new GridBagConstraints();
        btnHistoryConstraints.gridx = 0;
        btnHistoryConstraints.gridy = 3;
        menuPane.add((Component) this.btnHistory, btnHistoryConstraints);

        this.btnService = new JToggleButton("Giao Dịch");
        this.btnService.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.btnService.setIconTextGap(15);
        this.btnService.setIcon(new ImageIcon(img_service));
        this.btnService.setHorizontalTextPosition(4);
        this.btnService.setFocusable(false);
        this.btnService.setPreferredSize(this.btnSize);
        this.btnService.setForeground(Color.WHITE);
        this.btnService.setBackground(this.exitedColor);
        this.btnService.setFont(new Font("Open Sans", 1, 17));
        this.btnService.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                MenuClicked(service);
                MainFrame.this.btnService.setUI(MainFrame.this.metalToggleButton);
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                MainFrame.this.btnService.setUI(MainFrame.this.metalToggleButton2);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                MainFrame.this.btnService.setBackground(MainFrame.this.enteredColor);
                MainFrame.this.btnService.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                MainFrame.this.btnService.setBackground(MainFrame.this.exitedColor);
                MainFrame.this.btnService.setForeground(Color.WHITE);
            }
        });

        GridBagConstraints btnServiceConstraints = new GridBagConstraints();
        btnServiceConstraints.gridx = 0;
        btnServiceConstraints.gridy = 4;
        menuPane.add((Component) this.btnService, btnServiceConstraints);

        this.btnSetting = new JToggleButton("Cài Đặt");
        this.btnSetting.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.btnSetting.setIconTextGap(15);
        this.btnSetting.setHorizontalTextPosition(4);
        this.btnSetting.setFocusable(false);
        this.btnSetting.setIcon(new ImageIcon(img_setting));
        this.btnSetting.setBackground(this.exitedColor);
        this.btnSetting.setForeground(Color.WHITE);
        this.btnSetting.setPreferredSize(this.btnSize);
        this.btnSetting.setFont(new Font("Open Sans", 1, 17));
        this.btnSetting.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                MenuClicked(setting);
                MainFrame.this.btnSetting.setUI(MainFrame.this.metalToggleButton);
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                MainFrame.this.btnSetting.setUI(MainFrame.this.metalToggleButton2);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                MainFrame.this.btnSetting.setBackground(MainFrame.this.enteredColor);
                MainFrame.this.btnSetting.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                MainFrame.this.btnSetting.setBackground(MainFrame.this.exitedColor);
                MainFrame.this.btnSetting.setForeground(Color.WHITE);
            }
        });

        GridBagConstraints btnSettingConstraints = new GridBagConstraints();
        btnSettingConstraints.anchor = 15;
        btnSettingConstraints.gridx = 0;
        btnSettingConstraints.gridy = 12;
        menuPane.add((Component) this.btnSetting, btnSettingConstraints);

        JScrollPane scrollPane = new JScrollPane(menuPane);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane.setHorizontalScrollBarPolicy(31);
        this.contentPane.add((Component) scrollPane, "West");

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(this.btnHome);
        btnGroup.add(this.btnHistory);
        btnGroup.add(this.btnService);
        btnGroup.add(this.btnSetting);

        detailsPanel = new JPanel();
        detailsPanel.setBackground(new Color(245, 249, 252));
        detailsPanel.setLayout(new BorderLayout(0, 0));
        this.contentPane.add((Component) detailsPanel, "Center");

        JPanel toolPanel = new JPanel();
        toolPanel.setLayout(new FlowLayout(2, 15, 0));
        toolPanel.setBackground(Color.WHITE);
        toolPanel.setBorder(null);
        detailsPanel.add((Component) toolPanel, "North");


        JLabel btnOption = new JLabel(new ImageIcon("src/Res/male-user-30.png"));
        btnOption.setFocusable(false);
        btnOption.setHorizontalTextPosition(4);
        btnOption.setBorder(null);
        btnOption.setToolTipText("Profile");
        toolPanel.add((Component) btnOption);

        this.popupMenu = new JPopupMenu();
        this.popupMenu.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        this.popupMenu.setFont(new Font("Open Sans", 1, 17));
        this.popupMenu.setBackground(new Color(250, 250, 250));
        this.addPopupItem((Component) btnOption, this.popupMenu);

        JMenuItem itemProfile = new JMenuItem("Hồ Sơ");
        itemProfile.setPreferredSize(new Dimension(200, 30));
        itemProfile.setOpaque(false);
        itemProfile.setFont(new Font("Open Sans", 1, 17));
        itemProfile.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == itemProfile)
                {
                    try
                    {
                        System.out.println("hien thong tin ca nhan");
                    } catch (Exception exception)
                    {
                        System.out.println(exception.getMessage());
                    }
                }
            }
        });
        this.popupMenu.add(itemProfile);

        JSeparator separator = new JSeparator();
        separator.setRequestFocusEnabled(false);
        separator.setForeground(new Color(53, 53, 53, 255));
        this.popupMenu.add(separator);

        this.itemSignOut = new JMenuItem("Đăng Xuất");
        this.itemSignOut.setPreferredSize(new Dimension(200, 30));
        this.itemSignOut.setOpaque(false);
        this.itemSignOut.setBackground(Color.WHITE);
        this.itemSignOut.setFont(new Font("Open Sans", 1, 17));
        this.itemSignOut.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == MainFrame.this.itemSignOut)
                {
                    System.exit(0);
                }
            }
        });
        this.popupMenu.add(this.itemSignOut);


        detailsPanel.add(home, "Center");

    }

    public void MenuClicked(JPanel panel)
    {
        home.setVisible(false);
        profits.setVisible(false);
        orders.setVisible(false);
        service.setVisible(false);
        setting.setVisible(false);

        panel.setVisible(true);
        MainFrame.this.detailsPanel.add(panel, "Center");
    }

    public void addPopupItem(Component component, JPopupMenu popupMenu)
    {
        component.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton() == 1)
                {
                    this.showMenu(e);
                }
            }

            private void showMenu(MouseEvent e)
            {
                popupMenu.show(e.getComponent(), 0, e.getComponent().getHeight());
            }
        });
    }


}