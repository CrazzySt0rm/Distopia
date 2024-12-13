package noidea.Dystopia.controllers;


import lombok.AllArgsConstructor;
import noidea.Dystopia.db_reader.DbReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class DystopiaController {

    private final DbReader dbReader = new DbReader();


    @GetMapping("/home")
    public String getDistopiaOne() {
        return "home";
    }

    @GetMapping("/animation_3D")
    public String getAnim() {
        return "animation_3D";
    }

    @GetMapping("/page_three")
    public String getPageThree(Model model) {
        List<String> humans = new ArrayList<>();
        humans.add("Johnson");
        humans.add("Eric Foxy");
        humans.add("Lee Si Cin");
        model.addAttribute("test", dbReader.getMSG());
        model.addAttribute("xyz", humans);
        model.addAttribute("title", "imperium");
        return "page_three";

        //<div class="imp">
        //    <p data-th-text="${title}"></p>
        //
        //    <ul data-th-each="human: ${xyz}">
        //        <li data-th-text="${human}">1</li>
        //    </ul>
        //</div>
    }

    @GetMapping("/page_four")
    public String getPageFour() {
        return "page_four";
    }
}
