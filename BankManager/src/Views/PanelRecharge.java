package Views;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PanelRecharge extends JPanel
{
    private GridBagConstraints gbc3;

    public PanelRecharge()
    {
        gbc3 = new GridBagConstraints();
        gbc3.insets = new Insets(10, 10, 10, 10);
        gbc3.weightx = 1;
        gbc3.weighty = 1;
        gbc3.fill = GridBagConstraints.BOTH;


        JPanel accountNumber = new RadiusAndShadow();
        accountNumber.setBackground(Color.WHITE);
        accountNumber.setLayout(new GridBagLayout());
        JTextField txtAccountNumber = new JTextField();
        txtAccountNumber.setText("Số tài khoản nạp tiền");
        txtAccountNumber.setEnabled(false);
        txtAccountNumber.setBackground(Color.WHITE);
        txtAccountNumber.setBorder(null);
        txtAccountNumber.setColumns(20);
        txtAccountNumber.setFont(new Font("Arial", Font.PLAIN, 12));
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
        panelVND.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));

        JSeparator sptVND = new JSeparator();
        sptVND.setPreferredSize(new Dimension(10, 10));
        sptVND.setForeground(Color.GRAY);
        sptVND.setOrientation(SwingConstants.VERTICAL);
        panelVND.add(sptVND);

        JLabel lblVND = new JLabel("VNĐ");
        lblVND.setForeground(Color.GRAY);
        lblVND.setFont(new Font("Arial", Font.BOLD, 12));
        panelVND.add(lblVND);

        JTextField txtAmount = new JTextField();
        ((AbstractDocument) txtAmount.getDocument()).setDocumentFilter(new DocumentFilter()
        {
            Pattern regEx = Pattern.compile("\\d*");

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
        txtAmount.setBackground(Color.WHITE);
        txtAmount.setBorder(null);
        txtAmount.setColumns(20);
        txtAmount.setFont(new Font("Arial", Font.PLAIN, 12));
        panelAmount.add(txtAmount);
        panelAmount.add(Box.createHorizontalGlue());
        panelAmount.add(panelVND);


        gbc3.ipady = 170;
        JPanel content = new RadiusAndShadow();
        content.setBackground(Color.WHITE);
        content.setLayout(new GridBagLayout());
        JTextArea txtContent = new JTextArea();
        txtContent.setBackground(Color.WHITE);
        txtContent.setLineWrap(true);
        txtContent.setBorder(null);
        txtContent.setRows(10);
        txtContent.setColumns(20);
        txtContent.setFont(new Font("Arial", Font.PLAIN, 12));
        content.add(txtContent, gbc3);


        this.setLayout(new BorderLayout(0, 0));

        JPanel panelGBLHeader = new JPanel();
        panelGBLHeader.setPreferredSize(new Dimension(200, 80));
        this.add(panelGBLHeader, "North");

        JPanel panelGBLFooter = new JPanel();
        panelGBLFooter.setPreferredSize(new Dimension(200, 80));
        this.add(panelGBLFooter, "South");

        JPanel panelGBLEast = new JPanel();
        panelGBLEast.setPreferredSize(new Dimension(50, 200));
        this.add(panelGBLEast, "East");

        JPanel panelGBLWest = new JPanel();
        panelGBLWest.setPreferredSize(new Dimension(100, 200));
        this.add(panelGBLWest, "West");

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        this.add(panelCenter, "Center");

        JPanel GBL = new JPanel();
        GBL.setLayout(new GridBagLayout());
        panelCenter.add(GBL);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 0, 0);
        GBL.add(new JLabel("Account number received"), gbc);
        gbc.gridy++;
        GBL.add(new JLabel("Amount"), gbc);
        gbc.gridy++;
        GBL.add(new JLabel("Content"), gbc);
        gbc.gridx++;
        gbc.gridy = 0;
        GBL.add(accountNumber, gbc);
        gbc.gridy++;
        GBL.add(amount, gbc);
        gbc.gridy++;
        GBL.add(content, gbc);
    }
}
