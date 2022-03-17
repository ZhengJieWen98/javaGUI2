package textbook.two.pojo;

public class Grade {
    private int id;
    private int userID;
    private String grade;
    private String major;
    private int studentCount;

    public Grade(){

    }

    public Grade(int id, int userID, String grade, String major, int studentCount) {
        this.id = id;
        this.userID = userID;
        this.grade = grade;
        this.major = major;
        this.studentCount = studentCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", userID=" + userID +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", studentCount=" + studentCount +
                '}';
    }
}
