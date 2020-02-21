package callcenter;
/**
 * 
 * @author Ahmed Jawad Khan
 * Date: 2020-02-20
 * File: Employee.Java
 * 
 * Question:
 * A big retail company has a customer service call center with employees, a supervisor, and a manager. 
 * There are multiple employees but there can be only one supervisor and one manager.The employees answer 
 * the incoming calls. If an employee cannot handle the call, the call will be forwarded to the supervisor. 
 * If the supervisor is either busy or cannot handle the call, the call will be forward to the manager.
 *
 *
 */

// Employee Case - This the base class. Creates the employee and sets the status, name, and priority of employee
class Employee {
	private String name;
	private Call onCall;
	private CallDispatcher callDispatcher;
	protected int priority;
  
	Employee(String name, CallDispatcher callDispatcher) {
		this.name = name;
		this.callDispatcher = callDispatcher; 
	}

	public int getPriority() {
		return priority;
	}
  
	public boolean isFree() {
		return this.onCall == null;
	}

	public void assignCall(Call call) {
		System.out.println(name + " Received call!");
		onCall = call;
	}
	
	public Call getOnCall() {
		return onCall;
	}
}
