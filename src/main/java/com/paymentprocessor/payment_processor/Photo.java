package com.paymentprocessor.payment_processor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private UUID id;
    @Setter
    @Getter
    @Lob
    private byte[] photo;

    public Photo(byte[] photo) {
        this.photo = photo;
    }
    // no arg constructor for JPA to instantiate the entity - constructor is called by reflection at runtime
    protected Photo() {

    }
}
