package user.payload.response;

import lombok.Getter;
import lombok.Setter;
import user.entity.UserAdresDTO;

@Getter
@Setter

public class UserWithNoAddressResponse {

    UserAdresDTO user;
    String message;

    public UserWithNoAddressResponse(UserAdresDTO user, String message) {
        this.user = user;
        this.message = message;
    }
}
