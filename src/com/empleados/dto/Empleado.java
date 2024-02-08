package com.empleados.dto;

import java.time.LocalDate;

public class Empleado {
	private int id;
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private double salario;

	public Empleado(int id, String nombre, String apellido, LocalDate fechaNacimiento, double salario) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.salario = salario;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public double getSalario() {
		return salario;
	}



	public void setSalario(double salario) {
		this.salario = salario;
	}



	public int calcularEdad() {
		return LocalDate.now().getYear() - fechaNacimiento.getYear();
	}

	@Override
	public String toString() {
		return "Empleado{" + "ID=" + id + ", Nombre='" + nombre + '\'' + ", Apellido='" + apellido + '\''
				+ ", Fecha de Nacimiento=" + fechaNacimiento + ", Salario=" + salario + '}';
	}
}