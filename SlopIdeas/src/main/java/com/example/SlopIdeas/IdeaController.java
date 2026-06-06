package com.example.SlopIdeas;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IdeaController {

    private final IdeaService ideaService;

    IdeaController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }

    @CrossOrigin
    @GetMapping
    public List<String> defaultCall() {
        try {
            return ideaService.readAllLinesExample();
        } catch (Exception e) {
            System.err.println(e.toString());
            List<String> errorList = new ArrayList<>();
            errorList.add(e.toString());
            return errorList;
        }
    }

    @CrossOrigin(value = "*")
    @GetMapping("/{amount}")
    public List<String> GetNumber(@PathVariable("amount") int amount) throws Exception {
        try {
            return ideaService.getRandomIdeas(amount);
        } catch (Exception e) {
            System.err.println(e.toString());
            List<String> errorList = new ArrayList<>();
            errorList.add(e.toString());
            errorList.add("" + amount);
            return errorList;
        }
    }
    @CrossOrigin(value = "*")
    @GetMapping("/{groups}/{amountPerGroup}")
    public List<IdeaGroup> GetGroups( @PathVariable("groups") int groups,
    @PathVariable("amountPerGroup") int amountPerGroup) throws Exception {
        try {
            return ideaService.getRandomIdeaGroups(groups, amountPerGroup);
        } catch (Exception e) {
            System.err.println(e.toString());
            List<IdeaGroup> errorList = new ArrayList<>();
            String[] error = new String[3];
            error[0] = e.toString();
            error[1] = ("groups: " + groups);
            error[2] = ("amountPerGroup" + amountPerGroup);
            errorList.add(new IdeaGroup(error));
            return errorList;
        }
    }

}
