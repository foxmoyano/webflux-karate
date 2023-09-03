package cl.foxcorp.app.webfluxkarate.repository;

import cl.foxcorp.app.webfluxkarate.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Flux<User> findByState(Boolean state);
}