package com.pokemon.app.pokebattle.Service;

import com.pokemon.app.pokebattle.Model.Pokemon;

public interface PokemonService {
    public Pokemon attack(Pokemon attacker, int move, Pokemon defender);
}
