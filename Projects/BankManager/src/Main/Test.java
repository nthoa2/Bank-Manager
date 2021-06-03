package Main;

import Views.LoginFrame;
import Views.Main;

import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    LoginFrame login = new LoginFrame();
                    login.setVisible(true);
                }
            });
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
