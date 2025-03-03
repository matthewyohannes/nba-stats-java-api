package com.nba.nba_zone.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {

    private final PlayerService playerService; //

    @Autowired // injects the playerService bean to send business logic back to Service layer
    public PlayerController(PlayerService playerService) { // Constructor to set the playerService when Controller is used
        this.playerService = playerService;
    }

    @GetMapping // specifies for a GET request w no extra route only query params
                // RequestParam is similar to req, res
    public List<Player> getPlayers(
        @RequestParam(required = false) String team,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String position,
        @RequestParam(required = false) Double threePoint
    ){
        if (team != null) {
            return playerService.getPlayersByTeam(team);
        }

        else if (name != null) {
            return playerService.getPlayersByName(name);
        }

        else if (position != null) {
            return playerService.getPlayersByPosition(position);
        }

        else if (threePoint != null) {
            return playerService.getPlayersByThreePtPct(threePoint);
        }
        else {
            System.out.println("Players fetched");
            return playerService.getPlayers();
        }
    }

    @GetMapping("/test-connection")
    public ResponseEntity<String> testConnection() {
        try {
            List<Player> players = playerService.getPlayers(); // Querying for all players
            if (players != null) {
                return new ResponseEntity<>("Connection successful", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No players found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Database connection failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/efficient")
    public List<Player> getEfficientPlayers() {
        return playerService.getPlayersByEfficiencyClub();
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player resultPlayer = playerService.updatePlayer(player);
        if (resultPlayer != null) {
            return new ResponseEntity<>(resultPlayer, HttpStatus.OK); // only if player to update was found return ok
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // this returns if player to update did not exist
        }
    }


    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        List<Player> players = playerService.getPlayersByName(playerName); // Get players matching the name

        if (!players.isEmpty()) {  // Check if the list is not empty
            playerService.deletePlayer(playerName); // Proceed to delete the player
            return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND); // Player not found
        }

    }



}
