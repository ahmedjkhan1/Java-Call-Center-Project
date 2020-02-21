package callcenter;
/**
 * 
 * @author Ahmed Jawad Khan
 * Date: 2020-02-20
 * File: Manager.Java
 * 
 * Question:
 * A big retail company has a customer service call center with employees, a supervisor, and a manager. 
 * There are multiple employees but there can be only one supervisor and one manager.The employees answer 
 * the incoming calls. If an employee cannot handle the call, the call will be forwarded to the supervisor. 
 * If the supervisor is either busy or cannot handle the call, the call will be forward to the manager.
 *
 *
 */

// Manager Class - Extends the Employee class and uses employee constructor to set values of the employee class
public class Manager extends Employee {
	Manager(String name, CallDispatcher callDispatcher) {
        super(name, callDispatcher);
        this.priority = 3;
	}
}
