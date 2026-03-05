package fr.imt.gatcha.gatcha_api_players;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GatchaApiPlayersApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatchaApiPlayersApplication.class, args);
	}

    @Bean
    public CommandLineRunner dataInitializer(PlayerRepository playerRepository) {
        return args -> {
            // Optionnel : on nettoie la base pour éviter les doublons d'ID au redémarrage
            playerRepository.deleteAll();

            // Création du premier joueur (id: valentin)
            PlayerEntity p1 = new PlayerEntity();
            p1.setId("valentin");
            p1.setLevel(1);
            p1.setExperience(0);
            // On utilise la logique métier de l'entité pour le seuil d'XP [cite: 17, 18, 19]
            p1.setNextLevelExperience(p1.calculateRequiredXpForLevel(2));
            p1.setMonstres(List.of("m-001", "m-002"));

            // Création d'un deuxième joueur
            PlayerEntity p2 = new PlayerEntity();
            p2.setId("test_user");
            p2.setLevel(5);
            p2.setExperience(10.5);
            p2.setNextLevelExperience(p2.calculateRequiredXpForLevel(6));
            p2.setMonstres(List.of("m-999"));

            // Sauvegarde en base MongoDB [cite: 22]
            playerRepository.saveAll(List.of(p1, p2));

            System.out.println("--------------------------------------");
            System.out.println("Base de données initialisée avec succès");
            System.out.println("Joueurs créés : valentin, test_user");
            System.out.println("--------------------------------------");
        };
    }

}
