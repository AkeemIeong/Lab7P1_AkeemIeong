package lab7p1_akeemieong;

import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;
public class Lab7P1_AkeemIeong {

    static Scanner leer=new Scanner(System.in);
    static Random random=new Random();
    public static void main(String[] args) {
        int opcion;
        int caso;
        do{
            System.out.println("1<-Portrait");
            System.out.println("2<-Numero Magico");
            System.out.println("3<-Subsequencia");
            System.out.println("4<-Salida");
            System.out.print("Ingrese la opcion: ");
            opcion=leer.nextInt();
            caso=opciones(opcion);
            
            switch(caso){
                case 1:
                    System.out.println("Ingrese numero de filas: ");
                    int fila=leer.nextInt();
                    System.out.println("Ingrese numero de columnas: ");
                    int columna=leer.nextInt();
                    if (fila!=columna){
                        int [][]matriz=lectura(fila,columna);
                        JOptionPane.showConfirmDialog(null, "Cadena generada\n"+imprimir(matriz));
                        int[][]change=cambio(matriz);
                        JOptionPane.showConfirmDialog(null, "La nuva matriz generada es\n"+imprimir(change));
                    }
                    else System.out.println("Ingrese 2 numeros diferentes");
                    break;
                case 2:
                    System.out.println("Ingrese numero de filas: ");
                    int fila2=leer.nextInt();
                    System.out.println("Ingrese numero de columnas: ");
                    int columna2=leer.nextInt();
                    if (fila2!=columna2){
                    int [][]matriz=lectura(fila2,columna2);
                    JOptionPane.showConfirmDialog(null, "La matriz generada es\n"+imprimir(matriz));
                    int sum=numeromagico(matriz);
                    JOptionPane.showConfirmDialog(null,"El numero generado es: " +sum);
                    }else
                        System.out.println("Ingrese numeros que no son iguales");
                    break;
                case 3:
                    System.out.println("Ingrese la primera cadena: ");
                    String first=leer.next().toUpperCase();
                    System.out.println("Ingrese la segunda cadena: ");
                    String second=leer.next().toUpperCase();
                    int grande=subsequencia(first,second);
                    JOptionPane.showConfirmDialog(null, "El numero ms grande de la matriz es: "+grande);
                    break;
            }
            caso=opciones(opcion);
        }
        while(caso!=4);
    }
    public static int opciones(int opcion){
        int temp=opcion;
        return temp;
    }
    public static int [][]lectura(int fila,int columna){
        int temporal[][]=new int [fila][columna];
            for(int i=0;i<fila;i++){
                for(int j=0;j<columna;j++){
                    temporal[i][j]=1+random.nextInt(9);
                }
            }
        return temporal;
    }
    public static String imprimir(int[][]matriz){
    String cadena="";
    for (int i=0;i<matriz.length;i++){
        for(int j=0;j<matriz[i].length;j++){
            cadena += "["+matriz [i][j]+"]"+" ";
        }
        cadena+="\n";
    }
    return cadena;
}
    public static int[][] cambio(int[][] matriz){
        int [][]change=new int [matriz[0].length][matriz.length];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                change[matriz[0].length-1-j][matriz.length-i-1]=matriz[i][j];
            }
        }
        int [][]newmatriz=new int [change.length][change[0].length];
        return reorden(change);
        
    }
    public static int[][]reorden(int[][]newmatriz){
        int [][]original=new int [newmatriz.length][newmatriz[0].length];
        int fils=newmatriz.length-1;
        int cols=newmatriz[0].length;
        for (int i=fils;i>=0;i--){
            for(int j=0;j<=cols-1;j++){
                System.out.println(i+" "+j + " " + newmatriz[i][j]);
                original[fils-i][j]=newmatriz[i][j];
            }
        }
        return original;
    }
    public static int numeromagico(int[][]matriz){
        int num,sumaout=0,numin=1;
            for (int i=0;i<matriz.length;i++){
                for (int j=0;j<matriz[i].length;j++){
                    if (i==0&&j>=0||i>0&&j==0||i==matriz.length-1&&j>0 ||i>0&&j==matriz.length-1){
                       sumaout+=matriz[i][j];
                    }
                    else
                        numin=numin*matriz[i][j];
                }
            }
            num=sumaout+numin;
     return num;
    }
    public static int subsequencia(String first,String second){
        int grande;
        first="-"+first;
        second="-"+second;
        int [][]matri=new int [second.length()][first.length()];
        for (int i=0;i<second.length();i++){
            for(int j=0;j<first.length();j++){
                if (first.charAt(j)=='-'||second.charAt(i)=='-'){
                    matri[i][j]=0;
                }
                else
                    if(first.charAt(j)==second.charAt(i)){
                        matri[i][j]=1+matri[i-1][j-1];
                    }
                    else 
                        matri[i][j]=Math.max(matri[i][j-1], matri[i-1][j]);
                
                }
            
        }
        JOptionPane.showConfirmDialog(null, imprimir(matri));
        grande=matri[second.length()-1][first.length()-1];
        return grande;
    }
}
