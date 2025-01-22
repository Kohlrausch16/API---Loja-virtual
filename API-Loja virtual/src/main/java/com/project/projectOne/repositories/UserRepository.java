package com.project.projectOne.repositories;

import com.project.projectOne.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    // Sempre uma interface.
    // Informar qual o tipo do objeto, e da PK

    //OBS: OS MÉTODOS SÃO TODOS HERDADOS DO JPA Repository!!

}
