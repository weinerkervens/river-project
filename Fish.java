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
		super(isFemale, 0);
	}
	
	public String toString() {
		
		return new String(
				( this.getGender() ? "Female ":"Male ") +
				"Fish | " + 
				("Strength: " + this.getStrength())
				);
	}

}
