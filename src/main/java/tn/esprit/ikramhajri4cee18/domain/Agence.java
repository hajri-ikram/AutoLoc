package tn.esprit.ikramhajri4cee18.domain;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idAgence;
 private String nom;
private String ville;
 private String adresse;
 private String telephone;
 @OneToMany(mappedBy = "agence")
 private Set<Vehicule> vehicules ;
 @OneToMany(mappedBy = "agence")
 private Set<Employe> employes ;


}