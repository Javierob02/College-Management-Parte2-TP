import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OfferedCourses {
    List<Course> lista_courses;

    /**
     * Constructor de la clase OfferedCourses, inicializa todos los valores para la clase OfferedCourses
     * Crea una lista vacía llamada 'lista_courses'
     */
    public OfferedCourses() {
        lista_courses = new ArrayList<>();
    }

    /**
     * Método addCourses, añade un Curso a la lista 'lista_courses'
     * @param o -> Un objeto de la clase Course
     * @return true -> Si se añadió | false -> Si no se añadió porque ya estaba añadidio
     */
    public boolean addCourse(Course o) {
        boolean found = false;
        boolean result = false;
        for (int i = 0; i < this.lista_courses.size(); i++) {
            if (this.lista_courses.get(i).course_code == o.course_code) {
                found = true;
                break;
            }
        }
        if (found) {
            //Pass(result is already 'false')
        } else {
            this.lista_courses.add(o);
            result = true;
        }
        return  result;
    }

    /**
     * Método removeCourses, elimina un Curso de la lista 'lista_courses'
     * @param id -> Código de una asignatura
     * @return true -> Si se eliminó | false -> Si no se eliminó porque no estaba añadidio
     */
    public boolean removeCourse(int id) {
        boolean found = false;
        boolean result = false;
        int position = 0;
        for (int i = 0; i < this.lista_courses.size(); i++) {
            if (this.lista_courses.get(i).course_code == id) {
                position = i;
                found = true;
                break;
            }
        }
        if (found) {
            result = true;
            this.lista_courses.remove(position);     //Remove by index
        } else {
            //pass(Result is already 'false')
        }
        return result;
    }

    /**
     * Método getCourse, devuelve un curso con el mismo código de asignatura
     * @param id -> Un número que simula el código de una asignatura
     * @return result -> Un objeto de tipo Course, con el mismo código que 'id'
     */
    public Course getCourse(int id) {
        Course result = null;
        for (int i = 0; i < this.lista_courses.size(); i++) {
            if (this.lista_courses.get(i).course_code == id) {
                result = this.lista_courses.get(i);
                break;
            }
        }
        return result;
    }

    /**
     * Método getCourses, devuelve una lista con todas las asignaturas de un estudiante
     * @return result -> Lista de tipo Course, ordenada por código de las asignaturas
     */
    public List<Course> getCourses() {
        List<Course> result = new ArrayList<>();
        for (int i = 0; i < this.lista_courses.size(); i++) {
            result.add(this.lista_courses.get(i));
        }
        result.sort(Comparator.comparing(Course::getCode));
        return result;
    }
}