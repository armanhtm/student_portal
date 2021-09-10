import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import static java.awt.Frame.MAXIMIZED_BOTH;
/**
 * @author Arman Hatami
 * @version 1.0
 * admin user interface
 */

public class AdminUi implements ActionListener {
    private Admin admin;
    private JFrame jFrame;
    private JPanel announce;
    private Source source;
    private ChangePassword changePass;

    /**
     * constructor method
     * @param source
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public AdminUi(Source source) throws IOException, ClassNotFoundException {
        this.source = source;
        this.admin = source.Admin();
        jFrame = new JFrame();
        jFrame.setExtendedState(MAXIMIZED_BOTH);
        jFrame.setLayout(new BorderLayout(100,100));
        //setting method and adjust panel
        addAnnounce();
        addInfo();
        addOptions();
        jFrame.setVisible(true);
    }

    /**
     * make the information panel of main Jframe
     */
    public void addInfo(){
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(1,2));
        CirclePanel info = new CirclePanel();
        info.setLayout(new GridLayout(1,4));
        info.setPreferredSize(new Dimension(600,200));
        Date date = new Date();
        date.setPreferredSize(new Dimension(600,100));
        JLabel name = new JLabel("    Admin  " + admin.getName());
        name.setFont(new Font("Arial", Font.BOLD, 16));
        name.setForeground(Color.WHITE);
        info.add(name);
        JLabel stdCount = new JLabel("  students : " + admin.getListStudents().getSize() + "  +  ");
        stdCount.setFont(new Font("Arial", Font.BOLD, 12));
        stdCount.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                stdCount.setForeground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                stdCount.setForeground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                announce.removeAll();
                announce.add(addStudent());
                announce.revalidate();
                announce.repaint();
            }
        });
        JLabel tchCount = new JLabel("  teachers : " + admin.getListTeachers().getSize() + "  +  ");
        tchCount.setFont(new Font("Arial", Font.BOLD, 12));
        tchCount.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                tchCount.setForeground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                tchCount.setForeground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                announce.removeAll();
                announce.add(addTeacher());
                announce.revalidate();
                announce.repaint();
            }
        });
        JLabel foodCount = new JLabel("  foods : " + admin.getListFoods().getSize() + "  +  ");
        foodCount.setFont(new Font("Arial", Font.BOLD, 12));
        foodCount.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                foodCount.setForeground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                foodCount.setForeground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                announce.removeAll();
                announce.add(addFood());
                announce.revalidate();
                announce.repaint();
            }
        });
        stdCount.setForeground(Color.WHITE);
        tchCount.setForeground(Color.WHITE);
        foodCount.setForeground(Color.WHITE);
        info.add(stdCount);
        info.add(tchCount);
        info.add(foodCount);
        header.add(info);
        header.add(date);
        jFrame.add(header,BorderLayout.PAGE_START);

    }
    public void addOptions(){
        JPanel options = new JPanel();
        options.setLayout(new GridLayout(7,1));
        options.setPreferredSize(new Dimension(300,500));
        JButton announcement = new JButton("add announcement");
        announcement.setBackground(Color.WHITE);
        announcement.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                announcement.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                announcement.setBackground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                announce.removeAll();
                announce.add(addAnnounce());
                announce.revalidate();
                announce.repaint();
            }
        });
        options.add(announcement);
        JButton teachers = new JButton("show teachers");
        teachers.setBackground(Color.WHITE);
        teachers.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                teachers.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                teachers.setBackground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                announce.removeAll();
                announce.add(showTeachers());
                announce.revalidate();
                announce.repaint();
            }
        });
        options.add(teachers);
        JButton students = new JButton("show students");
        students.setBackground(Color.WHITE);
        students.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                students.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                students.setBackground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                announce.removeAll();
                announce.add(showStudents());
                announce.revalidate();
                announce.repaint();
            }
        });
        options.add(students);
        JButton foods = new JButton("show foods");
        foods.setBackground(Color.WHITE);
        foods.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                foods.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                foods.setBackground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                announce.removeAll();
                announce.add(showFoods());
                announce.revalidate();
                announce.repaint();
            }
        });
        options.add(foods);
        JButton courses = new JButton("show courses");
        courses.setBackground(Color.WHITE);
        courses.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                courses.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                courses.setBackground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                announce.removeAll();
                announce.add(showCourses());
                announce.revalidate();
                announce.repaint();
            }
        });
        options.add(courses);
        JButton changePassword = new JButton("change password");
        changePassword.setBackground(Color.WHITE);
        options.add(changePassword);
        changePassword.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                changePassword.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                changePassword.setBackground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                changePass = new ChangePassword("please enter your current password");
                announce.removeAll();
                announce.add(changePass.changePassword());
                announce.revalidate();
                announce.repaint();
                changePass.getBotton().addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {
                        changePass.getBotton().setBackground(Color.green);
                    }

                    public void mouseExited(MouseEvent e) {
                        changePass.getBotton().setBackground(Color.red);
                    }

                    public void mousePressed(MouseEvent e) {
                        if(changePass.getUsername().equals(admin.getName()) && changePass.getPassword().equals(admin.getPassword())){
                            changePass = new ChangePassword("please enter your new password");
                            announce.removeAll();
                            announce.add(changePass.changePassword());
                            announce.revalidate();
                            announce.repaint();
                            changePass.getBotton().addMouseListener(new MouseAdapter() {
                                public void mouseEntered(MouseEvent e) {
                                    changePass.getBotton().setBackground(Color.green);
                                }

                                public void mouseExited(MouseEvent e) {
                                    changePass.getBotton().setBackground(Color.red);
                                }

                                public void mousePressed(MouseEvent e) {
                                    if(changePass.getUsername().equals(admin.getName())) {
                                        if(admin.changePassword(changePass.getPassword()))
                                            JOptionPane.showMessageDialog(jFrame, "Successful!", "Result", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else
                                        JOptionPane.showMessageDialog(jFrame, "Failed!", "Result", JOptionPane.ERROR_MESSAGE);
                                }
                            });
                        }
                        else
                            JOptionPane.showMessageDialog(jFrame, "Failed!", "Result", JOptionPane.ERROR_MESSAGE);
                    }
                });
            }
        });
        JButton exit = new JButton("sign out");
        exit.setBackground(Color.WHITE);
        exit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                exit.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                exit.setBackground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                try {
                    source.setAdmin(admin);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                finally {
                    jFrame.setVisible(false);
                    jFrame.dispose();
                }
            }
        });
        options.add(exit);
        jFrame.add(options,BorderLayout.LINE_START);
    }

    /**
     * method for design a panel to add announcement
     * @return Jpanel
     */
    public JPanel addAnnounce(){
        announce = new JPanel(new BorderLayout(0, 50));
        announce.setBorder(new EmptyBorder(5, 5, 5, 5));
        JTextArea textArea = new JTextArea();

        JLabel label = new JLabel("whats new in portal?");
        label.setToolTipText("news relevant to portal");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));
        JButton loginButton = new JButton("contact : armanhatami.aut@gmail.com");
        loginButton.setToolTipText("contact me via gmail");
        loginButton.setBackground(Color.red);
        loginButton.setForeground(Color.white);
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(Color.red);
            }

            public void mousePressed(MouseEvent e) {
                admin.setAnnoucements(textArea.getText());
            }

        });

        int buttonWidth = loginButton.getPreferredSize().width;
        int buttonHeight = loginButton.getPreferredSize().height + 10;
        loginButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        textArea.append(admin.getAnnoucements());
        textArea.setFont(new Font("Arial", Font.BOLD, 16));
        textArea.setEditable(true);
        announce.add(label, BorderLayout.NORTH);
        announce.add(textArea,BorderLayout.CENTER);
        announce.add(loginButton, BorderLayout.SOUTH);
        jFrame.add(announce,BorderLayout.CENTER);
        return announce;
    }

    /**
     * make the panel of showing students
     * @return Jpanel
     */
    public JPanel addStudent(){
        ArrayList student = new ArrayList();
        JPanel panel = new JPanel(new BorderLayout(0, 50));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel(" register a new student ");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));


        JLabel nameLabel = new JLabel("               " +
                "                            username : ");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField nameField = new JTextField();


        JLabel psswdLabel = new JLabel("              " +
                "                            Password : ");
        JPasswordField psswdField = new JPasswordField();
        psswdLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel fieldsPanel = new JPanel(new GridLayout(2, 2, 0, 100));
        fieldsPanel.add(nameLabel);
        fieldsPanel.add(nameField);
        fieldsPanel.add(psswdLabel);
        fieldsPanel.add(psswdField);


        JButton loginButton = new JButton("register");
        loginButton.setBackground(Color.red);
        loginButton.setForeground(Color.white);
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(Color.red);
            }

            public void mousePressed(MouseEvent e) {

                    if (psswdField.getText().length() >= 8 && admin.checkUsername(nameField.getText())) {
                        student.add(nameField.getText());
                        student.add(psswdField.getText());
                        admin.getListStudents().addObject(student);
                        JOptionPane.showMessageDialog(jFrame, "Successful!", "Result", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(jFrame, "Failed!", "Result", JOptionPane.ERROR_MESSAGE);
                }


        });

        int buttonWidth = loginButton.getPreferredSize().width;
        int buttonHeight = loginButton.getPreferredSize().height + 10;
        loginButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        panel.add(label, BorderLayout.NORTH);
        panel.add(fieldsPanel, BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * make panel of adding new teacher
     * @return Jpanel
     */
    public JPanel addTeacher(){
        ArrayList teacher = new ArrayList();
        JPanel panel = new JPanel(new BorderLayout(0, 50));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel(" register a new teacher ");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));


        JLabel nameLabel = new JLabel("               " +
                "                            username : ");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField nameField = new JTextField();


        JLabel psswdLabel = new JLabel("              " +
                "                            Password : ");
        JPasswordField psswdField = new JPasswordField();
        psswdLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel fieldsPanel = new JPanel(new GridLayout(2, 2, 0, 100));
        fieldsPanel.add(nameLabel);
        fieldsPanel.add(nameField);
        fieldsPanel.add(psswdLabel);
        fieldsPanel.add(psswdField);


        JButton loginButton = new JButton("register");
        loginButton.setBackground(Color.red);
        loginButton.setForeground(Color.white);
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(Color.red);
            }

            public void mousePressed(MouseEvent e) {

                if (psswdField.getText().length() >= 8 && admin.checkUsername(nameField.getText())) {
                    teacher.add(nameField.getText());
                    teacher.add(psswdField.getText());
                    admin.getListTeachers().addObject(teacher);
                    JOptionPane.showMessageDialog(jFrame, "Successful!", "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(jFrame, "Failed!", "Result", JOptionPane.ERROR_MESSAGE);
            }


        });

        int buttonWidth = loginButton.getPreferredSize().width;
        int buttonHeight = loginButton.getPreferredSize().height + 10;
        loginButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        panel.add(label, BorderLayout.NORTH);
        panel.add(fieldsPanel, BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * make panel for adding food
     * @return Jpanel
     */
    public JPanel addFood(){
        ArrayList food = new ArrayList();
        JPanel panel = new JPanel(new BorderLayout(0, 50));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel(" add a food to the menu ");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));


        JLabel nameLabel = new JLabel("               " +
                "                           food name : ");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField nameField = new JTextField();


        JLabel selectDay = new JLabel("              " +
                "                            date : ");
        String[] day = new String[]{"saturday","sunday","monday","tuesday","wednesday"};
        JComboBox days = new JComboBox(day);
        selectDay.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel costLabel = new JLabel("              " +
                "                            cost  : ");
        costLabel.setFont(new Font("Arial", Font.BOLD, 16));
        SpinnerModel costValue = new SpinnerNumberModel(1000,500,5000,500);
        JSpinner cost = new JSpinner(costValue);
        JLabel capacityLabel = new JLabel("              " +
                "                            capacity  : ");
        capacityLabel.setFont(new Font("Arial", Font.BOLD, 16));
        SpinnerModel capacityValue = new SpinnerNumberModel(1000,100,2000,100);
        JSpinner capacity = new JSpinner(capacityValue);
        JPanel fieldsPanel = new JPanel(new GridLayout(4, 2, 0, 10));
        fieldsPanel.add(nameLabel);
        fieldsPanel.add(nameField);
        fieldsPanel.add(selectDay);
        fieldsPanel.add(days);
        fieldsPanel.add(costLabel);
        fieldsPanel.add(cost);
        fieldsPanel.add(capacityLabel);
        fieldsPanel.add(capacity);
        JButton loginButton = new JButton("add");
        loginButton.setBackground(Color.red);
        loginButton.setForeground(Color.white);
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(Color.red);
            }

            public void mousePressed(MouseEvent e) {

                if (nameField != null) {
                    food.add(nameField.getText());
                    food.add(days.getSelectedItem());
                    food.add(cost.getValue());
                    food.add(capacity.getValue());
                    admin.getListFoods().addObject(food);
                    JOptionPane.showMessageDialog(jFrame, "Successful!", "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(jFrame, "Failed!", "Result", JOptionPane.ERROR_MESSAGE);
            }


        });

        int buttonWidth = loginButton.getPreferredSize().width;
        int buttonHeight = loginButton.getPreferredSize().height + 10;
        loginButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        panel.add(label, BorderLayout.NORTH);
        panel.add(fieldsPanel, BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * make panel for show added foods
     * @return
     */
    public JPanel showFoods(){
        JPanel panel = new JPanel(new BorderLayout(0, 50));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel(" foods that you have already added ");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));
        JButton loginButton = new JButton("remove");
        loginButton.setBackground(Color.red);
        loginButton.setForeground(Color.white);
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(Color.red);
            }

            public void mousePressed(MouseEvent e) {
                try {
                    admin.getListFoods().deleteRow();
                    JOptionPane.showMessageDialog(jFrame, "Successful!", "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (Exception error){
                    JOptionPane.showMessageDialog(jFrame, "Failed!", "Result", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        int buttonWidth = loginButton.getPreferredSize().width;
        int buttonHeight = loginButton.getPreferredSize().height + 10;
        loginButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        panel.add(label, BorderLayout.NORTH);
        panel.add(admin.getListFoods().getPanel(), BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * make a panel for show teachers
     * @return Jpanel
     */
    public JPanel showTeachers(){
        JPanel panel = new JPanel(new BorderLayout(0, 50));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel(" teachers that you have already added ");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));
        JButton loginButton = new JButton("remove");
        loginButton.setBackground(Color.red);
        loginButton.setForeground(Color.white);
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(Color.red);
            }

            public void mousePressed(MouseEvent e) {
                try {
                    admin.getListTeachers().deleteRow();
                    JOptionPane.showMessageDialog(jFrame, "Successful!", "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (Exception error){
                    JOptionPane.showMessageDialog(jFrame, "Failed!", "Result", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        int buttonWidth = loginButton.getPreferredSize().width;
        int buttonHeight = loginButton.getPreferredSize().height + 10;
        loginButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        panel.add(label, BorderLayout.NORTH);
        panel.add(admin.getListTeachers().getPanel(), BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * make a panel for showing
     * @return Jpanel
     */
    public JPanel showStudents(){
        JPanel panel = new JPanel(new BorderLayout(0, 50));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel(" students that you have already added ");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));
        JButton loginButton = new JButton("select");
        loginButton.setBackground(Color.red);
        loginButton.setForeground(Color.white);
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(Color.red);
            }

            public void mousePressed(MouseEvent e) {
                try {
                    admin.getListStudents().deleteRow();
                    JOptionPane.showMessageDialog(jFrame, "Successful!", "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (Exception error){
                    JOptionPane.showMessageDialog(jFrame, "Failed!", "Result", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        int buttonWidth = loginButton.getPreferredSize().width;
        int buttonHeight = loginButton.getPreferredSize().height + 10;
        loginButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        panel.add(label, BorderLayout.NORTH);
        panel.add(admin.getListStudents().getPanel(), BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * make a panel for showing courses
     * @return
     */
    public JPanel showCourses(){
        JPanel panel = new JPanel(new BorderLayout(0, 50));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel(" added courses to portal by teachers");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));
        JButton loginButton = new JButton("select");
        loginButton.setBackground(Color.red);
        loginButton.setForeground(Color.white);
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(Color.red);
            }

            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(jFrame, "you can not do anything!", "Result", JOptionPane.ERROR_MESSAGE);
            }

        });

        int buttonWidth = loginButton.getPreferredSize().width;
        int buttonHeight = loginButton.getPreferredSize().height + 10;
        loginButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        panel.add(label, BorderLayout.NORTH);
        panel.add(admin.getListCourses().getPanel(), BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
        return panel;
    }
    public void actionPerformed(ActionEvent e) {

    }
}
