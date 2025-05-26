package com.pokemon.app.pokebattle.Service;

import com.pokemon.app.pokebattle.Model.Move;
import com.pokemon.app.pokebattle.Model.Pokemon;
import com.pokemon.app.pokebattle.Repository.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PokemonServiceImpl implements PokemonService {

    public HashMap<String, List<String>> weekTypes = new HashMap<>(){{
        put("normal",List.of("none"));
        put("fire",List.of("grass", "ice", "bug", "steel"));
        put("water",List.of("fire", "ground", "rock"));
        put("electric",List.of("water", "flying"));
        put("grass",List.of("water", "ground", "rock"));
        put("ice",List.of("dragon", "flying", "grass", "ground"));
        put("fighting",List.of("normal", "ice", "rock", "dark", "steel"));
        put("poison",List.of("grass", "fairy"));
        put("ground",List.of("fire", "electric", "poison", "rock", "steel"));
        put("flying",List.of("bug", "fighting", "grass"));
        put("psychic",List.of("fighting", "poison"));
        put("bug",List.of("grass", "psychic", "dark"));
        put("rock",List.of("fire", "ice", "flying", "bug"));
        put("ghost",List.of("ghost", "psychic"));
        put("dragon",List.of("dragon"));
        put("steel",List.of("ice", "rock", "fairy"));
        put("dark",List.of("ghost", "psychic"));
        put("fairy",List.of("dragon", "fighting", "dark"));
    }};
    public HashMap<String, List<String>> resistantTypes = new HashMap<>(){{
        put("normal",List.of("ghost"));
        put("fire",List.of("fire", "grass", "ice", "bug", "steel", "fairy"));
        put("water",List.of("fire", "water", "ice", "steel"));
        put("electric",List.of("electric", "flying", "steel"));
        put("grass",List.of("water", "electric", "grass", "ground"));
        put("ice",List.of("ice"));
        put("fighting",List.of("bug", "rock", "dark"));
        put("poison",List.of("grass", "fighting", "poison", "bug", "fairy"));
        put("ground",List.of("poison", "rock", "electric"));
        put("flying",List.of("grass", "fighting", "bug", "ground"));
        put("psychic",List.of("fighting", "psychic"));
        put("bug",List.of("grass", "fighting", "ground"));
        put("rock",List.of("normal", "fire", "poison", "flying"));
        put("ghost",List.of("poison", "bug", "normal", "fighting"));
        put("dragon",List.of("fire", "water", "electric", "grass"));
        put("steel",List.of("normal", "grass", "ice", "flying", "psychic", "bug", "rock", "dragon", "steel", "fairy", "poison"));
        put("dark",List.of("ghost", "dark"));
        put("fairy",List.of("fighting", "bug", "dark", "dragon"));
    }};



    @Autowired
    private  MoveRepository moveRepository;

    @Override
    public Pokemon attack(Pokemon attacker, int move, Pokemon defender) {
        Move usedMove = moveRepository.findById((long) move).orElseThrow(()->new RuntimeException("move not found..."));
        int damage = attacker.getStrength();
        if (defender.getTypes().size()==1){
            List<String> typesListStrongTo = weekTypes.get(usedMove.getTypeMove().toLowerCase());
            List<String> typesListWeekTo = weekTypes.get(usedMove.getTypeMove().toLowerCase());
            if (typesListStrongTo.contains(defender.getTypes().getFirst())){damage=(int)(damage * 1.25);}
            if (typesListWeekTo.contains(defender.getTypes().getFirst())){damage=(int)(damage*.75);}


        } else if (defender.getTypes().size()==2){
            List<String> typesListStrongTo = weekTypes.get(usedMove.getTypeMove().toLowerCase());
            List<String> typesListWeekTo = weekTypes.get(usedMove.getTypeMove().toLowerCase());
            if (typesListStrongTo.contains(defender.getTypes().getFirst())){
                if (typesListStrongTo.contains(defender.getTypes().getLast())){
                    damage=(int)(damage * 1.5);
                } else {damage=(int)(damage * 1.25);}}
            if (typesListWeekTo.contains(defender.getTypes().getFirst())){
                if (typesListStrongTo.contains(defender.getTypes().getLast())){
                    damage=(int)(damage * .5);
                } else {damage=(int)(damage*.75);}}
        }
        if (damage<defender.getHp()){
            defender.setHp(defender.getHp()-5);
        } else {
            defender.setHp(defender.getHp()-damage);
        }

        return null;
    }
}
