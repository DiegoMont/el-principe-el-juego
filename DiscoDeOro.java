public class DiscoDeOro extends Premio{
  public DiscoDeOro(){
    super("Disco de Oro");
  }

  public void aplicarA(PersonajePrincipal jugador){
    System.out.println("Utilizando un " + getNombre());
    System.out.println("Restableciendo la vida\n");
    jugador.curar(Personaje.HP_MAXIMA);
  }
  
}
