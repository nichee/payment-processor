package com.paymentprocessor.payment_processor;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PhotoService {
    private final HashMap<UUID, Photo> Photos = new HashMap<>();

    public PhotoService() {
    }

    public Collection<Photo> getAllPhotos() {
        return Photos.values();
    }

    public UUID uploadPhoto(byte[] photo) {
        UUID newId = UUID.randomUUID();
        Photo newPhoto = new Photo(newId, photo);
        Photos.put(newId, newPhoto);
        return newId;
    }
}