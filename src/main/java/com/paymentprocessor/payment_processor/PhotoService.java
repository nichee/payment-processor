package com.paymentprocessor.payment_processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PhotoService {
    //private final HashMap<UUID, Photo> Photos = new HashMap<>();

    @Autowired
    PhotoRepository photoRepository;
    public PhotoService() {
    }

    public Collection<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }

    public UUID uploadPhoto(byte[] photo) {
        Photo newPhoto = new Photo(photo);
        Photo savedPhoto = photoRepository.save(newPhoto);
        return savedPhoto.getId();
    }
}