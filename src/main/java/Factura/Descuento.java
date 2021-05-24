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
 *
 */
public abstract class Descuento
{

    private String descripcion;
    // TODO : Propiedad peso para un ordenamiento (Peso/total)

    private DescuentoTemporal filtroTemporal; // TODO: Implementar más en detalle.

    // CONSTRUCTOR =========================================
    public Descuento(String descripcion)
    {
        filtroTemporal = new DescuentoTemporal();
        this.descripcion = descripcion;
    }

    // PROPIEDADES ===========================================
    public String getDescripcion()
    {
        return descripcion;
    }

    public DescuentoTemporal getFiltroTemporal()
    {
        return filtroTemporal;
    }

    public void setFiltroTemporal(DescuentoTemporal filtroTemporal)
    {
        this.filtroTemporal = filtroTemporal;
    }

    protected Boolean isAplicableTemporalmente()
    {
        return filtroTemporal.isAplicable();
    }

    // A IMPLEMENTAR ===========================================
    abstract Double aplicar(ArrayList<Factura_Detalle> detalles);

}
