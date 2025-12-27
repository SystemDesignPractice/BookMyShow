package org.example.exception;

public class SeatNotAvailableException extends Exception {

    public SeatNotAvailableException(){
        super();
    }
    public SeatNotAvailableException(String message) {
        super(message);
    }
}
