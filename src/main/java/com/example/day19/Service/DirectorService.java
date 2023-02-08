package com.example.day19.Service;

import com.example.day19.Moudle.Director;
import com.example.day19.Repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service

public class DirectorService {
    private final DirectorRepository directorRepository;

    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    public Director addNewDirector(Director c) {
        return directorRepository.save(c);
    }

    public Optional<Director> updateDirector(Integer id, Director c) {
        if (directorRepository.existsById(id)) {
            Director chosenDirector = directorRepository.findDirectorById(id);
            chosenDirector.setName(c.getName());
            return Optional.of(directorRepository.save(chosenDirector));
        }
        return Optional.empty();
    }

    public boolean removeDirector(Integer id) {
        if (directorRepository.existsById(id)) {
            directorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
