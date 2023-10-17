package co.edu.udea.api.controller;

import co.edu.udea.api.model.Hero;
import co.edu.udea.api.model.Mensaje;
import co.edu.udea.api.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/heroes")
public class HeroController {

     private  HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHero(@PathVariable Integer id) {
        return new ResponseEntity<>(heroService.getHeroByCodigo(id), HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<Hero>> getHeroes() {
        return new ResponseEntity<>(heroService.getHeros(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Hero> addHero(@RequestBody Hero hero) {
        hero.setId((int) (Math.random()*1000+1));
        return new ResponseEntity<>(heroService.saveHero(hero), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mensaje> deleteHero(@PathVariable Integer id) {
        heroService.deleteHero(id);
        return new ResponseEntity<>(new Mensaje( "001", "Hero delete"), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Hero> updateHero(@RequestBody Hero hero) {
        return new ResponseEntity<>(heroService.updateHero(hero), HttpStatus.OK);
    }

    @GetMapping("/buscar/{name}")
    public ResponseEntity<List<Hero>> searchHeroes(@RequestParam String name) {
        return new ResponseEntity<>(heroService.searchHeroesContainsTerm(name), HttpStatus.OK);
    }
}
