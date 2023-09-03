package cl.foxcorp.app.webfluxkarate.controller;

import cl.foxcorp.app.webfluxkarate.dto.request.InUserDto;
import cl.foxcorp.app.webfluxkarate.dto.response.UserDto;
import cl.foxcorp.app.webfluxkarate.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Flux<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Mono<UserDto> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/state/{state}")
    public Flux<UserDto> getUserbyState(@PathVariable Boolean state) {
        return userService.getUserByState(state);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserDto> addUser(@Valid @RequestBody InUserDto userDto) {
        return userService.addUser(userDto);
    }

    @PutMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<UserDto> updateUser(@PathVariable String username, @Valid @RequestBody InUserDto userDto) {
        return userService.updateUser(username, userDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteUser(@PathVariable String id) {
        return userService.deleteUserById(id);
    }

}