package com.springboot.arboleda.model;

import java.io.Serializable;

public class Cuenta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public int nroCuenta; //Identifica a la cuenta.
	public String tipo; // Descripcion o tipo de la cuenta.
	public Double saldo; //vendría a ser el crédito que se especificó en las pantallas.
	 
	public Cuenta() {
		super();
		// TODO Auto-generated constructor stub
	} 
	 
	public Cuenta(int nroCuenta, String tipo, Double saldo) {
		super();
		this.nroCuenta = nroCuenta;
		this.tipo = tipo;
		this.saldo = saldo;
	}

	public int getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	 
	 
}
