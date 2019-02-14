package com.rpg.board.controller;

import com.rpg.board.model.Player;
import com.rpg.board.model.Session;
import com.rpg.board.service.PlayerService;
import com.rpg.board.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @PostMapping("/signup")
    public Player signup(@RequestBody Player player) {
        return service.signup(player);
    }

}
