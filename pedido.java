import java.util.Scanner;
public class pedido {
    private int numeroMesa;
    private plato plato1;
    private plato plato2;
    private plato plato3;
    private int cantidadDePlatos;
    private boolean cerrado;

    public pedido(int numeroMesa) {
        this.numeroMesa = numeroMesa;
        this.plato1 = null;
        this.plato2 = null;
        this.plato3 = null;
        this.cantidadDePlatos = 0;
        this.cerrado = false;
    }
    public int getnumeroMesa() {
        return numeroMesa;
    }

    public void agregarPlato(plato p) {
        if (cerrado) {
            System.out.println("Error: El pedido esta cerrado.");
            return;
        }
        if (p == null) {
            System.out.println("Error: El plato no puede ser nulo.");
            return;
        }
        if (cantidadDePlatos >= 3) {
            System.out.println("Error: El pedido ya tiene 3 platos.");
            return;
        }

        if (plato1 == null) {
            plato1 = p;
        } else if (plato2 == null) {
            plato2 = p;
        } else if (plato3 == null) {
            plato3 = p;
        }

        cantidadDePlatos++;
    }

    public double calcularTotal() {
        double total = 0;
        if (plato1 != null) total += plato1.getprecio();
        if (plato2 != null) total += plato2.getprecio();
        if (plato3 != null) total += plato3.getprecio();
        return total;
    }

    public void cerrarPedido() {
        this.cerrado = true;
        System.out.println("Total a pagar: " + calcularTotal());
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese numero de mesa: ");
        int mesa = scanner.nextInt();
        scanner.nextLine();

        pedido pedido = new pedido(mesa);

        for (int i = 1; i <= 3; i++) {
            System.out.print("Nombre del plato " + i + ": ");
            String nombre = scanner.nextLine();

            System.out.print("Precio del plato " + i + ": ");
            double precio = scanner.nextDouble();
            scanner.nextLine();

            plato plato = new plato(nombre, precio);
            pedido.agregarPlato(plato);
        }

        pedido.cerrarPedido();

        plato extra = new plato("Postre Extra", 500);
        pedido.agregarPlato(extra);

        scanner.close();
    }
}