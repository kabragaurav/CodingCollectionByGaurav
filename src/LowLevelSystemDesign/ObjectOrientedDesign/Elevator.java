package LowLevelSystemDesign.ObjectOrientedDesign;

import java.util.TreeSet;

/**
 *
 * Level : Hard
 * See : https://quip.com/UfJhAZCKm9pB/Quick-Revision-LLD#temp:C:fWTa9e000c717844d0dbfca5a7f7
 * @author gaurav kabra
 * @since 01/Jun/2022
 **/

public class Elevator {

    private int currentFloor = 0;
    private ElevatorStatus status = ElevatorStatus.IDLE;
    private Direction direction = Direction.NONE;

    private TreeSet<Request> currJobs = new TreeSet<>();
    private TreeSet<Request> upPendingJobs = new TreeSet<>();
    private TreeSet<Request> downPendingJobs = new TreeSet<>();

    public void startElevator() {
        this.direction = Direction.UP;
        this.status = ElevatorStatus.MOVING;
        Request nextRequest;
        while (true) {
            if (currJobs.size() > 0) {
                if (direction == Direction.UP) {
                    nextRequest = currJobs.pollFirst();
                    processUpRequest(nextRequest);
                    if (currJobs.size() == 0) {
                        addDownPendingJobs();
                    }
                } else {
                    nextRequest = currJobs.pollLast();
                    processDownRequest(nextRequest);
                    if (currJobs.size() == 0) {
                        addUpPendingJobs();
                    }
                }
            } else {
                this.direction = Direction.NONE;
                this.status = ElevatorStatus.IDLE;
            }
        }
    }

    public void addJob(Request request) {
        if (request.getExternalRequest().getDirection() == Direction.UP)
            upPendingJobs.add(request);
        else
            downPendingJobs.add(request);
    }

    private void processUpRequest(Request request) {
        if (currentFloor < request.getExternalRequest().getFromFloor()) {
            // move it up to that floor
            // and set currentFloor
            currentFloor = request.getExternalRequest().getFromFloor();
            // now move it up to destination
            // and set currentFloor
            currentFloor = request.getInternalRequest().getToFloor();
        } else {
            // move it down to that floor
            // and set currentFloor
            currentFloor = request.getExternalRequest().getFromFloor();
            // now move it up to destination
            // and set currentFloor
            currentFloor = request.getInternalRequest().getToFloor();
        }
    }

    private void processDownRequest(Request request) {
        if (currentFloor < request.getExternalRequest().getFromFloor()) {
            // move it down to that floor
            // and set currentFloor
            currentFloor = request.getExternalRequest().getFromFloor();
            // now move it down to destination
            // and set currentFloor
            currentFloor = request.getInternalRequest().getToFloor();
        } else {
            // move it up to that floor
            // and set currentFloor
            currentFloor = request.getExternalRequest().getFromFloor();
            // now move it down to destination
            // and set currentFloor
            currentFloor = request.getInternalRequest().getToFloor();
        }
    }

    private void addDownPendingJobs() {
        currJobs = downPendingJobs;
        direction = Direction.DOWN;
    }

    private void addUpPendingJobs() {
        currJobs = upPendingJobs;
        direction = Direction.UP;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
    }
}

class Manager implements Runnable {
    private Elevator[] elevators;

    public Manager(Elevator[] elevators) {
        this.elevators = elevators;
    }

    @Override
    public void run() {
        for (Elevator elevator : elevators)
            elevator.startElevator();
    }
}

class Request implements Comparable<Request> {
    private InternalRequest internalRequest;
    private ExternalRequest externalRequest;

    public Request(InternalRequest internalRequest, ExternalRequest externalRequest) {
        this.internalRequest = internalRequest;
        this.externalRequest = externalRequest;
    }

    public InternalRequest getInternalRequest() {
        return internalRequest;
    }

    public void setInternalRequest(InternalRequest internalRequest) {
        this.internalRequest = internalRequest;
    }

    public ExternalRequest getExternalRequest() {
        return externalRequest;
    }

    public void setExternalRequest(ExternalRequest externalRequest) {
        this.externalRequest = externalRequest;
    }

    @Override
    public int compareTo(Request req) {
        if (this.internalRequest.getToFloor() == req.internalRequest.getToFloor())
            return 0;
        return this.internalRequest.getToFloor() > req.internalRequest.getToFloor() ? 1
                                                                                    : -1;
    }
}

class InternalRequest {
    private int toFloor;

    public int getToFloor() {
        return toFloor;
    }

    public void setToFloor(int toFloor) {
        this.toFloor = toFloor;
    }
}

class ExternalRequest {
    private int fromFloor;
    private Direction direction;

    public int getFromFloor() {
        return fromFloor;
    }

    public void setFromFloor(int fromFloor) {
        this.fromFloor = fromFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}

enum ElevatorStatus {
    IDLE,
    MOVING,
    NOT_WORKING
}

enum Direction {
    UP,
    DOWN,
    NONE
}



