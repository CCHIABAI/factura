/**
 *
 * Programación Basica 2 - Comision 2900
 *
 * @author Claudio J. CHIABAI <cchiabai@alumno.unlam.edu.ar>
 *
 *
 */
package Factura;

import java.util.ArrayList;

/**
 * Clase solo para contener una linea de datos.
 */
public class Descuento_Articulo extends Descuento
{
    private String articulo;
    private Double porcentaje;

    // CONSTRUCTOR ==============================
    public Descuento_Articulo(String descripcion, String articulo, Double porcentaje)
    {
        super(descripcion);
        this.articulo = articulo.trim();
        this.porcentaje = porcentaje;
    }

    // PROPIEDADES ==============================
   
    public Double aplicar(ArrayList<Factura_Detalle> detalles)
    {
        Double monto = 0.0;
        if (super.isAplicableTemporalmente())
          {
              for (Factura_Detalle detalle : detalles)
                {
                  if (detalle.getArticulo().getDescripcion().equals(articulo) )
                    {
                      monto += detalle.articulo.getPrecio();
                      detalle.decCantidad();
                    }
                }
          }
        
        return monto;
    }

}
