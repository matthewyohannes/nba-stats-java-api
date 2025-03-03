package com.nba.nba_zone.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player_statistics")
public class Player {

    @Id
    @Column(name = "player_name", unique = true)
    private String name;
    private String position;
    private Double age;
    private String team;
    private Integer games_played;
    private Double fga_per_game;
    private Double field_goal_percent;
    private Double three_point_percent;
    private Double free_throw_percent;
    private Double rebounds_per_game;
    private Double assists_per_game;
    private Double steals_per_game;
    private Double blocks_per_game;
    private Double turnovers_per_game;
    private Double points_per_game;


    public Player() {
    }

    public Player(String name, String position, Double age, String team, Integer games_played, Double fga_per_game, Double field_goal_percent, Double three_point_percent, Double free_throw_percent, Double rebounds_per_game, Double assists_per_game, Double steals_per_game, Double blocks_per_game, Double turnovers_per_game, Double points_per_game) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.team = team;
        this.games_played = games_played;
        this.fga_per_game = fga_per_game;
        this.field_goal_percent = field_goal_percent;
        this.three_point_percent = three_point_percent;
        this.free_throw_percent = free_throw_percent;
        this.rebounds_per_game = rebounds_per_game;
        this.assists_per_game = assists_per_game;
        this.steals_per_game = steals_per_game;
        this.blocks_per_game = blocks_per_game;
        this.turnovers_per_game = turnovers_per_game;
        this.points_per_game = points_per_game;
    }


    public Player(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getGames_played() {
        return games_played;
    }

    public void setGames_played(Integer games_played) {
        this.games_played = games_played;
    }

    public Double getFga_per_game() {
        return fga_per_game;
    }

    public void setFga_per_game(Double fga_per_game) {
        this.fga_per_game = fga_per_game;
    }

    public Double getField_goal_percent() {
        return field_goal_percent;
    }

    public void setField_goal_percent(Double field_goal_percent) {
        this.field_goal_percent = field_goal_percent;
    }

    public Double getThree_point_percent() {
        return three_point_percent;
    }

    public void setThree_point_percent(Double three_point_percent) {
        this.three_point_percent = three_point_percent;
    }

    public Double getFree_throw_percent() {
        return free_throw_percent;
    }

    public void setFree_throw_percent(Double free_throw_percent) {
        this.free_throw_percent = free_throw_percent;
    }

    public Double getRebounds_per_game() {
        return rebounds_per_game;
    }

    public void setRebounds_per_game(Double rebounds_per_game) {
        this.rebounds_per_game = rebounds_per_game;
    }

    public Double getAssists_per_game() {
        return assists_per_game;
    }

    public void setAssists_per_game(Double assists_per_game) {
        this.assists_per_game = assists_per_game;
    }

    public Double getSteals_per_game() {
        return steals_per_game;
    }

    public void setSteals_per_game(Double steals_per_game) {
        this.steals_per_game = steals_per_game;
    }

    public Double getBlocks_per_game() {
        return blocks_per_game;
    }

    public void setBlocks_per_game(Double blocks_per_game) {
        this.blocks_per_game = blocks_per_game;
    }

    public Double getTurnovers_per_game() {
        return turnovers_per_game;
    }

    public void setTurnovers_per_game(Double turnovers_per_game) {
        this.turnovers_per_game = turnovers_per_game;
    }

    public Double getPoints_per_game() {
        return points_per_game;
    }

    public void setPoints_per_game(Double points_per_game) {
        this.points_per_game = points_per_game;
    }
}


