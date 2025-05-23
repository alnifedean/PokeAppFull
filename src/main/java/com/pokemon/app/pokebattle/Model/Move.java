package com.pokemon.app.pokebattle.Model;

public class Move {

    private long id;
    private String nameMove;
    private String typeMove;
    private int minLevel;

    public Move(){};

    public Move(String nameMove, String typeMove, int minLevel){
        this.nameMove=nameMove;
        this.typeMove =typeMove;
        this.minLevel=minLevel;
    };

    public long getId() {
        return id;}
    public void setId(long id) {
        this.id = id;}

    public String getNameMove() {
        return nameMove;}
    public void setNameMove(String nameMove) {
        this.nameMove = nameMove;}

    public String getTypeMove() {
        return typeMove;}
    public void setTypeMove(String typeMove) {
        this.typeMove = typeMove;}

    public int getMinLevel() {
        return minLevel;}
    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;}

    @Override
    public String toString(){
        return "This attack/move is type "+typeMove+" and the min level is "+minLevel;
    }
}
