package fr.imt.gatcha.gatcha_api_players;

import org.springframework.stereotype.Service;
import org.springframework.http.*;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final AuthClient authClient;

    public PlayerService(PlayerRepository playerRepository, AuthClient authClient) {
        this.playerRepository = playerRepository;
        this.authClient = authClient;
    }

    public PlayerResponse getProfile(String token) {
        String username = authClient.validateToken(token);
        System.out.println(username);

        PlayerEntity playerEntity = playerRepository.findById(username)
                .orElseThrow(() -> new RuntimeException("Joueur non trouvé"));

        return new PlayerResponse(playerEntity.getLevel(), playerEntity.getExperience(), playerEntity.getMonstres());
    }
}