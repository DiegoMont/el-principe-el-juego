public abstract class Premio {
  private String nombre;

  public Premio(String nombre){
    this.nombre = nombre;
  }

  public abstract void aplicarA(PersonajePrincipal jugador);

  public String getNombre(){
    return nombre;
  }
}
