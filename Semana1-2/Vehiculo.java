class Vehiculo implements Desplazamiento {

  public void desplazarse() {
    System.out.println("Nos estamos desplazando");
  }

  public void desplazarse(String medio) {
    System.out.println("Nos estamos desplazando por el " + medio);
  }

  @Override
  public void mostrarKilometrosRecorridos() {
    System.out.println("Vamos recorriendo X kilómetros");
  }
}
