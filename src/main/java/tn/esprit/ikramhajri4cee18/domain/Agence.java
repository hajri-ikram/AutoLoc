package tn.esprit.ikramhajri4cee18.domain;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import java.util.Set;
=======
>>>>>>> 6ce0c0d26c699093f5e2f4eeeff823efc8730eb6

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
<<<<<<< HEAD
 @OneToMany(mappedBy = "agence")
 private Set<Vehicule> vehicules ;
 @OneToMany(mappedBy = "agence")
 private Set<Employe> employes ;


=======
 @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
 private List<Vehicule> vehicules = new ArrayList<>();
@OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
  private List<Employe> employes = new ArrayList<>();
>>>>>>> 6ce0c0d26c699093f5e2f4eeeff823efc8730eb6
}