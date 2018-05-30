package br.org.cap.contactapi.resource;

import br.org.cap.contactapi.entity.Banco;
import br.org.cap.contactapi.entity.Person;
import br.org.cap.contactapi.storage.Disc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    Person person;

    @Autowired
    Banco banco;

    @Autowired
    Disc disc;

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        Person person = Banco.getPersonOfList(id);

        return ResponseEntity.ok(person);
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePerson(@RequestBody Person person) {

        this.person = person;
        Banco.getPersonList().add(person);

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<?> savePersonWithFoto(@RequestPart Person person, @RequestPart MultipartFile file) {

        this.person = person;
        Banco.getPersonList().add(person);

        disc.saveFoto(file);

        this.person.setPathOfFoto(disc.getRoot() + "/" + disc.getDirectoryFotos() + "/" + file.getName());

        return ResponseEntity.ok().build();
    }
}
