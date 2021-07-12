import java.util.Scanner;

public abstract class Personaje {
  private String nombre;
  private int hp;
  private int energia;
  public static Scanner sc;

  private Ataque ataquePrincipal;
  private AtaqueEspecial ataqueEspecial;

  public static final int ENERGIA_MAXIMA = 50;
  public static final int HP_MAXIMA = 100;
  public static final int ENERGIA_MINIMA = 0;
  public static final int HP_MINIMA = 0;

  public Personaje(String nombre, int energiaInicial){
    this.nombre = nombre;
    this.hp = HP_MAXIMA;
    this.energia = energiaInicial;
    this.ataquePrincipal = new Ataque(0, 25);
  }

  public abstract void comenzarTurnoContra(Personaje oponente);

  public String getNombre(){
    return nombre;
  }

  public int getHP(){
    return hp;
  }

  public boolean sigueVivo(){
    return this.getHP() > HP_MINIMA;
  }
  
  public void recibirDanio(int danio){
    hp -= danio;
    if(hp < HP_MINIMA)
      hp = HP_MINIMA;
  }

  public void curar(int vida){
    hp += vida;
    if(hp > HP_MAXIMA)
      hp = HP_MAXIMA;
  }

  public int getEnergia(){
    return energia;
  }

  public void modificarEnergia(int aumento){
    energia += aumento;
    if(energia < ENERGIA_MINIMA)
      energia = ENERGIA_MINIMA;
    else if(energia > ENERGIA_MAXIMA)
      energia = ENERGIA_MAXIMA;
  }

  public Ataque getAtaquePrincipal(){
    return this.ataquePrincipal;
  }

  public AtaqueEspecial getAtaqueEspecial(){
    return this.ataqueEspecial;
  }

  public void setAtaqueEspecial(AtaqueEspecial ataque){
    this.ataqueEspecial = ataque;
  }

  public String toString(){
    return String.format("**********\n%s:\nHP: %d/%d\nEnergia: %d/%d", nombre, hp, HP_MAXIMA, energia, ENERGIA_MAXIMA) + "\n**********\n";
  }
}
