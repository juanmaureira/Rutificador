/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rutificadorinterface;

/**
 *
 * @author juaneduardomaureirallanos
 */

public class dniUtils {
  // Defino los atributos de la clase
    private String dni;     // Crea atributo dni de clase String
    private String name;    // Crea atributo name de la clase String
    private int edad;       // Crea atributo edad de la clase int
    
    /**
     * 
     * @param dni
     * @return boolean true/false
     * 
     * @Definicion
     * Devuelve verdadero si el digito verificador del R.U.T chileno 
     * fue ingresado correctamente, de lo contrario, devuelve false
     */
    public String Modulo11( String dni ){         // Paso el argumento dni
        dni = dni.replace(".", "");
        String temp;
        char[] strToCharDni;
        int suma=0;
        int dvCalculado;
        String dv=null;
        int[] charToIntDni = new int[dni.length()];
        
        strToCharDni = dni.toCharArray();
        
        for(int i=0; i<strToCharDni.length;i++)
             charToIntDni[strToCharDni.length - (i+1)]=(int)(strToCharDni[i] - 48);
        
        for(int i=0,j=2;i<charToIntDni.length;i++,j++){
            suma+=charToIntDni[i]*j;
            if(j==7) j=1; 
        }
        
        dvCalculado = 11 - suma%11;
        
        dv = Integer.toString(dvCalculado);
        
        if(dvCalculado == 10) 
            dv = "K";
        
        if(dvCalculado == 11) 
            dv = "0";
        
        return dv;
        
    }  
}
