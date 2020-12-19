import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangePassword {
    private String header;
    private JTextField uNameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    public ChangePassword(String head){
        this.header = head;
    }
    public JPanel changePassword(){
        JPanel panel = new JPanel(new BorderLayout(0, 50));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel(header);
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));
        JLabel uNameLabel = new JLabel("              " +
                "                          Username : ");
        uNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        uNameField = new JTextField();

        JLabel passwordLabel = new JLabel("           " +
                "                           Password : ");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        passwordField = new JPasswordField();

        JPanel fieldsPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        fieldsPanel.add(uNameLabel);
        fieldsPanel.add(uNameField);
        fieldsPanel.add(passwordLabel);
        fieldsPanel.add(passwordField);
        loginButton = new JButton("request");
        loginButton.setBackground(Color.red);
        loginButton.setForeground(Color.white);
        int buttonWidth = loginButton.getPreferredSize().width;
        int buttonHeight = loginButton.getPreferredSize().height + 10;
        loginButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        panel.add(label, BorderLayout.NORTH);
        panel.add(fieldsPanel, BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
        return panel;
    }
    public void changeHeader(String head){
        if(head != null)
            this.header = head;
    }
    public String getUsername(){
        return uNameField.getText();
    }
    public String getPassword(){
        return passwordField.getText();
    }
    public JButton getBotton(){
        return loginButton;
    }
}
