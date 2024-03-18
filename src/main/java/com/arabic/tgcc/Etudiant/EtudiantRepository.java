package com.arabic.tgcc.Etudiant;

import jdk.jfr.Description;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends MongoRepository<Student, String> {
     Student findByMatricule(String Matricule);
}
