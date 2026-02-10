package chapter11.consumingEndpointsUsingOpenFeign.PaymentServiceConsumer.proxy;

import chapter11.consumingEndpointsUsingOpenFeign.PaymentServiceConsumer.models.Pokemon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "pokemon", url = "${pokemon.api.url}")
public interface PokemonProxy {

    @GetMapping("/api/v2/pokemon/{nome}")
    Pokemon getPokemon(@PathVariable String nome);
}
