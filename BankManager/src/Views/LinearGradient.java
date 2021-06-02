package Views;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class LinearGradient extends  JPanel{

    private int temp;

    public LinearGradient(int temp)
    {
        this.temp = temp;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        int w = getWidth();
        int h = getHeight();

        // Vertical
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(222, 97, 97),
                0, h, new Color(38, 87, 235));

        // Horizontal
        GradientPaint gp2 = new GradientPaint(
                0, 0, new Color(0, 90, 167),
                w, 0, new Color(255, 253, 228));

        if(temp == 1) // Horizontal
        {
            g2d.setPaint(gp2);
            g2d.fillRect(0, 0, w, h);
        }
        else  // Vertical
        {
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, w, h);
        }
    }
}