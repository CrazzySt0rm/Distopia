package noidea.Dystopia.controllers;

import lombok.AllArgsConstructor;
import noidea.Dystopia.models.Image;
import noidea.Dystopia.services.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@CrossOrigin(origins = "http://localhost:8081")

public class ImageController {

    private final ImageService imageService;


    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/view-image/{fileOid}")
    public String viewImage(@PathVariable String fileOid, Model model) {
        Image image = imageService.getFile(fileOid).get();
        model.addAttribute("fileOid", fileOid);
        model.addAttribute("image", image);
        return "page_sixth";
    }
}
