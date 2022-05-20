package com.gmail.at.kotamadeo.program;

import com.gmail.at.kotamadeo.utils.Utils;

import java.util.Scanner;

public class Program {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        int firstValue = 0;
        int secondValue = 0;
        int result = 0;
        while (true) {
            try {
                printMenu();
                String input = scanner.nextLine();
                if ("0".equals(input) || "выход".equalsIgnoreCase(input)) {
                    scanner.close();
                    break;
                } else {
                    int operationNumber = Integer.parseInt(input);
                    switch (operationNumber) {
                        case 1:
                            System.out.printf("%sВведите целые числа через пробел:%s%n",
                                    Utils.ANSI_BLUE, Utils.ANSI_RESET);
                            String[] values = scanner.nextLine().split(" ", 2);
                            firstValue = Integer.parseInt(values[0]);
                            secondValue = Integer.parseInt(values[1]);
                            break;
                        case 2:
                            result = firstValue - secondValue;
                            System.out.printf("%sРезультат вычитания числа \"%s\" из числа \"%s\" равен: %s%s%n",
                                    Utils.ANSI_CYAN, secondValue, firstValue, result, Utils.ANSI_RESET);
                            break;
                        case 3:
                            int absResult = Math.abs(result);
                            System.out.printf("%sЧисло \"%s\" с отброшенным знаком равно: %s%n",
                                    Utils.ANSI_CYAN, result, absResult, Utils.ANSI_RESET);
                            break;
                        default:
                            System.out.println(Utils.ANSI_RED + "Вы ввели неверный номер операции!" + Utils.ANSI_RESET);
                    }
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println(Utils.ANSI_RED + "Неверный ввод!" + Utils.ANSI_RESET);
            }
        }
    }

    private void printMenu() {
        System.out.println(Utils.ANSI_GREEN + "Эта программа позволяет вычесть одно целое число из другого." +
                Utils.ANSI_RESET);
        System.out.println(Utils.ANSI_YELLOW + "Возможные команды:" + Utils.ANSI_RESET);
        System.out.println("0 или выход: выход из программы.");
        System.out.println("1: ввести числа.");
        System.out.println("2: получить результат.");
        System.out.println("3: отбросить знак.");
        System.out.print(">>>>");
    }
}
