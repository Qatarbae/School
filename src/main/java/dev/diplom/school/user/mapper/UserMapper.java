package dev.diplom.school.user.mapper;


import dev.diplom.school.user.model.dto.UserDto;
import dev.diplom.school.user.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "fullName", target = "name")
    UserDto toUserDto(User user);

    @Mapping(source = "name", target = "fullName")
    User toUser(UserDto userDto);

    List<UserDto> toUserDtoList(List<User> users);

    List<User> toUserList(List<UserDto> userDtos);
}