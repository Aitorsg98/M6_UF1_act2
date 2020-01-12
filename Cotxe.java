package uf1;

import java.io.Serializable;

public class Cotxe implements Serializable {
	//Implementa la interfície Serializable
	private String marca;
	private String model;
	private String any;
	private String matricula;

	//constructor amb paràmetres
	public Cotxe (String marca, String model, String any, String matricula){
		//per no confondre el paràmetre amb el camp de variable
		this.marca = marca;
		//per no confondre el paràmetre amb el camp de variable
		this.model = model;
		//per no confondre el paràmetre amb el camp de variable
		this.any = any;
		//per no confondre el paràmetre amb el camp de variable
		this.matricula = matricula;
	}
	public Cotxe (){//constructor per defecte
		this.marca = null;
	}
	//per donar el valor als camps de variable private
	public void setMarca(String nom){marca = nom;}
	public void setModel(String nom){ model = nom;}
	public void setAny(String data){ any = data;}
	public void setMatricula(String nom){ matricula = nom;}
	//per consultar el valor dels camps de variable private
	public String getMarca(){return marca;}
	public String getModel(){return model;}
	public String getAny(){return any;}
	public String getMatricula(){return matricula;}

}
