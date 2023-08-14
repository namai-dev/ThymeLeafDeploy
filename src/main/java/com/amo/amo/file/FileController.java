package com.amo.amo.file;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping(path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void upload(@RequestBody MultipartFile file) throws IOException {
        System.out.println(file.getContentType());
        fileService.upload(file);

    }

    @GetMapping(path = "/fileList")
    public List<FileResponse>fileResponses(){
        return fileService.fileResponses();
    }


}
