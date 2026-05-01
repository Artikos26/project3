/** COS Project 3 - @author Calvin Johnson */

package todolist;

public interface Prioritizable {

	/**
	 * @param priority - integer representing task priority
	 */
	void setPriority(int priority);
	
	/**
	 * @return - priority value
	 */
	int getPriority();
}
