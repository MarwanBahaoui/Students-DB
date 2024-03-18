package com.arabic.tgcc.Etudiant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Document
@Getter
@Setter
public class Student {

    public Student() {}
    @Id
    private String Id;

    @NotNull(message = "Description is required")
    @Size(min= 3, message = "Description must be at least 3 characters.")
    private String Description;

    @NotNull(message = "Description is required")
    @Size(message= "Make it at a max 30 caracters" )
    private String Matricule;
    private Long timestamp;

    public Student(Long timestamp) {
        this.timestamp = timestamp;

    }

    public Student(String id, String description, String matricule) {
        Id = id;
        Description = description;
        Matricule = matricule;

    }
}
