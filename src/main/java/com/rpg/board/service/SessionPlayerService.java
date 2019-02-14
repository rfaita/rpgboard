package com.rpg.board.service;

import com.rpg.board.model.Player;
import com.rpg.board.model.Session;
import com.rpg.board.model.SessionPlayer;
import com.rpg.board.repository.SessionPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.ValidationException;
import java.util.Optional;

@Service
public class SessionPlayerService {

    @Autowired
    private SessionPlayerRepository repository;


    private void validateSave(SessionPlayer sessionPlayer) {
        if (sessionPlayer.getPlayer() == null) {
            throw new ValidationException("O player não foi informado.");
        }
        if (sessionPlayer.getSession() == null) {
            throw new ValidationException("A sessão não foi informada.");
        }
    }

    public SessionPlayer save(SessionPlayer sessionPlayer) {

        validateSave(sessionPlayer);

        return repository.save(sessionPlayer);

    }


}
