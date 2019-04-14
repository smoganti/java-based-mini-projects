package subClasses;
import Driver.DataStore;
import Driver.DataStore_1;
public class Storepin {

	public void Storepin(DataStore d){
		DataStore_1 d1 = (DataStore_1) d;
		d1.pin = d1.temp_p;
	}
}
