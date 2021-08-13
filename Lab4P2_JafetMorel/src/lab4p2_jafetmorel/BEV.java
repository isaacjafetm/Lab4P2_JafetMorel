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
public class BEV extends Automovil {

    private int km, baterias, aceleracion, carga;

    public BEV() {
        super();
    }

    public BEV(int km, int baterias, int aceleracion, int carga, String model, String vin, String carroceria, int pasajeros, int maletero) {
        super(model, vin, carroceria, pasajeros, maletero);
        this.km = km;
        this.baterias = baterias;
        this.aceleracion = aceleracion;
        this.carga = carga;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getBaterias() {
        return baterias;
    }

    public void setBaterias(int baterias) {
        this.baterias = baterias;
    }

    public int getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(int aceleracion) {
        this.aceleracion = aceleracion;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    @Override
    public String toString() {
        return "BEV{" + "km=" + km + ", baterias=" + baterias + ", aceleracion=" + aceleracion + ", carga=" + carga + '}';
    }

    public int calculo() throws miException {
        int cal = 2021 - (baterias + (carga * super.getPasajeros() / aceleracion));
        if (cal < 30) {
            throw new miException("El cálculo debe ser mayor a 30");
        }
        return cal;
    }
}
