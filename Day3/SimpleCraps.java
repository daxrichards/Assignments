package simpleCrapsGame;
import java.lang.*;
import java.util.*;

public class SimpleCraps {
	
	static int wins = 0;
	static int losses = 0;
	
	//Creating an empty SimpleCraps Constructor that contains no arguments
	public SimpleCraps(){}
	
	public int roll(){
		//Purpose of this method is to simulate the roll of two dice by creating two random numbers 
		int dice1;
		int dice2;
		int rollTotal;
		
		
		
		
		dice1 = (int) java.lang.Math.ceil(java.lang.Math.random()*6);
		dice2 = (int) java.lang.Math.ceil(java.lang.Math.random()*6);

		System.out.println("dice1 = " + dice1);
		System.out.println("dice2 = " + dice2);
        
		
		
		//Adding the random numbers together to obtain a total for the first roll called rollTotal
		rollTotal = dice1 + dice2;
		
		System.out.println("--------" );
		System.out.println(rollTotal + " <--Total from first roll \n" );
		
		return rollTotal;
	}
	public int rollAgain(int thePoint ){
		//Purpose of this method is to simulate a subsequent roll of the dice in those cases where a "Point" value is applicable
		int dice1;
		int dice2;
		int rollCnt = 0;
		int subSpinTotal;
		
		//The dice will be rolled multiple times until the subSpinTotal = 7 (loss) or subSpinTotal = Point (win)
		do{
			rollCnt++;
		dice1 = (int) java.lang.Math.ceil(java.lang.Math.random()*6);
		dice2 = (int) java.lang.Math.ceil(java.lang.Math.random()*6);
		
	    System.out.println("\nThis is attempt " + rollCnt + " to match the Point Value: " + thePoint);	
	    
	    System.out.println("dice1 = " + dice1);
		System.out.println("dice2 = " + dice2);
		System.out.println("--------" );
		
		
		subSpinTotal = dice1 + dice2;
		System.out.println(subSpinTotal + " <--Total from attempt " +rollCnt );
		
		}while(subSpinTotal != 7 && subSpinTotal != thePoint );
		
		
		if(subSpinTotal == thePoint){
			if(thePoint < 10){
			//System.out.println("\n");
			System.out.println("*********************************************************");
			System.out.println("**                  You are a winner                   **");
			System.out.println("**       The point was "+ thePoint + " and you spun a(n) " + thePoint + "           **");
			System.out.println("**              It took you " +rollCnt+ " attempt(s)               **");
			System.out.println("*********************************************************");
			wins++;
			}
			else{
			//System.out.println("\n");
			System.out.println("*********************************************************");
			System.out.println("**                  You are a winner                   **");
			System.out.println("**       The point was "+ thePoint + " and you spun a(n) " + thePoint + "         **");
			System.out.println("**               It took you " +rollCnt+ " attempt(s)              **");
			System.out.println("*********************************************************");
			wins++;
				
			}
		}
		else if(subSpinTotal == 7){
			System.out.println("You spun a " + subSpinTotal + " in attempt " + rollCnt +" so you lost");
			losses++;
		}
		
		return subSpinTotal;		
	}
	  //This method accepts the total rolled from the first roll and evaluates for win/loss/point value
		public int evalRoll(int totalRoll){	
			
			
			int point = 0;
		
	    //Evaluating the totals to determine winners and losers from first roll and point values if applicable
			
		switch (totalRoll) {
        case 7:  System.out.println("You're a winner");
                 wins++;
                 break;
        case 2:  System.out.println("You lose");
                 losses++;
                 break;
        case 3:  System.out.println("You lose");
                  losses++;
                 break;
        case 12: System.out.println("You lose");
                  losses++;
                 break;
        default: point = totalRoll;
                 break;
    }

		
		return point;
	}
	

	public static void main(String[] args) {
		
		int dispCounter = 0;
		int pointValue;
		
		// Creating a SimpleCraps class object
		SimpleCraps throwDice = new SimpleCraps();
		
		
	//*Extra Credit*- For Loop added to run the game more than 100 times and track wins/losses
	for(int i= 0; i<150; i = wins + losses){
		
		System.out.println("\n");
		System.out.println("*********************");
		System.out.println("    GAME " + (i+1) +"     ");
		System.out.println("*********************");
		
		
		//Assigning a value to the "Point"		
		pointValue = throwDice.evalRoll(throwDice.roll());
		
		if(pointValue != 0){
		System.out.println("The point is " + pointValue);
		}
		
	
		if(pointValue != 0){
			
				throwDice.rollAgain(pointValue);
			}
		dispCounter++;
		
		
    
	}	
	//Display the results for readability
	System.out.println("\n");
	System.out.println("*********************************************************");
	System.out.println("**        You played "+ dispCounter +" games.  Your results are:     **");
	System.out.println("                 WINS: " + wins + " Losses " + losses   +"                 ");
	System.out.println("**                                                     **");
	System.out.println("*********************************************************");
	
	}
		
	    	
	}



	
	
