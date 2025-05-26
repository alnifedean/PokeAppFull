package com.pokemon.app.pokebattle.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public interface BattleService {
    public HashMap<String,Object> startBattle(long userId, int level);
    public HashMap<String,Object> startBattlePublic(int level);
    public HashMap<String,Object> turnBattle(Map<String, Integer> data);
}
