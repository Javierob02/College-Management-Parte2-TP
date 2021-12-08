import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Work with course setting using methods
//aka getCourse(int id) -> offered or getStudent(int id) -> enrolled
//use to enroll student to course

class EnrollStudentDialog extends JDialog {
    OfferedCourses offeredCourses;
    EnrolledStudents enrolledStudents;
    private JComboBox students_combo;
    private JComboBox courses_combo;
    private JButton accept;
    private JButton cancel;

    public EnrollStudentDialog(Frame parent, EnrolledStudents e, OfferedCourses o) {
        super(parent, true);
        accept = new JButton("Accept");
        cancel = new JButton("Cancel");
        enrolledStudents = e;
        offeredCourses = o;
        students_combo = new JComboBox(list_s(enrolledStudents));
        courses_combo = new JComboBox(list_c(offeredCourses));

        Container panel = getContentPane();
        JPanel data = new JPanel();
        JPanel buttons = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        data.setLayout(new BoxLayout(data, BoxLayout.X_AXIS));
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));

        data.add(new JLabel("Student: "));
        data.add(students_combo);
        data.add(new JLabel(" Course: "));
        data.add(courses_combo);
        buttons.add(accept);
        buttons.add(cancel);
        panel.add(data); panel.add(buttons);

        accept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                isAccepted();
                CollegeGUI.setEnrolledStudents(enrolledStudents);
                CollegeGUI.setOfferedCourses(offeredCourses);
                setVisible(false);
            }
        });

        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                setVisible(false);
            }
        });

        setLocation(200,100);
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
    }

    public String[] list_s(EnrolledStudents enrolledStudents) {
        String[] students = new String[enrolledStudents.lista_students.size()];
        for(int i = 0; i < enrolledStudents.lista_students.size(); i++) {
            students[i] = enrolledStudents.getStudentsOrderById().get(i).toStudent();
        }
        return students;
    }

    public String[] list_c(OfferedCourses offeredCourses) {
        String[] courses = new String[offeredCourses.lista_courses.size()];
        for(int i = 0; i < offeredCourses.lista_courses.size(); i++) {
            courses[i] = offeredCourses.lista_courses.get(i).toString();
        }
        return courses;
    }

    public boolean isAccepted() {   //must add to outside list
        //selected student and course
        Student student = getStudent();
        Course course = getCourse();
        //enroll student
        student.enrollCourse(course);
        //close window
        setVisible(false);
        return true;
    }
    public Student getStudent() {       //How to get student
        int index = students_combo.getSelectedIndex();
        Student student = enrolledStudents.getStudentsOrderById().get(index);
        return student;
    }
    public Course getCourse() {
        int index = courses_combo.getSelectedIndex();
        Course course = offeredCourses.lista_courses.get(index);
        return course;
    }
}