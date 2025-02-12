package com.hackathon.digitalisation.controllers;

import com.hackathon.digitalisation.dtos.FileUploadOut;
import com.hackathon.digitalisation.entitites.FileEntity;
import com.hackathon.digitalisation.services.FileService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file")
@AllArgsConstructor
public class FileController {

    FileService fileService;
    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<FileUploadOut> upload(@RequestParam("file") MultipartFile file){
        System.out.println("hello");
        return fileService.saveFile(file);
    }

    @GetMapping("download/{fileId}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileId){
        ResponseEntity<FileEntity> file= fileService.getFile(fileId);
        FileEntity fileBody = file.getBody();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileBody.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachement; filename=\""+fileBody.getFileName())
                .body(new ByteArrayResource(fileBody.getFileData()));
    }

    @GetMapping("view/{fileId}")
    public ResponseEntity<Resource> viewFile(@PathVariable String fileId) {
        ResponseEntity<FileEntity> file = fileService.getFile(fileId);
        FileEntity fileBody = file.getBody();

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileBody.getFileType()))
                .body(new ByteArrayResource(fileBody.getFileData()));
    }
}