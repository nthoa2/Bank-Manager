package Views;

import javax.swing.*;
import java.awt.*;


public class PanelTransfer extends JPanel
{

    public PanelTransfer()
    {
//        JPanel accountNumber2 = new RadiusAndShadow();

        JPanel containAccountNumber = new JPanel();
        containAccountNumber.setLayout(new FlowLayout(FlowLayout.RIGHT,20,10));

        JPanel accountNumber = new RoundedPanel(20, Color.WHITE);
//        accountNumber.setBackground(Color.WHITE);
        accountNumber.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 8));
        containAccountNumber.add(accountNumber);

//        JTextField txtAccountNumber2 = new JTextField();
//        txtAccountNumber2.setBackground(Color.WHITE);
//        txtAccountNumber2.setBorder(null);
//        txtAccountNumber2.setColumns(25);
//        txtAccountNumber2.setFont(new Font("Arial", Font.PLAIN, 12));

        JTextField txtAccountNumber = new JTextField();
        txtAccountNumber.setBackground(Color.WHITE);
        txtAccountNumber.setBorder(null);
        txtAccountNumber.setColumns(25);
        txtAccountNumber.setFont(new Font("Arial", Font.PLAIN, 12));
//        txtAccountNumber.addFocusListener(new FocusAdapter()
//        {
//            @Override
//            public void focusGained(FocusEvent e)
//            {
//                accountNumber2.add(txtAccountNumber2);
//                accountNumber2.setBackground(Color.WHITE);
//                accountNumber2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 8));
//                containAccountNumber.removeAll();
//                containAccountNumber.revalidate();
//                containAccountNumber.repaint();
//                containAccountNumber.add(accountNumber2);
//                txtAccountNumber2.requestFocus();
//            }
//        });
        accountNumber.add(txtAccountNumber);


        JPanel containAmount=new JPanel();
        containAmount.setLayout(new FlowLayout(FlowLayout.RIGHT,20,10));

        JPanel amount=new RoundedPanel(20,Color.WHITE);
//        amount.setBackground(Color.WHITE);
        amount.setLayout(new FlowLayout(FlowLayout.LEFT,10,8));
        containAmount.add(amount);


        JTextField txtAmount=new JTextField();
        txtAmount.setBackground(Color.WHITE);
        txtAmount.setBorder(null);
        txtAmount.setColumns(25);
        txtAmount.setFont(new Font("Arial",Font.PLAIN,12));
        amount.add(txtAmount);

        JPanel containContent=new JPanel();
        containContent.setLayout(new FlowLayout(FlowLayout.RIGHT,20,10));

        JPanel content=new RoundedPanel(20,Color.WHITE);
//        content.setBackground(Color.WHITE);
        content.setLayout(new FlowLayout(FlowLayout.LEFT,10,8));
        containContent.add(content);

        JTextArea txtContent=new JTextArea();
        txtContent.setBackground(Color.WHITE);
        txtContent.setLineWrap(true);
        txtContent.setBorder(null);
        txtContent.setRows(15);
        txtContent.setColumns(25);
        txtContent.setFont(new Font("Arial",Font.PLAIN,12));
        content.add(txtContent);

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.anchor=GridBagConstraints.CENTER;
        this.add(new JLabel("Enter account number need transfer"),gbc);
        gbc.gridx+=1;
        this.add(containAccountNumber,gbc);
        gbc.gridy++;
        gbc.gridx=0;
        this.add(new JLabel("Amount"),gbc);
        gbc.gridx+=1;
        this.add(containAmount,gbc);
        gbc.gridy++;
        gbc.gridx=0;
        this.add(new JLabel("Content"),gbc);
        gbc.gridx+=1;
        this.add(containContent,gbc);
        }
        }
