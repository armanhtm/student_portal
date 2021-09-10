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
 * student user interface
 */
public class StudentUi implements ActionListener {
    private JPanel announce;
    private JPanel header;
    private JFrame jFrame;
    private Student student;
    private ChangePassword changePass;
    private Source source;

    /**
     * constructor method
     * @param source
     */
    public StudentUi(Source source){
        this.source = source;
        student = source.student();
        jFrame = new JFrame();
        jFrame.setExtendedState(MAXIMIZED_BOTH);
        jFrame.setLayout(new BorderLayout(100,100));
        addInfo();
        addOptions();
        addAnnounce();
        jFrame.setVisible(true);
    }

    /**
     * make info panel
     */
    public void addInfo(){
        header = new JPanel();
        header.setLayout(new GridLayout(1,2));
        CirclePanel info = new CirclePanel();
        info.setLayout(new GridLayout(1,4));
        info.setPreferredSize(new Dimension(600,200));
        Date date = new Date();
        date.setPreferredSize(new Dimension(600,100));
        JLabel name = new JLabel("    Student  " + student.getName());
        name.setFont(new Font("Arial", Font.BOLD, 16));
        name.setForeground(Color.WHITE);
        info.add(name);
        JLabel credit = new JLabel("  credit : " + student.getCredit() + "  +  ");
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
                announce.add(setCredit());
                announce.revalidate();
                announce.repaint();
            }
        });
        credit.setForeground(Color.WHITE);
        info.add(credit);
        JLabel units = new JLabel("units : " + student.numberOfUnits());
        units.setFont(new Font("Arial", Font.BOLD, 12));
        units.setForeground(Color.WHITE);
        info.add(units);
        JLabel average = new JLabel("average : " + student.getAverage());
        average.setFont(new Font("Arial", Font.BOLD, 12));
        average.setForeground(Color.WHITE);
        info.add(average);
        header.add(info);
        header.add(date);
        jFrame.add(header,BorderLayout.PAGE_START);

    }

    /**
     * add option panel to Jframe
     */
    public void addOptions(){
        JPanel options = new JPanel();
        options.setLayout(new GridLayout(6,1));
        options.setPreferredSize(new Dimension(300,500));
        JButton joinCourse = new JButton("join a new course");
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
                announce.add(joinCourse());
                announce.revalidate();
                announce.repaint();
            }
        });
        options.add(joinCourse);
        JButton reserveFood = new JButton("reserve food");
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
                announce.add(reserveFood());
                announce.revalidate();
                announce.repaint();
            }
        });
        options.add(reserveFood);
        JButton showCourse = new JButton("show courses");
        showCourse.setBackground(Color.WHITE);
        showCourse.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                showCourse.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                showCourse.setBackground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                announce.removeAll();
                announce.add(showSelectedCourses());
                announce.revalidate();
                announce.repaint();
            }
        });
        options.add(showCourse);
        JButton addCredit = new JButton("show foods");
        addCredit.setBackground(Color.WHITE);
        addCredit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                addCredit.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                addCredit.setBackground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                announce.removeAll();
                announce.add(showSelectedFoods());
                announce.revalidate();
                announce.repaint();
            }
        });
        options.add(addCredit);
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
                        if(changePass.getUsername().equals(student.getName()) && changePass.getPassword().equals(student.getPassword())){
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
                                    if(changePass.getUsername().equals(student.getName())) {
                                        if(student.changePassword(changePass.getPassword()))
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
        JButton signOut = new JButton("sign out");
        signOut.setBackground(Color.WHITE);
        signOut.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                signOut.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                signOut.setBackground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                try {
                    source.setStudentsArrayList();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                jFrame.setVisible(false);
                jFrame.dispose();
            }
        });
        options.add(signOut);
        jFrame.add(options,BorderLayout.LINE_START);
    }

    /**
     * add announce to main panel
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
    public void actionPerformed(ActionEvent e) {
    }

    /**
     * make Jpanel for increase credit
     * @return Jpanel
     */
    public JPanel setCredit(){
        JPanel panel = new JPanel(new BorderLayout(0, 50));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel(" Please Enter Your Information ");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));


        JLabel nameLabel = new JLabel("               " +
                "                            Amount : ");
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


        JButton loginButton = new JButton("request");
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

                    if (student.addCredit(Integer.parseInt(nameField.getText()))) {
                        JOptionPane.showMessageDialog(jFrame, "Successful!", "Result", JOptionPane.INFORMATION_MESSAGE);
                        header.removeAll();
                        header.add(updateInfo());
                        header.revalidate();
                        header.repaint();
                    }
                    else
                        JOptionPane.showMessageDialog(jFrame, "Failed!", "Result", JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception error){
                    System.out.println("empty blocks");
                }
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
     * make panel for reserve food
     * @return Jpanel
     */
    public JPanel reserveFood(){
        JPanel panel = new JPanel(new BorderLayout(0, 50));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel(" Please select foods you want to reserve ");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));
        JButton loginButton = new JButton("order");
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
                ArrayList temp = (ArrayList)student.getListFoods().select();
                if(student.subCredit((int)temp.get(2))){
                    student.getListSelectedFoods().addObject(temp);
                    JOptionPane.showMessageDialog(jFrame, "Successful!", "Result", JOptionPane.INFORMATION_MESSAGE);
                    header.removeAll();
                    header.add(updateInfo());
                    header.revalidate();
                    header.repaint();
                }
                else
                    JOptionPane.showMessageDialog(jFrame, "not enough!", "Result", JOptionPane.ERROR_MESSAGE);
            }

        });

        int buttonWidth = loginButton.getPreferredSize().width;
        int buttonHeight = loginButton.getPreferredSize().height + 10;
        loginButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        panel.add(label, BorderLayout.NORTH);
        panel.add(student.getListFoods().getPanel(), BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * make panel for show available courses
     * @return Jpanel
     */
    public JPanel joinCourse(){
            JPanel panel = new JPanel(new BorderLayout(0, 50));
            panel.setBorder(new EmptyBorder(5, 5, 5, 5));

            JLabel label = new JLabel(" Please select course you want to join ");
            label.setBackground(Color.ORANGE);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setOpaque(true);

            Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
            label.setBorder(border);

            int labelWidth = label.getPreferredSize().width;
            int labelHeight = label.getPreferredSize().height + 10;
            label.setPreferredSize(new Dimension(labelWidth, labelHeight));
            JButton loginButton = new JButton("join");
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
                    ArrayList temp = (ArrayList) student.getListCourses().select();
                    temp.remove(temp.size() - 1);
                    temp.add("");
                    if(student.checkForNewCourse((String)temp.get(2),(String)temp.get(3),(String)temp.get(4))){
                        student.getListSelectedCourses().addObject(temp);
                        source.addStudentToCourse(temp);
                        JOptionPane.showMessageDialog(jFrame, "Successful!", "Result", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(jFrame, "Failed!", "Result", JOptionPane.ERROR_MESSAGE);
                    }

                }

            });

            int buttonWidth = loginButton.getPreferredSize().width;
            int buttonHeight = loginButton.getPreferredSize().height + 10;
            loginButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

            panel.add(label, BorderLayout.NORTH);
            panel.add(student.getListCourses().getPanel(), BorderLayout.CENTER);
            panel.add(loginButton, BorderLayout.SOUTH);
            return panel;
    }

    /**
     * update header of Jframe
     * @return ـJpanel
     */
    public JPanel updateInfo(){
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(1,2));
        CirclePanel info = new CirclePanel();
        info.setLayout(new GridLayout(1,4));
        info.setPreferredSize(new Dimension(600,200));
        Date date = new Date();
        date.setPreferredSize(new Dimension(600,100));
        JLabel name = new JLabel("    Student  " + student.getName());
        name.setFont(new Font("Arial", Font.BOLD, 16));
        name.setForeground(Color.WHITE);
        info.add(name);
        JLabel credit = new JLabel("  credit : " + student.getCredit() + "  +  ");
        credit.setFont(new Font("Arial", Font.BOLD, 12));
        credit.setForeground(Color.WHITE);
        credit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                credit.setForeground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                credit.setForeground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                announce.removeAll();
                announce.add(setCredit());
                announce.revalidate();
                announce.repaint();
            }
        });
        info.add(credit);
        JLabel units = new JLabel("units : " + student.numberOfUnits());
        units.setFont(new Font("Arial", Font.BOLD, 12));
        units.setForeground(Color.WHITE);
        info.add(units);
        JLabel average = new JLabel("average : " + student.getAverage());
        average.setFont(new Font("Arial", Font.BOLD, 12));
        average.setForeground(Color.WHITE);
        info.add(average);
        header.add(info);
        header.add(date);
        return header;
    }

    /**
     * show jpanel of selected courses
     * @return Jpanel
     */
    public JPanel showSelectedCourses(){
        JPanel panel = new JPanel(new BorderLayout(0, 50));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel(" your courses ");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));
        JButton loginButton = new JButton("order");
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
                JOptionPane.showMessageDialog(jFrame, "this option is not active!", "Result", JOptionPane.INFORMATION_MESSAGE);
            }

        });

        int buttonWidth = loginButton.getPreferredSize().width;
        int buttonHeight = loginButton.getPreferredSize().height + 10;
        loginButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        panel.add(label, BorderLayout.NORTH);
        panel.add(student.getListSelectedCourses().getPanel(), BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * make Jpanel for show selected foods
     * @return Jpanel
     */
    public JPanel showSelectedFoods(){
        JPanel panel = new JPanel(new BorderLayout(0, 50));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel(" your foods ");
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
                    ArrayList temp = (ArrayList)student.getListSelectedFoods().select();
                    student.payBack((int)temp.get(2));
                    student.getListSelectedFoods().deleteRow();
                    JOptionPane.showMessageDialog(jFrame, "Successful!", "Result", JOptionPane.INFORMATION_MESSAGE);
                    header.removeAll();
                    header.add(updateInfo());
                    header.revalidate();
                    header.repaint();
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
        panel.add(student.getListSelectedFoods().getPanel(), BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
        return panel;
    }
}
