package com.example.librarysystem.common;

public class BookPhotoDto {
    Long id;
    String filename;
    String fileType;
    byte[] fileContent;

    public BookPhotoDto(Long id, String filename, String fileType, byte[] fileContent) {
        this.id = id;
        this.filename = filename;
        this.fileType = fileType;
        this.fileContent = fileContent;
    }

    public Long getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public String getFileType() {
        return fileType;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

}
