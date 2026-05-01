/** COS Project 3 - @author Calvin Johnson */

package todolist;

import java.time.LocalDate;

public class SimpleTask extends Task{

	public SimpleTask(String title, String description, LocalDate dueDate, int priority) {
		super(title, description, dueDate, priority);
	}
	
	@Override
	public String getTaskType() {
		return "Simple Task";
	}
	
	@Override
	public String getDetails() {
		return "Description: " + description;
	}
}
