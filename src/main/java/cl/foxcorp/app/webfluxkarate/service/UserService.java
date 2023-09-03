package cl.foxcorp.app.webfluxkarate.service;

import cl.foxcorp.app.webfluxkarate.dto.request.InUserDto;
import cl.foxcorp.app.webfluxkarate.dto.response.UserDto;
import cl.foxcorp.app.webfluxkarate.mapper.UserMapper;
import cl.foxcorp.app.webfluxkarate.model.User;
import cl.foxcorp.app.webfluxkarate.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserService(UserRepository userRepository,UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Flux<UserDto> getAllUsers() {
        return userRepository.findAll().map(userMapper::userToUserDto);
    }

    public Mono<UserDto> getUserById(String id) {
        return userRepository.findById(id).map(userMapper::userToUserDto);
    }

    public Flux<UserDto> getUserByState(Boolean state) {
        return userRepository.findByState(state).map(userMapper::userToUserDto);
    }

    public Mono<UserDto> addUser(InUserDto inUserDto) {
        User userData = userMapper.inUserDtoToUser(inUserDto);
        return userRepository.save(userData).map(userMapper::userToUserDto);
    }

    public Mono<UserDto> updateUser(String id, InUserDto inUserDto) {
        User userData = userMapper.inUserDtoToUser(inUserDto);
        userData.setId(id);
        return userRepository.save(userData).map(userMapper::userToUserDto);
    }

    public Mono<Void> deleteUserById(String id) {
        return userRepository.deleteById(id);
    }

}