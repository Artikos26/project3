package todolist;

public class TaskManager {
	
	private MyArrayList<Task> allTasks;
	private MyStack undoStack;
	private MyQueue todayQueue;
	
	public TaskManager() {
		allTasks = new MyArrayList<>();
		undoStack = new MyStack();
		todayQueue = new MyQueue();
	}
	
	public MyArrayList<Task> getAllTasks() {
		return allTasks;
	}
	
	public MyQueue getTodayQueue() {
		return todayQueue;
	}
	
	public void addTask(Task task) {
		allTasks.add(task);
		// store action on stack: type, task, and current index (size - 1)
		undoStack.push(new UndoAction(UndoAction.ActionType.ADD, task, allTasks.size() - 1));
	}
	
	public void removeTask(int index) {
		if (index >= 0 && index < allTasks.size()) {
			Task removedTask = allTasks.get(index);
			allTasks.remove(index);
			undoStack.push(new UndoAction(UndoAction.ActionType.REMOVE, removedTask, index));
		}
	}
	
	public void completeTask(int index) {
		if (index >= 0 && index < allTasks.size()) {
			Task task = allTasks.get(index);
			if (!task.isCompleted()) {
				task.markComplete();
				undoStack.push(new UndoAction(UndoAction.ActionType.COMPLETE, task, index));
			}
		}
	}
	
	public void undo() {
		UndoAction lastAction = undoStack.pop();
		if (lastAction == null) {
			System.out.println("Nothing to undo.");
			return;
		}
		
		switch (lastAction.getType()) {
		case ADD:
			// To undo an add, remove the last item
			allTasks.remove(allTasks.size() - 1);
			break;
		case REMOVE:
			// For a basic implementation
			allTasks.add(lastAction.getTask());
			break;
		case COMPLETE:
			lastAction.getTask().resetCompletion();
			break;
		}
		System.out.println("Undo successful.");
	}
	
	public void loadTodayTasks() {
		todayQueue.clear();
		for (int i = 0; i < allTasks.size(); i++) {
			Task t = allTasks.get(i);
			if (t instanceof RecurringTask) {
				todayQueue.enqueue(t);
			}
		}
	}
	
	public void displayFiltered(String type) {
		for (int i = 0; i < allTasks.size(); i++) {
			Task t = allTasks.get(i);
			if (t.getTaskType().equalsIgnoreCase(type)) {
				System.out.println(i + ": " + t);
			}
		}
	}
}
