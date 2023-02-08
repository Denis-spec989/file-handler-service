package github.denisspec989.azsservice.rest;

import github.denisspec989.azsservice.models.JSON;
import github.denisspec989.azsservice.models.PetrolStationDto;
import github.denisspec989.azsservice.service.Converter;
import github.denisspec989.azsservice.service.JSONConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class JSONController {
    private final Converter converter;
    @PostMapping(value = "",consumes = "multipart/form-data")
    List<PetrolStationDto> getJsonData(@RequestParam("file") MultipartFile file){
        try {
            return (List<PetrolStationDto>)converter.convert(new JSON(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
