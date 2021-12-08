import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddStudentDialog extends JDialog{
    private JTextField id;
    private JTextField nombre;
    private JButton accept;
    private JButton cancel;
    EnrolledStudents enrolledStudents;
    OfferedCourses offeredCourses;

    public AddStudentDialog(Frame parent, EnrolledStudents e, OfferedCourses o) {
        super(parent, true);
        nombre = new JTextField(10);
        id = new JTextField(10);
        accept = new JButton("Accept");
        cancel = new JButton("Cancel");
        offeredCourses = o;
        enrolledStudents = e;

        Container panel = getContentPane();
        JPanel panel_id = new JPanel();
        JPanel panel_name = new JPanel();
        JPanel buttons = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel_name.setLayout(new BoxLayout(panel_name, BoxLayout.X_AXIS));
        panel_id.setLayout(new BoxLayout(panel_id, BoxLayout.X_AXIS));
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));

        panel_id.add(new JLabel("Student ID: ")); panel_id.add(id);
        panel_name.add(new JLabel("Student name: ")); panel_name.add(nombre);
        buttons.add(accept); buttons.add(cancel);
        panel.add(panel_id); panel.add(panel_name); panel.add(buttons);

        accept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                isAccepted();
                CollegeGUI.setEnrolledStudents(enrolledStudents);
                CollegeGUI.setOfferedCourses(offeredCourses);
            }
        });

        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                setVisible(false);
            }
        });

        setLocation(200,100);
        setSize(900,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
    }

    public boolean isAccepted() {   //Doesn`t add to the list
        int student_id = Integer.parseInt(getId());
        Student s = new Student(student_id, getName());
        setVisible(false);
        enrolledStudents.addStudent(s);
        return true;
    }

    public String getId() {
        return id.getText();
    }

    public String getName() {
        return nombre.getText();
    }
}