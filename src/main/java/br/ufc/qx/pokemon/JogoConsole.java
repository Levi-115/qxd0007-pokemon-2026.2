package br.ufc.qx.pokemon;

import java.util.Scanner;


public class JogoConsole {

  private static final String COMANDO_SAIR = "sair";

  private final Jogo jogo;

  public JogoConsole(Jogo jogo) {
    this.jogo = jogo;
  }

  public void iniciar() {
    Scanner scanner = new Scanner(System.in);
    boolean sair = false;
    while (!sair) {
      System.out.print(jogo.renderizarMapa());
      System.out.println("Informe a direção para onde queres ir");
      String opcao = scanner.nextLine();
      if (opcao.equalsIgnoreCase(COMANDO_SAIR)) {
        sair = true;
      } else {
        if (Direcao.eDirecaoValida(opcao)) {
          jogo.mover(Direcao.get(opcao));
          if (jogo.encontrouPokemon(jogo.getTreinador().getPosicao())) {
            opcaoBatalha();
            Batalha batalha = jogo.iniciarBatalha();
            while(batalha.isEmAndamento()) {
              String acao = scanner.nextLine();
              if (acao.equalsIgnoreCase("F")) {
                batalha.fugir();
              } else if (acao.equalsIgnoreCase("P")) {
                opcaoCaptura();
                int escolha = scanner.nextInt();
                Pokebola pokebola = null;
                  switch (escolha) {
                      case 1 -> pokebola = new Pokebola();
                      case 2 -> pokebola = new GreatBall();
                      case 3 -> pokebola = new UltraBall();
                      case 4 -> pokebola = new MasterBall();
                      default -> System.out.println("Escolha inválida.");
                  }

                if (pokebola != null) {
                  boolean capturou = batalha.tentarCaptura(pokebola);
                  if (capturou) {
                    System.out.println("Você capturou o Pokémon!");
                  } else {
                    System.out.println("O Pokémon fugiu!");
                  }
                } else {
                  System.out.println("Você não tem Pokébolas!");
                }
              } else {
                System.out.println("Ação inválida. Digite 'F' para fugir ou 'P' para arremessar uma Pokébola.");
              }
            }
          }
        } else {
          System.out.println("Valor invalido");
        }
      }
    }
  }

  private void opcaoBatalha() {
    System.out.println("Você encontrou um Pokémon selvagem!");
    System.out.println("[F]ugir ou Arremessar [P]okebola?");
  }
  private void opcaoCaptura(){
    System.out.println("Escolha uma Pokébola para arremessar:");
    System.out.println("1. Pokébola, 2. Super Pokébola, 3. Ultra Pokébola, 4. Master Pokébola");
  }
}
