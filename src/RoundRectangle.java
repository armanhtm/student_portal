import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
/**
 * @author Arman Hatami
 * @version 1.0
 * a class for showing a rectangle panel (without sharp angles)
 */
public class RoundRectangle extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(133,158,51));
        g.fillRoundRect(0,0,getWidth(),getHeight(),30,30);
    }
}
