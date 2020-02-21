package callcenter;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class findCallHandlerTest {

	// Checks if Caller is put on hold after all employees are occupied
	// Creates 5 employees - 3 agents - 1 supervisor - 1 manager
	// create 9 callers
	// if caller9 is on hold test case pass if not fails
	@Test
	public void testWaitQueueEmpty() {
		System.out.println("Welcome to Ahmed's Call Center");
		CallDispatcher dispatcher = new CallDispatcher();
		dispatcher = createEmployee(dispatcher);
		
		Caller caller1 = new Caller("Lebron James");
		Caller caller2 = new Caller("Anthony Davis");
		Caller caller3 = new Caller("Rajon Rando");
		Caller caller4 = new Caller("Dwight Howard");
		Caller caller5 = new Caller("Kyle Kuzma");
		Caller caller6 = new Caller("Alex Curuso");
		
		dispatcher.findCallHandler(caller1); // received by Agent 1
		dispatcher.findCallHandler(new Call()); //received by Agent 2
		dispatcher.findCallHandler(new Call()); // received by Agent 3
		dispatcher.findCallHandler(new Call()); // received by Supervisor 1
		dispatcher.findCallHandler(caller2); // received by Supervisor 2
		dispatcher.findCallHandler(caller3); // received by Supervisor 3
		dispatcher.findCallHandler(caller4); // received by Manager 1
		dispatcher.findCallHandler(caller5); // received by Agent 2
		dispatcher.findCallHandler(caller6); // on hold - Will get message to wait for next available agent
		
		
		ArrayList<Call> waitQueueList = dispatcher.getWaitQueue();
		if (waitQueueList.isEmpty()) {
			fail("Caller was not put on hold, the wait Queue was empty");
		}
	}
	
	// Checks if correct employee is assined the correct caller
	// create 9 callers
	// if caller3 "Rajon Rondo" is assigned the right employee
	@Test
	public void testDispatchToEmployees() {
		System.out.println("Welcome to Ahmed's Call Center");
		CallDispatcher dispatcher = new CallDispatcher();
		dispatcher = createEmployee(dispatcher);
		
		Caller caller1 = new Caller("Lebron James");
		Caller caller2 = new Caller("Anthony Davis");
		Caller caller3 = new Caller("Rajon Rando");
		Caller caller4 = new Caller("Dwight Howard");
		Caller caller5 = new Caller("Kyle Kuzma");
		Caller caller6 = new Caller("Alex Curuso");
		
		dispatcher.findCallHandler(caller1); // received by Agent 1
		dispatcher.findCallHandler(new Call()); //received by Agent 2
		dispatcher.findCallHandler(new Call()); // received by Agent 3
		dispatcher.findCallHandler(new Call()); // received by Supervisor 1
		dispatcher.findCallHandler(caller2); // received by Supervisor 2
		dispatcher.findCallHandler(caller3); // received by Supervisor 3
		dispatcher.findCallHandler(caller4); // received by Manager 1
		dispatcher.findCallHandler(caller5); // received by Agent 2
		dispatcher.findCallHandler(caller6); // on hold - Will get message to wait for next available agent
		
		ArrayList<Employee> employeeList = dispatcher.getEmployeeList();
		Employee emp1 = employeeList.get(4);
		Call onCallWith = emp1.getOnCall();
		Caller whichCaller = onCallWith.getCaller();
		String nameOfCaller = whichCaller.getName();

		if (nameOfCaller != "Anthony Davis") {
			fail("Caller was not dispatched to the correct employee");
		}
	}
	
	
	// Functions creates a set of employee and returns the list
	public CallDispatcher createEmployee(CallDispatcher dispatcher) {
		dispatcher.addEmployee(new Agent("Agent Norman Powell", dispatcher));
		dispatcher.addEmployee(new Agent("Agent Pascal Siakam", dispatcher));
		dispatcher.addEmployee(new Agent("Agent Terrance Davis", dispatcher));
		
		dispatcher.addEmployee(new Supervisor("Supervisor Kyle Lowry", dispatcher));

		
		dispatcher.addEmployee(new Manager("Manager Nick Nurse", dispatcher));

		
		return dispatcher;
	}

}
