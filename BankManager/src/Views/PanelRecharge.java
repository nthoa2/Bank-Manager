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
        gbc3.fill = GridBagConstraints.HORIZONTAL;


        JPanel accountNumber = new RadiusAndShadow();
        accountNumber.setBackground(Color.WHITE);
        accountNumber.setLayout(new GridBagLayout());
        JTextField txtAccountNumber = new JTextField();
        txtAccountNumber.setEnabled(false);
        txtAccountNumber.setText("Số tài khoản nạp tiền");
        txtAccountNumber.setBackground(Color.WHITE);
        txtAccountNumber.setBorder(null);
        txtAccountNumber.setColumns(20);
        txtAccountNumber.setFont(new Font("Arial", Font.PLAIN, 12));
        accountNumber.add(txtAccountNumber, gbc3);


        JPanel amount = new RadiusAndShadow();
        amount.setBackground(Color.WHITE);
        amount.setLayout(new GridBagLayout());
        JTextField txtAmount = new JTextField();
        ((AbstractDocument)txtAmount.getDocument()).setDocumentFilter(new DocumentFilter(){
            Pattern regEx = Pattern.compile("\\d*");

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
            {
                Matcher matcher = regEx.matcher(text);
                if(!matcher.matches()){
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
        txtAmount.setBackground(Color.WHITE);
        txtAmount.setBorder(null);
        txtAmount.setColumns(20);
        txtAmount.setFont(new Font("Arial", Font.PLAIN, 12));
        amount.add(txtAmount, gbc3);

        gbc3.ipady = 170;
        gbc3.fill = GridBagConstraints.BOTH;
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

        JPanel panelGBLCenter = new JPanel();
        panelGBLCenter.setLayout(new GridBagLayout());
        this.add(panelGBLCenter, "Center");

        JPanel GBL = new JPanel();
        GBL.setLayout(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.weightx = 0.1;
        gbc2.weighty = 0.1;
        gbc2.fill = GridBagConstraints.BOTH;
        panelGBLCenter.add(GBL, gbc2);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 10, 0, 0);
        GBL.add(new JLabel("Account number received"), gbc);
        gbc.gridx += 1;
        GBL.add(accountNumber, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        GBL.add(new JLabel("Amount"), gbc);
        gbc.gridx += 1;
        GBL.add(amount, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        GBL.add(new JLabel("Content"), gbc);
        gbc.gridx += 1;
        GBL.add(content, gbc);
    }
}
