package github.denisspec989.azsservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
public class JSON {
    private final MultipartFile multipartFile;
}
