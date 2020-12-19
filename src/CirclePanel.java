import javax.swing.*;
import java.awt.*;

public class CirclePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(133,158,51));
        g.fillOval(0,0,getWidth(),getHeight());
    }
}
