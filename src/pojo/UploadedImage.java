package pojo;

import org.springframework.web.multipart.MultipartFile;
 
public class UploadedImage {
    MultipartFile image;
    public MultipartFile getImage() {
        return image;
    }
    public void setImage(MultipartFile image) {
        this.image = image;
    }
 
}