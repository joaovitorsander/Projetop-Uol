package joao.sander.uolhostbackend.controller;

import jakarta.validation.Valid;
import joao.sander.uolhostbackend.model.Player;
import joao.sander.uolhostbackend.model.dtos.PlayerDTO;
import joao.sander.uolhostbackend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody @Valid PlayerDTO dto) {
        Player newPlayer = service.createPlayer(dto);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        return new ResponseEntity<>(service.getAllPlayers(), HttpStatus.OK);
    }
}
