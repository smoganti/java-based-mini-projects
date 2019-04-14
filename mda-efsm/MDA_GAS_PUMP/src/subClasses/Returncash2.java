package subClasses;
import Driver.DataStore_2;
import Driver.DataStore;

public class Returncash2 extends Returncash{

	@Override
	public void Returncash(DataStore d) {
		DataStore_2 d2 = (DataStore_2) d;
		
		if ((d2.cash - d2.total) > 0) {
            System.out.println("Cash to return: $" + (d2.cash - d2.total));
            System.out.println("Returning Cash $" + (d2.cash - d2.total));
        } else {
            System.out.println("No cash to be returned");
        }
        System.out.println("Transaction Complete !");
    }
	
}
