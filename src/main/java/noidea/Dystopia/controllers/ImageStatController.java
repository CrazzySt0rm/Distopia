package noidea.Dystopia.controllers;

import lombok.AllArgsConstructor;
import noidea.Dystopia.models.ImageStat;
import noidea.Dystopia.services.ImageStatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class ImageStatController {

    private final ImageStatService imageStatService;



    @GetMapping("/")
    public String makeImageStat(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("makeImageStat", imageStatService.imageStatList(title));
        return "home";
    }
    @GetMapping("/image_stat/{id}")
    public String imageStatInfo(@PathVariable(value = "id") Long id, Model model) {
        ImageStat imageStat = imageStatService.getImageStatById(id);
        model.addAttribute("image_stat", imageStat);
        model.addAttribute("images", imageStat.getImages());
        return "info";
    }
    @PostMapping("/image_stat/create")
    public String createImageStat(@RequestParam("file1") MultipartFile file1, ImageStat imageStat) throws IOException {
        imageStatService.saveImageStat(imageStat, file1);
        //return "redirect:/";
        return "info";
    }


    @DeleteMapping("/image_stat/delete/{id}")
    public String deleteImageStat(@PathVariable(value = "id") Long id) {
        imageStatService.deleteImageStat(id);
        return "redirect:/";
    }
}
