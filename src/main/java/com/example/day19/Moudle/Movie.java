package com.example.day19.Moudle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "name can not be null ")
    @Size(min = 3, message = "title must be more than 2")
    private String title;
    @NotNull(message = "genre can not be empty")
    @Pattern(regexp = "Drama|Action|Comedy")
    private String genre;
    @NotNull(message = "rating can not be empty")
    @Size(min = 1, max = 5, message = "must be between 1 - 5")
    private int rating;
    @NotNull(message = "duration can not be empty")
    @Size(min = 61, message = "duration must be more than 60")
    private int duration;
    @NotNull(message = "idDirector can not be empty")
    @Size(min = 4, message = "idDirector length must be more than 3")

    private int idDirector;
}


