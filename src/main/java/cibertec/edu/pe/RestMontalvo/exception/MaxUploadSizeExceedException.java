package cibertec.edu.pe.RestMontalvo.exception;

public class MaxUploadSizeExceedException extends RuntimeException {
    public MaxUploadSizeExceedException (String message){
        super(message);
    }
}
