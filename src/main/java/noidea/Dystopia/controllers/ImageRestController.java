package noidea.Dystopia.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class ImageRestController {


//
//    private final ImageRepository imageRepository;
//
//    @GetMapping("/images_zero/{id}")
//    private ResponseEntity<?> getImageById(@PathVariable(value = "id") Long id) {
//        Image image = (Image) imageRepository.findById(id).orElse(null);
//        return ResponseEntity.ok()
//                .header("fileName", image.getOriginalFileName())
//                .contentType(MediaType.valueOf(image.getContentType()))
//                .contentLength(image.getSize())
//                .body(new InputStreamResource(new ByteArrayInputStream(image.getImageData())));
//    }


}
