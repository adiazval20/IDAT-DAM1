class Aplicacion {

  public static void main(String[] args) {
    // System.out.println(retornarSaludo());
    Vehiculo miVehiculo = new Aeronave();
    // miVehiculo.mostrarKilometrosRecorridos();
    // miVehiculo.desplazarse("aire");
    Aeronave miAeronave = new Aeronave();
    miAeronave.mostrarKilometrosRecorridos();
    // miAeronave.volar();
  }

  public static String retornarSaludo() {
    String saludo = "Hola a todos!"; //0010001110010101010
    Integer numero = 6; //int, float, char, etc..
    return saludo;
  }
}
