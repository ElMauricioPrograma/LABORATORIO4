package com.example.laboratorio4.model;

public class Edificacion {
    private String nombre;
    private String direccion;
    private double lat;
    private double lng;

    public Edificacion(String nombre, String direccion, double lat, double lng) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.lat = lat;
        this.lng = lng;
    }

    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public double getLat() { return lat; }
    public double getLng() { return lng; }
}
