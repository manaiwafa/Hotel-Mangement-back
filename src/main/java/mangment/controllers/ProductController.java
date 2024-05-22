package mangment.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Fichier vide !");
        }

        try {
            // Récupérer le nom du fichier
            String fileName = file.getOriginalFilename();

            // Créer un nouveau fichier dans le répertoire de stockage (par exemple, dans le répertoire "uploads" à la racine du projet)
            File destFile = new File("uploads/" + fileName);
            destFile.createNewFile();

            // Écrire le contenu du fichier téléversé dans le nouveau fichier créé
            FileOutputStream fos = new FileOutputStream(destFile);
            fos.write(file.getBytes());
            fos.close();

            return ResponseEntity.ok().body("Fichier téléversé avec succès : " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erreur lors du téléversement du fichier : " + e.getMessage());
        }
    }}
