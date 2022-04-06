
package Class;


public class StudentEnrolment {
    private String idStudent;
    private String idCourse;
    private String semester;

    public StudentEnrolment(String idStudent, String idCourse, String semester) {
        this.idStudent = idStudent;
        this.idCourse = idCourse;
        this.semester = semester;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

   

   
}
