package br.ufc.qx.pokemon.pokebola;

import br.ufc.qx.pokemon.Pokemon;

public class Pokebola {
    private final String nome;
    private final double taxaBase;


    public Pokebola(){
        this.nome = "Pokebola";
        this.taxaBase = 0.4;
    }
    protected Pokebola(String nome, double taxaBase) {
        this.nome = nome;
        this.taxaBase = taxaBase;
    }
    public String getNome() {
        return nome;
    }
    public double getTaxaDeCaptura(Pokemon pokemon) {
        return taxaBase-taxaBase*(pokemon.getNivel()/Pokemon.NIVEL_MAXIMO)+0.05;
    }
    public boolean capturar(Pokemon pokemon) {
        double taxaDeCaptura = getTaxaDeCaptura(pokemon);
        double chance = Math.random();
        return chance <= taxaDeCaptura;
    }
}