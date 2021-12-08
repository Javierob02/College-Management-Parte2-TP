public class Course {
    int course_code;
    String course_name;

    /**
     * Constructor de Course, inicializa los valores necesarios para la clase.
     * @param course_code -> Código del curso
     * @param course_name ->  Nombre del curso
     */
    public Course(int course_code, String course_name) {
        this.course_code = course_code;
        this.course_name = course_name;
    }

    /**
     * Método getCode, devuelve el código de un curso.
     * @return course_code -> Código del curso
     */
    public int getCode() {
        return this.course_code;
    }

    /**
     * Método getName, devuelve el nombre de un curso.
     * @return course_name -> Nombre del curso
     */
    public String getName() {
        return this.course_name;
    }

    /**
     * Método toString, representación en String de la clase Course
     * @return result -> e.g (9182)Matemáticas
     */
    public String toString() {
        String result = "(" + this.course_code + ")" + this.course_name;
        return result;
    }
}