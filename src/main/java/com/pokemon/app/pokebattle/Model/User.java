package com.pokemon.app.pokebattle.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column
    private String userName;
    @NotBlank
    @Column
    private String name;
    @NotBlank
    @Column
    private String email;
    @NotNull
    @Min(1)
    @Column
    private long age;
    @NotBlank
    @Column
    private String password;
    @NotEmpty
    @Column
    private List<Pokemon> myTeam;
    @NotEmpty
    @Column
    private List<Pokemon> storagedPokemons;

    public User(){};

    public User(String userName, String name, String email, long age, String password){
        this.userName=userName;
        this.name=name;
        this.email=email;
        this.age=age;
        this.password=password;
    }

    public long getId() {
        return id;}
    public void setId(long id) {
        this.id = id;}

    public String getUserName() {
        return userName;}
    public void setUserName(String userName) {
        this.userName = userName;}

    public String getName() {
        return name;}
    public void setName(String name) {
        this.name = name;}

    public String getEmail() {
        return email;}
    public void setEmail(String email) {
        this.email = email;}

    public long getAge() {
        return age;}
    public void setAge(long age) {
        this.age = age;}

    public String getPassword() {
        return password;}
    public void setPassword(String password) {
        this.password = password;}

    public List<Pokemon> getMyTeam() {
        return myTeam;}
    public void setMyTeam(List<Pokemon> myTeam) {
        this.myTeam = myTeam;}

    public List<Pokemon> getStoragedPokemons() {
        return storagedPokemons;}
    public void setStoragedPokemons(List<Pokemon> storagedPokemons) {
        this.storagedPokemons = storagedPokemons;}


    @Override
    public String toString(){
        return "I am a trainer and my name is "+this.name+"!";
    }
}