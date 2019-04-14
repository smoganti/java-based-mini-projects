package subClasses;
import Driver.DataStore;
import Driver.DataStore_1;


public class Gaspumpedmsg1 extends Gaspumpedmsg{

	@Override
	public void Gaspumpedmsg(DataStore d) {
		DataStore_1 d1 = (DataStore_1)d;
		
		System.out.println("Pumped 1 gallon of Gasoline");
        System.out.println("Total Number of gallons pumped: " + d1.G+" Gallons");
	}

}
