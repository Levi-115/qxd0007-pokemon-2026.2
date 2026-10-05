package br.ufc.qx.pokemon;

import java.util.Arrays;
import java.util.List;

import br.ufc.qx.pokemon.mapa.Posicao;

public class Treinador {
  
  private static final int MAX_POKEBOLAS= 20;
  private static final int MAX_POKEMONS = 6;

  private final String nome;
  private Posicao posicao;
  private final Pokemon[] pokemons;
  private int qtdPokemons;
  private final Pokebola[] pokebolas;
  private int qtdPokebolas;

  public Treinador(String nome) {
    this.nome = nome;
    this.posicao = new Posicao(0, 0);
    this.pokemons = new Pokemon[MAX_POKEMONS];
    this.pokebolas = new Pokebola[MAX_POKEBOLAS];
  }

  public String getNome() {
    return nome;
  }

  public Posicao getPosicao() {
    return posicao;
  }

  public void moverPara(Posicao destino) {
    this.posicao = destino;
  }

  public List<Pokemon> getPokemons() {
    return List.copyOf(Arrays.asList(pokemons).subList(0, qtdPokemons));
  }

  public boolean capturar(Pokemon pokemon) {
    if (qtdPokemons < pokemons.length) {
      pokemons[qtdPokemons++] = pokemon;
      return true;
    }
    return false;
  }
  public boolean adicionarPokebola(Pokebola pokebola) {
    if (pokebola == null) {
      return false;
    }
    if (qtdPokebolas < MAX_POKEBOLAS) {
      pokebolas[qtdPokebolas++] = pokebola;
      return true;
    }
    return false;
  }
  public boolean temPokebolas(Pokebola pokebola) {
    if (pokebola == null) {
      return false;
    }
    for (int i = 0; i < qtdPokebolas; i++) {
      if (pokebolas[i].equals(pokebola)) {
        return true;
      }
    }
    return false;
  }

  public Pokebola arremessarPokebola(Pokebola pokebola) {
  
    if (temPokebolas(pokebola)) {
      for (int i = 0; i < qtdPokebolas; i++) {
        if (pokebolas[i].equals(pokebola)) {
          Pokebola arremessada = pokebolas[i];
          for (int j = i; j < qtdPokebolas - 1; j++) {
            pokebolas[j] = pokebolas[j + 1];
          }
          pokebolas[--qtdPokebolas] = null;
          return arremessada;
        }
      }
    }
    return null;
  }
}
