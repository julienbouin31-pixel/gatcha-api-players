package fr.imt.gatcha.gatcha_api_players;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PlayerRepository extends MongoRepository<PlayerEntity, String> {
    Optional<PlayerEntity> findById(String id);
}