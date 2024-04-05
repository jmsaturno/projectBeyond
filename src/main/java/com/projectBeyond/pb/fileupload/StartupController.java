package com.projectBeyond.pb.fileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StartupController {
    private final S3Uploader s3;

    @Autowired
    StartupController(
            S3Uploader s3) {
        this.s3 = s3;
    }
    
    @GetMapping("/")
    public String greetingForm(Model model) {
        model.addAttribute("receivedinfo", new ReceivedInfo());
        return "startup";
    }

    @PostMapping("/receivedinfo")
    public String infoSubmit(@ModelAttribute ReceivedInfo receivedinfo) {
        
        // Upload file to S3 Bucket
        s3.submitFileS3(receivedinfo);
        return "result";
    }
}