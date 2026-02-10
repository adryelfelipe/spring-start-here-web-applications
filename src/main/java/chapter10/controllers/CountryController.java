package chapter10.controllers;

import chapter10.models.Country;
import chapter10.models.exceptions.CountryNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    @GetMapping("/france")
    public Country countryFrance() {
        return new Country("France", 1000L);
    }

    @GetMapping("/brazil")
    public String stringBrazil() {
        return "Brazil";
    }

    @GetMapping("/listOfBrazil")
    public List<Country> listBrazil() {
        return List.of(new Country("Brazi", 20L), new Country("Brazil", 52L));
    }

    @GetMapping("/test1ResponseEntity")
    public ResponseEntity<String> test1ResponseEntity() {
        return ResponseEntity.ok("testing 1");
    }

    @GetMapping("/test2ResponseEntity")
    public ResponseEntity<Void> test2ResponseEntity() {
        return ResponseEntity.ok().header("SASAA", "qe3qeq").build();
    }

    @GetMapping("/test3ResponseEntity")
    public ResponseEntity<Void> test3ResponseEntity() {
        return ResponseEntity.status(200).header("TETHEU", "DEVENZZI").build();
    }


    @GetMapping("/test4ResponseEntity")
    public ResponseEntity<Void> test4ResponseEntity() {
        return ResponseEntity.status(200).header("TETHEU", "DEVENZZI").header("TETHEU", "DEVENZZI").build();
    }

    @GetMapping("/test5ResponseEntity")
    public ResponseEntity<Void> test5ResponseEntity() {
        HttpStatus status = HttpStatus.CREATED;
        return ResponseEntity.status(status).header("TETHEU", "DEVENZZI").header("TETHEU", "DEVENZZI").build();
    }

    @GetMapping("/test6ResponseEntity")
    public ResponseEntity<String> test6ResponseEntity() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("TETHEU", "DEVENZZI").header("TETHEU", "DEVENZZI").body(null);
    }

    @GetMapping("/test7CountryHandlerException")
    public ResponseEntity<String> test7CountryHandlerException() {
        if(true) {
            throw new CountryNullException();
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).header("TETHEU", "DEVENZZI").header("TETHEU", "DEVENZZI").body(null);
    }

    @PostMapping("/test8ConvertingIntoParameters")
    public ResponseEntity<Void> test8ConvertingIntoParameters(Country country) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).header("country name", country.getName()).header("contry population").build();
    }

    @GetMapping("/test9ConvertingIntoParameters")
    public ResponseEntity<String> test9ConvertingIntoParameters(@RequestBody Country country) {
        return ResponseEntity.ok("name: " + country.getName() + " :: population: " + country.getPopulation());
    }
}
