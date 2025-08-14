package library_management.library_management_system.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AwsS3Service {
    public String uploadFile(MultipartFile file, String folder){
        String url = "https://billing-software-irfan0354.s3.ap-south-1.amazonaws.com/0af004e7-dd4a-42b3-9a36-37a0e4558347.png" + file.getOriginalFilename();
        return url;
    }
}
