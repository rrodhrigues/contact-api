package br.org.cap.contactapi.resource;

import br.org.cap.contactapi.storage.Disc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fotos")
public class FotosResource {

    @Autowired
    private Disc disc;

    @PostMapping
    public void upload(@RequestParam MultipartFile foto) {
        disc.saveFoto(foto);
    }

}
