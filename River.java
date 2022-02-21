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
		
		for(int i=0; i<size/2;i++) {
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
	public void mouvment() {
		Random rand = new Random();
		int arrLength = animalArray.length;
		
		while(true) {
			int choice = rand.nextInt(); 
		}
	}
	
	
	public String toString() {
		String riverState = "";
		
		for (int i = 0; i<this.animalArray.length;i++) {
			if (this.animalArray[i] == null) {
				riverState += i + "-\n";
			} else {
				riverState += i + "- " + this.animalArray[i].toString() + "\n";
			}
		}
		return riverState;
	}
	

}
