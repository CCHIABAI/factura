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
public class Articulo
{

    private final Double IMPUESTO_BASE = 21.0; // 21 % IVA

    private String producto = "Articulo";
    private String descripcion;
    private Double precioNeto = 0.0;
    private Double impuesto = 0.0;

    // CONSTRUCTOR ==========================
    public Articulo(String descripcion, Double precioNeto)
    {
        this.descripcion = descripcion;
        setPrecioNeto(precioNeto);
    }

    // PROPIEDADES ==========================
    public String getProducto()
    {
        return producto;
    }

    protected void setProducto(String clase)
    {
        this.producto = clase;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    // Impuesto ===========================================
    protected void setImpuesto(Double impuesto)
    {
      this.impuesto = impuesto;
    }
    
    protected Double getImpuesto()
    {
        return impuesto;
    }
    
    public Boolean hasImpuesto()
    {
       return impuesto != 0.0;
    }        

    public Double getImpuestoBase()
    {
        return IMPUESTO_BASE;
    }

    private Double getMontoImpuesto(Double impuesto)
    {
        return getPrecioNeto() * impuesto / 100;
    }

    // PRECIO =====================================
    // PRecio Base (sin impuesto) -----------------------------
    public void setPrecioNeto(Double precioNeto)
    {
        this.precioNeto = Math.abs(precioNeto); // No precio negativo
    }

    public Double getPrecioNeto()
    {
        return precioNeto;
    }

    // Precio base (Neto mas impuesto base [IVA]) ------------------------------
    public Double getMontoImpuestoBase()
    {
        return getMontoImpuesto(IMPUESTO_BASE);
    }

    public Double getPrecioBase()
    {
        return getPrecioNeto() + getMontoImpuestoBase();
    }

    // Precio total a pagar (Precio base + Impuesto agregado) ----------------------------
    public Double getMontoImpuesto()
    {
        return getMontoImpuesto(getImpuesto());
    }

    public Double getPrecio()
    {
        return getPrecioBase() + getMontoImpuesto();
    }
}
