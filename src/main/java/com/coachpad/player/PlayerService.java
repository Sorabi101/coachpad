package com.coachpad.player;
import org.springframework.stereotype.Service;
import com.coachpad.player.dto.CreatePlayerRequest;
import java.util.List;


@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(CreatePlayerRequest request) {
        Player player = new Player(
            request.firstName(),
            request.lastName(),
            request.dateOfBirth(),
            request.email(),
            request.phoneNumber(),
            request.gender(),
            request.clubName(),
            request.lk()
        );

        return playerRepository.save(player);
    }

    public List<Player> getAllActivePlayers() {
        return playerRepository.findByStatusOrderByLastNameAsc(PlayerStatus.ACTIVE);
    }

    public List<Player> getAllArchivedPlayers() {
        return playerRepository.findByStatusOrderByLastNameAsc(PlayerStatus.ARCHIVED);
    }
}
