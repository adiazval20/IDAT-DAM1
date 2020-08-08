class Aeronave extends Vehiculo {

  @Override
  public void desplazarse() {
    System.out.println("Nos estamos desplazando por el aire!");
  }

  public void volar() {
    System.out.println("Estamos volando!");
  }
}
