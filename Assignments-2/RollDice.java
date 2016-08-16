package rollDice;



public class RollDice {

	
	
	public int roll(){
		//This method will simulate the rolling of the dice 
		int total = 0;
		int rand = 0;
		
		
		while(rand !=1){		
			
			rand = (int) java.lang.Math.ceil(java.lang.Math.random()*10);
			System.out.println(rand);
			if(rand >=1 && rand <=6){
			total += rand;
			}
			else {
				continue;
			}
		}
		
		return (total - 1);
	}
	
	
	
	public static void main(String[] args) {
		// This creates an instance of the RollDice Class 
      RollDice firsTry = new RollDice();
      
      
      
      System.out.println(firsTry.roll());
	}

}
