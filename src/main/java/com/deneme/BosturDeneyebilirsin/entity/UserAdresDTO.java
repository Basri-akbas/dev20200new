package com.deneme.BosturDeneyebilirsin.entity;

import com.example.deneme.entity.Adres;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAdresDTO {

   private Optional<User> user;

    private AdresDTO  adresDTO;


    public UserAdresDTO(Optional<User> user, Adres adresDTO) {
    }
}
