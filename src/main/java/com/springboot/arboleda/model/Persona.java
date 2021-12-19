package com.springboot.arboleda.model;

import java.io.Serializable;
import java.util.List;

public class Persona implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    public String name;
 
    public String username;
    
    public List<Cuenta> listaCuentas;
    
    public Persona() {
        super();
    }

	public Persona(String name, String username,List<Cuenta> listaCuentas) {
        super();
        this.name = name;
        this.username = username;
        this.listaCuentas = listaCuentas;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
    
    public List<Cuenta> getListaCuentas() {
		return listaCuentas;
	}

	public void setListaCuentas(List<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}
}
