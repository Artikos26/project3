/** COS Project 3 - @author Calvin Johnson */

package todolist;

import java.time.LocalDate;

public class RecurringTask extends Task implements Recurring {
	private String recurrencePattern;
	
	public RecurringTask(String title, String description, LocalDate dueDate, int priority, String pattern) {
		super(title, description, dueDate, priority);
		this.recurrencePattern = pattern;
	}
	
	@Override
	public void setRecurrence (String pattern) {
		this.recurrencePattern = pattern;
	}
	
	@Override
	public String getRecurrence() {
		return this.recurrencePattern;
	}
	
	@Override
	public String getTaskType() {
		return "Recurring Task";
	}
	
	@Override
	public String getDetails() {
		return "Repeats: " + recurrencePattern + " | Description: " + description;
	}
}