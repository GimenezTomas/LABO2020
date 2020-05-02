package Ordendecompra;

public class OrdenDeCompra {
        //atributos
        private String fecha;
        private String cliente;
        private String hora;
        private String forma_de_pago;
        private int imorte_a_pagar;
        private int Cantidad_total_de_productos;

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public String getCliente() {
            return cliente;
        }

        public void setCliente(String cliente) {
            this.cliente = cliente;
        }

        public String getHora() {
            return hora;
        }

        public void setHora(String hora) {
            this.hora = hora;
        }

        public int getImorte_a_pagar() {
            return imorte_a_pagar;
        }

        public void setImorte_a_pagar(int imorte_a_pagar) {
            this.imorte_a_pagar = imorte_a_pagar;
        }

        public String getForma_de_pago() {
            return forma_de_pago;
        }

        public void setForma_de_pago(String forma_de_pago) {
            this.forma_de_pago = forma_de_pago;
        }

        public int getCantidad_total_de_productos() {
            return Cantidad_total_de_productos;
        }

        public void setCantidad_total_de_productos(int cantidad_total_de_productos) {
            Cantidad_total_de_productos = cantidad_total_de_productos;
        }

        public boolean cantidadmenor(int Cantidad_total_de_productos) {
            boolean CantidadVoF = true;
            if (Cantidad_total_de_productos < 25) {
                CantidadVoF = true;
                return CantidadVoF;
            } else {
                CantidadVoF = false;
                return CantidadVoF;
            }
        }

        public void efectivoSioNo(String forma_de_pago) {
            if (forma_de_pago == "Efectivo") {
                System.out.println("Si pagara en efectivo");
            } else {
                System.out.println("No pagara en efectivo");
            }
        }
    }

