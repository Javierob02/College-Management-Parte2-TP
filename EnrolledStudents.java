import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EnrolledStudents {
    List<Student> lista_students;

    /**
     * Constructor de la clase EnrolledStudents, inicializa todos los valores para la clase EnrolledStudents
     * Crea una lista vaciá para los estudiantes
     */
    public EnrolledStudents() {
        lista_students = new ArrayList<>();
    }

    /**
     * Método addStudents, añade los estudiantes a la lista 'lista_students'
     * @param o -> Un objeto de la clase Student
     * @return true -> Si se añade a la lista | false -> Si no se añade a la lista ya que ya estaba añadido
     */
    public boolean addStudent(Student o) {
        boolean found = false;
        boolean result = false;
        for (int i = 0; i < lista_students.size(); i++) {
            if (lista_students.get(i).student_id == o.student_id) {
                found = true;
                break;
            }
        }
        if (found) {
            //pass(Result is already 'false')
        } else {
            result = true;
            lista_students.add(o);
        }
        return result;
    }

    /**
     * Métdod removeStudents, elimina a un estudiante de la lista 'lista_students'
     * @param id -> Número identifiacativo de un estudiante
     * @return true -> Si se eliminado a la lista | false -> Si no se ha eliminado de la lista ya que no estaba añadido
     */
    public boolean removeStudent(int id) {
        boolean found = false;
        boolean result = false;
        int position = 0;
        for (int i = 0; i < lista_students.size(); i++) {
            if (lista_students.get(i).student_id == id) {
                position = i;
                found = true;
                break;
            }
        }
        if (found) {
            result = true;
            lista_students.remove(position);     //Remove by index
        } else {
            //pass(Result is already 'false')
        }
        return result;
    }

    /**
     * Método getStudent, devuelve un estudiante con el id correspondiente.
     * @param id -> Identificador a buscar en un estudiante
     * @return result -> Devuelve un objeto de la clase Student si halla una igualdad | Devuelve null si no se encuentra
     */
    public Student getStudent(int id) {
        Student result = null;
        for (int i = 0; i < lista_students.size(); i++) {
            if (lista_students.get(i).student_id == id) {
                result = lista_students.get(i);
                break;
            }
        }
        return result;
    }

    /**
     * Método getStudentsByCourse, devuelve una lista de estudiantes ordenada por el curso.
     * @param id -> Código de una asignatura
     * @return students_enrolled -> Lista ordenada por curso de estudiantes
     */
    public List<Student> getStudentsByCourse(int id) {      //id -> Codigo de Asignatura
        List<Student> students_enrolled = new ArrayList<>();
        for(int i = 0; i < lista_students.size(); i++) {
            for (Course curso:lista_students.get(i).getEnrolledCourses()) {
                if (curso.getCode() == id) {
                    students_enrolled.add(lista_students.get(i));
                }
            }
        }
        students_enrolled.sort(Comparator.comparing(Student::getName));
        return students_enrolled;
    }

    /**
     * Método getStudentsOrderByName, devuelve una lista de estudiantes ordenada por el nombre.
     * @return result -> Lista ordenada por nombre de los estudiantes
     */
    public List<Student> getStudentsOrderByName() {     //Fix for equal Names, must compare by Id
        List<Student> result = new ArrayList<>();
        for (int i = 0; i < this.lista_students.size(); i++) {
            result.add(this.lista_students.get(i));
        }
        result.sort(Comparator.comparing(Student::getName));
        return result;
    }

    /**
     * Método getStudentsOrderById, devuelve una lista de estudiantes ordenada por el id
     * @return result -> Lista ordenada por id del estudiante
     */
    public List<Student> getStudentsOrderById() {
        List<Student> result = new ArrayList<>();
        for (int i = 0; i < this.lista_students.size(); i++) {
            result.add(this.lista_students.get(i));
        }
        result.sort(Comparator.comparing(Student::getId));
        return result;
    }
}