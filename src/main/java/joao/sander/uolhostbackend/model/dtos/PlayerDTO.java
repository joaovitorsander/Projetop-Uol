package joao.sander.uolhostbackend.model.dtos;

import joao.sander.uolhostbackend.model.GroupType;

public record PlayerDTO(
        String name,
        String email,
        String phoneNumber,
        GroupType groupType
) {
}
