package com.pokemon.app.pokebattle.Factory;

import com.pokemon.app.pokebattle.Model.Pokemon;

public class PokemonFactory {

    public Pokemon createPokemon(String type){
        return new Pokemon() {};
    };
}