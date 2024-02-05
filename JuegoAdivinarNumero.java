package Ejercicio4_1_Entregable;

import java.util.Scanner;

public class Ejercicio4_1_Entregable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            menuInicio(sc);
        } while (menuSalida(sc));
    }

    public static boolean menuSalida(Scanner sc) {
        String respuesta;
        do {
            System.out.println("¿Quieres volver a jugar? (si/no)");
            respuesta = sc.nextLine();
        } while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no"));
        if (respuesta.equalsIgnoreCase("no")) {
            System.out.println("Adiós!!");
            return false;
        } else {
            return true;
        }
    }

    public static void menuInicio(Scanner sc) {
        String select;
        System.out.println("El juego va de adivinar un número: ");
        System.out.println("(1) si quieres que la máquina adivine");
        System.out.println("(2) si quieres adivinar");
        select = sc.nextLine();
        switch (select) {
            case "1":
                juegaMaquina(sc);
                break;
            case "2":
                juegaUsuario(sc);
                break;
            default:
                System.out.println("Introduce una opción válida la próxima vez.");
                break;
        }
    }

    public static void juegaMaquina(Scanner sc) {
        int min = 1, max = 100, intentos = 0, guess;
        String entrada;
        System.out.println("La máquina intentará adivinar tu número");
        System.out.println("Si tu número es mayor, dile mayor. Si es menor, dile menor. Si acierta, dile correcto.");
        guess = aleatorio(min, max);

        do {
            System.out.println("Es tu número " + guess + "? (mayor/menor/correcto)");
            entrada = sc.nextLine();
            if (entrada.equalsIgnoreCase("menor")) {
                max = guess - 1;
                intentos++;
                guess = aleatorio(min, max);
            } else if (entrada.equalsIgnoreCase("mayor")) {
                min = guess + 1;
                intentos++;
                guess = aleatorio(min, max);
            } else if (entrada.equalsIgnoreCase("correcto")) {
                intentos++;
                System.out.println("La máquina ha adivinado tu número en " + intentos + " intentos");
            } else {
                System.out.println("Sólo se acepta mayor, menor o correcto.");
            }
        } while (!entrada.equalsIgnoreCase("correcto"));
    }

    public static void juegaUsuario(Scanner sc) {
        int answer, min = 1, max = 100, entrada, intentos = 0;
        answer = aleatorio(min, max);
        do {
            System.out.print("Introduce un número entre " + min + " y " + max + ": ");
            entrada = sc.nextInt();
            if (entrada < answer) {
                if (entrada > min) {
                    System.out.println("Tu número es menor ");
                    min = entrada;
                    intentos++;
                } else {
                    System.out.println("Elige un número entre los indicados");
                }

            } else if (entrada > answer) {
                if (entrada < max) {
                    System.out.println("Tu número es mayor ");
                    max = entrada;
                    intentos++;
                } else {
                    System.out.println("Elige un número entre los indicados");
                }

            } else {
                System.out.println("Has logrado adivinar el número!");
                intentos++;
                System.out.println("Te ha tomado " + intentos + " intentos adivinar el número.");
            }
        } while (entrada != answer);
    }

    public static int aleatorio(int min, int max) {
        int random = (int) (Math.random() * (max + 1 - min) + min);
        return random;
    }
}
