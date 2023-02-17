import java.util.Scanner;

public class Main {
    /**
     * En este metodo se inicializan y se ejecutan los datos para realizar la criba de Erastotenes
     * @param args
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int[] vector =new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        vectorInicial(vector);
        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta:"+dato);
        vectorPrimos(vector);
    }

    /**
     * El metodo lo que hace es calcular e imprimir los numeros del vector que se le pasa. Cuando llega a un numero multiplo de 10 imprime un salto de linia.
     * @param vector es un vector de datos que le pasamos al metodo
     */
    private static void vectorPrimos(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vector[i]+"\t");
        }
    }

    /**
     * Imprime los numeros desde el 1 hasta el numero que se le pasa para la criba
     * @param vector es un vector de datos que le pasamos al metodo, definido en el main
     */
    private static void vectorInicial(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
    }

    // Generar números primos de 1 a max

    /**
     * Este metodo lo que hace es calcular los numeros primos hasta un numero maximo que se le pasa al metodo.
     * @param max es el maximo de numeros primos que vamos a generar
     * @return devuelve un vector de numeros primos
     */
    public static int[] generarPrimos (int max)
    {
        int i,j;
        if (max >= 2) {
            // Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];
            // Inicializar el array
            for (i=0; i<dim; i++)
                esPrimo[i] = true;
            // Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;
            // Criba
            criba(dim, esPrimo);
            // ¿Cuántos primos hay?
            int cuenta = contarPrimos(dim, esPrimo);
            // Rellenar el vector de números primos
            return rellenaVectorNumerosPrimos(dim, esPrimo, cuenta);
        } else { // max < 2
            return new int[0];
        // Vector vacío
        }
    }

    /**
     * Este metodo lo que realiza es la criba de Erastotenes
     * @param dim es el tamaño del array que creamos en el main + 1
     * @param esPrimo es un vector de booleanos que nos indica si el numero que hay en esa posicion es primo o no es primo
     */
    private static void criba(int dim, boolean[] esPrimo) {
        int j;
        int i;
        for (i=2; i<Math.sqrt(dim)+1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (j=2*i; j< dim; j+=i)
                    esPrimo[j] = false;
            }
        }
    }

    /**
     * El metodo cuenta la cantidad de numeros primos que hay
     * @param dim es el tamaño del array que creamos en el main + 1
     * @param esPrimo es un vector de booleanos que nos indica si el numero que hay en esa posicion es primo o no es primo
     * @return devuelve un entero con la cantidad de numeros primos que hay en el vector
     */
    private static int contarPrimos(int dim, boolean[] esPrimo) {
        int i;
        int cuenta = 0;
        for (i=0; i< dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    /**
     * El metodo lo que hace es rellenar el vector con aquellos numeros que son primos
     * @param dim es el tamaño del array que creamos en el main + 1
     * @param esPrimo es un vector de booleanos que nos indica si el numero que hay en esa posicion es primo o no es primo
     * @param cuenta es la cantidad de numeros primos que hay
     * @return devuelve un vector con los numeros primos
     */
    private static int[] rellenaVectorNumerosPrimos(int dim, boolean[] esPrimo, int cuenta) {
        int j;
        int i;
        int[] primos = new int[cuenta];
        for (i=0, j=0; i< dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }
}