package fr.imt.gatcha.gatcha_api_players;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "players")
public class PlayerEntity {
    @MongoId
    private String id;

    private int level; // De 0 à 50
    private double experience; // XP actuelle du joueur
    private double nextLevelExperience; // Seuil d'XP pour le prochain niveau

    // Liste des IDs uniques des monstres possédés
    private List<String> monstres = new ArrayList<>();

    public PlayerEntity() {}

    /**
     * Calcule la limite maximale de monstres selon le niveau.
     * Commence à 10, puis +1 par niveau.
     */
    public int getMaxMonstersLimit() {
        return 10 + this.level;
    }

    /**
     * Calcule l'XP nécessaire pour monter de niveau.
     * Base de 50, multipliée par 1.1 à chaque niveau.
     */
    public double calculateRequiredXpForLevel(int targetLevel) {
        if (targetLevel <= 1) return 50.0;
        return 50.0 * Math.pow(1.1, targetLevel - 1);
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public double getExperience() { return experience; }
    public void setExperience(double experience) { this.experience = experience; }

    public List<String> getMonstres() { return monstres; }
    public void setMonstres(List<String> monstres) { this.monstres = monstres; }

    public double getNextLevelExperience() { return nextLevelExperience; }
    public void setNextLevelExperience(double nextLevelExperience) { this.nextLevelExperience = nextLevelExperience; }
}