package com.example.demo.Controller;

import com.example.demo.Service.Sugerencia;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SugerenciaController{
    private ArrayList<Sugerencia> sugerencias = new ArrayList<Sugerencia>();

    @PostMapping("/postSugerencia")
    public ResponseEntity<Sugerencia> postSugerencia(@RequestBody Sugerencia sugerencia){
        int id = sugerencias.size();
        sugerencia.setId(id);
        sugerencias.add(sugerencia);

        return new ResponseEntity<Sugerencia>(sugerencia, HttpStatus.OK);
    }

    @GetMapping("/getSugerencias")
    public ResponseEntity<ArrayList<Sugerencia>> getSugerencias(){
        return new ResponseEntity<ArrayList<Sugerencia>>(sugerencias, HttpStatus.OK);
    }

    //Esto por ahora no lo uso
    @GetMapping("/getSugerencia/{id}")
    public ResponseEntity<Sugerencia> getSugerencia(@PathVariable String id){
        int idInt = Integer.parseInt(id);
        if(idInt <= sugerencias.size() & idInt>=0){
            return new ResponseEntity<Sugerencia>(sugerencias.get(idInt), HttpStatus.OK);
        }
        return new ResponseEntity<Sugerencia>(sugerencias.get(idInt), HttpStatus.NOT_FOUND); //como hago esto bien??
    }


}