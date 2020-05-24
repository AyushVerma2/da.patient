package com.sb.da.patient.entity;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class User {
    private String id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private String roles="ADMIN";
}
