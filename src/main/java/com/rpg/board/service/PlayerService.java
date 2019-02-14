package com.rpg.board.service;

import com.rpg.board.model.Player;
import com.rpg.board.model.Session;
import com.rpg.board.repository.PlayerRepository;
import com.rpg.board.repository.SessionPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;


    private void validateSignup(Player player) {
        if (StringUtils.isEmpty(player.getName())) {
            throw new ValidationException("O Nome do player não foi informado.");
        }
    }

    public Player signup(Player player) {

        validateSignup(player);

        return repository.save(player);

    }


    public Player findById(Integer id) {
        Optional<Player> ret = repository.findById(id);

        if (ret.isPresent()) {
            return ret.get();

        }
        return null;
    }


}
