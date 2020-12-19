import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class List implements Serializable {
    private Object object;
    private JPanel panel=new JPanel();
    private String[] listMenu;
    private ArrayList<ArrayList> objects;
    public List(String[] listMenu, ArrayList<ArrayList> objects) {
        this.listMenu = listMenu;
        this.objects = objects;
        startUI();
    }


    public void startUI() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
//                try {
//                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//                    ex.printStackTrace();
//                }
                int j;
                MyTableModel model = new MyTableModel();
                for(int i = 0 ;i < getSize() ; i++){
                    Object[] row = new Object[ objects.get(i).size() + 1];
                    for (j = 0; j < objects.get(i).size(); j++) {
                        row[j] = objects.get(i).get(j);
                    }
                    row[j] = false;

                    model.addRow(row);
                }

                panel.removeAll();
                JTable table = new JTable(model);
                panel.add(new JScrollPane(table));
                panel.revalidate();
                panel.repaint();
            }
        });
    }

    public void deleteRow(){
        if (objects.contains(object))
            objects.remove(object);
        startUI();
    }

    public JPanel addGrade(JPanel jPanel) {
        JPanel panel = new JPanel(new BorderLayout(0, 50));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel(" enter grade for selected student ");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);
        JLabel grade = new JLabel("              " + "grade  : ");
        grade.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField gradeField = new JTextField();
        gradeField.setFont(new Font("Arial", Font.BOLD, 12));
        JPanel fieldsPanel = new JPanel(new GridLayout(4, 2, 0, 10));
        fieldsPanel.add(grade);
        fieldsPanel.add(gradeField);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));
        JButton loginButton = new JButton("add");
        loginButton.setBackground(Color.red);
        loginButton.setForeground(Color.white);
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                loginButton.setForeground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                loginButton.setForeground(Color.WHITE);
            }

            public void mousePressed(MouseEvent e) {
                if (objects.contains(object)){
                    String grade=gradeField.getText();
                    int i=objects.indexOf(object);
                    objects.get(i).set(2,grade);
                }
                startUI();
                panel.removeAll();
                panel.add(jPanel);
                panel.revalidate();
                panel.repaint();
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
    public class MyTableModel extends DefaultTableModel {

        public MyTableModel() {
            super(listMenu, 0);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            Class stringClass = String.class;
            if(columnIndex == objects.get(0).size()){
                stringClass = Boolean.class;
            }
            else
            if(columnIndex == 0){
                stringClass = Integer.class;
            }
            return stringClass;
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return column == objects.get(0).size();
        }


        @Override
        public void setValueAt(Object aValue, int row, int column) {
            if (aValue instanceof Boolean && column == objects.get(0).size()) {
                if (aValue==Boolean.TRUE){
                    object=objects.get(row);
                }
                Vector rowData = (Vector)getDataVector().get(row);
                rowData.set(objects.get(0).size(), aValue);
                fireTableCellUpdated(row, column);
            }
        }

    }
    public JPanel getPanel(){
        return panel;
    }
    public void addObject(ArrayList object){
        objects.add(object);
        startUI();
    }
    public int getSize(){
        try {
            return objects.size();
        }
        catch (Exception e){
            return 0;
        }
    }
    public ArrayList<ArrayList> getObjects(){
        return objects;
    }
    public Object select(){
        return object;
    }
}
