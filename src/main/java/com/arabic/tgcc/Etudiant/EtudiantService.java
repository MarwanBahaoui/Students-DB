package com.arabic.tgcc.Etudiant;

import com.arabic.tgcc.error.ConflictException;
import com.arabic.tgcc.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;


    /** Get all students - @return List of students**/
    public List<Student> findAll() {
        return etudiantRepository.findAll();
    }

    public Student getById(String id) {
        try {
            return etudiantRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No record with the id [%s] was found in our database", id));
        }
    }



public Student save(Student student) {
    if (etudiantRepository.findByMatricule(student.getMatricule()) != null) {
        throw new ConflictException("Another record with the same matricule exists");
    }
    return etudiantRepository.insert(student);
}

public void delete(String id) {
    etudiantRepository.deleteById(id);
  }
     }

