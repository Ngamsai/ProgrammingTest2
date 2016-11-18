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
        if (request.getRequestType()== IRequest.REQUEST_ADD) {
            if (!exists(request)) {
                requestList.add(request);
            } else {
                throw new RuntimeException("You has been enrolled this course.");
            }
        } else {
            throw new RuntimeException("Wrong request type");
        }
    }

    // Drop existing course, only request with existing studentID/courseID
    // is a valid request. Invalid request will cause an exception
    public void drop(IRequest request) {
        if (request.getRequestType() == IRequest.REQUEST_DROP) {
            if (exists(request)) {
                requestList.remove(request);
            } else {
                throw new RuntimeException("You has not been enrolled this course.");
            }
        } else {
            throw new RuntimeException("Wrong request type.");
        }
    }

    // Check whether the request is in repository.
    private boolean exists(IRequest request) {
        return requestList.contains(request);
    }

    // Count all requests
    public int count() {
        return requestList.size();
    }

    // Count requests by request type
    public int countByType(int type) {
        int j = 0;
        for (IRequest r : requestList) {
            if (r.getRequestType() == type) {
                j = j+1 ;
            }
        }
        return j;
    }


    // Count request by course ID
    public int countByCourseID(String courseID) {
        int j = 0;
        for(IRequest r : requestList) {
            if (r.getCourseID().equals(courseID)) {
                j = j + 1;
            }
        }
        return j;
    }

    // Count request by student ID
    public int countByStudentID(String studentID) {
        int j = 0;
        for (IRequest r : requestList){
            if (r.getStudentID().equals(studentID)){
                j = j+1 ;
            }
        }
        return j;
    }
}
