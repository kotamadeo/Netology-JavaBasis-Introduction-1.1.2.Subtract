# **Задача №2 Вычитание разности переменных**

## **Цель**:

1. Создать программу, которая будет вычитать из одной произвольной переменной - другую.

### *Пример*:
``` Пример 1
10
```
``` Пример 2 
-300
```

### **Моя реализация**:

1. Реализация осуществлена в парадигме ООП.
2. Создал отдельный класс **Program**, и использовал в реализации метода *start()* ```Scanner``` для общения с
   пользователем, метод *start()* дополнительно инициирует внутри себя ```void``` метод *printMenu()*, выводящий меню на экран.

#### Класс **Program**:
``` java 
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
        System.out.println("1: ввести числа число.");
        System.out.println("2: получить результат.");
        System.out.println("3: отбросить знак.");
        System.out.print(">>>>");
    }
}
```

3. Использовал кодирование цвета текста (ANSI).

#### Класс **Utils**:
``` java
public class Utils {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void printDelim() {
        System.out.println(ANSI_GREEN + "*********************************************" + ANSI_RESET);
    }
}
```

4. Использовал ```try-catch```, чтобы избежать падение программы в исключения.
5. Дополнительно реализовал возможность отбросить модуль числа через ```Math.abs```.

#### Метод *main()* в классе **Main**:
``` java
public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        program.start();
    }
}
```

## *Вывод в консоль*:

* меню:
``` 
Эта программа позволяет вычесть одно целое число из другого.
Возможные команды:
0 или выход: выход из программы.
1: ввести числа.
2: получить результат.
3: отбросить знак.
>>>>
```

* Демонстрация работы:
```
>>>>1
Введите целые числа через пробел:
9 10

>>>>2
Результат вычитания числа "10" из числа "9" равен: -1

>>>>3
Число "-1" с отброшенным знаком равно: 1
```