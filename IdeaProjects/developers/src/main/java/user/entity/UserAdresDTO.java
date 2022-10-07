package user.entity;


import address.entity.Adres;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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