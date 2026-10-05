package br.ufc.qx.pokemon;


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
        return taxaBase-taxaBase*(pokemon.getNivel()*1.0/Pokemon.NIVEL_MAXIMO)+0.05;
    }
    public boolean capturar(Pokemon pokemon) {
        return Math.random() <= getTaxaDeCaptura(pokemon);
    }
}