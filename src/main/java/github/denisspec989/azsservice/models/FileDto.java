package github.denisspec989.azsservice.models;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {
    private String name;
    private Long size;
    private byte[] fileBytes;
}
