package callcenter;
/**
 * 
 * @author Ahmed Jawad Khan
 * Date: 2020-02-20
 * File: Caller.Java
 * 
 * Question:
 * A big retail company has a customer service call center with employees, a supervisor, and a manager. 
 * There are multiple employees but there can be only one supervisor and one manager.The employees answer 
 * the incoming calls. If an employee cannot handle the call, the call will be forwarded to the supervisor. 
 * If the supervisor is either busy or cannot handle the call, the call will be forward to the manager.
 *
 *
 */

// Caller Class - Holds the information of the caller
final class Caller {
	private String name;

	Caller(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}