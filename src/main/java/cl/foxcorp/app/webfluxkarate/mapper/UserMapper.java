package cl.foxcorp.app.webfluxkarate.mapper;

import cl.foxcorp.app.webfluxkarate.dto.request.InUserDto;
import cl.foxcorp.app.webfluxkarate.dto.response.UserDto;
import cl.foxcorp.app.webfluxkarate.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", source = "id")
    UserDto userToUserDto(User user);

    @Mapping(target = "id", source = "id")
    User userDtoToUser(UserDto userDto);

    @Mapping(target = "id", source = "id")
    User inUserDtoToUser(InUserDto inUserDto);
}