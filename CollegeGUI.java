import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.UIManager.*;
public class CollegeGUI extends JFrame {
    static private OfferedCourses offeredCourses= new OfferedCourses();
    static private EnrolledStudents enrolledStudents = new EnrolledStudents();

    private JTextArea data;
    private JRadioButton orderName;
    private JRadioButton orderId;
    private JButton addStudent;
    private JButton enrollStudent;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem itemAddStudent, itemEnrollStudent, itemExit;

    private void constructMenu() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menu = new JMenu("Menu");
        itemAddStudent = new JMenuItem("Add new student");
        itemEnrollStudent = new JMenuItem("Enroll student in course");
        itemExit = new JMenuItem("Exit");
        menu.add(itemAddStudent);
        menu.add(itemEnrollStudent);
        menu.add(itemExit);
        menuBar.add(menu);
    }
    private Component constructControls() {
        orderName = new JRadioButton("Order by student's name", true);
        orderId = new JRadioButton("Order by student's id", false);
        ButtonGroup bg = new ButtonGroup();
        bg.add(orderName);
        bg.add(orderId);
        addStudent = new JButton("Add new student");
        enrollStudent = new JButton("Enroll student in course");
        JPanel east = new JPanel();
        east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
        JPanel order = new JPanel();
        order.setLayout(new BoxLayout(order, BoxLayout.PAGE_AXIS));
        order.add(orderName);
        order.add(orderId);
        order.setBorder(BorderFactory.createTitledBorder("List order"));
        east.add(order);
        east.add(addStudent);
        east.add(enrollStudent);
        return east;
    }

    private Component constructInfo() {
        data = new JTextArea();
        data.setEditable(false);
        return new JScrollPane(data);
    }

    public static void setEnrolledStudents(EnrolledStudents obj) {
        enrolledStudents = obj;
    }

    public static void setOfferedCourses(OfferedCourses obj) {
        offeredCourses = obj;
    }

    public CollegeGUI(){
        super("College Management");
        InitialData.init(offeredCourses, enrolledStudents);
        constructMenu();
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        pane.add(constructInfo(), BorderLayout.CENTER);
        pane.add(constructControls(), BorderLayout.EAST);
        setContentPane(pane);
        setLocation(50,50);
        setSize(700,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        if (orderName.isSelected()) {
            order();
        } else if (orderId.isSelected()) {
            order();
        }
        addStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                AddStudentDialog d = new AddStudentDialog(CollegeGUI.this, enrolledStudents, offeredCourses);
                d.setVisible(true);
                order();
            }
        });

        enrollStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                EnrollStudentDialog d = new EnrollStudentDialog(CollegeGUI.this, enrolledStudents, offeredCourses);
                d.setVisible(true);
                order();
            }
        });

        itemAddStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                AddStudentDialog d = new AddStudentDialog(CollegeGUI.this, enrolledStudents, offeredCourses);
                d.setVisible(true);
                order();
            }
        });

        itemEnrollStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                EnrollStudentDialog d = new EnrollStudentDialog(CollegeGUI.this, enrolledStudents, offeredCourses);
                d.setVisible(true);
                order();
            }
        });

        itemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                CollegeGUI.super.dispose();
            }
        });

        orderName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                if (orderName.isSelected()) {
                    order();
                }
            }
        });

        orderId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                if (orderId.isSelected()) {
                    order();
                }
            }
        });

    }

    public void order() {
        if (orderName.isSelected()) {
            data.setText("");
            String result = "";
            List<Student> students = enrolledStudents.getStudentsOrderByName();
            for (int i = 0; i < students.size(); i++) {
                if (i == 0) {
                    result += students.get(i);
                } else {
                    result += "\n" + students.get(i);
                }
            }
            data.setText(result);
        } else if (orderId.isSelected()) {
            data.setText("");
            String result = "";
            List<Student> students = enrolledStudents.getStudentsOrderById();
            for (int i = 0; i < students.size(); i++) {
                if (i == 0) {
                    result += students.get(i);
                } else {
                    result += "\n" + students.get(i);
                }
            }
            data.setText(result);
        }
    }


    public static void main (String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {
        }
        new CollegeGUI();
    }
}