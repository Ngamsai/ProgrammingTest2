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
        if (studentID != null){
            Request.studentID = studentID;
            return studentID;
        }else{
            throw new RuntimeException("StudentID is null!");
        }
    }

    @Override
    public String getCourseID() {
        return courseID;
    }

    @Override
    public void setCourseID(String courseID) {
        if (courseID != null){
            Request.courseID = courseID;
        }else{
            throw new RuntimeException("CourseID is null");
        }
    }

    @Override
    public int getRequestType() {
        return type;
    }

    @Override
    public int setType(int type){
        if (type == IRequest.REQUEST_ADD || type == IRequest.REQUEST_DROP) {
            Request.type = type;
            return type;
        } else {
            throw new RuntimeException("Invalid Type");
        }
    }
}

