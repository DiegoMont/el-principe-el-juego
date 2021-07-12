public class Grammy extends Premio{

  public Grammy(){
    super("Grammy");
  }

  public void aplicarA(PersonajePrincipal jugador){
    System.out.println("Utilizando un " + getNombre());
    System.out.println("Incrementando la energía de ataque\n");
    jugador.modificarEnergia(25);
  }
}
