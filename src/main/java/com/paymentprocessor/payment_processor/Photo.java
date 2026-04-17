package com.paymentprocessor.payment_processor;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Photo {
    private UUID id;
    @Setter
    @Getter
    private byte[] photo;

    public Photo(UUID id, byte[] photo) {
        this.photo = photo;
        this.id = id;
    }

}
