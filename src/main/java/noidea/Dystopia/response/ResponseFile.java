package noidea.Dystopia.response;

import java.time.LocalDateTime;

public class ResponseFile {

    private String name;
    private String url;
    private String contentType;
    private String description;
    private long size;





    private LocalDateTime dateOfCreated;

    public ResponseFile(String name, String url, String contentType, String description, long size, LocalDateTime dateOfCreated, int length) {
        this.name = name;
        this.url = url;
        this.contentType = contentType;
        this.description = description;
        this.size = size;
        this.dateOfCreated = dateOfCreated;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
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

