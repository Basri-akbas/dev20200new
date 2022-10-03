package com.deneme.BosturDeneyebilirsin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdresDTO {

    private String id;
    private String Sokak;

    private String Zip;

    private String Sehir;

    private String Ulke;

    @Override
    public String toString() {
        return "AdresDTO{" +
                "id='" + id + '\'' +
                ", Sokak='" + Sokak + '\'' +
                ", Zip='" + Zip + '\'' +
                ", Sehir='" + Sehir + '\'' +
                ", Ulke='" + Ulke + '\'' +
                '}';
    }
}
