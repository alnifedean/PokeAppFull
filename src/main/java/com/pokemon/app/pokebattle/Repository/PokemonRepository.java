package com.pokemon.app.pokebattle.Repository;

import com.pokemon.app.pokebattle.Model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Pokemon findByPokeNumber(int pokeNumber);
}