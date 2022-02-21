package com.river.project;

import java.util.Random;

public class Animal {
	
//	INSTANCE VARIABLES
	private float animalStrength;
	private boolean isFemale;
	
//	CONSTRUCTORS
	public Animal() {
		this.animalStrength = 0;
		this.isFemale = false;
	}
	
	public Animal(boolean isFemale, float animalStrength) {
		Random rand = new Random();
		this.isFemale = isFemale;
		this.animalStrength = animalStrength + rand.nextFloat();
	}
	
	
//	ACCESSORS
	public float getStrength() {
		return this.animalStrength;
	}
	
	public boolean getGender() {
		return this.isFemale;
	}
	
	
//	MUTATORS
	public void setStrength(float animalStrength) {
		this.animalStrength = animalStrength;
	}
	
	
//	METHODS
	public boolean isStronger(Animal otherAnimal) {
		boolean isStronger = this.animalStrength > otherAnimal.getStrength();
		
		return isStronger;
	}
	
	public boolean isOfSameGender(Animal otherAnimal) {
		return this.getGender() == otherAnimal.getGender();
	}
	
	public  boolean isSameType(Animal otherAnimal) {
		return this.getClass() == otherAnimal.getClass();
	}
	
	public String toString() {
		
		return new String(
				( this.getGender() ? "Female ":"Male ") +
				"Animal | " + 
				("Strength: " + this.getStrength())
				);
	}
	
	
	

}
