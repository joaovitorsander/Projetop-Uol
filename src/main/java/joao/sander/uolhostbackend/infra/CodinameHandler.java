package joao.sander.uolhostbackend.infra;

import joao.sander.uolhostbackend.model.GroupType;
import joao.sander.uolhostbackend.service.CodinameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CodinameHandler {

    @Autowired
    private CodinameService service;

    public String findCodiname(GroupType groupType) {
        if (groupType == GroupType.AVANGERS) {
            String firstMatch = service.getAvangersCodinameList().stream().findFirst().orElseThrow();
            this.service.getAvangersCodinameList().remove(firstMatch);
            return firstMatch;
        }
        String firstMatch = service.getJusticeLeagueCodinameList().stream().findFirst().orElseThrow();
        this.service.getJusticeLeagueCodinameList().remove(firstMatch);
        return firstMatch;
    }
}
