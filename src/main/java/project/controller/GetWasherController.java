package project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.Washer;
import project.service.WasherService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/show")
public class GetWasherController {
    private final WasherService washerService;

    @GetMapping(value = "/all", headers = {"Accept=text/html"})
    public String getAll(Model model) {
        model.addAttribute("washers", washerService.all());
        return "all";
    }

    @GetMapping(value = "/all", headers = {"Accept=application/json"})
    @ResponseBody
    public Iterable<Washer> getAllJson() {
        return washerService.all();
    }

    @GetMapping(value = "/{washerId}", headers = {"Accept=text/html"})
    public String washerForm(@PathVariable int washerId, Model model) {
        if(!washerService.existsById(washerId)) {
            model.addAttribute("error", "washer not found");
        } else {
            model.addAttribute("washer", washerService.get(washerId));
        }
        return "washer";
    }

    @GetMapping(value = "/{washerId}", headers = {"Accept=application/json"})
    public ResponseEntity<Washer> washerJson(@PathVariable int washerId) {
        if(!washerService.existsById(washerId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(washerService.get(washerId));
    }

    @GetMapping(value = "/all/heavier", headers = {"Accept=text/html"})
    public String getAllHeavier(@RequestParam("weight") int weight, Model model) {
        model.addAttribute("washers", washerService.allHeavier(weight));
        return "all";
    }

    @GetMapping(value = "/all/heavier", headers = {"Accept=application/json"})
    @ResponseBody
    public Iterable<Washer> getAllHeavierJson(@RequestParam("weight") int weight) {
        return washerService.allHeavier(weight);
    }
}
