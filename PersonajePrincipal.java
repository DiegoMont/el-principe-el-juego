import java.util.ArrayList;

public class PersonajePrincipal extends Personaje{
  private ArrayList<Premio> inventario;

  public static final int INCREMENTO_DE_ENERGIA = 15;

  private static final int OPCION_INVENTARIO = 1;
  private static final int OPCION_ATAQUE_PRINCIPAL = 2;
  private static final int OPCION_ATAQUE_ESPECIAL = 3;

  public PersonajePrincipal(String nombre){
    super(nombre, Personaje.ENERGIA_MAXIMA);
    AtaqueEspecial ataqueEspecial = new AtaqueEspecial("La Nave del Olvido");
    this.setAtaqueEspecial(ataqueEspecial);
    this.inventario = new ArrayList<>();
  }

  public void comenzarTurnoContra(Personaje oponente){
    int seleccion = 0;
    while(seleccion != OPCION_ATAQUE_ESPECIAL && seleccion != OPCION_ATAQUE_PRINCIPAL){
      imprimirMenu();
      seleccion = Integer.parseInt(sc.nextLine());
      if(seleccion == OPCION_INVENTARIO)
        abrirInventario();
      else if(seleccion == OPCION_ATAQUE_PRINCIPAL)
        getAtaquePrincipal().atacar(this, oponente);
      else if(seleccion == OPCION_ATAQUE_ESPECIAL){
        String descripcionAtaque = getNombre() + " ha atacado con " + getAtaqueEspecial().getNombre();
        System.out.println(descripcionAtaque);
        getAtaqueEspecial().atacar(this, oponente);
      } else
        System.out.println("Opcion no disponible");
    }
    modificarEnergia(INCREMENTO_DE_ENERGIA);
  }

  private void imprimirMenu(){
    System.out.println("\n#############");
    System.out.println(OPCION_INVENTARIO + ". Ver inventario");
    System.out.println(OPCION_ATAQUE_PRINCIPAL + ". Usar ataque principal");
    if(this.getEnergia() >= getAtaqueEspecial().getEnergiaRequerida())
      System.out.println(OPCION_ATAQUE_ESPECIAL + ". Usar ataque especial");
    System.out.print("Ingresa una opcion: ");
  }

  private ArrayList<Premio> getInventario(){
    return inventario;
  }

  public void recibirPremio(Premio premio){
    inventario.add(premio);
  }

  private void abrirInventario(){
    int seleccion = -1;
    while(true){
      imprimirInventario();
      seleccion = Integer.parseInt(sc.nextLine());
      if (getInventario().size()+1 == seleccion)
        break;
      usarObjetoDeInventario(seleccion-1);
    }
  }

  private void imprimirInventario(){
    System.out.println("\n#####################################");
    System.out.println("Premios disponibles en tu inventario:");
    int n = inventario.size();
    int i;
    for (i = 1; i <= n; i++) {
      Premio p = getInventario().get(i-1);
      System.out.println(i + ". " + p.getNombre());
    }
    System.out.println(i + ". Salir del inventario");
    System.out.print("Ingresa un numero: ");
  }

  private void usarObjetoDeInventario(int indice){
    int lengthInventario = getInventario().size();
    if (indice > -1 && indice < lengthInventario) {
      Premio p = getInventario().remove(indice);
      p.aplicarA(this);
    }
  }
}
