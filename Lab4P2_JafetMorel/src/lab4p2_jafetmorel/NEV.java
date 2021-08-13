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
public class NEV extends Automovil {

    private int consumo, duracion, velocidad;
    private String cambio;

    public NEV() {
        super();
    }

    public NEV(int consumo, int duracion, int velocidad, String cambio, String model, String vin, String carroceria, int pasajeros, int maletero) {
        super(model, vin, carroceria, pasajeros, maletero);
        this.consumo = consumo;
        this.duracion = duracion;
        this.velocidad = velocidad;
        this.cambio = cambio;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    @Override
    public String toString() {
        return "consumo de combustible: " + consumo + " kilometros por litro, duracion del aceite: " + duracion + " meses, velocidad máxima: " + velocidad + ", tipo de cambio: " + cambio + '.';
    }

    public int calculo() throws miException{
        int cal= 2021 - (super.getPasajeros() * consumo) - (duracion * consumo);
        if(cal<30){
            throw new miException("El cálculo debe ser mayor a 30");
        }
        return cal;
    }
}
