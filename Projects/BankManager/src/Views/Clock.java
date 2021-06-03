package Views; /**
 *  Simple Digital Clock
 *  Author : Ny Aina Erick Randrianjafy
 *  email : ainaerik@gmail.com
 *  fb : Ny Aina Erick Randrianjafy
 *  (c) 25/07/2015
 *
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock extends JPanel implements MouseListener, MouseMotionListener {
    private static final long serialVersionUID = 1L;
    private JLabel timeLabel, dateLabel;
    private Timer timer;
    private Font fontT = new Font("Segoe UI", 8, 35);
    private Font fontD = new Font("Segoe UI", 8, 20);
    private int initX, initY;

    public Clock(Color color)
    {
//        setSize(250,100);
//        setLocation( Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth(), 1 );
//        setUndecorated(true);
//        setType(Type.UTILITY);  //remove icon on taskbar
//        setResizable(false);

        JPanel pan = new RadiusAndShadow();
        pan.setBackground(color);
        pan.setBorder(null);

        timeLabel = new JLabel(" ", JLabel.CENTER);
        dateLabel = new JLabel(" ", JLabel.CENTER);
        timeLabel.setFont(fontT);
        timeLabel.setForeground(new Color(38, 38, 38));
        dateLabel.setFont(fontD);
        dateLabel.setForeground(new Color(38, 38, 38));
        timer = new Timer(1000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                timeLabel.setText(currentTime(timeLabel));
                dateLabel.setText(currentDate(dateLabel));
            }
        });
        timer.start();
        pan.add(timeLabel);
        pan.add(dateLabel);
        add(pan);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    private String currentTime(JLabel labelT) {
        Date d = new Date();
        SimpleDateFormat sp = new SimpleDateFormat("kk:mm:ss");
        String strT = sp.format(d);
        labelT.setText(strT);
        return strT;
    }

    private String currentDate(JLabel labelD) {
        Date d = new Date();
        SimpleDateFormat spd = new SimpleDateFormat("dd MMMM yyyy");
        String strD = spd.format(d);
        labelD.setText(strD);
        return strD;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {}

    @Override
    public void mouseEntered(MouseEvent arg0) {}

    @Override
    public void mouseExited(MouseEvent arg0) {}

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {}

    @Override
    public void mouseDragged(MouseEvent e) {
//        this.setLocation(
//                this.getLocation().x + (e.getX()-initX),
//                this.getLocation().y + (e.getY()-initY)
//        );
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {}
}
