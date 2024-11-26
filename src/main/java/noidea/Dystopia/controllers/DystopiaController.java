package noidea.Dystopia.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class DystopiaController {

    @GetMapping("/home")
    public String getDistopiaOne() {
        return "home";
    }
}
