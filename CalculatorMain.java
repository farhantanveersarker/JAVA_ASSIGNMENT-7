// Name: MD FARHAN TANVEER SARKER
// PRN: 23070126157
// Batch: 2023-27
// Branch: AIML(B3)


import java.util.Scanner;

 public class CalculatorMain {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         CalculatorOperations calc = new CalculatorOperations();
         boolean continueCalc = true;
 
         while (continueCalc) {
             displayMenu();
             try {
                 System.out.print("Enter your choice (1-8): ");
                 int choice = Integer.parseInt(scanner.nextLine());
 
                 switch (choice) {
                     case 1 -> performBinaryOperation(scanner, calc, "Addition", "add");
                     case 2 -> performBinaryOperation(scanner, calc, "Subtraction", "subtract");
                     case 3 -> performBinaryOperation(scanner, calc, "Multiplication", "multiply");
                     case 4 -> performBinaryOperation(scanner, calc, "Division", "divide");
                     case 5 -> performUnaryOperation(scanner, calc, "Square", "square");
                     case 6 -> performUnaryOperation(scanner, calc, "Cube", "cube");
                     case 7 -> performUnaryOperation(scanner, calc, "Square Root", "squareRoot");
                     case 8 -> {
                         continueCalc = false;
                         System.out.println("Calculator exiting. Goodbye!");
                     }
                     default -> throw new InvalidInputException("Choice must be between 1 and 8.");
                 }
             } catch (NumberFormatException e) {
                 System.out.println("Error: Please enter a valid number.");
             } catch (InvalidInputException e) {
                 System.out.println("Error: " + e.getMessage());
             } catch (Exception e) {
                 System.out.println("Unexpected error: " + e.getMessage());
             }
         }
         scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== Calculator Menu ===");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Square");
        System.out.println("6. Cube");
        System.out.println("7. Square Root");
        System.out.println("8. Exit");
    }

    private static void performBinaryOperation(Scanner scanner, CalculatorOperations calc, String operation, String method)
             throws InvalidInputException {
         try {
             System.out.print("Enter first number: ");
             double num1 = Double.parseDouble(scanner.nextLine());
             System.out.print("Enter second number: ");
             double num2 = Double.parseDouble(scanner.nextLine());
 
             double result = switch (method) {
                 case "add" -> calc.add(num1, num2);
                 case "subtract" -> calc.subtract(num1, num2);
                 case "multiply" -> calc.multiply(num1, num2);
                 case "divide" -> calc.divide(num1, num2);
                 default -> throw new InvalidInputException("Invalid operation.");
             };
             System.out.printf("%s Result: %.2f%n", operation, result);
         } catch (ArithmeticException e) {
             System.out.println("Error: " + e.getMessage());
         }
    }

    private static void performUnaryOperation(Scanner scanner, CalculatorOperations calc, String operation, String method)
             throws InvalidInputException {
         try {
             System.out.print("Enter a number: ");
             double num = Double.parseDouble(scanner.nextLine());
 
             double result = switch (method) {
                 case "square" -> calc.square(num);
                 case "cube" -> calc.cube(num);
                 case "squareRoot" -> calc.squareRoot(num);
                 default -> throw new InvalidInputException("Invalid operation.");
             };
             System.out.printf("%s Result: %.2f%n", operation, result);
         } catch (ArithmeticException e) {
             System.out.println("Error: " + e.getMessage());
         }
    }

}
