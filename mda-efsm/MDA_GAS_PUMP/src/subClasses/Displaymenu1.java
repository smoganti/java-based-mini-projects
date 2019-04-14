package subClasses;
import Driver.DataStore;
import Driver.DataStore_1;

public class Displaymenu1 extends Displaymenu{

	@Override
	public void displaymenu(DataStore d) {
		DataStore_1 d1 = (DataStore_1)d;
		System.out.println("Select from the list of options:");
		System.out.println("Diesel: "+d1.Dprice);
		System.out.println("Regular: "+d1.Rprice);
	}

}
