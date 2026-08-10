package com.coachpad.player;
import java.util.List;


import com.coachpad.player.dto.CreatePlayerRequest;
import com.coachpad.player.dto.UpdatePlayerRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player createPlayer(@Valid @RequestBody CreatePlayerRequest request) {
        return playerService.createPlayer(request);
    }

    @GetMapping("/active")
    public List<Player> getAllActivePlayers() {
        return playerService.getAllActivePlayers();
    }

    @GetMapping("/archived")
    public List<Player> getAllArchivedPlayers() {
        return playerService.getAllArchivedPlayers();
    }

    @GetMapping("/{id}")
    public Player viewPlayer(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @PatchMapping("/{id}")
    public Player updatePlayerInfo(@PathVariable Long id, @Valid @RequestBody UpdatePlayerRequest request) {
        return playerService.updatePlayer(id, request);
    }

    @PatchMapping("/{id}/archive")
    public Player archivePlayer(@PathVariable Long id) {
        return playerService.archivePlayer(id);
    }

    @PatchMapping("/{id}/restore")
    public Player restorePlayer(@PathVariable Long id) {
        return playerService.restorePlayer(id);
    }
}
