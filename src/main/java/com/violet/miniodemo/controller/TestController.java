package com.violet.miniodemo.controller;
import com.violet.miniodemo.config.MinioUtil;
import com.violet.miniodemo.config.UploadResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private MinioUtil minioUtil;

    /**
     * @author: xx
     * @date: 2022/5/25 15:32
     * @description: 上传文件
     */
    @PostMapping("/upload")
    public UploadResponse minioUpload(@RequestParam(value = "file") MultipartFile file){
        UploadResponse response = null;
        try {
            response = minioUtil.uploadFile(file, "my-bucket");
        } catch (Exception e) {
            log.error("上传失败",e);
        }
        return response;
    }


    /**
     * @author: xx
     * @date: 2022/5/25 15:32
     * @description: 上传视频
     */
    @PostMapping("/uploadVideo")
    public UploadResponse uploadVideo(@RequestParam(value = "file") MultipartFile file){
        UploadResponse response = null;
        try {
            response = minioUtil.uploadVideo(file, "my-bucket");
        } catch (Exception e) {
            log.error("上传失败",e);
        }
        return response;
    }

}
