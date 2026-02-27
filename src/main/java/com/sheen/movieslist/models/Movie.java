package com.sheen.movieslist.models;

import jakarta.persistence.*;
import lombok.*;

@Entity // to tell spring boot this class represents a database table
@Table(name = "movies_java") // to control the exact name

@Data // for getters, setters, toString and so on
@NoArgsConstructor // for empty constructor
@AllArgsConstructor // for constructor with all fields

public class Movie {
    @Id
    // postgreSql will handle the id generation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer year;
    private  Double rating;

    // no need constructors, getters and setters because we're using Lombok
}
