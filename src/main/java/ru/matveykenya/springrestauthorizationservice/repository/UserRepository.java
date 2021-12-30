package ru.matveykenya.springrestauthorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.matveykenya.springrestauthorizationservice.exception.InvalidPassword;
import ru.matveykenya.springrestauthorizationservice.model.Authorities;
import ru.matveykenya.springrestauthorizationservice.model.User;

import java.util.*;

@Repository
public class UserRepository {
    private final Map<String, User> listUsers = createListUsers();

    public List<Authorities> getUserAuthorities(String nameUser, String password) {
        final var user = listUsers.get(nameUser);
        if (user != null){
            if (user.getPassword().equals(password)){
                return user.getAuthoritiesList();
            } else {
                throw new InvalidPassword("Invalid Password for User: " + nameUser);
            }
        }
        return Collections.emptyList();
    }

    private HashMap<String, User> createListUsers(){
        final var map =  new HashMap<String, User>();
        map.put("Vasya", new User("Vasya", "123", Set.of(Authorities.WRITE, Authorities.READ)));
        map.put("Fedya", new User("Fedya", "1234", Set.of(Authorities.WRITE)));
        map.put("Kostya", new User("Kostya", "123", Set.of(Authorities.READ)));
        map.put("Vika", new User("Vika", "222", Set.of()));
        map.put("Olga", new User("Olga", "333", Set.of(Authorities.WRITE, Authorities.READ, Authorities.DELETE)));
        return map;
    }
}
