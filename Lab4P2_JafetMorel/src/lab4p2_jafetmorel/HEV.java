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
public class HEV extends Automovil {

    private int bateria, motor;

    public HEV() {
        super();
    }

    public HEV(int bateria, int motor, String model, String vin, String carroceria, int pasajeros, int maletero) {
        super(model, vin, carroceria, pasajeros, maletero);
        this.bateria = bateria;
        this.motor = motor;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public int getMotor() {
        return motor;
    }

    public void setMotor(int motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "capacidad de la bateria: " + bateria + " kilowatts por hora, capacidad del motor eléctrico: " + motor + " kilowatts.";
    }

    public int calculo() throws miException{
        int cal=  2021 - (bateria * super.getMaletero()) / super.getPasajeros();
        if(cal<30){
            throw new miException("El cálculo debe ser mayor a 30");
        }
        return cal;
    }
}
