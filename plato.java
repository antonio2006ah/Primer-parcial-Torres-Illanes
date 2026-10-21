public  class plato {
    private String nombre;
    private double precio;

    public plato(String nombre, double precio) {
        this.nombre = nombre;
        if (precio < 0) {
            this.precio = 0;
        } else {
            this.precio = precio;
        }
    }

    public String getnombre() {
        return nombre;
    }

    public double getprecio() {
        return precio;
    }
}