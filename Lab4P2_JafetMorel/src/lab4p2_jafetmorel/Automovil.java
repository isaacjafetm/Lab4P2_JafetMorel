/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4p2_jafetmorel;

/**
 *
 * @author 24661
 */
public abstract class Automovil {
    private String model, vin, carroceria;
    private int pasajeros, maletero;

    public Automovil() {
    }

    public Automovil(String model, String vin, String carroceria, int pasajeros, int maletero) {
        this.model = model;
        this.vin = vin;
        this.carroceria = carroceria;
        this.pasajeros = pasajeros;
        this.maletero = maletero;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public int getMaletero() {
        return maletero;
    }

    public void setMaletero(int maletero) {
        this.maletero = maletero;
    }

    @Override
    public String toString() {
        return "Modelo: " + model + ", VIN: " + vin + ", Carroceria: " + carroceria + ", Capacidad de pasajeros: " + pasajeros + ", Capacidad de maletero: " + maletero + " litros, ";
    }
    
    public abstract int calculo() throws miException;
        
    
}
