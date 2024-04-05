package com.projectBeyond.pb.fileupload;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;


public class S3Uploader {

  public void submitFileS3(ReceivedInfo info) {
    
    S3Client s3 = S3Client.builder()
      .region(Region.US_EAST_1)
      .build();
      
    try{
      ReceivedInfo ri = new ReceivedInfo();
      ri.setFile(info.getFile());
      ri.setFileName(info.getFileName());
      ri.setBucketName(info.getBucketName());


      RequestBody requestBody = RequestBody.fromFile(ri.getFile());
      
      PutObjectRequest request = PutObjectRequest.builder()
        .bucket(ri.getBucketName())
        .key(ri.getFileName())
        .build();
        
      s3.putObject(request, requestBody);
    }
    catch (S3Exception e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
  }
}