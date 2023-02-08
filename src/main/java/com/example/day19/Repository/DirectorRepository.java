package com.example.day19.Repository;

import com.example.day19.Moudle.Director;
import com.example.day19.Moudle.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {
    Director findDirectorById(Integer id);
}
