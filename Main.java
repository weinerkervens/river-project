/**
 * 
 */
package com.river.project;

import javax.swing.JOptionPane;

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
		
		/*
		 * ERROR_MESSAGE
		 * INFORMATION_MESSAGE
		 * WARNING_MESSAGE
		 * QUESTION_MESSAGE
		 * PLAIN_MESSAGE
		 */
		
		
		int chance = 3;
		boolean haveerror = true;
		int sizeInt = -1;
		
		JOptionPane.showMessageDialog(null, "Hi!\n"
				+ "We are going to create a river with some animals and\n"
				+ "simulate movements.", "The River", JOptionPane.INFORMATION_MESSAGE);
		
		
		do {			
			
			
			String size = JOptionPane.showInputDialog(null,
								"Please input the size of the river", "River Size - " + chance + " chance(s) left",
								JOptionPane.QUESTION_MESSAGE);
		
		
				
		   try {
			   
			   sizeInt = Integer.parseInt(size);
			
			   if(sizeInt <=1 ) {
				   
				haveerror = true;
				chance--;
				JOptionPane.showMessageDialog(null, "Your input should be at least 2.", "Invalid Value", JOptionPane.ERROR_MESSAGE);
				
			} else {
				haveerror = false;
			}
			
		} catch (NumberFormatException e) {
			
			if(size == null) {
				chance = 0;
			} else {
				if(size.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a number. Empty values are not allowed.", "Invalid Value", JOptionPane.WARNING_MESSAGE);
					chance--;
				} else {
					JOptionPane.showMessageDialog(null, "Only numbers are allowed.", "Invalid Value", JOptionPane.ERROR_MESSAGE);
					chance--;
				}
			}
			
		}
			
		} while( haveerror && chance > 0);
		
		
		
		
		
		
		if((chance>0) && (sizeInt >= 2)) {
			
			River river = new River(sizeInt);
			
			JOptionPane.showMessageDialog(null, "You've successfully created a river with " + sizeInt + " places.\n"
							+ "We've populated it with " + (sizeInt/2) + " animal(s) for you.", "River State", JOptionPane.INFORMATION_MESSAGE);
					
			System.out.println(river.toString());
					
					
			JOptionPane.showMessageDialog(null, "You are about to make animals move.\n"
							+ "GET READY!!!", "Movements", JOptionPane.INFORMATION_MESSAGE);
			
			
			
			
			String[] choices = {"MOVE", "MOVE 10X", "Cancel"};
			
			int breaker = 0;
			
			
			do {	
						
					
			int result = JOptionPane.showOptionDialog(null, "Would you like to make a single movement or 10 movements ?",
			                "Movements",
			                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
					
			switch(result) {
					case 0:
						String movement = river.movement();
						System.out.println(movement);
						JOptionPane.showMessageDialog(null, movement, "Moved", JOptionPane.INFORMATION_MESSAGE);
						System.out.println(river.toString());
						break;
					
					case 1:
						for(int i=0; i<10; i++) {
							String movement1 = river.movement();
							System.out.println(movement1);
							JOptionPane.showMessageDialog(null, movement1, "Movement #" + (i+1), JOptionPane.INFORMATION_MESSAGE);
							System.out.println(river.toString());
						}
						
						JOptionPane.showMessageDialog(null, "10 movements took place in the river.", "Summary", JOptionPane.INFORMATION_MESSAGE);
						System.out.println(river.toString());
						break;
						
					case 2:
						JOptionPane.showMessageDialog(null, "Okay! We got you.\nHave a good day ;)", "Good Bye!", JOptionPane.INFORMATION_MESSAGE);
						breaker = -1;
						break;
					
					default:
						JOptionPane.showMessageDialog(null, "Okay! We got you.\nHave a good day ;)", "Good Bye!", JOptionPane.INFORMATION_MESSAGE);
						breaker = -1;
						break;
						
					}							
			
			} while(breaker==0);
			
			
			
		}
		
		
		if(chance == 0) {
			JOptionPane.showMessageDialog(null, "We were glad to have you :)\nHave a good day!!!", "Good Bye!", JOptionPane.INFORMATION_MESSAGE);
		}
				
		
	}

}
