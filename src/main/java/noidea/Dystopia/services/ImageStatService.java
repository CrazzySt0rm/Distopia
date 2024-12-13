package noidea.Dystopia.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import noidea.Dystopia.models.Image;
import noidea.Dystopia.models.ImageStat;
import noidea.Dystopia.repositories.ImageStatRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ImageStatService {

    private final ImageStatRepository imageStatRepository;

    public List<ImageStat> imageStatList(String title) {
        if (title != null) return imageStatRepository.findByTitle(title);
        return imageStatRepository.findAll();
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void saveImageStat(ImageStat imageStat, MultipartFile file1) throws IOException {
        Image image1;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            imageStat.addImageToImageStat(image1);
        }
        log.info(imageStat.getTitle());
        ImageStat imageStatFromDb = imageStatRepository.save(imageStat);
        imageStatFromDb.setPreviewImageId(imageStatFromDb.getImages().get(0).getId());
        imageStatRepository.save(imageStat);
    }

    public ImageStat getImageStatById(Long id) {
        return imageStatRepository.findById(id).orElse(null);
    }

    public void deleteImageStat(Long id) {
        imageStatRepository.deleteById(id);
    }
}

