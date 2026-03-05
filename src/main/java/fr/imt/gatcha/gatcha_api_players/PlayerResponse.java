package fr.imt.gatcha.gatcha_api_players;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record PlayerResponse(int level, double experience, List<String> monstres) {}

