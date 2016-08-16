package rollDice;



public class RollDice {

	
	
	public int roll(){
		
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
		// TODO Auto-generated method stub
      RollDice firsTry = new RollDice();
      
      
      
      System.out.println(firsTry.roll());
	}

}
