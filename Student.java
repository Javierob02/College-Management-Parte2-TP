import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Student {
    int student_id;
    String student_name;
    List<Course> lista_enrolled;

    /**
     * Constructor de la clase Student, inicializa los valores necesarios para la clase.
     * @param student_id -> Número identificativo del estudiante
     * @param student_name -> Nombre del estudiante
     */
    public Student(int student_id, String student_name) {
        this.student_id = student_id;
        this.student_name = student_name;
        lista_enrolled = new ArrayList<>();
    }

    /**
     * Método getId, devuelve el código identificativo de un estudiante.
     * @return student_id -> Código de un estudiante
     */
    public int getId() {
        return this.student_id;
    }

    /**
     * Método getName, devuelve el nombre de un estudiante.
     * @return student_name -> Nombre de un estudiante.
     */
    public String getName() {
        return this.student_name;
    }

    /**
     * Método enrollCourse, añade a un estudiante a una asigntura
     * @param o -> Un objeto de la clase Course
     * @return true -> Si se ha añadido correctamente | false -> Si no se ha añadido, ya que estaba añadido
     */
    public boolean enrollCourse(Course o){
        boolean found = false;
        boolean result = false;
        for (int i = 0; i < this.lista_enrolled.size(); i++) {
            if (this.lista_enrolled.get(i).getCode() == o.getCode()) {
                found = true;
                break;
            }
        }
        if (found) {
            //Pass(Ya está matriculado) -> False
        } else {        //Not enrolled, therefore must add to 'list_enrolled'
            result = true;
            this.lista_enrolled.add(o);
        }
        return result;
    }

    /**
     * Métdodo unenrollCourse, elimina a un estudiante de una asignatura
     * @param code -> El código de una asignatura
     * @return true -> Si se ha eliminado correctamente | false -> Si no se ha eliminado, ya que no estaba añadido
     */
    public boolean unenrollCourse(int code){
        boolean found = false;
        boolean result = false;
        int position = 0;
        for (int i = 0; i < this.lista_enrolled.size(); i++) {
            if (this.lista_enrolled.get(i).getCode() == code) {
                found = true;
                position = i;
                break;
            }
        }
        if (found) {
            this.lista_enrolled.remove(position);
            result = true;
        }   //If !found, result is alrady 'false'
        return result;
    }

    /**
     * Método getEnrolledCourses, devuelve una Colección de asignaturas a las que un estudiante pertenece
     * @return result -> Una colección de asignaturas
     */
    public Collection<Course> getEnrolledCourses() {
        List<Course> result = new ArrayList<>();
        for (int i = 0; i < this.lista_enrolled.size(); i++) {
            result.add(this.lista_enrolled.get(i));
        }
        result.sort(Comparator.comparing(Course::getCode));
        return result;
    }

    /**
     * Método toString, representación en String de la clase Student
     * @return result -> La representación string e.g. 1-Javier[(9273)Matmáticas, (2431)Programación]
     */
    public String toString() {
        String result;
        String pre_result = this.student_id + "-" + this.student_name;
        String all_courses = "[";
        List<Course> ordered_courses = new ArrayList<>();
        for (int i = 0; i < this.lista_enrolled.size(); i++) {
            ordered_courses.add(this.lista_enrolled.get(i));
        }
        ordered_courses.sort(Comparator.comparing(Course::getCode));
        if (ordered_courses.size() == 0) {
            all_courses = all_courses + "]";
        } else {
            for (int i = 0; i < ordered_courses.size(); i++) {
                if (i == 0){
                    all_courses = all_courses + ordered_courses.get(i);
                } else {
                    all_courses = all_courses + ", " + ordered_courses.get(i);
                }
            }
            all_courses = all_courses + "]";
        }
        result = pre_result + all_courses;
        return result;
    }

    public String toStudent() {
        return this.student_id + "-" + this.student_name;
    }
}
