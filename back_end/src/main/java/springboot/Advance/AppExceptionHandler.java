package springboot.Advance;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import springboot.Exception.ProductException;

import org.springframework.http.HttpStatus;

//erajaa les errors (enadhem les exceptions)
@RestControllerAdvice
public class AppExceptionHandler  {
	
	@ResponseStatus(HttpStatus.CONFLICT)//trajaa lcode
	@ExceptionHandler(ProductException.class)
	public Map<String, String> handleException( ProductException exception){
	    Map<String, String> errorsMap = new HashMap<>();//hash map : key : valeur
	    errorsMap.put("errorMessage", exception.getMessage());
	    return errorsMap;
	}
	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//trajaa lcode
	@ExceptionHandler(Exception.class)
	public Map<String, String> handleException( Exception exception){
	    Map<String, String> errorsMap = new HashMap<>();//hash map : key : valeur
	    errorsMap.put("errorMessage", "Something wrong happened");
	    return errorsMap;
	}

	
}
