package pl.strzelecki.springbootvaadin;

import org.springframework.stereotype.Repository;
import pl.strzelecki.springbootvaadin.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PokemonDeck {

    private List<Pokemon> pokemonlist;

    public PokemonDeck() {
        this.pokemonlist = new ArrayList<>();
    }

    public List<Pokemon> getPokemonlist() {
        return pokemonlist;
    }

    public void setPokemonlist(List<Pokemon> pokemonlist) {
        this.pokemonlist = pokemonlist;
    }
}
