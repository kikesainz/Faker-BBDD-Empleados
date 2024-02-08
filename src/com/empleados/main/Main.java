package com.empleados.main;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.empleados.dto.Empleado;
import com.github.javafaker.Faker;

public class Main {

    public static void main(String[] args) {
        List<Empleado> empleados = generarEmpleadosFalsos(100);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Buscar empleados por rango de edad");
        System.out.print("Edad mínima: ");
        int edadMin = scanner.nextInt();
        System.out.print("Edad máxima: ");
        int edadMax = scanner.nextInt();
        List<Empleado> empleadosPorEdad = buscarPorRangoEdad(empleados, edadMin, edadMax);
        empleadosPorEdad.forEach(System.out::println);

        System.out.println("\nBuscar empleados por rango de salario");
        System.out.print("Salario mínimo: ");
        double salarioMin = scanner.nextDouble();
        System.out.print("Salario máximo: ");
        double salarioMax = scanner.nextDouble();
        List<Empleado> empleadosPorSalario = buscarPorRangoSalario(empleados, salarioMin, salarioMax);
        empleadosPorSalario.forEach(System.out::println);
    }

    private static List<Empleado> generarEmpleadosFalsos(int cantidad) {
        List<Empleado> empleados = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < cantidad; i++) {
            String nombre = faker.name().firstName();
            String apellido = faker.name().lastName();
            LocalDate fechaNacimiento = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            double salario = 10000 + (faker.number().randomDouble(2, 0, 5000));
            empleados.add(new Empleado(i, nombre, apellido, fechaNacimiento, salario));
        }
        return empleados;
    }

    private static List<Empleado> buscarPorRangoEdad(List<Empleado> empleados, int edadMin, int edadMax) {
        return empleados.stream()
                .filter(empleado -> {
                    int edad = empleado.calcularEdad();
                    return edad >= edadMin && edad <= edadMax;
                })
                .collect(Collectors.toList());
    }

    private static List<Empleado> buscarPorRangoSalario(List<Empleado> empleados, double salarioMin, double salarioMax) {
        return empleados.stream()
                .filter(empleado -> empleado.getSalario() >= salarioMin && empleado.getSalario() <= salarioMax)
                .collect(Collectors.toList());
    }

}
