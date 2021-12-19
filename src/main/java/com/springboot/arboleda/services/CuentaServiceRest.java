package com.springboot.arboleda.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.arboleda.model.Cuenta;
import com.springboot.arboleda.model.Persona;



@RestController
public class CuentaServiceRest {
	Scanner sc = new Scanner(System.in);
	
	//Por sencillez se ha comenzado a realizar operaciones entre cuentas de un solo usuario.
	private static List<Cuenta> listaCuentas = new ArrayList<Cuenta>() {
        {
            add(new Cuenta(01, "CUENTAABC",500.50));
            add(new Cuenta(02, "CUENTADEF",600.70));
            add(new Cuenta(03, "CUENTAFGH",700.80));
        }
    };    
    
    private static Persona persona1 = new Persona("Salvador","Chava", listaCuentas);
    
    //Mediante este método se puede observar los datos de la persona.
    @RequestMapping(value="/persona", method=RequestMethod.GET)
    public Persona  getPersona(){
        return persona1;
    }
    
    //Mediante este método se pueden observar todas las cuentas y sus saldos.
    @RequestMapping(value="/cuentas", method=RequestMethod.GET)
    public List<Cuenta>  getCuentas(){
        return listaCuentas;
    }
    
    //Mediante este metodo se solicita la cuenta origen, destino, monto a transferir y se realiza la transaccion, mostrando el resultado de las cuentas.
    @RequestMapping(value="/transaccion", method=RequestMethod.GET)
    public List<Cuenta>  updateCuentas(){
    	System.out.println("Seleccione cuenta origen:");
    	int ctaorigen = leerCuenta();
    	System.out.println("Seleccione cuenta destino:");
    	int ctadestino = leerCuenta();
    	
    	System.out.println("Ingrese monto a transferir");
    	Double monto = leerMonto();
    	
    	transaccionCuentas(ctaorigen,ctadestino,monto);

        return listaCuentas;
    }
    
//Metodos utilizados (por ahora se pasan los valores por consola). 
    // lee el numero de cuenta. Para el ejemplo es 1, 2, 3, etc
    public int leerCuenta() { 
    	return sc.nextInt();	
    }
    
    // lee el monto a transferir
    public Double leerMonto() { 
    	return sc.nextDouble();
    }
    
    // realiza la transacción (aun falta aplicar el concepto de Transacción, por si ocurre un error.)
    public void transaccionCuentas(int ctaorigen, int ctadestino, Double monto) {
    	if (monto > listaCuentas.get(ctaorigen).saldo) {
    		System.out.println("No se puede realizar una transacción. Su saldo quedaría negativo.");
    		return;
    	}
    	try {
    		listaCuentas.get(ctaorigen).saldo = listaCuentas.get(ctaorigen).saldo - monto;
        	listaCuentas.get(ctadestino).saldo = listaCuentas.get(ctadestino).saldo + monto;
    	} catch(Exception e) {
    	    System.out.println("ERROR: Vuelva a intentar más tarde :)");
    	    return;
    	}
    	
    	System.out.println("Se realizó la transacción con éxito.");

    	
    }
    
    
}
