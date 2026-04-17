package com.paymentprocessor.payment_processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

@RestController
public class LearningController {
    private final PhotoService photoService;

    @Autowired
    LearningController(PhotoService photoService) {
        this.photoService = photoService;
    }
    @GetMapping("/")
    public Collection<Photo> get() {
        return photoService.getAllPhotos();
    }

    @PostMapping("/images")
    public ResponseEntity<String> uploadPhoto(@RequestPart(value="file") MultipartFile file) {
        try {
            UUID uuid = photoService.uploadPhoto(file.getBytes());
            return new ResponseEntity<>(
                    uuid.toString(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(
                    "its fucked", HttpStatus.BAD_REQUEST);
        }
    }
}
