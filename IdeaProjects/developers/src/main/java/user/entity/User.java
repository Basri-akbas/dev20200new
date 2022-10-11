package user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {

    public User(Book bookId, String name, String soyIsim, String adres, String telefon, Date createdDate, String email, String securityNumber, boolean isSingle) {
        this.bookId = bookId;
        this.name = name;
        this.soyIsim = soyIsim;
        this.adres = adres;
        this.telefon = telefon;
        this.createdDate = createdDate;
        this.email = email;
        this.securityNumber = securityNumber;
        this.isSingle = isSingle;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book bookId;

    @Column(name = "isim")
    private String name;

    @Column(name = "soyIsim")
    private String soyIsim;

    @Column(name = "adres")
    private String adres;

    @Column(name = "telefon")
    private String telefon;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Turkey")
    @Column(name="date")
    private Date createdDate;

    @Column(name="email")
    @Email
    private String email;

    @Column(name="securityNumber ")
    private String securityNumber ;

    @Column(name="single")
    private boolean isSingle;


}