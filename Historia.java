import java.util.Scanner;

public class Historia {
  public static Scanner sc;

  public static void imprimirIntro(){
    System.out.println("\n##############################");
    System.out.println("          EL PRINCIPE         \n");
    System.out.println("Ayuda a nuestro Principe de la");
    System.out.println("cancion a derrotar a la malvada");
    System.out.println("Sarita, que quiere quitarnos");
    System.out.println("toda su musica.\n");
    System.out.println("Enfrenta a los tres villanos");
    System.out.println("para encontrar pistas del paradero");
    System.out.println("de Sarita");
    System.out.println("Muchas suerte!");
    System.out.println("##############################\n");
    System.out.print("Presiona enter para continuar: ");
    sc.nextLine();
  }

  public static void imprimirPreJefe(){
    System.out.println("\n##############################\n");
    System.out.println("Ahora que derrotaste a todos los");
    System.out.println("villanos, podremos encontrar a");
    System.out.println("Sarita y regresarle su gran voz");
    System.out.println("a nuestro Principe");
    System.out.println("##############################\n");
    System.out.print("Presiona enter para continuar: ");
    sc.nextLine();
  }

  public static void gameOver(){
    System.out.println("\n##############################");
    System.out.println("NO HAS PODIDO DERROTAR AL JEFE\n");
    System.out.println("Sigue intentando ayudar a nuestro");
    System.out.println("principe.\n");
    System.out.println("Yo he rodado de aca, para alla");
    System.out.println("Fui de todo y sin medida...");
    System.out.println("##############################\n");
  }

  public static void juegoTerminado(){
    System.out.println("\n##############################");
    System.out.println("FELICIDADES LIBERASTE AL PRINCIPE\n");
    System.out.println("Gracias a tu ayuda, podra seguir");
    System.out.println("deleitandonos con su voz.\n");
    System.out.println("Que triste, fue decirnos adios");
    System.out.println("Cuando nos adorabamos mas");
    System.out.println("Hasta la golondrina emigro...");
    System.out.println("##############################\n");
  }
}
