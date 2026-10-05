package br.ufc.qx.pokemon;

public class MasterBall extends Pokebola {
    public MasterBall() {
        super("Master Ball", 1.0);
    }
    @Override
    public boolean capturar(Pokemon pokemon) {
        return true;
    }
}