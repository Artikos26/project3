/** COS Project 3 - @author Calvin Johnson */

package todolist;

import java.time.LocalDate;

public abstract class Task {

	public abstract String getTaskType();
	public abstract String getDetails();
	
	protected String title;
	protected String description;
	protected boolean completed;
	protected LocalDate dueDate;
	protected int priority;
	
	
	public Task(String title, String description, LocalDate dueDate, int priority) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.priority = priority;
		this.completed = false; // task starts incomplete
	}
	
	public void markComplete() { this.completed = true; }
	
	public String getTitle() { return title; }
	public String getDescription() { return description; }
	public boolean isCompleted() { return completed; }
	public LocalDate getDueDate() { return dueDate; }
	public int getPriority() { return priority; }
	public void resetCompletion() { this.completed = false; }
	
	@Override
	public String toString() {
		return "[" + getTaskType() + "] " + title + " (Due: " + dueDate + ") - " +
				(completed ? "Done" : "Pending");
	}
}
