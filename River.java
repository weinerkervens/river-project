/**
 * 
 */
package com.river.project;

import java.util.Random;

/**
 * @author WINNER
 *
 */
public class River {
	
	private Animal[] animalArray;
	
	public River(int size) {
		
		
		this.animalArray = new Animal[size];
		Random rand = new Random();
		
		for(int i=0; i < (size/2); i++) {
			int randNumber = rand.nextInt(size);
			Animal[] randAnimal = new Animal[] {new Bear(rand.nextBoolean()), new Fish(rand.nextBoolean())};
			
			if (this.animalArray[randNumber] == null) {
				this.animalArray[randNumber] = randAnimal[rand.nextInt(2)];
			} else {
				i--;
			}
		}
		
		
		
	}
	
	
//	PSEUDO CODE
//	MOUVMAN POSIB SI GEN ESPAS VID
//	ALEYATWAMAN OU CHWAZI YON CHIF NAN SIZE TABLEAU A
//	SIL GEN YON ANIMAL LADAN
//		OU PRAN POSITIONL KI SE CHIF ALEYATWA A
//		OU PRAN REFERANS LI POUW KONN SEXE LI, TIP LI AK FOS LI
//		OU CHWAZI YON CHIF ALEYATWAMAN ANT 0, 1, 2 POUW KONN KI MOUVMAN LAP FE
//			0: LI RET KOTEL YE A
//			1: LI FE DEVAN (SIL KAPAB)
//			2: LI FE DEYE (SIL KAPAB)
//		SIL DESIDE BOUJE WAL GAD ENFOMASYON SOU ANIMAL KI NAN PLAS LI VLE ALE A (NAN INDEX +1 OUBYEN -1)
//		SIL MENM TIP EPI SE YON FEMEL PANDAN LOT LA SON MAL, LAP RET KOTEL YE A EPI LAP KREYE YON NOUVO MENM TIP EPI SEXE ALEYATWA
//		SIL MENM TIP EPI YO MENM SEXE, SAK PI FO A AP PRAN PLAS LOT LA
//		SIL YO TIP DIFERAN SAK GEN PLIS FOS LA AP PRAN PLAS LOT LA EPI LAP PRAN TOUT FOS LI
//	SIL PA GEN YON ANIMAL LADAN, LAP TIRE YON LOT CHIF ALEYATWA
	public String movement() {
		
		String movementDescription = "++++++++++++++ A MOVEMENT IS ABOUT TO TAKE PLACE IN THE RIVER ++++++++++++++\n\n";
		
		
//		Random number generator
		Random rand = new Random();
		
		int choice = -1;
		
//		Get the array length to check if there are empty spaces left
		int arrLength = animalArray.length;
		
//		Choose a random animal to move
		while(true) {
			choice = rand.nextInt(arrLength);
			
			if(animalArray[choice] != null) {
				break;
			}
			
		}
		
		
//		Now we have a valid animal reference which we chose randomly
		Animal selectedAnimal = animalArray[choice];
		
//		Displaying what's happening
		movementDescription += selectedAnimal.toString() + " at 0-based position "+ choice + " has the intention to move.\n";
		
		
//		Randomly choose a random movement decision
//		0: stays where it is
//		1: wants to move forward
//		2: wants to move backward
		int movementDecision = rand.nextInt(3);
		
		
//		Process each case of the movement decision
		switch(movementDecision) {
		
//		Stays at the same location
		case 0:
			movementDescription += "And has decided to stay where it is.\n";
			break;
		
//		Moves forward
		case 1:
			movementDescription += "And has decided to move forward.\n";
			
			
//			checks the bounds of the array			
			
			if( (choice + 1) >= arrLength ) {
				movementDescription += "\nBut unfortunately can't move because it has reached the limit of the river\n";
				
			} else {
				
//				Check if there is already an animal in the next position or not
				
//				If yes, prepare to process the conflict case
				if(animalArray[choice + 1] != null) {
					
//					Reference of the Animal in the next position
					Animal opponentAnimal = animalArray[choice + 1];
					
//					If both animals are of the same type (i.e Bear-Bear or Fish-Fish), process.
					if(selectedAnimal.isSameType(opponentAnimal)) {
						
						if(selectedAnimal.isOfSameGender(opponentAnimal)) {
							
							if(selectedAnimal.isStronger(opponentAnimal)) {
								
								float increment = opponentAnimal.getStrength() - (int) opponentAnimal.getStrength();
								selectedAnimal.setStrength(selectedAnimal.getStrength() + increment);

								animalArray[choice + 1] = selectedAnimal;
								animalArray[choice] = null;
								
								
								
							} else {
								
								float increment = selectedAnimal.getStrength() - (int) selectedAnimal.getStrength();
								opponentAnimal.setStrength(opponentAnimal.getStrength() + increment);
								
								animalArray[choice] = null;
								animalArray[choice + 1] = opponentAnimal;
								
							}
						} else {
							
							boolean availableSpace = false;
							
							for(int i = 0; i < arrLength ; i++) {
								
								if(animalArray[i]==null) {
									availableSpace = true;
									break;
								}
								
							}
							
							if(availableSpace) {
								Animal[] newBornArray = new Animal[] {new Bear(rand.nextBoolean()), new Fish(rand.nextBoolean())};
								
								Animal newBorn = (selectedAnimal.isSameType(newBornArray[0])) ? newBornArray[0] : newBornArray[1];
								
								while(true) {
									
									
									int randomPosition = rand.nextInt(arrLength);
									
									if(animalArray[randomPosition] == null) {
										animalArray[randomPosition] = newBorn;
										movementDescription += "\nA new Animal has been created." + "\nIt's description is "
															+ newBorn.toString()
															+ "\nAnd was put in the 0-based position "
															+ randomPosition + "\n";										
										break;
									}
									
								}
							} else {
								movementDescription += "\nUnfortunately there are no more spaces left to create new animal in the river.\n";
							}
							
						}					
					} else {
						
//						If both animals are of different type the strongest eats the weakest and acquire strength of the weakest
						if(selectedAnimal.isStronger(opponentAnimal)) {
							String selectedAnimalPreviousState = selectedAnimal.toString();
							
							selectedAnimal.setStrength(opponentAnimal.getStrength() + selectedAnimal.getStrength());
							
							animalArray[choice + 1] = selectedAnimal;
							animalArray[choice] = null;
							
							movementDescription += "\n" + selectedAnimalPreviousState + " has eaten " + opponentAnimal.toString() + "\n"
												+ "And is now " + selectedAnimal.toString() + "\n";
						} else {
							String opponentAnimalPreviousState = opponentAnimal.toString();
							opponentAnimal.setStrength(selectedAnimal.getStrength() + opponentAnimal.getStrength());
							
							animalArray[choice] = null;
							
							movementDescription += "\n" + selectedAnimal.toString() + " has been eaten by " + opponentAnimalPreviousState + "\n"
												+ "And the winning animal is now " + opponentAnimal.toString() + "\n";							
						}
					}
					
				} else {
					this.animalArray[choice + 1] = selectedAnimal;
					this.animalArray[choice] = null;
					movementDescription += "\nAnd successfully moved to 0-base position " + (choice + 1) + "\n";
					
				}
			}
			
			break;
			
			
		case 2:
			movementDescription += "And has decided to move backward.\n";
			
			
//			checks the bounds of the array			
			
			if( (choice - 1) < 0  ) {
				movementDescription += "\nBut unfortunately can't move because it has reached the limit of the river\n";
				
			} else {
				
//				Check if there is already an animal in the next position or not
				
//				If yes, prepare to process the conflict case
				if(animalArray[choice - 1] != null) {
					
//					Reference of the Animal in the next position
					Animal opponentAnimal = animalArray[choice - 1];
					
//					If both animals are of the same type (i.e Bear-Bear or Fish-Fish), process.
					if(selectedAnimal.isSameType(opponentAnimal)) {
						
						if(selectedAnimal.isOfSameGender(opponentAnimal)) {
							
							if(selectedAnimal.isStronger(opponentAnimal)) {
								
								float increment = opponentAnimal.getStrength() - (int) opponentAnimal.getStrength();
								selectedAnimal.setStrength(selectedAnimal.getStrength() + increment);

								animalArray[choice - 1] = selectedAnimal;
								animalArray[choice] = null;
								
								
								
							} else {
								
								float increment = selectedAnimal.getStrength() - (int) selectedAnimal.getStrength();
								opponentAnimal.setStrength(opponentAnimal.getStrength() + increment);
								
								animalArray[choice] = null;
								animalArray[choice - 1] = opponentAnimal;
								
							}
						} else {
							
							boolean availableSpace = false;
							
							for(int i = 0; i < arrLength ; i++) {
								
								if(animalArray[i]==null) {
									availableSpace = true;
									break;
								}
								
							}
							
							if(availableSpace) {
								Animal[] newBornArray = new Animal[] {new Bear(rand.nextBoolean()), new Fish(rand.nextBoolean())};
								
								Animal newBorn = (selectedAnimal.isSameType(newBornArray[0])) ? newBornArray[0] : newBornArray[1];
								
								while(true) {
									
									
									int randomPosition = rand.nextInt(arrLength);
									
									if(animalArray[randomPosition] == null) {
										animalArray[randomPosition] = newBorn;
										movementDescription += "\nA new Animal has been created." + "\nIt's description is "
															+ newBorn.toString()
															+ "\nAnd was put in the 0-based position "
															+ randomPosition + "\n";
										
										break;
									}
									
								}
							} else {
								movementDescription += "\nUnfortunately there are no more spaces left to create new animal in the river.\n";
							}
							
						}					
					} else {
						
//						If both animals are of different type the strongest eats the weakest and acquire strength of the weakest
						if(selectedAnimal.isStronger(opponentAnimal)) {
							String selectedAnimalPreviousState = selectedAnimal.toString();
							
							selectedAnimal.setStrength(opponentAnimal.getStrength() + selectedAnimal.getStrength());
							
							animalArray[choice - 1] = selectedAnimal;
							animalArray[choice] = null;
							
							movementDescription += "\n" + selectedAnimalPreviousState + " has eaten " + opponentAnimal.toString() + "\n"
												+ "And is now " + selectedAnimal.toString() + "\n";

						} else {
							String opponentAnimalPreviousState = opponentAnimal.toString();
							opponentAnimal.setStrength(selectedAnimal.getStrength() + opponentAnimal.getStrength());
							
							animalArray[choice] = null;
							
							movementDescription += "\n" + selectedAnimal.toString() + " has been eaten by " + opponentAnimalPreviousState + "\n"
												+ "And the winning animal is now " + opponentAnimal.toString() + "\n";
							
						}
					}
					
				} else {
					this.animalArray[choice - 1] = selectedAnimal;
					this.animalArray[choice] = null;
					movementDescription += "\nAnd successfully moved to 0-base position " + (choice - 1) + "\n";
					
				}
			}
			
			break;
			
			
		}
		
		movementDescription += "\n++++++++++++++++++++++++++++ END OF MOVEMENT +++++++++++++++++++++++++++\n";
		
		return movementDescription;
	}
	
	
	public String toString() {
		String riverState = "===============STATE OF THE RIVER================\n\n";
		
		for (int i = 0; i<this.animalArray.length;i++) {
			if (this.animalArray[i] == null) {
				riverState += i + "-\n";
			} else {
				riverState += i + "- " + this.animalArray[i].toString() + "\n";
			}
		}
		return riverState+= "\n================================================\n";
	}
	

}
