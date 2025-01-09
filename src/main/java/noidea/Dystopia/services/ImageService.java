package noidea.Dystopia.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import noidea.Dystopia.models.Image;
import noidea.Dystopia.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Slf4j

public class ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Image Image = new Image(fileName, file.getContentType(), file.getBytes());

        return imageRepository.save(Image);
    }

    public Optional<Image> getFile(String id) {
        System.out.println("fileID: " + id);
        return imageRepository.findById(id);
    }

    public Stream<Image> getAllFiles() {
        return imageRepository.findAll().stream();
    }
}

