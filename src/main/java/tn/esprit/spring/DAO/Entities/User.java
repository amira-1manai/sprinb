package tn.esprit.spring.DAO.Entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="utilisateur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(name="FirstName" , unique = true)
     String nom ;
    @Column(name="LastName")
     String prenom ;

     LocalDate dateNaissance ; //JJ/MM/YY
    @Enumerated(EnumType.STRING)
     Sexe sexe ;
    @Temporal(TemporalType.DATE) // YYYY-MM-JJ HH:MM:SS
     Date dateInscription ;

    @Transient
     int age; // pour ne pas mapper l'attribute age dans la BD

}
