/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerUno;

import java.util.Scanner;

/**
 *
 * @author Felix castro
 */

public class ejer1 {
    //entrada de datos por consola
    static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        //definicion de varaibles y arrays
        double [][] notEst;
        
        //inicializacion de variables y arrays
        notEst = new double[3][4];
        
        //titulo
        System.out.println("SISTEMA DE CALIFICACIONES");
        
        //procedimento menu
        menu(notEst);
    }
    
    public static void menu(double notEst[][]) {
        int exit = 0;
        while (exit == 0) {

            System.out.println("ESCOGA UNA OPCION:\n1) INGRESAR NOTAS\n2) "
                    + "CORREGIR O ACTUALIZAR NOTAS \n3) "
                    + "IMPRIMIR NOTAS \n4) SALIR");
            String opt = leer.next();
            switch (opt) {

                case "1":
                    inserNota(notEst);
                    break;
                case "2":
                    updaNota(notEst);
                    break;
                case "3":
                    printNotas(notEst);
                    break;
                case "4":
                    exit = 1;
                    break;
            }
        }
    }
    
    public static void inserNota(double notEst[][]){
        System.out.println("INGRESO DE NOTAS DE CADA ESTUDIANTES");
        for (int i = 0; i < 3; i++) {
            System.out.print("ESTUDIANTE " + (i + 1) + "\n");
            for (int j = 0; j < 3; j++) {
                System.out.print("DIGITE LA NOTA DEL " + (j + 1) + " CORTE:");
                notEst[i][j] = leer.nextDouble();
            }
            notEst[i][3] = (notEst[i][0] + notEst[i][1] + notEst[i][2]) / 3;
            System.out.println("");
        }
    }

    private static void printNotas(double[][] notEst) {
        System.out.println("IMPRESION DE NOTAS");
        for (int i = 0; i < 3; i++) {
            System.out.print("ESTUDIANTE " + (i + 1) + "\n");
            for (int j = 0; j < 3; j++) {
                System.out.print("LA NOTA DEL " + (j + 1) + " PRIMER CORTE ES:" + 
                        notEst[i][j] + "\n");
            }
            System.out.println("PROMEDIO:" + notEst[i][3]);
            System.out.println("");
        }
    }

    private static void updaNota(double[][] notEst) {
        System.out.print("INGRESE EL NUMERO DEL ESTUDIANTE:");
        int numEst = leer.nextInt() - 1;

        System.out.print("INGRESE EL NUMERO DEL CORTE: ");
        int numCort = leer.nextInt() - 1;

        System.out.print("INGRESE LA NUEVA NOTA: ");
        double nNota = leer.nextDouble();       
        
        
        System.out.print("NOTA ANTERIOR: " + 
                notEst[numEst][numCort] + "\nNUEVA NOTA: " + nNota + 
                "\n CORREGIR O MODIFICAR LA NOTA?\n1) SI\n2) NO");
        String opt = leer.next();

        if (opt.equals("1")) {
            notEst[numEst][numCort] = nNota;
            System.out.println("NOTA MODIFICADA");
        } else {
            System.out.println("NINGUN CAMBIO REALIZADO");
        }
        
    }
}
