public class AtaqueEspecial extends Ataque{
  private String nombre;
  public AtaqueEspecial(String nombre){
    super(30, 40);
    this.nombre = nombre;
  }

  public String getNombre() {
    return this.nombre;
  }
}
