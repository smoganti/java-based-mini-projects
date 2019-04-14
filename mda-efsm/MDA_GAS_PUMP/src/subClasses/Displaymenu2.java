package subClasses;
import Driver.DataStore;
import Driver.DataStore_2;

public class Displaymenu2 extends Displaymenu{

	@Override
	public void displaymenu(DataStore d) {
		DataStore_2 d2 = (DataStore_2) d;
		System.out.println("Select from the list of options:");
		System.out.println("Premium: "+d2.Pprice);
		System.out.println("Regular: "+d2.Rprice);
		System.out.println("Super: "+d2.Sprice);
		
	}

}
