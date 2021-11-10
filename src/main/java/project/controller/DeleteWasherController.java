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
@RequestMapping("/delete")
public class DeleteWasherController {
    private final WasherService washerService;

    @PostMapping(headers = {"Content-Type=application/x-www-form-urlencoded"})
    public void deleteWasher(
            @ModelAttribute("washer") WasherDTO washerDTO,
            HttpServletResponse httpServletResponse
    ) throws IOException {
        if(!washerService.existsById(washerDTO.getId())) {
            httpServletResponse.sendRedirect("/show/all");
        }

        washerService.delete(washerDTO.getId());

        httpServletResponse.sendRedirect("/show/all");
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<?> deleteJson(@RequestParam("id") int id) {
        washerService.delete(id);

        return ResponseEntity.ok().build();
    }
}
