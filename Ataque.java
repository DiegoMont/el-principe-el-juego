public class Ataque {
  private int energiaRequerida;
  private int danio;

  public Ataque(int energiaRequerida, int danio){
    this.energiaRequerida = energiaRequerida;
    this.danio = danio;
  }

  public void atacar(Personaje atacante, Personaje victima){
    int energiaDisponible = atacante.getEnergia();
    if (energiaDisponible < energiaRequerida){
      System.out.println("El ataque falló\n");
      return;
    } else 
      realizarAtaque(atacante, victima);
  }

  public int getEnergiaRequerida(){
    return this.energiaRequerida;
  }

  public int getDanio(){
    return this.danio;
  }

  private void realizarAtaque(Personaje atacante, Personaje victima){
    victima.recibirDanio(danio);
    atacante.modificarEnergia(-energiaRequerida);
  }
}
