package tn.esprit.spring.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Bloc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bloc {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long idBloc ;
    @Column(name="nomBloc")
    private String nomBloc ;
    @Column(name="capaciteBloc")
    private int capaciteBloc ;
    @JsonIgnore
    @ManyToOne
    Foyer foyer ;


    @OneToMany(mappedBy = "bloc" , cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private Set<Chamber> chambers = new HashSet<>();
}
