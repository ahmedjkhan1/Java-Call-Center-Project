package callcenter;
/**
 * 
 * @author Ahmed Jawad Khan
 * Date: 2020-02-20
 * File: CallDispatcher.Java
 * 
 * Question:
 * A big retail company has a customer service call center with employees, a supervisor, and a manager. 
 * There are multiple employees but there can be only one supervisor and one manager.The employees answer 
 * the incoming calls. If an employee cannot handle the call, the call will be forwarded to the supervisor. 
 * If the supervisor is either busy or cannot handle the call, the call will be forward to the manager.
 *
 *
 */


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// CallDispatcher Class - Dispatches the call to the rightful employee, stores the list of available employees
// if there are no available employees caller is put on the wait queue
public class CallDispatcher {
	private ArrayList<Employee> employees;
	private ArrayList<Call> waitQueue;

	CallDispatcher() {
		this.employees = new ArrayList<Employee>();
        this.waitQueue = new ArrayList<Call>();
	}
	
	private Optional<Employee> getCallHandler() {
		List<Employee> activeEmployees = employees.stream()
                .filter(Employee::isFree)
                .sorted(Comparator.comparingInt(Employee::getPriority))
                .collect(Collectors.toList());
	
	    if(!activeEmployees.isEmpty()){
	        return Optional.of(activeEmployees.get(0)); 
	    }
	return Optional.empty(); 
	}
	
	public void addEmployee(Employee employee) {
	    employees.add(employee);
	}
	
	public void findCallHandler(Caller caller) {
		findCallHandler(new Call(caller));
	}
	 
	public void findCallHandler(Call call) {
		/* check if any Agent is free */
	    Optional<Employee> handler = getCallHandler();
	    if (!handler.isPresent()) {
	        System.out.println("We appreciate your patience, your call is important to us, all our agents are busy at the moment, the next available agent will take your call");
	        putCallInWaitQueue(call);
	        return;
	    }
	    handler.get().assignCall(call);
	    call.setEmployee(handler.get());
	}
	
	public void putCallInWaitQueue(Call call) {
		int getRank = call.getRank();
		waitQueue.add(getRank, call);
		
	}
	
	public ArrayList<Call> getWaitQueue() {
		return waitQueue;
	}
	
	public ArrayList<Employee> getEmployeeList() {
		return employees;
	}
}
