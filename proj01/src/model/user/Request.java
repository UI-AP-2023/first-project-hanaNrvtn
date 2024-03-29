package model.user;

abstract public class Request {
    private final RequestType requestType;

    Request(RequestType requestType) {
        this.requestType = requestType;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    @Override
    public String toString() {
        return "request type: " + requestType.toString();
    }
}




