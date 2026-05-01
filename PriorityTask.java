/** COS Project 3 - @author Calvin Johnson */

package todolist;

import java.time.LocalDate;

public class PriorityTask extends Task implements Prioritizable {
	
	public PriorityTask(String title, String description, LocalDate dueDate, int priority) {
		super(title, description, dueDate, priority);
	}
	
	@Override
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@Override
	public int getPriority() {
		return this.priority;
	}
	
	@Override
	public String getTaskType() {
		return "Priority Task";
	}
	
	@Override
	public String getDetails() {
		return "Priority Level: " + priority + " | Description: " + description;
	}
}