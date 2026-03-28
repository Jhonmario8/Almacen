package com.example.onix.models.repositories;

import com.example.onix.models.dto.UserDto;
import com.example.onix.models.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT new com.example.onix.models.dto.UserDto(u.id, u.name, u.email, u.password) FROM User u")
    List<UserDto> findAllDto();

    Boolean existsUserByNameAndPassword(String name, String password);

    @Query("select new com.example.onix.models.dto.UserDto(u.id, u.name, u.email, u.password) From User u")
    Optional<UserDto> findDtoByName(String name);

    Boolean existsUserByEmail(String email);
}
