package github.denisspec989.azsservice.service;

import github.denisspec989.azsservice.domain.FileEntity;
import github.denisspec989.azsservice.models.FileDto;
import org.springframework.stereotype.Service;

public interface FileService {
    FileEntity getFile(String fileName);
    void loadFileToDB(FileDto fileDto);
}
