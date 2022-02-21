/**
 * 
 */
package com.river.project;


/**
 * @author WINNER
 *
 */
public class Fish extends Animal{
	
	public Fish(boolean isFemale) {
		super(isFemale, 1);
	}
	
	public String toString() {
		
		return new String(
				( this.getGender() ? "Female ":"Male ") +
				"Fish | " + 
				("Strength: " + this.getStrength())
				);
	}

}
