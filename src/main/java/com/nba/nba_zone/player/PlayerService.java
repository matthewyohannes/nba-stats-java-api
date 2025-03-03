package com.nba.nba_zone.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }



    public List<Player> getPlayers() {
    return playerRepository.findAll();
    }

    // findAll returns the list of all players in DB
    // .stream() converts the list into a stream which lets you do filtering
    // .filter() line - for each 'player' it checks if teamName param = 'player's getTeam
    // collects what is left in stream after filtering into a list

//    public List<Player> getPlayersFromTeam(String teamName) {
//    return playerRepository.findAll().stream()
//            .filter(player -> teamName.equals(player.getTeam()))
//            .collect(Collectors.toList());
//    }

//    public List<Player> getPlayersByTeam(String teamName) {
//        return playerRepository.findByTeam(teamName);
//    }

    public List<Player> getPlayersByName(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByTeam(String teamName) {
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equalsIgnoreCase(player.getTeam()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByPosition(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPosition().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }


    public List<Player> getPlayersByThreePtPct(Double percentage) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getThree_point_percent() != null && player.getThree_point_percent() >= percentage && player.getGames_played() >= 45)
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByEfficiencyClub() {
        return playerRepository.findAll().stream()
                .filter(player -> (player.getFree_throw_percent() != null) && (player.getField_goal_percent() != null) && (player.getThree_point_percent() != null) && (player.getThree_point_percent() >= 0.40) && (player.getFree_throw_percent() >= 0.80) && (player.getField_goal_percent() >= 0.40) && (player.getGames_played() >= 45))
                .collect(Collectors.toList());
    }

    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName()); // finds the existing player w the getName()
        // Optional incase player does not exist and prevents error
        if (existingPlayer.isPresent()) { // checks if the player exists so that operations may be applied
            Player playerToUpdate = existingPlayer.get(); // extracts the Player object from existingPlayer since it is an Optional
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setTeam(updatedPlayer.getTeam());

            playerRepository.save(playerToUpdate); // officially saves the updates that just happened to playerToUpdate
            return playerToUpdate;
        }

        return null;
    }

    @Transactional // maintains data integrity during delete operation
    public void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }

}
