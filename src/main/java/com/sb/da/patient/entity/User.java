package com.sb.da.patient.entity;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class User {
    private String id;
    private String email;
    private String password="1234";
    private String lastName;
    private String firstName="ayush";
    private boolean active=true;
    private String role="USER , ADMIN";
}
