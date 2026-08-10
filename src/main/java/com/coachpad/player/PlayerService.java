package com.coachpad.player;
import com.coachpad.player.dto.UpdatePlayerRequest;
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

    public Player getPlayerById(Long playerId) {
        return playerRepository.findById(playerId)
            .orElse(null);
    }

    public Player updatePlayer(Long playerId, UpdatePlayerRequest request) {
        Player player = playerRepository.findById(playerId)
            .orElse(null);

        if (request.firstName() != null) {
            player.setFirstName(request.firstName());
        }

        if (request.lastName() != null) {
            player.setLastName(request.lastName());
        }

        if (request.dateOfBirth() != null) {
            player.setDateOfBirth(request.dateOfBirth());
        }

        if (request.email() != null) {
            player.setEmail(request.email());
        }

        if (request.phoneNumber() != null) {
            player.setPhoneNumber(request.phoneNumber());
        }

        if (request.clubName() != null) {
            player.setClubName(request.clubName());
        }

        if (request.lk() != null) {
            player.setLk(request.lk());
        }

        return playerRepository.save(player);
    }

    public Player archivePlayer(Long playerId) {
        Player player = playerRepository.findById(playerId)
            .orElse(null);

       if(player.getStatus() == PlayerStatus.ACTIVE) {
           player.setStatus(PlayerStatus.ARCHIVED);
       }

        return playerRepository.save(player);
    }

    public Player restorePlayer(Long playerId) {
        Player player = playerRepository.findById(playerId)
            .orElse(null);

        if(player.getStatus() == PlayerStatus.ARCHIVED) {
            player.setStatus(PlayerStatus.ACTIVE);
        }

        return playerRepository.save(player);
    }

}
