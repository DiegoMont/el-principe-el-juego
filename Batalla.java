import java.util.Random;

public class Batalla {
  private PersonajePrincipal jugador;
  private Villano enemigo;

  private static final int NUM_MAXIMO_PREMIOS = 3;

  private static final String introTemplate = "Una batalla entre %s y %s ha comenzado\n";

  public Batalla(PersonajePrincipal jugador, Villano enemigo){
    this.jugador = jugador;
    this.enemigo = enemigo;
  }

  public void comenzar(){
    System.out.println(String.format(introTemplate, jugador.getNombre(), enemigo.getNombre()));
    while(jugador.sigueVivo()){
      System.out.println("//////////////////////////////");
      System.out.println(jugador.toString());
      jugador.comenzarTurnoContra(enemigo);
      if(enemigo.sigueVivo()){
        System.out.println(enemigo.toString());
        enemigo.comenzarTurnoContra(jugador);
      }
      else{
        System.out.println("\nHas derrotado a " + enemigo.getNombre() + "\n");
        darPremios();
        break;
      }
        System.out.println("//////////////////////////////");
    }
  }

  private void darPremios(){
    Random rand = new Random();
    int numGrammys = rand.nextInt(NUM_MAXIMO_PREMIOS);
    int numDiscos = NUM_MAXIMO_PREMIOS - numGrammys;
    for(; numGrammys > 0; numGrammys--)
      jugador.recibirPremio(new Grammy());
    for(; numDiscos > 0; numDiscos--)
      jugador.recibirPremio(new DiscoDeOro());
  }
  
}
