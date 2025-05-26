package com.pokemon.app.pokebattle.Service;

import com.pokemon.app.pokebattle.Factory.PokemonFactory;
import com.pokemon.app.pokebattle.Model.Pokemon;
import com.pokemon.app.pokebattle.Model.User;
import com.pokemon.app.pokebattle.Repository.PokemonRepository;
import com.pokemon.app.pokebattle.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BattleServiceImpl implements BattleService{

    @Autowired
    PokemonRepository pokemonRepository;
    @Autowired
    PokemonFactory pokemonFactory;
    @Autowired
    UserRepository userRepository;

    HashMap<String, Object> enemyAndMyPoke = new HashMap<>();
    Random random = new Random();
    List<Pokemon> enemyTeam = new ArrayList<>();
    List<Pokemon> myTeam = new ArrayList<>();
    List<Pokemon> allPokemons = new ArrayList<>();
    int levelSelected = 0;
    boolean onAction = false;
    Pokemon enemyMain = enemyTeam.getFirst();
    Pokemon myMain = myTeam.getFirst();

    @Override
    public HashMap<String, Object> startBattle(long userId, int level) {
        levelSelected=level;
        onAction=true;
        allPokemons = pokemonRepository.findByLevel(levelSelected);

        for (int x=0;x<6;x++){
            enemyTeam.add(pokemonFactory.createPokemon(random.nextInt(allPokemons.size())));
        }
        enemyAndMyPoke.put("enemy" , enemyTeam);

        User user = userRepository.findById(1L).orElseThrow(() -> new RuntimeException("Not user found..."));

        enemyAndMyPoke.put("myTeam", user.getMyTeam());

        enemyMain = enemyTeam.getFirst();
        myMain = myTeam.getFirst();

        return enemyAndMyPoke;
    }
    @Override
    public HashMap<String, Object> startBattlePublic(int level) {
        levelSelected=level;
        onAction=true;
        allPokemons = pokemonRepository.findByLevel(levelSelected);

        for (int x=0;x<6;x++){
            enemyTeam.add(pokemonFactory.createPokemon(random.nextInt(allPokemons.size())));
        }
        enemyAndMyPoke.put("enemy" , enemyTeam);

        for (int x=0;x<6;x++){
            myTeam.add(pokemonFactory.createPokemon(random.nextInt(allPokemons.size())));
        }
        enemyAndMyPoke.put("myTeam", myTeam);

        enemyMain = enemyTeam.getFirst();
        myMain = myTeam.getFirst();

        return enemyAndMyPoke;
    }

    @Override
    public HashMap<String, Object> turnBattle(Map<String, Integer> data){
        //data = "mine": no. pokemon, "myAction":99998 (0 to run, 99998 to heal, 99999 to change pokemon)

        if (enemyAndMyPoke.containsKey("enemyMain") || enemyAndMyPoke.containsKey("myMain")){if (enemyAndMyPoke.get("enemyMain")=="lost" || enemyAndMyPoke.get("myMain")=="lost"){return enemyAndMyPoke;}}

        int suma=0;
        int suma2=0;
        for (int x=0;x<6;x++){
            suma += myTeam.get(x).getHp();
            suma2 += enemyTeam.get(x).getHp();}
        if (suma==0){
            enemyAndMyPoke.clear();
            enemyAndMyPoke.put("enemyMain" , enemyMain);
            enemyAndMyPoke.put("myMain","lost");
            return enemyAndMyPoke;
        } else if (suma2==0) {
            enemyAndMyPoke.clear();
            enemyAndMyPoke.put("enemyMain" , "lost");
            enemyAndMyPoke.put("myMain",myMain);
            return enemyAndMyPoke;
        }

        if(data.get("myAction")==0){
            if (levelSelected==1 || levelSelected==2){
                enemyAndMyPoke.clear();
                enemyAndMyPoke.put("enemyMain" , enemyMain);
                enemyAndMyPoke.put("myMain","lost");
                return enemyAndMyPoke;
            } else if (levelSelected==3){
                // Add the "eliminate a pokemon" because lost
                enemyAndMyPoke.clear();
                enemyAndMyPoke.put("enemyMain" , enemyMain);
                enemyAndMyPoke.replace("myMain","lost");
                return enemyAndMyPoke;
            }
        } else if (data.get("myAction")==99998) {
            myMain.setHp((int)Math.round (myMain.getHp()*1.10));
        } else if (data.get("myAction")==99999) {
            myMain=myTeam.get(data.get("mine"));
        } else if (data.get("myAction")<0 || data.get("myAction")>99999){
            throw new RuntimeException("action invalid...");
        } else {
            // Attacks
        }


        return null;
    }
}
