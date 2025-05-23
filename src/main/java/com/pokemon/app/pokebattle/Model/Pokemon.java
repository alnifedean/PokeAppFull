package com.pokemon.app.pokebattle.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "pokemons")
public abstract class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Min(1)
    @Column
    private int pokeNumber;
    @NotBlank
    @Column
    private String name;
    @NotEmpty
    @Column
    private List<String> types;
    @NotNull
    @Min(1)
    @Column
    private int hp;
    @NotNull
    @Min(1)
    @Column
    private int strength;
    @NotNull
    @Min(1)
    @Column
    private int defense;
    @NotEmpty
    @Column
    private List<Move> attacks;
    @NotNull
    @Min(1)
    @Column
    private int level;


    public Pokemon(){};

    public Pokemon(int pokeNumber, String name, List<String> types, int hp, int strength, int defense, List<Move> attacks, int level){
        this.pokeNumber=pokeNumber;
        this.name=name;
        this.types=types;
        this.hp=hp;
        this.strength=strength;
        this.defense=defense;
        this.attacks=attacks;
        this.level=level;
    }

    public Pokemon(int pokeNumber, String name, List<String> types, int hp, int strength, int defense, int level){
        this.pokeNumber=pokeNumber;
        this.name=name;
        this.types=types;
        this.hp=hp;
        this.strength=strength;
        this.defense=defense;
        this.level=level;
    }


    public long getId() {
        return id;}
    public void setId(long id) {
        this.id = id;}

    public int getPokeNumber() {
        return pokeNumber;}
    public void setPokeNumber(int pokeNumber) {
        this.pokeNumber = pokeNumber;}

    public String getName() {
        return name;}
    public void setName(String name) {
        this.name = name;}

    public List<String> getTypes() {
        return types;}
    public void setTypes(List<String> types) {
        this.types = types;}

    public int getHp() {
        return hp;}
    public void setHp(int hp) {
        this.hp = hp;}

    public int getStrength() {
        return strength;}
    public void setStrength(int strength) {
        this.strength = strength;}

    public int getDefense() {
        return defense;}
    public void setDefense(int defense) {
        this.defense = defense;}

    public List<Move> getAttacks() {
        return attacks;}
    public void setAttacks(List<Move> attacks) {
        this.attacks = attacks;}

    public int getLevel() {
        return level;}
    public void setLevel(int level) {
        this.level = level;}


    @Override
    public String toString(){
        return "I am a pokemon, my name is "+this.name+"and my number is "+this.pokeNumber;
    }
}
