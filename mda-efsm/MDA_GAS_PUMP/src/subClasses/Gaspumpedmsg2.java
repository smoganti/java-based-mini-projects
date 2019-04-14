package subClasses;
import Driver.DataStore;
import Driver.DataStore_2;

public class Gaspumpedmsg2 extends Gaspumpedmsg{

	@Override
	public void Gaspumpedmsg(DataStore d) {
	DataStore_2 d2 = (DataStore_2) d;
	
	System.out.println("Pumped 1 Liter of gasoline");
    System.out.println("Total Number of Liters pumped: " + d2.L +" Liters");
		
	}

}
