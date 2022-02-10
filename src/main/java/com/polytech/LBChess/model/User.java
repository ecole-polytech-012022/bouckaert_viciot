package com.polytech.LBChess.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Data
public class User {
    @Id // annotation for ID column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy for ID, here it well be ID++
    @Column(length = 11) // column size on database side definition
    private Integer id;

    @Column(name = "nom", nullable = false, length = 45) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private String nom;

    @Column(name = "prenom", nullable = false, length = 45) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private String prenom;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 100)
    private String password;
}
