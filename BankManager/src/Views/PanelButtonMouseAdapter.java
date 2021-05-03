package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PanelButtonMouseAdapter extends MouseAdapter
{

    JPanel panel;
    int x, y, z;


    public PanelButtonMouseAdapter(JPanel panel, int x, int y, int z)
    {
        this.panel = panel;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        this.panel.setBackground(new Color(162, 85, 113));
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        this.panel.setBackground(new Color(x, y, z));
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        this.panel.setBackground(new Color(216, 53, 65));
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        this.panel.setBackground(new Color(x, y, z));
    }
}

