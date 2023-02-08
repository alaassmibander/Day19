package com.example.day19.Controller;

import com.example.day19.Moudle.Director;
import com.example.day19.Service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("api/v1/director")
@RestController
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping("/get")
    List<Director> getDirectors() {
        return directorService.getAllDirectors();
    }

    @PostMapping("/add")
    public ResponseEntity postNewDirector(@RequestBody Director c) {
        Director newDirector = directorService.addNewDirector(c);
        return new ResponseEntity<>(newDirector, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Optional<Director>> putDirector(@PathVariable Integer id, @RequestBody Director c) {
        Optional<Director> result = directorService.updateDirector(id, c);
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Optional<String>> deleteDirectorById(@PathVariable Integer id) {
        if (directorService.removeDirector(id)) {
            return new ResponseEntity<>(Optional.of("Deleted"), HttpStatus.OK);
        }
        return new ResponseEntity<>(Optional.of("Not Found"), HttpStatus.NOT_FOUND);
    }

}


