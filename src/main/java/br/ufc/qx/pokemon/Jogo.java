package br.ufc.qx.pokemon;

import br.ufc.qx.pokemon.mapa.Mapa;
import br.ufc.qx.pokemon.mapa.Posicao;
import br.ufc.qx.pokemon.pokebola.Pokebola;
public class Jogo {

  private static final int LARGURA_MAPA = 10;
  private static final int ALTURA_MAPA = 5;

  private final Treinador treinador;
  private final Mapa mapa;
  private final GeradorDePokemon geradorPokemon;
  public Jogo(String nome) {
    treinador = new Treinador(nome);
    for (int i = 0; i < 10; i++) {
      treinador.adicionarPokebola(new Pokebola());
    }
    mapa = new Mapa(LARGURA_MAPA, ALTURA_MAPA);
    geradorPokemon = new GeradorDePokemon();
  }

  public Treinador getTreinador() {
    return treinador;
  }

  public String renderizarMapa() {
    return mapa.renderizar(treinador.getPosicao());
  }

  public void mover(Direcao direcao) {
    Posicao destino = direcao.aplicarEm(treinador.getPosicao());
    if (mapa.ePosicaoValida(destino)) {
      treinador.moverPara(destino);
    }
  }
  public boolean encontrouPokemon(Posicao posicao) {
    return mapa.ePosicaoValida(posicao) && Math.random() < 0.2;
  }
}