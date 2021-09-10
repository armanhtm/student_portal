import javax.swing.*;
import java.io.IOException;
import static java.awt.Frame.MAXIMIZED_BOTH;
/**
 * @author Arman Hatami
 * @version 1.0
 * main class where i just run the program
 */

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //change the look anf feel to nimbus
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        //make an instance of login
       Login login = new Login();
    }
}
