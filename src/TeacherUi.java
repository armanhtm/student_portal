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
 * teacher user interface
 */
public class TeacherUi implements ActionListener {
    private JPanel announce;
    private JPanel header;
    private JFrame jFrame;
    private Teacher teacher;
    private ChangePassword changePass;
    private Source source;

    /**
     * constructor method
     * @param source
     */
    public TeacherUi(Source source) {
        this.source = source;
        teacher = source.teacher();
        jFrame = new JFrame();
        jFrame.setExtendedState(MAXIMIZED_BOTH);
        jFrame.setLayout(new BorderLayout(100,100));
        addAnnounce();
        addInfo();
        addOptions();
        jFrame.setVisible(true);
    }

    /**
     * add announce to main Jframe
     */
    public void addAnnounce(){
        announce = new JPanel(new BorderLayout(0, 50));
        announce.setBorder(new EmptyBorder(5, 5, 5, 5));

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
                /*
                try {

                    if (student.addCredit(Integer.parseInt(nameField.getText())))
                        JOptionPane.showMessageDialog(jFrame, "Successful!", "Result", JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(jFrame, "Failed!", "Result", JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception error){
                    System.out.println("empty blocks");
                }

                 */
            }

        });

        int buttonWidth = loginButton.getPreferredSize().width;
        int buttonHeight = loginButton.getPreferredSize().height + 10;
        loginButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        JTextArea textArea = new JTextArea();
        textArea.append(source.getAnnouncement());
        textArea.setFont(new Font("Arial", Font.BOLD, 16));
        textArea.setEditable(false);
        announce.add(label, BorderLayout.NORTH);
        announce.add(textArea,BorderLayout.CENTER);
        announce.add(loginButton, BorderLayout.SOUTH);
        jFrame.add(announce,BorderLayout.CENTER);
    }

    /**
     * add info to main Jframe
     */
    public void addInfo(){
        header = new JPanel();
        header.setLayout(new GridLayout(1,2));
        CirclePanel info = new CirclePanel();
        info.setLayout(new GridLayout(1,4));
        info.setPreferredSize(new Dimension(600,200));
        Date date = new Date();
        date.setPreferredSize(new Dimension(600,100));
        JLabel name = new JLabel("    Teacher  " + teacher.getName());
        name.setFont(new Font("Arial", Font.BOLD, 16));
        name.setForeground(Color.WHITE);
        info.add(name);
        JLabel credit = new JLabel("  courses : " + teacher.getListCourses().getSize() + "  +  ");
        credit.setFont(new Font("Arial", Font.BOLD, 12));
        credit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                credit.setForeground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                credit.setForeground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                announce.removeAll();
                announce.add(addCourse());
                announce.revalidate();
                announce.repaint();
            }
        });
        credit.setForeground(Color.WHITE);
        info.add(credit);
        JLabel average = new JLabel("students : " + teacher.getListStudents().getSize());
        average.setFont(new Font("Arial", Font.BOLD, 12));
        average.setForeground(Color.WHITE);
        info.add(average);
        header.add(info);
        header.add(date);
        jFrame.add(header,BorderLayout.PAGE_START);

    }

    /**
     * add options to main Jframe
     */
    public void addOptions(){
        JPanel options = new JPanel();
        options.setLayout(new GridLayout(4,1));
        options.setPreferredSize(new Dimension(300,500));
        JButton joinCourse = new JButton("show courses");
        joinCourse.setBackground(Color.WHITE);
        joinCourse.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                joinCourse.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                joinCourse.setBackground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                announce.removeAll();
                announce.add(showCourse());
                announce.revalidate();
                announce.repaint();
            }
        });
        options.add(joinCourse);
        JButton reserveFood = new JButton("show Students");
        reserveFood.setBackground(Color.WHITE);
        reserveFood.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                reserveFood.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                reserveFood.setBackground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                announce.removeAll();
                announce.add(showStudents());
                announce.revalidate();
                announce.repaint();
            }
        });
        options.add(reserveFood);
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
                        if(changePass.getUsername().equals(teacher.getName()) && changePass.getPassword().equals(teacher.getPassword())){
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
                                    if(changePass.getUsername().equals(teacher.getName())) {
                                        if(teacher.changePassword(changePass.getPassword()))
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
        JButton addCredit = new JButton("sign out");
        addCredit.setBackground(Color.WHITE);
        addCredit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                addCredit.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                addCredit.setBackground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                try {
                    source.setTeacherArrayList();
                    source.setCourseArrayList();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } finally {
                    jFrame.setVisible(false);
                    jFrame.dispose();
                }
            }
        });
        options.add(addCredit);
        jFrame.add(options,BorderLayout.LINE_START);
    }

    /**
     * add a new course by teacher
     * @return Jpanel
     */
    public JPanel addCourse(){
        ArrayList course = new ArrayList();
        JPanel panel = new JPanel(new BorderLayout(0, 50));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel(" add a new course ");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));


        JLabel nameLabel = new JLabel("               " +
                "                           course name : ");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField nameField = new JTextField();
        JLabel selectHour = new JLabel("              " +
                "                            time : ");
        selectHour.setFont(new Font("Arial", Font.BOLD, 16));
        String[] hour = new String[]{"8 - 10","10 - 12","14 - 16"};
        JComboBox time = new JComboBox(hour);
        JLabel selectDayOne = new JLabel("              " +
                "                            first session : ");
        selectDayOne.setFont(new Font("Arial", Font.BOLD, 16));
        String[] day = new String[]{"saturday","sunday","monday","tuesday","wednesday"};
        JComboBox firstSession = new JComboBox(day);
        JLabel selectDayTwo = new JLabel("              " +
                "                            second session : ");
        JComboBox secondSession = new JComboBox(day);
        selectDayTwo.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel costLabel = new JLabel("              " +
                "                            units  : ");
        costLabel.setFont(new Font("Arial", Font.BOLD, 16));
        SpinnerModel costValue = new SpinnerNumberModel(1,0,4,1);
        JSpinner cost = new JSpinner(costValue);
        JLabel capacityLabel = new JLabel("              " +
                "                            capacity  : ");
        capacityLabel.setFont(new Font("Arial", Font.BOLD, 16));
        SpinnerModel capacityValue = new SpinnerNumberModel(20,5,100,5);
        JSpinner capacity = new JSpinner(capacityValue);
        JPanel fieldsPanel = new JPanel(new GridLayout(6, 2, 0, 5));
        fieldsPanel.add(nameLabel);
        fieldsPanel.add(nameField);
        fieldsPanel.add(selectHour);
        fieldsPanel.add(time);
        fieldsPanel.add(selectDayOne);
        fieldsPanel.add(firstSession);
        fieldsPanel.add(selectDayTwo);
        fieldsPanel.add(secondSession);
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
                    course.add(nameField.getText());
                    course.add(time.getSelectedItem());
                    course.add(firstSession.getSelectedItem());
                    course.add(secondSession.getSelectedItem());
                    course.add(cost.getValue());
                    course.add(capacity.getValue());
                    teacher.getListCourses().addObject(course);
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
     * show course of the teacher
     * @return
     */
    public JPanel showCourse(){
        JPanel panel = new JPanel(new BorderLayout(0, 50));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel("open courses");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));
        JButton loginButton = new JButton("close selected course");
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
                    teacher.getListCourses().deleteRow();
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
        panel.add(teacher.getListCourses().getPanel(), BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * show students of teacher
     * @return Jpanel
     */
    public JPanel showStudents(){
        JPanel panel = new JPanel(new BorderLayout(0, 50));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel("students in your courses");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));
        JButton loginButton = new JButton("add grade to selected student");
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
                    announce.removeAll();
                    announce.add(teacher.getListStudents().addGrade(showStudents()));
                    announce.revalidate();
                    announce.repaint();
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
        panel.add(teacher.getListStudents().getPanel(), BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
        return panel;
    }
    public void actionPerformed(ActionEvent e) {

    }
}
