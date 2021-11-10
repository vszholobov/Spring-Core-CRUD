package project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.UserDTO;
import project.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping
    public String getLoginForm(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "authentication/login";
    }

    @PostMapping(headers = {"Content-Type=application/x-www-form-urlencoded"})
    public void login(
            @ModelAttribute("user") UserDTO userDTO,
            HttpServletResponse httpServletResponse,
            HttpServletRequest httpServletRequest
    ) throws IOException {
        loginService.login(userDTO, httpServletRequest);

        httpServletResponse.sendRedirect("/");
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> loginJson(
            @RequestBody UserDTO userDTO,
            HttpServletRequest httpServletRequest
    ) {
        String sessionId = loginService.login(userDTO, httpServletRequest);

        return ResponseEntity.ok().body(Map.of("session", sessionId));
    }
}
