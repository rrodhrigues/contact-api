package br.org.cap.contactapi.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class Disc {

    @Value("${contato.disco.raiz}") // /tmp/contato-disco
    private String root;

    @Value("${contato.disco.diretorio-fotos}") // /fotos
    private String directoryFotos;


    public void saveFoto(MultipartFile foto) {
        this.save(this.directoryFotos, foto);
    }

    private void save(String directory, MultipartFile file) {
        Path directoryPath = Paths.get(this.root, directory);
        Path filePath = directoryPath.resolve(file.getOriginalFilename());

        try {
            Files.createDirectories(directoryPath);
            file.transferTo(filePath.toFile());

        } catch (IOException e) {
            throw new RuntimeException("Problemas na tentativa de salvar aquivo.", e);
        }
    }

    public String getRoot() {
        return root;
    }

    public String getDirectoryFotos() {
        return directoryFotos;
    }
}
