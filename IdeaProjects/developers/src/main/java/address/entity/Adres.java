package address.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "adreses")
public class Adres {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String Sokak;

   private String Zip;

   private String Sehir;

   private String Ulke;


}
