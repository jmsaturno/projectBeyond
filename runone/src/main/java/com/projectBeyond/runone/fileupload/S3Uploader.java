// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package com.projectBeyond.runone.fileupload;

// snippet-start:[s3.java2.s3_object_upload.main]
// snippet-start:[s3.java2.s3_object_upload.import]
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


import software.amazon.awssdk.core.sync.RequestBody; 
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

public class S3Uploader {

  public static void main(String[] args) {
    
    S3Client s3 = S3Client.builder()
      .region(Region.US_EAST_1)
      .build();
      
    String bucketName = "Xy-bucket";
    String key = "file.txt";
    String filePath = "/path/to/file.txt";
    
    RequestBody requestBody = RequestBody.fromFile(new File(filePath));
    
    PutObjectRequest request = PutObjectRequest.builder()
      .bucket(bucketName) 
      .key(key)
      .build();
      
    s3.putObject(request, requestBody);
  }
}