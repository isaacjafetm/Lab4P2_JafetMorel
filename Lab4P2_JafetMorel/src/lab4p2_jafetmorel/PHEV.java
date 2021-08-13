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
public class PHEV extends Automovil {

    private int km, motores, remolque;
    private boolean x;

    public PHEV() {
        super();
    }

    public PHEV(int km, int motores, int remolque, boolean x, String model, String vin, String carroceria, int pasajeros, int maletero) {
        super(model, vin, carroceria, pasajeros, maletero);
        this.km = km;
        this.motores = motores;
        this.remolque = remolque;
        this.x = x;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getMotores() {
        return motores;
    }

    public void setMotores(int motores) {
        this.motores = motores;
    }

    public int getRemolque() {
        return remolque;
    }

    public void setRemolque(int remolque) {
        this.remolque = remolque;
    }

    public boolean isX() {
        return x;
    }

    public void setX(boolean x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return " cantidad de kilometros en modo eléctrico: " + km + ", cantidad de motores eléctricos: " + motores + ", capacidad de remolque: " + remolque + " toneladas, 4x4: " + x + '.';
    }

    public int calculo() throws miException{
        int cal = 2021 - ((super.getPasajeros() * motores) + (km / remolque));
        if(cal<30){
            throw new miException("El cálculo debe ser mayor a 30");
        }
        return cal;
    }
}
