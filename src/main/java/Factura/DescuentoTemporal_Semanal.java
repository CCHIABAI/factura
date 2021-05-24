/** 
 *
 * Programación Basica 2 - Comision 2900
 * @author Claudio J. CHIABAI <cchiabai@alumno.unlam.edu.ar>
 *
 **/


package Factura;

import java.time.DayOfWeek;

/**
 * 
 */
public class DescuentoTemporal_Semanal extends DescuentoTemporal {
    
    private DayOfWeek inicioDiaSemana; 
    private DayOfWeek finDiaSemana;   
    
    @Override
    public Boolean isAplicable()
    {
        return true;
    }
    
}
