package Main;


import Views.LoginFrame;

import java.awt.*;

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
