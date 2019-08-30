
package main_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   
   public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   public static float ans = 0;
   
   public static void main(String[] args) throws IOException{
      String input = "";
      System.out.println("*** BIENVENIDO A LA CALCULADORA ***\n");
      while(true){
         System.out.println("Digite alguna de las siguientes opciones...\n");
         System.out.println(
            "  1. Iniciar calculadora.\n" +
            "  2. Mostrar tabla de multiplicar.\n" +
            "  3. Salir del programa.\n"
         );
         System.out.print("Digite su opcion:");
         input = br.readLine();
         System.out.println("");
         if(input.equals("1") || input.equals("1.") || input.equals("uno") || input.equals("uno.")){
            System.out.println("*** Ahora esta en el programa de calculo de operaciones aritmeticas ***\n");
            ans = 0;
            boolean calculationStarted = false;
            while(true){
               if(calculationStarted){
                  System.out.println("EL resultado del ultimo calculo es: " + ans);
                  System.out.println("Para acceder a el use la palabra clave 'ans'.");
               }
               System.out.println(
                  "Cual de las siguientes operaciones desea realizar:\n" +
                  "  (+) suma.\n" +
                  "  (-) resta.\n" +
                  "  (*) multiplicacion.\n" +
                  "  (/) division.\n" +
                  "  (salir) salir de la calculadora.\n"
               );
               System.out.print("Operacion:");
               String operation = br.readLine();
               if(operation.equals("+") || operation.equals("(+)") ||
               operation.equals("suma") || operation.equals("suma.")){
                  System.out.print("Inserte el primer operando:");
                  String strOp_1 = br.readLine();
                  System.out.print("Inserte el segundo operando:");
                  String strOp_2 = br.readLine();
                  calculator(strOp_1, strOp_2, "+");
                  calculationStarted = true;
                  System.out.println("\nrespuesta: " + ans + "\n");
               }else if(operation.equals("-") || operation.equals("(-)") ||
               operation.equals("resta") || operation.equals("resta.")){
                  System.out.print("Inserte el primer operando:");
                  String strOp_1 = br.readLine();
                  System.out.print("Inserte el segundo operando:");
                  String strOp_2 = br.readLine();
                  calculator(strOp_1, strOp_2, "-");
                  calculationStarted = true;
                  System.out.println("\nrespuesta: " + ans + "\n");
               }else if(operation.equals("*") || operation.equals("(*)") ||
               operation.equals("multiplicacion") || operation.equals("multiplicacion.")){
                  System.out.print("Inserte el primer operando:");
                  String strOp_1 = br.readLine();
                  System.out.print("Inserte el segundo operando:");
                  String strOp_2 = br.readLine();
                  calculator(strOp_1, strOp_2, "*");
                  calculationStarted = true;
                  System.out.println("\nrespuesta: " + ans + "\n");
               }else if(operation.equals("/") || operation.equals("(/)") ||
               operation.equals("division") || operation.equals("division.")){
                  System.out.print("Inserte el primer operando:");
                  String strOp_1 = br.readLine();
                  System.out.print("Inserte el segundo operando:");
                  String strOp_2 = br.readLine();
                  calculator(strOp_1, strOp_2, "/");
                  calculationStarted = true;
                  System.out.println("\nrespuesta: " + ans + "\n");
               }else if(operation.equals("salir") || operation.equals("(salir)")){
                  System.out.println("\n*** Ha elegido salir de la calculadora ***\n");
                  break;
               }else{
                  System.out.println("\n[X] Ha ingresado una opcion invalida, intentelo de nuevo...\n");
               }
            }
         }else if(input.equals("2") || input.equals("2.") || input.equals("dos") || input.equals("dos.")){
            System.out.println("*** Ahora esta en el programa de calculo de tablas de multiplicar ***\n");
            while(true){
               System.out.println(
                  "Opciones:\n\n" +
                  "  1. Mostrar todas las tablas (del 1 al 10)\n" +
                  "  2. Mostrar una tabla con limite establecido.\n" +
                  "  3. Mostrar una tabla hasta el 10.\n" +
                  "  4. Salir.\n"
               );
               System.out.print("Opcion:");
               input = br.readLine();
               if(input.equals("1") || input.equals("1.") || input.equals("uno") || input.equals("uno.")){
                  System.out.println("");
                  for (int i = 1; i <= 10; i++) {
                     System.out.println(calculateTable(Integer.toString(i), "10"));
                  }
               }else if(input.equals("2") || input.equals("2.") || input.equals("dos") || input.equals("dos.")){
                  System.out.println("");
                  System.out.println("*** Solo valores enteros ***");
                  System.out.print("Ingrese el numero cuya tabla de multiplicar quiere graficar:");
                  String numTable = br.readLine();
                  System.out.print("Ingrese el numero limite para la tabla de multiplicar:");
                  String numLimit = br.readLine();
                  System.out.println("\n" + calculateTable(numTable, numLimit));
               }else if(input.equals("3") || input.equals("3.") || input.equals("tres") || input.equals("tres.")){
                  System.out.println("");
                  System.out.println("*** Solo valores enteros ***");
                  System.out.print("Ingrese el numero cuya tabla de multiplicar quiere graficar:");
                  String numTable = br.readLine();
                  System.out.println("\n" + calculateTable(numTable, "10"));
               }else if(input.equals("4") || input.equals("4.") || input.equals("salir") || input.equals("salir.")){
                  System.out.println("\n*** Ha elegido salir de las tablas de multiplicar ***\n");
                  break;
               }else{
                  System.out.println("\n[X] Ha ingresado una opcion invalida, intentelo de nuevo...\n");
               }
            }
         }else if(input.equals("3") || input.equals("3.") || input.equals("tres") || input.equals("tres.")){
            System.out.println("*** El programa ha finalizado ***\n");
            break;
         }else{
            System.out.println("[X] Entrada no valida...\n");
         }
      }
   }
   
   public static void calculator(String num1, String num2, String op){
      if(num1.equals("ans") && !num2.equals("ans")){
         ans = calculate(ans, Float.parseFloat(num2), op);
      }else if(!num1.equals("ans") && num2.equals("ans")){
         ans = calculate(Float.parseFloat(num1), ans, op);
      }else if(num1.equals("ans") && num2.equals("ans")){
         ans = calculate(ans, ans, op);
      }else{
         ans = calculate(Float.parseFloat(num1), Float.parseFloat(num2), op);
      }
   }
   
   public static float calculate(float num1, float num2, String op){
      float output = 0;
      if(op.equals("+")){
         output = num1 + num2;
      }else if(op.equals("-")){
         output = num1 - num2;
      }else if(op.equals("*")){
         output = num1 * num2;
      }else if(op.equals("/")){
         output = num1 / num2;
      }
      return(output);
   }
   
   public static String calculateTable(String strNum, String strLimit){
      int num = Integer.parseInt(strNum);
      int limit = Integer.parseInt(strLimit);
      String output = "";
      for (int i = 1; i <= limit; i++) {
         output += "<" + num + " * " + i + " = " + (num * i) + ">\n";
      }
      return(output);
   }
}
