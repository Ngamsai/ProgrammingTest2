import java.util.ArrayList;

public class Registration {
    // Request repository
    private ArrayList<IRequest> requestList;

    public Registration(){
        requestList = new ArrayList<>();
    }
    // Add new course, only request with non-exists studentID/courseID
    // is a valid request. Invalid request will cause an exception
    public void add(IRequest request) {
        if (request.getRequestType()== 1) {
            if (exists(request) == false) {
                requestList.add(request);
            } else {
                throw new RuntimeException("You has been enrolled this course.");
            }
        } else {
            throw new RuntimeException("Enroll is successfully.");
        }
    }

    // Drop existing course, only request with existing studentID/courseID
    // is a valid request. Invalid request will cause an exception
    public void drop(IRequest request) {
        if (request.getRequestType() == 2) {
            if (exists(request) == true) {
                requestList.remove(request);
            } else {
                System.out.println("Not found!!!");
            }
        } else {
            throw new RuntimeException("Drop is successfully.");
        }
    }

    // Check whether the request is in repository.
    public boolean exists(IRequest request) {
        return requestList.contains(request);
    }

    // Count all requests
    public int count() {
        return requestList.size();
    }

    // Count requests by request type
    public int countByType(int type) {
        int j = 0;
        for (int i = 0; i < requestList.size(); i++) {
            if (requestList.get(i).getRequestType() == type) {
                j = j+1 ;
            }
        }
        return j;
    }


    // Count request by course ID
    public int countByCourseID(String courseID) {
        int j = 0;
        for (int i = 0; i < requestList.size(); i++) {
            if (requestList.get(i).getCourseID() == courseID) {
                j = j+1 ;
            }
        }
        return j;
    }

    // Count request by student ID
    public int countByStudentID(String studentID) {
        int j = 0;
        for (int i = 0; i < requestList.size(); i++) {
            if (requestList.get(i).getStudentID() == studentID) {
                j = j+1 ;
            }
        }
        return j;
    }
}
