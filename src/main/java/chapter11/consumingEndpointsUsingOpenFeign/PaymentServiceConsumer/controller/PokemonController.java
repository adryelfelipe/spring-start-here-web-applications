package chapter11.consumingEndpointsUsingOpenFeign.PaymentServiceConsumer.controller;

import chapter11.consumingEndpointsUsingOpenFeign.PaymentServiceConsumer.models.Pokemon;
import chapter11.consumingEndpointsUsingOpenFeign.PaymentServiceConsumer.proxy.PokemonProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {
    private PokemonProxy pokemonProxy;

    public PokemonController(PokemonProxy proxy) {
        this.pokemonProxy = proxy;
    }

    @GetMapping("/pokemon")
    public Pokemon getPokemon(@RequestParam String nome) {
        return pokemonProxy.getPokemon(nome);
    }
}
