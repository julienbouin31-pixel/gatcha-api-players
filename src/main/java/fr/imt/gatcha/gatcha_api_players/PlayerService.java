package fr.imt.gatcha.gatcha_api_players;


import org.springframework.stereotype.Service;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerResponse getProfile(String id){
        PlayerEntity playerEntity = playerRepository.findById(id).orElse(null);
        if(playerEntity == null){
            throw new RuntimeException("Joueur non trouvé");
        }
        return new PlayerResponse(playerEntity.getLevel(),playerEntity.getExperience(),playerEntity.getMonstres());
    }



}