package ordendecompra;

public class Main {

    public static void main(String[] args) {
        OrdenDeCompra Ord1 = new OrdenDeCompra();
        Ord1.setCantidad_total_de_productos(10);
        Ord1.setCliente("Mariano Pavone");
        Ord1.setFecha("9/12/18");
        Ord1.setForma_de_pago("Efectivo");
        Ord1.setImorte_a_pagar(5040);
        Ord1.setHora("22:00");
        System.out.println("booleana: "+Ord1.cantidadmenor(Ord1.getCantidad_total_de_productos()));
        Ord1.efectivoSioNo(Ord1.getForma_de_pago());
    }
}
