package com.example.deneme.controller;

import com.example.deneme.service.AdresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/adres")
public class AdresController {

    @Autowired
    private final AdresService adresService;

    @Autowired
    public AdresController(AdresService adresService) {
        this.adresService = adresService;
    }

    @GetMapping("/add")
    public ResponseEntity<String> addAdres() throws SQLException, ClassNotFoundException {
        adresService.addAdres();

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

  /*  @GetMapping("/all")
    public ResponseEntity<List<AdresDTO>> getAllUsers() throws SQLException, ClassNotFoundException {
        List<AdresDTO> adress=jdbcDbConnector.getAdres();

        return new ResponseEntity<>(adress, HttpStatus.OK);
    }   */
}
