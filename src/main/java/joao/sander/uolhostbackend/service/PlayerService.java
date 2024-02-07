package joao.sander.uolhostbackend.service;

import joao.sander.uolhostbackend.infra.CodinameHandler;
import joao.sander.uolhostbackend.model.GroupType;
import joao.sander.uolhostbackend.model.Player;
import joao.sander.uolhostbackend.model.dtos.PlayerDTO;
import joao.sander.uolhostbackend.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {


    @Autowired
    private PlayerRepository repository;

    @Autowired
    private CodinameHandler handler;

    public Player createPlayer(PlayerDTO dto) {
        Player newPlayer = new Player(dto);
        String codiname = getCodiname(dto.groupType());
        newPlayer.setCodiname(codiname);
        return repository.save(newPlayer);
    }

    public String getCodiname(GroupType groupType) {
        return handler.findCodiname(groupType);
    }

    public List<Player> getAllPlayers() {
        return repository.findAll();
    }
}
