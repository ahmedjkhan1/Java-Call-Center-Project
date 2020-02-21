package callcenter;
/**
 * 
 * @author Ahmed Jawad Khan
 * Date: 2020-02-20
 * File: Call.Java
 * 
 * Question:
 * A big retail company has a customer service call center with employees, a supervisor, and a manager. 
 * There are multiple employees but there can be only one supervisor and one manager.The employees answer 
 * the incoming calls. If an employee cannot handle the call, the call will be forwarded to the supervisor. 
 * If the supervisor is either busy or cannot handle the call, the call will be forward to the manager.
 *
 *
 */

// Call Class - Handles the call attributes and sets the rank, caller, and which employee is taking the call
final class Call { // final by default
	private int rank;
	private Caller caller;
	private Employee employee;

	Call() {
		this.rank = 0;
	}

	Call(Caller caller) {
		super();
		this.caller = caller;
	}

	public int getRank() {
		return rank;
	}

	public void incrementRank() {
		this.rank += 1;
	}

	public void setCaller(Caller caller) {
		this.caller = caller;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Caller getCaller(){
		return caller;
	}
}
