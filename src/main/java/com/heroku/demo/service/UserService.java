package com.heroku.demo.service;

import com.heroku.demo.security.UserSS;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserService {

    public static UserSS authenticated() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            /**
             * O caso mais clássico de erro seria o caso de não haver um usuário logado no
             * sistema. Nesse caso, ocorreria um erro no cast para UserSS.
             */
            return null;
        }
    }
}
