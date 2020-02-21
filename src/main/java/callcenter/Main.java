package callcenter;


import java.lang.*;
import java.util.ArrayList;

/**
 * 
 * @author Ahmed Jawad Khan
 * Date: 2020-02-20
 * File: Main.Java
 * 
 * Question:
 * A big retail company has a customer service call center with employees, a supervisor, and a manager. 
 * There are multiple employees but there can be only one supervisor and one manager.The employees answer 
 * the incoming calls. If an employee cannot handle the call, the call will be forwarded to the supervisor. 
 * If the supervisor is either busy or cannot handle the call, the call will be forward to the manager.
 *
 *
 */

// Main Class - Create the simulation of a call center. Creates the employees (Agent, Supervisor, Manager)
// Also creates the caller - Some with name, some without names
// Procedure to handle the call or put call on hold is done in the main using respective classes and functions
public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to Ahmed's Call Center");
		CallDispatcher dispatcher = new CallDispatcher();
		
		dispatcher.addEmployee(new Agent("Agent Norman Powell", dispatcher));
		dispatcher.addEmployee(new Agent("Agent Pascal Siakam", dispatcher));
		dispatcher.addEmployee(new Agent("Agent Terrance Davis", dispatcher));
		
		dispatcher.addEmployee(new Supervisor("Supervisor Kyle Lowry", dispatcher));
		
		dispatcher.addEmployee(new Manager("Manager Nick Nurse", dispatcher));
		
		Caller caller1 = new Caller("Lebron James");
		Caller caller2 = new Caller("Anthony Davis");
		Caller caller3 = new Caller("Rajon Rando");
		Caller caller4 = new Caller("Dwight Howard");
		Caller caller5 = new Caller("Kyle Kuzma");
		Caller caller6 = new Caller("Alex Curuso");
		
		dispatcher.findCallHandler(caller1); // received by Agent 1
		dispatcher.findCallHandler(new Call()); //received by Agent 2
		dispatcher.findCallHandler(new Call()); // received by Agent 3
		dispatcher.findCallHandler(new Call()); // received by Supervisor
		dispatcher.findCallHandler(caller2); // received by Manager
		dispatcher.findCallHandler(caller3); // on hold
		dispatcher.findCallHandler(caller4); // on hold
		dispatcher.findCallHandler(caller5); // on hold 
		dispatcher.findCallHandler(caller6); // on hold 
	}
}

