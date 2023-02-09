package github.denisspec989.azsservice.service;

import github.denisspec989.azsservice.models.FileDto;
import org.springframework.stereotype.Service;

@Service
public interface FileService {
    void loadFileToDB(FileDto fileDto);
}
