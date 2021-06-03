package Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ScaleImg extends JPanel
{
    private BufferedImage image;

    public ScaleImg(String pathImg)
    {
        try
        {
            image = ImageIO.read(getClass().getResource(pathImg));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(500, 0);
    }
}
