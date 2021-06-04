package Main;


import Views.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main
{
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            EventQueue.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    new LoginFrame().setVisible(true);
                }
            });
        }catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
