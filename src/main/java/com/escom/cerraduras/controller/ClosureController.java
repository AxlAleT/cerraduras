package com.escom.cerraduras.controller;

import com.escom.cerraduras.model.StringClosure;
import com.escom.cerraduras.service.ClosureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/cerradura")
public class ClosureController {

    private final ClosureService ClosureService;

    @Autowired
    public ClosureController(ClosureService ClosureService) {
        this.ClosureService = ClosureService;
    }

    @PutMapping("/estrella/{input}")
    public ResponseEntity<StringClosure> getKleeneClosure(@PathVariable("input") int n) {
        if (n < 0) {
            return ResponseEntity.badRequest().build();
        }

        Set<String> kleeneClosure = ClosureService.calculateKleeneClosure(n);
        return ResponseEntity.ok(new StringClosure(kleeneClosure));
    }

    @PutMapping("/positiva/{input}")
    public ResponseEntity<StringClosure> getPositiveClosure(@PathVariable("input") int n) {
        if (n < 0) {
            return ResponseEntity.badRequest().build();
        }

        Set<String> positiveClosure = ClosureService.calculatePositiveClosure(n);
        return ResponseEntity.ok(new StringClosure(positiveClosure));
    }
}