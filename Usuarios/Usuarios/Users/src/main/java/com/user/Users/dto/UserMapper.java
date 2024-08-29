package com.user.Users.dto;

import com.user.Users.entity.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "email", target = "email"),
    })
    UserDto userEntityToUserDto(User user);

    @InheritInverseConfiguration
    User userDtoToUserEntity(UserDto userDto);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "email", target = "email"),
    })
    UserToSaveDto userEntityToUserToDto(User user);

    @InheritInverseConfiguration
    User userToSaveDtoToUserEntity(UserToSaveDto userToSaveDto);
}
