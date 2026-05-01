/** COS Project 3 - @author Calvin Johnson */

package todolist;

public interface Recurring {
	
	/**
	 * @param pattern - string description of recurrence (EX. daily, weekly)
	 */
	void setRecurrence(String pattern);
	
	/**
	 * @return -  recurrence string
	 */
	String getRecurrence();
}
