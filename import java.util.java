import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {

    // Метод для вывода пронумерованного списка дел
    private static void printTasks(ArrayList<String> tasks) {
        System.out.println("Ваш список дел:");
        if (tasks.isEmpty()) {
            System.out.println("(список пуст)");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите операцию:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить дело");
            System.out.println("2. Показать дела");
            System.out.println("3. Удалить дело по номеру");
            System.out.println("4. Удалить дело по названию");
            System.out.print("Ваш выбор: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "0":
                    System.out.println("Программа завершена. Хорошего дня!");
                    scanner.close();
                    return;

                case "1":
                    System.out.print("Введите название задачи: ");
                    String taskName = scanner.nextLine().trim();
                    
                    if (taskName.isEmpty()) {
                        System.out.println("Название дела не может быть пустым!");
                    } else if (tasks.contains(taskName)) {
                        System.out.println("Такое дело уже есть в списке!");
                    } else {
                        tasks.add(taskName);
                        System.out.println("Добавлено!");
                    }
                    printTasks(tasks);
                    break;

                case "2":
                    printTasks(tasks);
                    break;

                case "3":
                    if (tasks.isEmpty()) {
                        System.out.println("Список дел пуст, удалять нечего.");
                        break;
                    }
                    System.out.print("Введите номер для удаления: ");
                    String numInput = scanner.nextLine().trim();
                    
                    try {
                        int taskNum = Integer.parseInt(numInput);
                        if (taskNum >= 1 && taskNum <= tasks.size()) {
                            tasks.remove(taskNum - 1);
                            System.out.println("Удалено!");
                        } else {
                            System.out.println("Ошибка: дела с номером " + taskNum + " не существует!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: пожалуйста, введите корректное число!");
                    }
                    printTasks(tasks);
                    break;

                case "4":
                    if (tasks.isEmpty()) {
                        System.out.println("Список дел пуст, удалять нечего.");
                        break;
                    }
                    System.out.print("Введите задачу для удаления: ");
                    String taskToDelete = scanner.nextLine().trim();
                    
                    if (tasks.contains(taskToDelete)) {
                        tasks.remove(taskToDelete);
                        System.out.println("Удалено!");
                    } else {
                        System.out.println("Ошибка: дело с текстом '" + taskToDelete + "' не найдено!");
                    }
                    printTasks(tasks);
                    break;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, введите цифру от 0 до 4.");
                    break;


}
        }
    }
}