package github.denisspec989.azsservice.service.impl;

import github.denisspec989.azsservice.domain.FileEntity;
import github.denisspec989.azsservice.models.FileDto;
import github.denisspec989.azsservice.repository.FileRepository;
import github.denisspec989.azsservice.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;

    @Override
    @Transactional
    public FileEntity getFile(String fileName) {
        return fileRepository.findByName(fileName).orElseThrow();
    }

    @Override
    @Transactional
    public void loadFileToDB(FileDto fileDto) {
        fileRepository.findByName(fileDto.getName()).ifPresent(fileRepository::delete);
        FileEntity file = new FileEntity();
        file.setFileBytes(fileDto.getFileBytes());
        file.setName(fileDto.getName());
        file.setSize(fileDto.getSize());
        fileRepository.save(file);
    }
}
