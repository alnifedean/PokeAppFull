package com.pokemon.app.pokebattle.Model;

public class User {

    private long id;
    private String userName;
    private String name;
    private String email;
    private long age;
    private String password;

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

    @Override
    public String toString(){
        return "I am a trainer and my name is "+this.name+"!";
    }
}