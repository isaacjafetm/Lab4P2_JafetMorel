/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4p2_jafetmorel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 24661
 */
public class Lab4P2_JafetMorel {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Automovil> lista = new ArrayList();

    public static void main(String[] args) {
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("MENU:\n"
                    + "1.Crear automovil\n"
                    + "2.Modificar\n"
                    + "3.Eliminar\n"
                    + "4.Listar\n"
                    + "5.Cálculo\n"
                    + "6.Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    agregar();
                    break;
                case 2:
                    modificar();
                    break;
                case 3:
                    eliminar();
                    break;
                case 4:
                    listar();
                    break;
                case 5:
                    calculo();
                    break;
            }
        }
    }

    public static void agregar() {
        System.out.println("¿Que tipo de vehículo desea agregar\n"
                + "1. Combustión\n"
                + "2. Híbrido\n"
                + "3. Híbrido enchufable\n"
                + "4. Eléctrico\n");
        int op = sc.nextInt();
        System.out.println("Ingrese el model del vehículo: ");
        String modelo = sc.next();
        System.out.println("Ingrese el VIN: ");
        String VIN = sc.next();
        int aux = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (VIN.equals(lista.get(i).getVin())) {
                aux++;
            }
        }//verificación de VIN único
        while (aux == 1) {
            aux = 0;
            System.out.println("Ese VIN ya está en uso, ingrese uno diferente: ");
            VIN = sc.next();
            for (int i = 0; i < lista.size(); i++) {
                if (VIN.equals(lista.get(i).getVin())) {
                    aux++;
                }
            }
        }//verificación de VIN único
        System.out.println("Ingrese la carrocería: ");
        String carroceria = sc.next();
        System.out.println("Ingrese la cantidad de pasajeros que aguanta: ");
        int pasajeros = sc.nextInt();
        System.out.println("Ingrese la cantidad de litros de capacidad del maletero: ");
        int maletero = sc.nextInt();
        switch (op) {
            case 1:
                System.out.println("Ingrese cantidad de consumo de combustible en kilometro por litro:");
                int consumo = sc.nextInt();
                System.out.println("Ingrese cantidad de meses que dura el aceite: ");
                int duracion = sc.nextInt();
                System.out.println("Ingrese la velocidad máxima: ");
                int velocidad = sc.nextInt();
                System.out.println("Ingrese el tipo de cambio (automático o maual): ");
                String cambio = sc.next();
                lista.add(new NEV(consumo, duracion, velocidad, cambio, modelo, VIN, carroceria, pasajeros, maletero));
                break;
            case 2:
                System.out.println("Ingrese capacidad de batería en kilowatt por hora: ");
                int bateriah = sc.nextInt();
                System.out.println("Ingrese capacidad de motor eléctrico en kilowatt: ");
                int motor = sc.nextInt();
                lista.add(new HEV(bateriah, motor, modelo, VIN, carroceria, pasajeros, maletero));
                break;
            case 3:
                System.out.println("Ingrese cantidad de kilometros en modo eléctrico: ");
                int kmhe = sc.nextInt();
                System.out.println("Ingrese cantidad de motores eléctricos: ");
                int motores = sc.nextInt();
                System.out.println("Ingrese cantidad de toneladas de capacidad del remolque: ");
                int remolque = sc.nextInt();
                System.out.println("¿Es 4x4? [s/n]");
                char resp = sc.next().charAt(0);
                boolean x = false;
                if (resp == 's') {
                    x = true;
                }
                lista.add(new PHEV(kmhe, motores, remolque, x, modelo, VIN, carroceria, pasajeros, maletero));
                break;
            case 4:
                System.out.println("Ingrese cantidad de kilómetros que puede recorrer (autonomía): ");
                int kme = sc.nextInt();
                System.out.println("Ingrese cantidad de baterias que almacena: ");
                int baterias = sc.nextInt();
                System.out.println("Ingrese la cantidad de segundos para una aceleración de 0-100: ");
                int acc = sc.nextInt();
                System.out.println("Ingrese la cantidad de minutos que dura una carga completa: ");
                int carga = sc.nextInt();
                lista.add(new BEV(kme, baterias, acc, carga, modelo, VIN, carroceria, pasajeros, maletero));
                break;
        }
    }

    public static void modificar() {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ". " + lista.get(i));
        }
        System.out.println("¿Que posición desea modificar?");
        int pos = sc.nextInt();
        if (pos < 0 || pos >= lista.size()) {
            System.out.println("Posición no válida");
        } else {
            System.out.println("¿Que desea modificar?\n"
                    + "1. modelo\n"
                    + "2. VIN\n"
                    + "3. carroceria\n"
                    + "4. pasajeros\n"
                    + "5. maletero\n");
            if (lista.get(pos) instanceof NEV) {
                System.out.println("6. Consumo del combustible\n"
                        + "7. Duracion del aceite\n"
                        + "8. Velocidad máxima\n"
                        + "9. Tipo de cambio");
            } else if (lista.get(pos) instanceof HEV) {
                System.out.println("6. Capacidad de la bateria\n"
                        + "7. Capacidad del motor eléctrico");
            } else if (lista.get(pos) instanceof PHEV) {
                System.out.println("6. Cantidad de kilómetros en modo eléctrico\n"
                        + "7. Cantidad de motores eléctricos\n"
                        + "8. Capacidad de remolque\n"
                        + "9. 4x4");
            } else if (lista.get(pos) instanceof BEV) {
                System.out.println("6. Cantidad de kilómetros que puede recorrer\n"
                        + "7. Cantidad de baterías que almacena\n"
                        + "8. Aceleración de 0 a 100\n"
                        + "9. Tiempo que dura una carga completa");
            }
            int mod = sc.nextInt();
            switch (mod) {
                case 1:
                    System.out.println("Ingrese el modelo: ");
                    String modelo = sc.next();
                    lista.get(pos).setModel(modelo);
                    break;
                case 2:
                    System.out.println("Ingrese VIN: ");
                    String VIN = sc.next();
                    int aux = 0;
                    for (int i = 0; i < lista.size(); i++) {
                        if (VIN.equals(lista.get(i).getVin())) {
                            aux++;
                        }
                    }//verificación de VIN único
                    while (aux == 1) {
                        aux = 0;
                        System.out.println("Ese VIN ya está en uso, ingrese uno diferente: ");
                        VIN = sc.next();
                        for (int i = 0; i < lista.size(); i++) {
                            if (VIN.equals(lista.get(i).getVin())) {
                                aux++;
                            }
                        }
                    }//verificación de VIN único
                    lista.get(pos).setVin(VIN);
                    break;
                case 3:
                    System.out.println("Ingrese la carroceria: ");
                    String carroceria = sc.next();
                    lista.get(pos).setCarroceria(carroceria);
                    break;
                case 4:
                    System.out.println("Ingrese la capacidad de pasajeros: ");
                    int pasajeros = sc.nextInt();
                    lista.get(pos).setPasajeros(pasajeros);
                    break;
                case 5:
                    System.out.println("Ingrese capacidad de litros del maletero: ");
                    int maletero = sc.nextInt();
                    lista.get(pos).setMaletero(maletero);
                    break;
            }
            if (lista.get(pos) instanceof NEV) {
                if (mod < 0 || mod > 9) {
                    System.out.println("posicion no válida");
                } else {
                    switch (mod) {
                        case 6:
                            System.out.println("Ingrese cantida de kilometros por litro del consumo de combustible: ");
                            int combustible = sc.nextInt();
                            ((NEV) lista.get(pos)).setConsumo(combustible);
                            break;
                        case 7:
                            System.out.println("Ingrese cantidad de meses que dura el aceite: ");
                            int meses = sc.nextInt();
                            ((NEV) lista.get(pos)).setDuracion(meses);
                            break;
                        case 8:
                            System.out.println("Ingrese la velocidad máxima: ");
                            int velocidad = sc.nextInt();
                            ((NEV) lista.get(pos)).setVelocidad(velocidad);
                            break;
                        case 9:
                            System.out.println("Ingrese el tipo de cambio(automático o manual)");
                            String cambio = sc.next();
                            ((NEV) lista.get(pos)).setCambio(cambio);
                            break;
                    }
                }
            } else if (lista.get(pos) instanceof HEV) {
                if (mod < 0 || mod > 7) {
                    System.out.println("posicion no válida");
                } else {
                    switch (mod) {
                        case 6:
                            System.out.println("Ingrese la cantidad de kilowatts por hora que tiene de capacidad la bvatería: ");
                            int capacidad = sc.nextInt();
                            ((HEV) lista.get(pos)).setBateria(capacidad);
                            break;
                        case 7:
                            System.out.println("Ingrese la capacidad del motor eléctrico: ");
                            int motor = sc.nextInt();
                            ((HEV) lista.get(pos)).setMotor(motor);
                            break;
                    }
                }
            } else if (lista.get(pos) instanceof PHEV) {
                if (mod < 0 || mod > 9) {
                    System.out.println("posicion no válida");
                } else {
                    switch (mod) {
                        case 6:
                            System.out.println("Ingrese la cantidad de kilómetros en modo eléctrico:");
                            int km = sc.nextInt();
                            ((PHEV) lista.get(pos)).setKm(km);
                            break;
                        case 7:
                            System.out.println("Cantidad de motores eléctricos: ");
                            int motores = sc.nextInt();
                            ((PHEV) lista.get(pos)).setMotores(motores);
                            break;
                        case 8:
                            System.out.println("Ingrese la cantidad de tonelada que tiene de capacidad de remolque:");
                            int remolques = sc.nextInt();
                            ((PHEV) lista.get(pos)).setRemolque(remolques);
                            break;
                        case 9:
                            System.out.println("¿Es 4x4?[s/n]");
                            int resp = sc.nextInt();
                            boolean x = false;
                            if (resp == 's') {
                                x = true;
                            }
                            ((PHEV) lista.get(pos)).setX(x);
                            break;
                    }
                }
            } else if (lista.get(pos) instanceof BEV) {
                if (mod < 0 || mod > 9) {
                    System.out.println("posicion no válida");
                } else {
                    switch (mod) {
                        case 6:
                            System.out.println("Ingrese la cantidad de kilómetros que puede recorrer(autonomía): ");
                            int km = sc.nextInt();
                            ((BEV) lista.get(pos)).getKm();
                            break;
                        case 7:
                            System.out.println("Ingrese la cantidad de baterías que almacena :");
                            int baterias = sc.nextInt();
                            ((BEV) lista.get(pos)).setBaterias(baterias);
                            break;
                        case 8:
                            System.out.println("Ingrese la cantidad de segundos que toma la aceleración de 0 a 10");
                            int aceleracion = sc.nextInt();
                            ((BEV) lista.get(pos)).setAceleracion(aceleracion);
                            break;
                        case 9:
                            System.out.println("Ingrese la cantidad de minutos que dura una carga completa: ");
                            int carga = sc.nextInt();
                            ((BEV) lista.get(pos)).setCarga(carga);
                            break;
                    }
                }
            }
        }
    }

    public static void eliminar() {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ". " + lista.get(i));
        }
        System.out.println("¿Que posición desea eliminar?");
        int pos = sc.nextInt();
        if (pos < 0 || pos >= lista.size()) {
            System.out.println("Poscición no válida");
        } else {
            lista.remove(pos);
        }
    }

    public static void listar() {
        for (Automovil automovil : lista) {
            System.out.println(automovil);
        }
    }

    public static void calculo() {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ". " + lista.get(i));
        }
        System.out.println("¿Que posición desea ver el calculo?");
        int pos = sc.nextInt();
        if (pos < 0 || pos >= lista.size()) {
            System.out.println("Posición no válida.");
        } else {
            try {
                System.out.println(lista.get(pos).calculo());
            } catch (miException ex) {
                System.out.println("Ingrese el model del vehículo: ");
                String modelo = sc.next();
                lista.get(pos).setModel(modelo);
                System.out.println("Ingrese el VIN: ");
                String VIN = sc.next();
                int aux = 0;
                for (int i = 0; i < lista.size(); i++) {
                    if (VIN.equals(lista.get(i).getVin())) {
                        aux++;
                    }
                }//verificación de VIN único
                while (aux == 1) {
                    aux = 0;
                    System.out.println("Ese VIN ya está en uso, ingrese uno diferente: ");
                    VIN = sc.next();
                    for (int i = 0; i < lista.size(); i++) {
                        if (VIN.equals(lista.get(i).getVin())) {
                            aux++;
                        }
                    }
                }//verificación de VIN único
                lista.get(pos).setVin(VIN);
                System.out.println("Ingrese la carrocería: ");
                String carroceria = sc.next();
                lista.get(pos).setCarroceria(carroceria);
                System.out.println("Ingrese la cantidad de pasajeros que aguanta: ");
                int pasajeros = sc.nextInt();
                lista.get(pos).setPasajeros(pasajeros);
                System.out.println("Ingrese la cantidad de litros de capacidad del maletero: ");
                int maletero = sc.nextInt();
                lista.get(pos).setMaletero(maletero);
                if (lista.get(pos) instanceof NEV) {
                    System.out.println("Ingrese cantidad de consumo de combustible en kilometro por litro:");
                    int consumo = sc.nextInt();
                    ((NEV) lista.get(pos)).setConsumo(consumo);
                    System.out.println("Ingrese cantidad de meses que dura el aceite: ");
                    int duracion = sc.nextInt();
                    ((NEV) lista.get(pos)).setDuracion(duracion);
                    System.out.println("Ingrese la velocidad máxima: ");
                    int velocidad = sc.nextInt();
                    ((NEV) lista.get(pos)).setVelocidad(velocidad);
                    System.out.println("Ingrese el tipo de cambio (automático o maual): ");
                    String cambio = sc.next();
                    ((NEV) lista.get(pos)).setCambio(cambio);
                } else if (lista.get(pos) instanceof HEV) {
                    System.out.println("Ingrese capacidad de batería en kilowatt por hora: ");
                    int bateriah = sc.nextInt();
                    ((HEV) lista.get(pos)).setBateria(bateriah);
                    System.out.println("Ingrese capacidad de motor eléctrico en kilowatt: ");
                    int motor = sc.nextInt();
                    ((HEV) lista.get(pos)).setMotor(motor);
                } else if (lista.get(pos) instanceof PHEV) {
                    System.out.println("Ingrese cantidad de kilometros en modo eléctrico: ");
                    int kmhe = sc.nextInt();
                    ((PHEV) lista.get(pos)).setKm(kmhe);
                    System.out.println("Ingrese cantidad de motores eléctricos: ");
                    int motores = sc.nextInt();
                    ((PHEV) lista.get(pos)).setMotores(motores);
                    System.out.println("Ingrese cantidad de toneladas de capacidad del remolque: ");
                    int remolque = sc.nextInt();
                    ((PHEV) lista.get(pos)).setRemolque(remolque);
                    System.out.println("¿Es 4x4? [s/n]");
                    char resp = sc.next().charAt(0);
                    boolean x = false;
                    if (resp == 's') {
                        x = true;
                    }
                    ((PHEV) lista.get(pos)).setX(x);
                } else if (lista.get(pos) instanceof BEV) {
                    System.out.println("Ingrese cantidad de kilómetros que puede recorrer (autonomía): ");
                    int kme = sc.nextInt();
                    ((BEV) lista.get(pos)).setKm(kme);
                    System.out.println("Ingrese cantidad de baterias que almacena: ");
                    int baterias = sc.nextInt();
                    ((BEV) lista.get(pos)).setBaterias(baterias);
                    System.out.println("Ingrese la cantidad de segundos para una aceleración de 0-100: ");
                    int acc = sc.nextInt();
                    ((BEV) lista.get(pos)).setAceleracion(acc);
                    System.out.println("Ingrese la cantidad de minutos que dura una carga completa: ");
                    int carga = sc.nextInt();
                    ((BEV) lista.get(pos)).setCarga(carga);
                }
            }
        }
    }

}
