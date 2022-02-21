/**
 * 
 */
package com.river.project;

/**
 * @author WINNER
 *
 */
public class Bear extends Animal {
	
	public Bear(boolean isFemale) {
		super(isFemale , 15);
	}
	
	
	public String toString() {
			
			return new String(
					( this.getGender() ? "Female ":"Male ") +
					"Bear | " + 
					("Strength: " + this.getStrength())
					);
		}

}
