package com.example.trazabilidad.mappers;

import com.example.trazabilidad.dtos.UserCreateDto;
import com.example.trazabilidad.dtos.UserDto;
import com.example.trazabilidad.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserCreateDto userDto);
}
