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
 *
 */
class Factura_Impuesto
{

    private String producto;
    private Double impuesto;
    private Integer cantidadArticulos = 1;
    private Double total = 0.0;

    public Factura_Impuesto(String claseProducto, Double impuesto, Double montoInicial)
    {
        this.producto = claseProducto;
        this.impuesto = impuesto;
        this.total = montoInicial;
    }

    // PROPIEDADES =======================================
    public String getProducto()
    {
        return producto;
    }

    public Double getImpuesto()
    {
        return impuesto;
    }

    public Double getTotal()
    {
        return total;
    }

    public Integer getCantidad()
    {
        return cantidadArticulos;
    }

    // Metodos =========================================
    public void incTotal(Double monto, Integer cantidad)
    {
        this.total += monto;
        this.cantidadArticulos += cantidad;
    }

}
