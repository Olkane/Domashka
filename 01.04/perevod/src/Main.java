import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Перевод из двоичной системы в десятичную и шестнадцатеричную");
            System.out.println("2. Перевод из десятичной системы в двоичную и шестнадцатеричную");
            System.out.println("3. Перевод из шестнадцатеричной системы в двоичную и десятичную");
            System.out.println("4. Сложение двух чисел в выбранной системе");
            System.out.println("5. Вычитание двух чисел в выбранной системе");
            System.out.println("0. Выход");
            System.out.print("Введите номер действия: ");
            String choice = scanner.nextLine();

            if (choice.equals("0")) {
                System.out.println("Выход из программы.");
                break;
            } else if (choice.equals("1")) {
                System.out.print("Введите двоичное число: ");
                String binary = scanner.nextLine();
                try {
                    Binary b = new Binary(binary);
                    System.out.println("Десятичное: " + b.getDecimal());
                    System.out.println("Шестнадцатеричное: " + b.getHexdecimal());
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            } else if (choice.equals("2")) {
                System.out.print("Введите десятичное число: ");
                String decimal = scanner.nextLine();
                try {
                    Decimal d = new Decimal(decimal);
                    System.out.println("Двоичное: " + d.getBinary());
                    System.out.println("Шестнадцатеричное: " + d.getHexdecimal());
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            } else if (choice.equals("3")) {
                System.out.print("Введите шестнадцатеричное число: ");
                String hex = scanner.nextLine();
                try {
                    Hexdecimal h = new Hexdecimal(hex);
                    System.out.println("Двоичное: " + h.getBinary());
                    System.out.println("Десятичное: " + h.getDecimal());
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            } else if (choice.equals("4")) {
                System.out.print("Выберите систему для сложения (binary, decimal, hexdecimal): ");
                String systemType = scanner.nextLine();
                System.out.print("Введите первое число: ");
                String num1 = scanner.nextLine();
                System.out.print("Введите второе число: ");
                String num2 = scanner.nextLine();
                try {
                    if (systemType.equals("binary")) {
                        Binary n1 = new Binary(num1);
                        Binary n2 = new Binary(num2);
                        System.out.println("Результат сложения: " + n1.getAdditionResult(n2));
                    } else if (systemType.equals("decimal")) {
                        Decimal n1 = new Decimal(num1);
                        Decimal n2 = new Decimal(num2);
                        System.out.println("Результат сложения: " + n1.getAdditionResult(n2));
                    } else if (systemType.equals("hexdecimal")) {
                        Hexdecimal n1 = new Hexdecimal(num1);
                        Hexdecimal n2 = new Hexdecimal(num2);
                        System.out.println("Результат сложения: " + n1.getAdditionResult(n2));
                    } else {
                        System.out.println("Неверный тип системы");
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            } else if (choice.equals("5")) {
                System.out.print("Выберите систему для вычитания (binary, decimal, hexdecimal): ");
                String systemType = scanner.nextLine();
                System.out.print("Введите первое число: ");
                String num1 = scanner.nextLine();
                System.out.print("Введите второе число: ");
                String num2 = scanner.nextLine();
                try {
                    if (systemType.equals("binary")) {
                        Binary n1 = new Binary(num1);
                        Binary n2 = new Binary(num2);
                        System.out.println("Результат вычитания: " + n1.getSubtractionResult(n2));
                    } else if (systemType.equals("decimal")) {
                        Decimal n1 = new Decimal(num1);
                        Decimal n2 = new Decimal(num2);
                        System.out.println("Результат вычитания: " + n1.getSubtractionResult(n2));
                    } else if (systemType.equals("hexdecimal")) {
                        Hexdecimal n1 = new Hexdecimal(num1);
                        Hexdecimal n2 = new Hexdecimal(num2);
                        System.out.println("Результат вычитания: " + n1.getSubtractionResult(n2));
                    } else {
                        System.out.println("Неверный тип системы");
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            } else {
                System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
        scanner.close();
    }
}
