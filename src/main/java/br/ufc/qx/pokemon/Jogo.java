package br.ufc.qx.pokemon;

import br.ufc.qx.pokemon.mapa.Mapa;
import br.ufc.qx.pokemon.mapa.Posicao;
public class Jogo {

  private static final int LARGURA_MAPA = 10;
  private static final int ALTURA_MAPA = 5;
  private static final GeradorDePokemon geradorPokemon = new GeradorDePokemon();

  private final Treinador treinador;
  private final Mapa mapa;
  
  public Jogo(String nome) {
    treinador = new Treinador(nome);
    for (int i = 0; i < 10; i++) {
      treinador.adicionarPokebola(new Pokebola());
    }
    mapa = new Mapa(LARGURA_MAPA, ALTURA_MAPA);
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
    return mapa.temPokemon(posicao);
  }
  public Batalha iniciarBatalha() {
    return new Batalha(treinador, geradorPokemon.gerar());
  }
}