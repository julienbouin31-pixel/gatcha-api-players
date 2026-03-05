package fr.imt.gatcha.gatcha_api_players;


import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PlayerController {

    private final PlayerService playerService;


    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/getProfile")
    public ResponseEntity<?> getProfile(@RequestParam String id) {
        try{
            PlayerResponse playerResponse =  playerService.getProfile(id);
            return ResponseEntity.ok(playerResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(Map.of(
                    "code", 401,
                    "message", e.getMessage()
            ));
        }
    }


}