/** 
 *
 * Programación Basica 2 - Comision 2900
 * @author Claudio J. CHIABAI <cchiabai@alumno.unlam.edu.ar>
 *
 **/


package Factura;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Date;

/**
 * 
 * @author claudio
 */
public class DescuentoTemporal {

    
    /* public enum TipoTemporal { Libre, Especifico, Semanal, Diario };
    private TipoTemporal limiteTemporal = TipoTemporal.Libre;
    
    private Date inicioDia; private LocalTime inicioHora;
    private Date finDia; private LocalTime finHora;
    private DayOfWeek inicioDiaSemana; private DayOfWeek finDiaSemana;     */
    
   
    protected Boolean isAplicable()
    {
      return true;
    }
    
}
