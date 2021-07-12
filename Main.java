import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  private static Scanner sc;
  private static PersonajePrincipal jugador;
  private static LinkedList<Villano> villanos;
  private static Villano jefe;
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    Personaje.sc = sc;
    Historia.sc = sc;
    crearPersonajePrincipal();
    crearVillanos();
    Historia.imprimirIntro();
    for (Villano villano : villanos) {
      System.out.println("*********************************");
      System.out.println("* Te has encontrado con " + villano.getNombre() + " *");
      System.out.println("*********************************\n");
      Batalla batalla = new Batalla(jugador, villano);
      batalla.comenzar();
      if(!jugador.sigueVivo()){
        System.out.println("No has podido derrotar a los villanos");
        System.out.println("Mejor suerte en la proxima");
        return;
      }
    }

    Historia.imprimirPreJefe();
    crearJefe();
    Batalla batallaFinal = new Batalla(jugador, jefe);
    batallaFinal.comenzar();
    if(jugador.sigueVivo())
      Historia.juegoTerminado();
    else
      Historia.gameOver();
  }

  private static void crearPersonajePrincipal(){
    System.out.print("Elige un nombre para tu personaje: ");
    String nombre = sc.nextLine();
    jugador = new PersonajePrincipal(nombre);
  }

  private static void crearVillanos(){
    Villano disquera = new Villano("La Disquera", "Un Contrato Limitante");
    Villano medios = new Villano("Revistas de Chismes", "Criticas del Playback");
    Villano alcohol = new Villano("Alcohol", "Una Cubaby Pintadita");
    villanos = new LinkedList<>();
    villanos.add(disquera);
    villanos.add(medios);
    villanos.add(alcohol);
    Collections.shuffle(villanos);
  }

  private static void crearJefe(){
    jefe = new Villano("Sarita Sosa", "Testamento Falso", 40);
  }

}
