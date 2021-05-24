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
import java.util.Iterator;

/**
 *
 */
public class Factura
{

    // ELEMENTOS DE LA FACTURA ===============================
    private ArrayList<Factura_Detalle> detalles;
    private ArrayList<Factura_Impuesto> impuestos;
    private ArrayList<Descuento> descuentos;

    // SubTotales =================================
    private Double subTotalArticulos;
    private Double subTotalImpuesto;
    private Double subTotalDescuentos;

    public Factura()
    {
        detalles = new ArrayList<Factura_Detalle>();
        impuestos = new ArrayList<Factura_Impuesto>();
        descuentos = new ArrayList<Descuento>();
    }

    // Articulos =========================================================
    // Agregar un articulo y generar la linea de detalle --------
    public void add(Articulo articulo)
    {
        Boolean found = false;

        // Buscar si esta ingresado 
        for (Iterator<Factura_Detalle> iterator = detalles.iterator(); iterator.hasNext();)
          {
            Factura_Detalle next = iterator.next();

            if ((next.getArticulo().getDescripcion().equals(articulo.getDescripcion())) && !found)
              {
                next.incCantidad(); // Incrementar en uno la cantidad de la linea.
                found = true;
              }
          }

        // Si no esta ingresado, agregar la linea de detalle correspondiente
        if (!found) detalles.add(new Factura_Detalle(articulo));
    }

    // Remover un articulo de la lina de detalle ==================================
    public void remove(Articulo articulo)
    {
        // Buscar si esta ingresado 
        for (Iterator<Factura_Detalle> iterator = detalles.iterator(); iterator.hasNext();)
          {
            Factura_Detalle next = iterator.next();

            if (next.getArticulo().getDescripcion().equals(articulo.getDescripcion()))
              {
                next.decCantidad(); // Incrementar en uno la cantidad de la linea.
                if (next.getCantidad() == 0) detalles.remove(next); // Si es cero la cantidad eliminar la linea de detalle 
                return;
              }
          }
    }

    // Descuentos ======================================================
    public void addDescuento(Descuento descuento)
    {
       descuentos.add(descuento);
    }

    // SALIDA =================================
    @Override
    public String toString()
    {
        String output = "";
        // Detalle de la compra -------------------------
        impuestos.clear(); // Limpiar las lineas de impuestos
        subTotalArticulos = 0.0;
        subTotalImpuesto = 0.0;
        subTotalDescuentos = 0.0;

        if (this.detalles.size() != 0)
          {
            output += toStringArticulos();
            if (this.impuestos.size() != 0) output += toStringImpuestos();
            //if (this.descuentos.size() != 0) 
                output += toStringDescuentos();
          }

        // Total de la compra ---------------------------
        return output;
    }

    // ARTICULOS -----------------------------------------------------
    private String toStringArticulos()
    {
        String output = "Descripcion                Cant. X     Precio =        SubTotal\n";

        // Recorrer el listado de detalle de articulos ------------------------
        for (Factura_Detalle detalle : detalles)
          {
            subTotalArticulos += detalle.getTotal();

            // Armar linea detalle -------------------------
            output += String.format("%-27s", detalle.getArticulo().getDescripcion());
            //result += String.format(" --> %-8s", next.getArticulo().getClase());

            output += String.format("%5d", detalle.getCantidad());
            output += " x ";
            output += String.format("%10.2f", detalle.getArticulo().getPrecioBase());
            output += " = ";
            output += String.format("%15.2f", detalle.getTotal());
            output += "\n";
            // ---------------------------------------------

            addImpuesto(detalle); // Cargar impuesto para la clase de articulo 
          }

        // Total articulos/ compra --------------------------------------
        output += "\n***** SubTotal compra --> " + subTotalArticulos + " *****\n";

        return output;
    }

    // Calcular el monto de impuestos a partir del detalle  ------------------------
    private void addImpuesto(Factura_Detalle detalle)
    {
        Boolean found = false;

        // Recorrer los impuestos recogidos del listado ---------------------
        for (Factura_Impuesto impuesto : impuestos)
          {
            if ((impuesto.getProducto().equals(detalle.getArticulo().getProducto()) // Buscar por clase de articulo
                    && (detalle.getArticulo().hasImpuesto()))) // Que tenga impuesto agregado.
              {
                // Incrementar los valores en el impuesto encontrado.
                impuesto.incTotal(detalle.getArticulo().getMontoImpuesto(), detalle.getCantidad());
                found = true;
              }
          }

        // Agregar nuevos impuesto detectado ---------------------
        if (!found && detalle.getArticulo().hasImpuesto())
          {
            impuestos.add(
                    new Factura_Impuesto(detalle.getArticulo().getProducto(),
                            detalle.getArticulo().getImpuesto(),
                            detalle.getArticulo().getMontoImpuesto()));
          }
    }

    // Mostrar monto impuestos 
    private String toStringImpuestos()
    {
        String output = "";
        // Mostrar lineas impuestos ++++++++++++++++++++++++++++++++++++
        if (impuestos.size() > 0)
          {
            // Cabecera ------------
            output += "\n -= Impuestos =-------------------------\n";
            output += "Producto             Imp.%                Monto\n";

            for (Factura_Impuesto impuesto : impuestos)
              {
                output += String.format("(%5d) ", impuesto.getCantidad());
                output += String.format("%-12s", impuesto.getProducto());
                output += String.format("%3.2f", impuesto.getImpuesto()) + "% ";
                output += String.format("%20.2f", impuesto.getTotal()) + "\n";

                subTotalImpuesto += impuesto.getTotal();
              }
            
            // SubTotal --------------------------------------  
            output += "\n***** Total Impuestos ----> " + subTotalImpuesto + " *****\n";
          }
        
        return output;
    }

    // Calcular monto de descuentos -------------------------------------------
    private String toStringDescuentos()
    {
        subTotalDescuentos = 0.0;
        Double montoDescuento = 0.0; 
        String output = ""; 
        ArrayList listaItems = (ArrayList) detalles.clone();
        
        for (Descuento descuento : descuentos)
          {
            if (descuento.isAplicableTemporalmente())
              {
                 montoDescuento += descuento.aplicar(listaItems);
                 subTotalDescuentos += montoDescuento;
                 output += descuento.getDescripcion() + " --> " + montoDescuento;
              }
          }

        return output;
    }

}
