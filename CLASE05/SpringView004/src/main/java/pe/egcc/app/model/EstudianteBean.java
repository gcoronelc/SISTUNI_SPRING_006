package pe.egcc.app.model;

/**
 * 
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 *
 */
public class EstudianteBean {

  private String nombre;
  private int nota1;
  private int nota2;
  private int prom;
  private String condicion;

  public EstudianteBean() {
  }

  public EstudianteBean(String nombre, int nota1, int nota2, int prom) {
    super();
    this.nombre = nombre;
    this.nota1 = nota1;
    this.nota2 = nota2;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getNota1() {
    return nota1;
  }

  public void setNota1(int nota1) {
    this.nota1 = nota1;
  }

  public int getNota2() {
    return nota2;
  }

  public void setNota2(int nota2) {
    this.nota2 = nota2;
  }

  public int getProm() {
    return prom;
  }

  public void setProm(int prom) {
    this.prom = prom;
  }

  public String getCondicion() {
    return condicion;
  }
  
  public void setCondicion(String condicion) {
    this.condicion = condicion;
  }
  
}
