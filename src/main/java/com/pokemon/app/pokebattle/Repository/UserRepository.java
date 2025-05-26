package com.pokemon.app.pokebattle.Repository;

import com.pokemon.app.pokebattle.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
