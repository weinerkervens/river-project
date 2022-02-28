/**
 * 
 */
package com.river.project;

/**
 * @author WINNER
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		River river = new River(10);
		
		System.out.println("INITIAL STATE OF THE RIVER\n\n" + river.toString() + "\n");
		int increment = 0;
		int limit = 30;
		
		while(increment <= limit) {
			river.movement();
			increment++;
		}
		
		System.out.println("\n\nFINAL STATE OF THE RIVER\n" + river.toString() + "\n");
	}

}
