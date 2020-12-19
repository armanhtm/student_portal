import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Login implements ActionListener {
    private JFrame jFrame;
    private JTextField username;
    private JPasswordField password;
    private JPanel panel;
    private Source source;
    public Login() throws IOException, ClassNotFoundException {
        source = new Source();
        panel =new JPanel();
        panel.setSize(300,300);
        panel.setLayout(null);
        panel.setLocation(600,150);
        jFrame=new JFrame();
        addLoginPanel();
        jFrame.setExtendedState(MAXIMIZED_BOTH);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
    public void addLoginPanel(){
        JLabel sign = new JLabel("Sign in to Portal");
        sign.setForeground(Color.black);
        sign.setBounds(645,80,200,80);
        sign.setFont(new Font("Arial", Font.BOLD, 18));
        jFrame.add(sign);
        jFrame.setBackground(Color.WHITE);
        JLabel numCart=new JLabel("Username");
        numCart.setBounds(0,0,80,40);
        panel.add(numCart);
        username =new JTextField();
        username.setBounds(0,30,250,30);
        panel.add(username);
        JLabel passCart=new JLabel("Password");
        passCart.setBounds(0,50,80,40);
        panel.add(passCart);
        password =new JPasswordField();
        password.setBounds(0,85,250,30);
        panel.add(password);
        JButton loginButton=new JButton("Login");
        loginButton.setBackground(Color.red);
        loginButton.setBounds(0,130,250,30);
        loginButton.setVisible(true);
        panel.add(loginButton);
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(Color.red);
            }

            public void mousePressed(MouseEvent e) {
                try {
                    if(!source.findUser(username.getText(),password.getText()))
                        JOptionPane.showMessageDialog(jFrame, "wrong username or password!", "Result", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        jFrame.add(panel);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
