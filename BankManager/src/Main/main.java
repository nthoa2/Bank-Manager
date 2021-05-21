package Main;


import Views.LoginFrame;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
