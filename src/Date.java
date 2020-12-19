import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

public class Date extends JPanel implements ActionListener {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
    private String clock;
    public Date() {
        updateClock();
        new Timer(1000, this).start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        updateClock();
        repaint();
    }
    private void updateClock() {
        LocalDate currentDate = LocalDate.now();
        clock = dateFormat.format(Calendar.getInstance().getTime());
        clock += "     " + currentDate.getDayOfWeek();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.setColor(Color.DARK_GRAY);
        g.drawString(clock,100,30);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.setColor(Color.CYAN);
        g.drawString("welcome",350,150);
    }
    public String getClock(){
        return clock;
    }
}
