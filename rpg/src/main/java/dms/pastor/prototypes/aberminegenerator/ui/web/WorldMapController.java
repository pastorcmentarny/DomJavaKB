package dms.pastor.prototypes.aberminegenerator.ui.web;

import dms.pastor.utils.CollectionsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class WorldMapController {

    private final WorldMapService worldMapService;

    public WorldMapController(WorldMapService worldMapService) {
        this.worldMapService = worldMapService;
    }

    @GetMapping("/map/world")
    public String index(Model model) {
        worldMapService.generateNewWorld();
        final String map = worldMapService.getMapAsString();
        System.out.println(map);
        return go("",model);
    }

    @GetMapping("/game/world/move/north")
    public String north(Model model) {
        worldMapService.goNorth();
        return go("north",model);
    }

    @GetMapping("/game/world/move/west")
    public String west(Model model) {
        worldMapService.goWest();
        return go("west",model);

    }

    @GetMapping("/game/world/move/east")
    public String east(Model model) {
        worldMapService.goEast();
        return go("east",model);
    }

    @GetMapping("/game/world/move/south")
    public String south(Model model) {
        worldMapService.goSouth();
        return go("south",model);
    }

    private String go(String where,Model model){
        final String mapAsString = worldMapService.getMapAsString();
        System.out.println(mapAsString);
        final List<String> map = CollectionsUtils.convertToStringArray(mapAsString.toCharArray());
        model.addAttribute("direction",where);
        model.addAttribute("map", map);
        return "/game/map/world";

    }
}