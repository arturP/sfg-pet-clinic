package io.artur.spring.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @ManyToOne
    @JoinColumn(name="type_id")
    private PetType type;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

}
