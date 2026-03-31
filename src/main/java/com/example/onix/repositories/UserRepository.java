package com.example.onix.repositories;

import com.example.onix.models.dto.UserDto;
import com.example.onix.models.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Boolean existsUserByNameAndPassword(String name, String password);

    Optional<User> findByName(String name);

    Boolean existsUserByEmail(String email);
}
