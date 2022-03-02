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
		
		String size = JOptionPane.showInputDialog(null, "Please input the size of the river", "River Size", JOptionPane.QUESTION_MESSAGE);
		
		System.out.println(size);
		
		int sizeInteger = Integer.parseInt(size);
		
		River river = new River(sizeInteger);
		
		JOptionPane.showMessageDialog(null, river.toString(), "River State", JOptionPane.INFORMATION_MESSAGE);
		
		JOptionPane.showMessageDialog(null, river.movement(), "River State", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, river.movement(), "River State", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, river.movement(), "River State", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, river.movement(), "River State", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, river.movement(), "River State", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, river.movement(), "River State", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, river.movement(), "River State", JOptionPane.INFORMATION_MESSAGE);
		
		JOptionPane.showMessageDialog(null, river.toString(), "River State", JOptionPane.INFORMATION_MESSAGE);
		
		
		
//		System.out.println(msg);
		
		
	}

}
