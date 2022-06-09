package com.example.golfmax.Models;

import com.google.gson.annotations.SerializedName;

public class CourseImages {

    @SerializedName("fileName")
    private String fileName;

    @SerializedName("fileType")
    private String fileType;

    @SerializedName("id")
    private String id;

    @SerializedName("data")
    private byte[] data;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
