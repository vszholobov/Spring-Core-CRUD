package project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.model.WasherDTO;
import project.service.WasherService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/update")
public class UpdateController {
    private final WasherService washerService;

    @PostMapping(headers = {"Content-Type=application/x-www-form-urlencoded"})
    public void updateWasher(
            @ModelAttribute("washer") WasherDTO washerDTO,
            HttpServletResponse httpServletResponse
    ) throws IOException {
        if(!washerService.existsById(washerDTO.getId())) {
            httpServletResponse.sendRedirect("/show/all");
        }

        washerService.update(washerDTO);

        httpServletResponse.sendRedirect("/show/" + washerDTO.getId());
    }

    @PatchMapping
    @ResponseBody
    public ResponseEntity<?> updateJson(@RequestBody WasherDTO washerDTO) {
        washerService.update(washerDTO);

        return ResponseEntity.ok().build();
    }
}
