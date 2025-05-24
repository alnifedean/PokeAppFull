package com.pokemon.app.pokebattle.Factory;

import com.pokemon.app.pokebattle.Model.Move;
import com.pokemon.app.pokebattle.Model.Pokemon;
import com.pokemon.app.pokebattle.Repository.MoveRepository;
import com.pokemon.app.pokebattle.Repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonFactory {

    private final PokemonRepository pokemonRepository;
    private final MoveRepository moveRepository;

    public PokemonFactory(PokemonRepository pokemonRepository, MoveRepository moveRepository){
        this.pokemonRepository=pokemonRepository;
        this.moveRepository=moveRepository;
    }


    public Pokemon createPokemon(int pokeNumber){
        Pokemon pokemon = pokemonRepository.findByPokeNumber(pokeNumber);

        if (pokemon.getTypes().size()==1){
            List<Move> allMoves = moveRepository.findByTypeMoveAndMinLevel(pokemon.getTypes().getFirst(), pokemon.getLevel());
        }






        return pokemon;
    };
}