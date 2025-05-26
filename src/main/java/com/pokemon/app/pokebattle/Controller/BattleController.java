package com.pokemon.app.pokebattle.Controller;

import com.pokemon.app.pokebattle.Factory.PokemonFactory;
import com.pokemon.app.pokebattle.Model.Pokemon;
import com.pokemon.app.pokebattle.Model.User;
import com.pokemon.app.pokebattle.Repository.PokemonRepository;
import com.pokemon.app.pokebattle.Repository.UserRepository;
import com.pokemon.app.pokebattle.Service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("battle")
public class BattleController {

    @Autowired
    PokemonRepository pokemonRepository;
    @Autowired
    PokemonFactory pokemonFactory;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BattleService battleService;

    @GetMapping
    public ResponseEntity<HashMap<String,Object>> startBattle(@RequestBody int level, @RequestHeader(value = "Authorization")String token){

        HashMap<String, Object> enemyAndMyPoke = battleService.startBattle(1L, level);

        return ResponseEntity.ok().body(enemyAndMyPoke);
    }

    @GetMapping(value = "/public")
    public ResponseEntity<HashMap<String,Object>> startBattlePublic(@RequestBody int level){

        HashMap<String, Object> enemyAndMyPoke = battleService.startBattlePublic(level);

        return ResponseEntity.ok().body(enemyAndMyPoke);
    }

    @PostMapping
    public ResponseEntity<HashMap<String,Object>> turnBattle(@RequestBody Map<String, Integer> data){
        //data = "mine": no. pokemon, "myAction":99998 (to heal)



        return null;
    }
}
