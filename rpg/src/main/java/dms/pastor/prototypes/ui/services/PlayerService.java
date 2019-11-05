package dms.pastor.prototypes.ui.services;

import dms.pastor.rpg.game.units.Hero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PlayerService {

    public Hero getPlayer() {
        log.debug("retrieving player ..");
        return Hero.getHero();
    }
}
