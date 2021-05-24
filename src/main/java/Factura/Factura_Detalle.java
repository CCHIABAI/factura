/**
 *
 * Programación Basica 2 - Comision 2900
 *
 * @author Claudio J. CHIABAI <cchiabai@alumno.unlam.edu.ar>
 *
 *
 */
package Factura;

/**
 * Detalle de articulo en la factura.
 */
public class Factura_Detalle
{

    public Articulo articulo;
    public Integer cantidad = 1;

    public Factura_Detalle(Articulo arcticulo)
    {
        this.articulo = arcticulo;
    }

    public Articulo getArticulo()
    {
        return articulo;
    }

    public Integer getCantidad()
    {
        return cantidad;
    }

    public void incCantidad()
    {
        cantidad += 1;
    }

    public void decCantidad()
    {
        cantidad -= 1;
        if (cantidad < 0) cantidad = 0;
    }

    public Double getTotal()
    {
        return articulo.getPrecioBase() * getCantidad();
    }
}
