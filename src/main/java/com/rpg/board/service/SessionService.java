package com.rpg.board.service;

import com.rpg.board.model.Player;
import com.rpg.board.model.Session;
import com.rpg.board.model.SessionPlayer;
import com.rpg.board.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository repository;


    @Autowired
    private PlayerService playerService;
    @Autowired
    private SessionPlayerService sessionPlayerService;

    private void validateOpen(Session session) {
        if (StringUtils.isEmpty(session.getName())) {
            throw new ValidationException("O Nome da sessão não foi informado.");
        }
    }

    public Session open(Session session, Integer idPlayerMaster) {

        validateOpen(session);

        Session ret = repository.save(session);

        join(ret.getId(), idPlayerMaster);

        return ret;

    }

    public Session findById(Integer id) {
        Optional<Session> ret = repository.findById(id);

        if (ret.isPresent()) {
            return ret.get();
        }

        return null;
    }

    public SessionPlayer join(Integer idSession, Integer idPlayer) {

        if (StringUtils.isEmpty(idSession)) {
            throw new ValidationException("Sessão não informada.");
        }
        if (StringUtils.isEmpty(idPlayer)) {
            throw new ValidationException("Player não informado.");
        }

        Session session = findById(idSession);

        if (session == null) {
            throw new ValidationException("Sessão não encontrada.");
        }


        Player player = playerService.findById(idPlayer);

        if (player == null) {
            throw new ValidationException("Player não encontrado.");
        }


        SessionPlayer sessionPlayer =
                SessionPlayer.builder()
                        .session(session)
                        .player(player)
                        .build();

        return sessionPlayerService.save(sessionPlayer);
    }

    public List<Session> findAll() {
        return repository.findAll();
    }

}
