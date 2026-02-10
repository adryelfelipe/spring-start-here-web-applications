package chapter11.usingRestTemplate.controller;

import chapter11.usingRestTemplate.models.Pokemon;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v2/pokemon/")
public class PokemonController {

    @Value("${pokemon.api.url}")
    private String pokemonUrl;

    @GetMapping("{nome}")
    public ResponseEntity<Pokemon> get(@PathVariable String nome, RestTemplate template) throws URISyntaxException {
        HttpEntity<Void> httpEntity = new HttpEntity<>((Void) null);
        return template.exchange(new URI(pokemonUrl + "/" + nome), HttpMethod.GET, httpEntity, Pokemon.class);
    }
}
