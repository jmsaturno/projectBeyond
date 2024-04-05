package com.projectBeyond.pb.fileupload;

import java.io.File;

public class ReceivedInfo {

    private File myfile;
    private String fileName;
    private String bucketName;
    
    public ReceivedInfo() {
    }
    
    public File getFile() {
        return this.myfile;
    }

    public void setFile(File myfile) {
        this.myfile = myfile;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public String getBucketName(){
        return this.bucketName;
    }

    public void setBucketName(String bucketName){
        this.bucketName = bucketName;
    }

}