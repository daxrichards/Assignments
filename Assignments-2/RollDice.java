package rollDice;


//Roll Dice Class to simulate the rolling of dice
public class RollDice {

	
	
	public int roll(){
		
		//This wonderful method will use a while loop to generate a series of random numbers to be totalled, until which point a #1 is generated and the loop is exited.
		
		
		int total = 0;
		int rand = 0;
		
		
		while(rand !=1){		
			
			rand = (int) java.lang.Math.ceil(java.lang.Math.random()*6);
			System.out.println(" " + rand);
			total += rand;
						
			}
		total = total - 1;
		System.out.println("****\n" + total + " <-Total\n");
		
		return (total);
	}
	public void dispTotals(int[] rollTot){
		java.util.Arrays.sort(rollTot);
		for(int i=0;i < 100;i++){
		System.out.println("The Total at index " + i + " = " + rollTot[i] );
		
	    }	
	}
	
		
  
	
	
	public static void main(String[] args) {
		
		int[] totals = new int[100];
		
		// A new instance of the RollDice class is created
      RollDice rollIt = new RollDice();
      
      //Create an array called Totals and populate each index of the array with totals from 100 runs
        for(int i=0; i<100; i++){
    	  totals[i] = rollIt.roll();
        }
      //Towards bottom of console - This call will display the totals from 100 runs in order from least to greatest
     rollIt.dispTotals(totals);
          
 
      
      }

}
