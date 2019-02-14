package com.rpg.board.controller;

import com.rpg.board.model.Session;
import com.rpg.board.model.SessionPlayer;
import com.rpg.board.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService service;

    @PostMapping("/open")
    public Session open(@RequestBody Session session) {
        return service.open(session, 1);
    }

    @GetMapping
    public List<Session> findAll() {

        return service.findAll();
    }


    @PutMapping("/join/{idSession}/{idPlayer}")
    public SessionPlayer join(@PathVariable Integer idSession, @PathVariable Integer idPlayer) {

        return service.join(idSession, idPlayer);
    }

}
