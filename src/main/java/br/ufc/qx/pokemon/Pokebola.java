package br.ufc.qx.pokemon;

public class Pokebola {
    private final String nome;
    private double taxaBase;


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
    public double getTaxaDeCaptura() {
        return taxaBase-taxaBase*(Pokemon.getNivel()/Pokemon.NIVEL_MAXIMO)+0.05;
    }
}