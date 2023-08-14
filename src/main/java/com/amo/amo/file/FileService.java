package com.amo.amo.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository fileRepository;

    public ProductFile upload(MultipartFile file) throws IOException {
        ProductFile productFile = new ProductFile();
        productFile.setName(file.getOriginalFilename());
        productFile.setType(file.getContentType());
        productFile.setData(file.getBytes());
        return fileRepository.save(productFile);
    }

    public byte[] download(String name){
        ProductFile productFile = fileRepository.findByName(name).orElseThrow();
        return productFile.getData();
    }


    public List<FileResponse>fileResponses(){
        List<FileResponse>fileResponses = new ArrayList<>();
        fileRepository.findAll().stream().forEach(productFile -> {
           FileResponse fileResponse = FileResponse.builder().name(productFile.getName()).type(productFile.getType()).build();
           fileResponses.add(fileResponse);
        });

        return fileResponses;
    }
}
