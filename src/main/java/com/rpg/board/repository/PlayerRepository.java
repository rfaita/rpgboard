package com.rpg.board.repository;

import com.rpg.board.model.Player;
import com.rpg.board.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
