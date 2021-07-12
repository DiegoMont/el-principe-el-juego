public class Villano extends Personaje{

  private static final int INCREMENTO_DE_ENERGIA = 10;

  public Villano(String nombre, String nombreAtaqueEspecial){
    super(nombre, 25);
    AtaqueEspecial ataqueEspecial = new AtaqueEspecial(nombreAtaqueEspecial);
    this.setAtaqueEspecial(ataqueEspecial);
  }

  public Villano(String nombre, String nombreAtaqueEspecial, int energiaInicial){
    super(nombre, energiaInicial);
    AtaqueEspecial ataqueEspecial = new AtaqueEspecial(nombreAtaqueEspecial);
    this.setAtaqueEspecial(ataqueEspecial);
  }

  public void comenzarTurnoContra(Personaje oponente){
    Ataque ataqueARealizar = elegirAtaqueDisponible();
    ataqueARealizar.atacar(this, oponente);
    modificarEnergia(INCREMENTO_DE_ENERGIA);
    System.out.print("Presiona enter para continuar:");
    sc.nextLine();
  }

  private Ataque elegirAtaqueDisponible(){
    double randomNumber = Math.random();
    boolean tieneEnergiaSuficiente = this.getAtaqueEspecial().getEnergiaRequerida() <= this.getEnergia();
    if(randomNumber > 0.5 && tieneEnergiaSuficiente){
      System.out.println(getNombre() + " ha atacado con " + getAtaqueEspecial().getNombre());
      return getAtaqueEspecial();
    } else 
      return getAtaquePrincipal();
  }

}
