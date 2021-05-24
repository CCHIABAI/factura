/** 
 *
 * Programación Basica 2 - Comision 2900
 * @author Claudio J. CHIABAI <cchiabai@alumno.unlam.edu.ar>
 *
 **/


package Factura;

/**
 * 
 */
public class Bebida extends Articulo {

    public Bebida(String descripcion, Double precioNeto)
    {
        super(descripcion, precioNeto);
        setProducto("Bebida");
        setImpuesto(15.0);
    }

     
    
}
