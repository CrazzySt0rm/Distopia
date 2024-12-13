package noidea.Dystopia.controllers;

import lombok.AllArgsConstructor;
import noidea.Dystopia.models.Image;
import noidea.Dystopia.repositories.ImageRepository;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class ImageController {

    private final ImageRepository imageRepository;

    @GetMapping("/images_01/{id}")
    private ResponseEntity<?> getImageById(@PathVariable(value = "id") Long id) {
        Image image = (Image) imageRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}
