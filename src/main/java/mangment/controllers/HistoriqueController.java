package mangment.controllers;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mangment.entities.Chambre;
import mangment.entities.Employer;

import mangment.services.impl.HistoriqueServiceImpl;


@RestController
@RequestMapping("/historique")
public class HistoriqueController {

   
    @Autowired 
    private HistoriqueServiceImpl HistoriqueServiceImpl ;


    @PostMapping("/employers/{idEmployer}/affecterChambres")
    public Employer AddEmployerAChambre(@PathVariable Long idEmployer, @RequestBody List<Chambre> chambres) {
        LocalDate date = LocalDate.now(); 
        return HistoriqueServiceImpl.affecterEmployerAChambre(idEmployer, chambres, date);
    }
    @GetMapping("/{idEmployer}/chambres")
    public ResponseEntity<List<Chambre>> getChambresForEmployerToday(@PathVariable Long idEmployer) {
        LocalDate today = LocalDate.now();
        List<Chambre> chambres =  HistoriqueServiceImpl.getChambresByEmployerAndDate(idEmployer, today);
        return ResponseEntity.ok(chambres);
    }
    }

		
	

