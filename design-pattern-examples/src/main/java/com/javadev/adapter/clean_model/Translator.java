package com.javadev.adapter.clean_model;

public class Translator{
    private String name;
    private Player foreignNBAPlayer;
    public Translator(String name,Player foreignNBAPlayer){this.name = name;this.foreignNBAPlayer = foreignNBAPlayer;}
    public void translatorAttack(){
        foreignNBAPlayer.attack();
    }

}