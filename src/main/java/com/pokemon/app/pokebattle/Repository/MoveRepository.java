package com.pokemon.app.pokebattle.Repository;

import com.pokemon.app.pokebattle.Model.Move;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MoveRepository extends JpaRepository<Move, Long> {
    List<Move> findByTypeMoveAndMinLevel(String typeMove, int minLevel);
}
