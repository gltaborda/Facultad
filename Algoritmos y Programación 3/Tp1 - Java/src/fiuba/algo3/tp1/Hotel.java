package fiuba.algo3.tp1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Hotel {

    private double costoPorNoche;
    private String fechaDeIngreso, fechaDeEgreso;

    public Hotel(Integer costoPorNoche, String fechaDeIngreso, String fechaDeEgreso){

        this.costoPorNoche = costoPorNoche;
        this.fechaDeIngreso = fechaDeIngreso;
        this.fechaDeEgreso = fechaDeEgreso;

    }

    public double calcularCosto (){

        return ((this.calcularDias())*this.costoPorNoche);

    }

    private double calcularDias(){

        int duracion;

        LocalDate fechaDeEntrada = LocalDate.parse(fechaDeIngreso, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate fechaDeSalida = LocalDate.parse(fechaDeEgreso, DateTimeFormatter.ISO_LOCAL_DATE);
        Duration diff = Duration.between(fechaDeEntrada.atStartOfDay(), fechaDeSalida.atStartOfDay());
        duracion = Math.toIntExact(diff.toDays());

        return duracion;

    }

    public void agregarAsistenciaAlViajero(){

        this.costoPorNoche = this.costoPorNoche + 30;

    }

}
