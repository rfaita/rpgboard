package com.rpg.board.repository;

import com.rpg.board.model.SessionPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionPlayerRepository extends JpaRepository<SessionPlayer, Integer> {
}
