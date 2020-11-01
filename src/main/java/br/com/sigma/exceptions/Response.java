package br.com.sigma.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {

    public static ResponseEntity ok(){
        ResponseError response = ResponseError.builder()
                .status(true)
                .build();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    public static ResponseEntity duplicated(String message){
        ResponseError response = ResponseError.builder()
                .status(false)
                .message(message)
                .build();
        return new ResponseEntity(response, HttpStatus.CONFLICT);
    }

    public static ResponseEntity notFound(String message){
        ResponseError response = ResponseError.builder()
                .status(false)
                .message(message)
                .build();
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity forbidden(String message){
        ResponseError response = ResponseError.builder()
                .status(false)
                .message(message)
                .build();
        return new ResponseEntity(response, HttpStatus.FORBIDDEN);
    }
}
