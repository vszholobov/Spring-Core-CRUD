package project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.Washer;
import project.model.WasherDTO;
import project.service.WasherService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/add")
public class AddWasherController {
    private final WasherService washerService;

    @PostMapping(headers = {"Content-Type=application/x-www-form-urlencoded"})
    @ResponseBody
    public void postWasher(
            @ModelAttribute("washer") WasherDTO washerDTO,
            HttpServletResponse httpServletResponse
    ) throws IOException {
        int washerId = washerService.add(new Washer(
                washerDTO.getWeight(),
                washerDTO.getVolume(),
                washerDTO.getBrand(),
                washerDTO.getOwnerName(),
                washerDTO.getPassword()
        ));

        httpServletResponse.sendRedirect("/show/" + washerId);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<?> postWasherJson(@RequestBody WasherDTO washerDTO) {
        washerService.add(
                new Washer(
                        washerDTO.getWeight(),
                        washerDTO.getVolume(),
                        washerDTO.getBrand(),
                        washerDTO.getOwnerName(),
                        washerDTO.getPassword()
                )
        );
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public String getWasherForm(Model model) {
        model.addAttribute("washer", new WasherDTO());
        return "add";
    }
}
