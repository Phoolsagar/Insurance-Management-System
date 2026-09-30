package com.insurance.exception;
import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestControllerAdvice public class ApiExceptionHandler {
 @ExceptionHandler(RuntimeException.class) ResponseEntity<?> runtime(RuntimeException e){return ResponseEntity.badRequest().body(Map.of("message",e.getMessage()==null?"Request failed":e.getMessage()));}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<?> validation(MethodArgumentNotValidException e){return ResponseEntity.badRequest().body(Map.of("message","Validation failed","errors",e.getBindingResult().getFieldErrors().stream().map(x->x.getField()+": "+x.getDefaultMessage()).toList()));}
}
