package com.cg.onlinehotelmanagementsystem.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ExceptionHandlerController {
	
	    @ExceptionHandler(value = { IOException.class })
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public Alert badRequest(Exception e)
	    {
	        return new Alert(400,ExceptionMessage.MESSAGE_400);
	    }
	    
	    @ExceptionHandler(value = { Exception.class })
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public Alert unKnownException(Exception e)
	    {
	        return new Alert(404,ExceptionMessage.MESSAGE_404 );
	    }
	    @ExceptionHandler(value = { ProgramException.class })
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public Alert KnownException(Exception ex)
	    {
	        return new Alert(400, ErrorMessages.MESSAGE18);
	    }
	

}
