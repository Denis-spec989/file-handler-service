package github.denisspec989.azsservice.rest;

import github.denisspec989.azsservice.models.FileDto;
import github.denisspec989.azsservice.models.JSON;
import github.denisspec989.azsservice.models.PetrolStationDto;
import github.denisspec989.azsservice.models.XML;
import github.denisspec989.azsservice.service.ConverterService;
import github.denisspec989.azsservice.service.FileService;
import github.denisspec989.azsservice.service.impl.ConverterServiceImpl;
import github.denisspec989.azsservice.service.impl.JSONConverter;
import github.denisspec989.azsservice.service.impl.XMLConverter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class FileController {
    private final FileService fileService;
    private final ConverterService<Iterable<PetrolStationDto>> converterService;
    @PostMapping(value = "/json")
    List<PetrolStationDto> getJsonData(@RequestParam("fileName") String fileName){
        return (List<PetrolStationDto>) converterService.convert(new JSON(fileService.getFile(fileName+".json").getFileBytes()));
    }
    @PostMapping(value = "/xml")
    List<PetrolStationDto> getXmlData(@RequestParam("fileName") String fileName){
        return (List<PetrolStationDto>) converterService.convert(new XML(fileService.getFile(fileName+".xml").getFileBytes()));
    }
    @SneakyThrows
    @PostMapping(value = "/load",consumes = "multipart/form-data")
    ResponseEntity loadFileToDb(@RequestParam("file") MultipartFile file){
        FileDto fileDto = new FileDto();
        fileDto.setFileBytes(file.getBytes());
        fileDto.setName(file.getOriginalFilename());
        fileDto.setSize(file.getSize());
        fileService.loadFileToDB(fileDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
