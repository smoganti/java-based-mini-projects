package subClasses;
import Driver.DataStore;
import Driver.DataStore_1;
public class initializedata1 extends initializedata {

	@Override
	public void initializedata(DataStore d) {
		DataStore_1 d1 = (DataStore_1)d;
		d1.price=0;
	}

}
