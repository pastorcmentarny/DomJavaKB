package dms.pastor.prototypes.aberminegenerator.ui.web;

import dms.pastor.utils.converters.CharArrayToListConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class WorldMapController {

    private final WorldMapService worldMapService;
    private final CharArrayToListConverter converter = new CharArrayToListConverter();

    public WorldMapController(WorldMapService worldMapService) {
        this.worldMapService = worldMapService;
    }

    @GetMapping("/map/world")
    public String index(Model model) {
        worldMapService.generateNewWorld();
        return go("", model);
    }

    @GetMapping("/game/world/move/north")
    public String north(Model model) {
        worldMapService.goNorth();
        return go("north", model);
    }

    @GetMapping("/game/world/move/west")
    public String west(Model model) {
        worldMapService.goWest();
        return go("west", model);

    }

    @GetMapping("/game/world/move/east")
    public String east(Model model) {
        worldMapService.goEast();
        return go("east", model);
    }

    @GetMapping("/game/world/move/south")
    public String south(Model model) {
        worldMapService.goSouth();
        return go("south", model);
    }

    @SuppressWarnings("SameReturnValue")
    private String go(String where, Model model) {
        final String mapAsString = worldMapService.getMapAsString();
        final List<String> map = converter.convert(mapAsString.toCharArray());
        model.addAttribute("player", worldMapService.getPlayerInfo());
        model.addAttribute("direction", where);
        model.addAttribute("map", map);
        return "/game/map/world";

    }
}
