package com.codehunter.springdockerpractice.entites;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_tb")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
