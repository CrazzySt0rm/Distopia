package noidea.Dystopia.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "files")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Image {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String originalFileName;

    private String name;

    private long size;



    private String contentType;


    private String description;

    private boolean isPreviewImage;

    @Lob
    private byte[] imageData;

    private LocalDateTime dateOfCreated;



    @PrePersist
    private void init() {

        dateOfCreated = LocalDateTime.now();
    }

    public Image(String fileName, String contentType, byte[] imageData) {
    }

    public String generateBase64Image() {
        return Base64.encodeBase64String(this.imageData);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setData(byte[] imageData) {
        this.imageData = imageData;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateOfCreated() {
        return dateOfCreated;
    }

    public void setDateOfCreated(LocalDateTime dateOfCreated) {
        this.dateOfCreated = dateOfCreated;
    }



}



//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    private ImageStat imageStat;
//}
