package ru.matveykenya.springrestauthorizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.matveykenya.springrestauthorizationservice.exception.InvalidCredentials;
import ru.matveykenya.springrestauthorizationservice.exception.InvalidPassword;
import ru.matveykenya.springrestauthorizationservice.exception.UnauthorizedUser;
import ru.matveykenya.springrestauthorizationservice.model.Authorities;
import ru.matveykenya.springrestauthorizationservice.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service){
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) //400
    String resolveException(RuntimeException exception){
        return exception.getMessage();
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED) //401
    String resolveException2(RuntimeException exception){
        return exception.getMessage();
    }

    @ExceptionHandler(InvalidPassword.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT) //418
    String resolveException3(RuntimeException exception){
        return exception.getMessage();
    }
}
