import java.util.Scanner;
import java.util.Stack;

public class main {

    private static void secuenciaNumReales() {
        double arrayNumReales[] = new double[10];
        PADPila pila = new PADPila(10);

        System.out.println("Secuencia Original");
        for (int i = 0; i < 10; i++) {
            arrayNumReales[i] = Math.random()*201 - 100;
            System.out.println(arrayNumReales[i]);
            pila.apilar(arrayNumReales[i]);
        }

        System.out.println("\nSecuencia extraida de la pila");
        for (int i = 0; i < 10; i++) {
            System.out.println(pila.desapilar());
        }
    }

    private static void copiarPila(PADPila pila1, PADPila pila2) {
        System.out.println("Pila A Copiar");
        for (int i = 0; i < pila1.obtenerTamano(); i++) {
            Object object = pila1.desapilar();
            System.out.println(object);
            pila2.apilar(object);
        }
        System.out.println("\nPila copiada");
        for (int i = 0; i < pila2.obtenerTamano(); i++) {
            System.out.println(pila2.desapilar());
        }
    }

    public static void retirarPalabras(PADPila pila, String letra) {
        int cont = 0;
        PADPila aux = new PADPila(pila.obtenerTamano());
        System.out.println("Pila Original");
        for (int i = 0; i < pila.obtenerTamano(); i++) {
            String palabra = (String) pila.desapilar();
            System.out.println(palabra);
            if(!palabra.split("")[0].equals(letra)){
                aux.apilar(palabra);
                cont++;
            }
        }

        PADPila salida = new PADPila(cont);
        for (int i = 0; i < cont; i++) {
            Object pal = aux.desapilar();
            salida.apilar(pal);
        }

        System.out.println("\nPila tratada");
        for (int i = 0; i < salida.obtenerTamano(); i++) {
            System.out.println(salida.desapilar());
        }
    }

    public static void main(String[] args) {
        int op = -1;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Menu");
            System.out.println("1. Secuencia de números");
            System.out.println("2. Copiar pila");
            System.out.println("3. Eliminar palabras que comienzen por una letra");
            System.out.print("Ingrese el numero de la opcion: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    secuenciaNumReales();
                    break;
                case 2:
                    PADPila pilaA = new PADPila(10);
                    for (int i = 0; i < 10; i++) {
                        pilaA.apilar(Math.random()*201 - 100);
                    }
                    PADPila pilaB = new PADPila(10);
                    copiarPila(pilaA, pilaB);
                    break;
                case 3:
                    System.out.println("Numero de Palabras a digitar: ");
                    //sc.nextInt();
                    int numPalabras = sc.nextInt();

                    PADPila pilaPalabras = new PADPila(numPalabras);
                    for (int i = 0; i < numPalabras; i++) {
                        System.out.println("Palabra: " + i);
                        if(i==0){
                            sc.nextLine();
                        }
                        pilaPalabras.apilar(sc.nextLine());
                    }

                    System.out.println("Letra con la que comienzan las palabras a retirar");
                    //sc.nextLine();
                    String letra = sc.nextLine();

                    retirarPalabras(pilaPalabras, letra);
                    break;
            }
        } while (op != 0);
    }
}
