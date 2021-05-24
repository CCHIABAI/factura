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
public class Perfume extends Articulo {


    public Perfume(String descripcion, Double precioNeto)
    {
        super(descripcion, precioNeto);
        setProducto("Perfume");
        setImpuesto(20.0);

    }

}
