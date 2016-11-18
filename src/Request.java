/**
 * Created by pruet on 18/11/2559.
 */
public class Request implements IRequest {
    private static int type;
    private static String studentID;
    private static String courseID;

    public static IRequest createRequest(int type, String studentID, String courseID) {
        IRequest a = new Request();
        a.setType(type);
        a.setStudentID(studentID);
        a.setCourseID(courseID);
        return a;
    }

    protected Request() {
        throw new UnsupportedOperationException("Please override this method");
    }

    @Override
    public String getStudentID() {
        return studentID;
    }

    @Override
    public String setStudentID(String studentID) {
        String Old_student_ID;
        if (studentID != null){
            Old_student_ID = this.studentID;
            this.studentID = studentID;
            return Old_student_ID;
        }else{
            throw new RuntimeException("Empty List!");
        }
    }

    @Override
    public String getCourseID() {
        return courseID;
    }

    @Override
    public void setCourseID(String courseID) {
        if (studentID != null){
            this.courseID = courseID;
        }else{
            throw new RuntimeException("Empty List!");
        }
    }

    @Override
    public int getRequestType() {
        return type;
    }

    @Override
    public int setType(int type){
        if (type == 1 || type == 2) {
            return type;
        } else {
            throw new RuntimeException("InValid Type");
        }
    }
}

