package br.ufc.qx.pokemon;

public class Batalha {
    private final Treinador treinador;
    private final Pokemon pokemon;
    private boolean emAndamento;
    public Batalha(Treinador treinador, Pokemon pokemon) {
        this.treinador = treinador;
        this.pokemon = pokemon;
        this.emAndamento = true;
    }
    public boolean tentarCaptura(Pokebola pokebola) {
        if (pokebola.capturar(pokemon) && treinador.temPokebolas(pokebola)) {
            fugir();
            return treinador.capturar(pokemon);
        }
        return false;
    }
    public void fugir() {
        emAndamento = false;
    }
    public boolean isEmAndamento() {
        return emAndamento;
    }
}