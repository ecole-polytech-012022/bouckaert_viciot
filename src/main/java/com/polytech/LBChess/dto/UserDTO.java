package com.polytech.LBChess.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {
    private String nom;
    private String prenom;
    private String email;
}
