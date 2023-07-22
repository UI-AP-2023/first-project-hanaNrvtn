package com.example.firstproj02.model.processes;

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
        return requestType.toString();
    }

    public String toString1() {
        return requestType.toString();
    }

}




