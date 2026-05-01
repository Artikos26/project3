/** COS Project 3 - @author Calvin Johnson */

package todolist;

public class UndoAction {
	
	public enum ActionType { ADD, REMOVE, COMPLETE }
	
	private ActionType type;
	private Task task;
	private int index; // for putting a removed task back in the right spot
	
	public UndoAction(ActionType type, Task task, int index) {
		this.type = type;
		this.task = task;
		this.index = index;
	}
	
	public ActionType getType() { return type; }
	public Task getTask() { return task; }
	public int getIndex() { return index; }
}
