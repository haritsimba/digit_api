package com.hackathon.digitalisation.dtos;

public record FileUploadOut(
        String fileName,
        String downloadUrl,
        String viewUrl,
        String fileType,
        Long fileSize
){
}
