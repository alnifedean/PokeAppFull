package com.pokemon.app.pokebattle.Factory;

import com.pokemon.app.pokebattle.Model.Move;
import com.pokemon.app.pokebattle.Model.Pokemon;
import com.pokemon.app.pokebattle.Repository.MoveRepository;
import com.pokemon.app.pokebattle.Repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        List<Move> selectedMoves = new ArrayList<>();
        Random random = new Random();

        if (pokemon.getTypes().size()==1){
            List<Move> allMoves = moveRepository.findByTypeMoveAndMinLevel(pokemon.getTypes().getFirst(), pokemon.getLevel());

            for(int x=0;x<6;x++){
                selectedMoves.add(allMoves.get(random.nextInt(allMoves.size())));
            }
            pokemon.setAttacks(selectedMoves);
        } else if (pokemon.getTypes().size()==2) {
            List<Move> oneTypeMoves = moveRepository.findByTypeMoveAndMinLevel(pokemon.getTypes().getFirst(), pokemon.getLevel());
            List<Move> twoTypeMoves = moveRepository.findByTypeMoveAndMinLevel(pokemon.getTypes().getLast(),pokemon.getLevel());

            for (int x=0;x<3;x++){
                selectedMoves.add(oneTypeMoves.get(random.nextInt(oneTypeMoves.size())));
                selectedMoves.add(twoTypeMoves.get(random.nextInt(twoTypeMoves.size())));
            }
            pokemon.setAttacks(selectedMoves);
        } else {
            throw new RuntimeException("No valid type");
        }
        return pokemon;
    };
}