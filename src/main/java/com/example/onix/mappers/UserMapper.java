package com.example.onix.mappers;

import com.example.onix.models.dto.UserDto;
import com.example.onix.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);

    List<UserDto> toDtoList(List<User> users);
}
