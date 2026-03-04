package com.example.onix.models.repositories;

import com.example.onix.models.dto.UserDto;
import com.example.onix.models.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT new com.example.onix.models.dto.UserDto(u.id, u.name, u.email, u.password) FROM User u")
    List<UserDto> findAllDto();

}
