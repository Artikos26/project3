/** COS Project 3 - @author Calvin Johnson */

package todolist;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	
	private static TaskManager manager = new TaskManager();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean running = true;
		
		while (running) {
			printMenu();
			int choice = getIntInput();
			
			switch (choice) {
			case 1: addTask(); break;
			case 2: viewAll(); break;
			case 3: completeTask(); break;
			case 4: removeTask(); break;
			case 5: manager.undo(); break;
			case 6: manager.loadTodayTasks(); break;
			case 7: viewQueue(); break;
			case 8: processNext(); break;
			case 9: filterTasks(); break;
			case 10: running = false; break;
			default: System.out.println("Invalid choice. Try again.");
			}
		}
		
		System.out.println("Goodbye!");
	}
	
	private static void printMenu() {
		System.out.println("\n--- To-Do List System ---");
		System.out.println("1. Add Task\n2. View All Tasks\n3. Complete Task\n4. Remove Task\n5. Undo Last Action");
		System.out.println("6. Load Today's Tasks\n7. View Task Queue\n8. Process Next Task\n9. Filter Tasks\n10. Exit");
		System.out.print("Enter choice: ");
	}
	
	private static int getIntInput() {
		while (!scanner.hasNextInt()) {
			System.out.print("Invalid input. Please enter a number: ");
			scanner.next();
		}
		
		int input = scanner.nextInt();
		scanner.nextLine();
		return input;
	}
	
	private static void addTask() {
		System.out.println("\nSelect Task Type:");
		System.out.println("1. Simple Task");
		System.out.println("2. Priority Task");
		System.out.println("3. Recurring Task");
		System.out.print("Choice: ");
		int typeChoice = getIntInput();
		
		System.out.print("Enter Title: ");
		String title = scanner.nextLine();
		System.out.print("Enter Description: ");
		String desc = scanner.nextLine();
		
		int priority = 1;
		if (typeChoice == 1) {
			manager.addTask(new SimpleTask(title, desc, LocalDate.now(), priority));
		} else if (typeChoice == 2) {
			System.out.print("Enter Priority Level (1-5): ");
			priority = getIntInput();
			manager.addTask(new PriorityTask(title, desc, LocalDate.now(), priority));
		} else if (typeChoice == 3) {
			System.out.print("Enter Recurrence Pattern (e.g., Daily, Weekly): ");
			String pattern = scanner.nextLine();
			manager.addTask(new RecurringTask(title, desc, LocalDate.now(), priority, pattern));
		}
		
		System.out.println("Task added successfully.");
	}
	
	private static void viewAll() {
		System.out.println("\n--- All Tasks ---");
		if (manager.getAllTasks().size() == 0) {
			System.out.println("No tasks found.");
			return;
		}
		for (int i = 0; i < manager.getAllTasks().size(); i++) {
			System.out.println(i + ": " + manager.getAllTasks().get(i));
		}
	}
	
	private static void completeTask() {
		System.out.print("Enter the index of the task to complete: ");
		int index = getIntInput();
		manager.completeTask(index);
	}
	
	private static void removeTask() {
		System.out.print("Enter the index of the task to remove: ");
		int index = getIntInput();
		if (index >= 0 && index < manager.getAllTasks().size()) {
			manager.removeTask(index);
			System.out.println("Task removed.");
		} else {
			System.out.println("Error: Invalid task index.");
		}
	}
	
	private static void viewQueue() {
		System.out.println("\n--- Today's Task Queue ---");
	}
	
	private static void processNext() {
		
	}
	
	private static void filterTasks() {
		System.out.print("Enter task type (Simple/Priority/Recurring): ");
		String type = scanner.nextLine();
		manager.displayFiltered(type);
	}
}
