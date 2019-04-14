package subClasses;

import Driver.DataStore_2;
import Driver.DataStore;

public class initializedata2 extends initializedata{

	@Override
	public void initializedata(DataStore d) {
		DataStore_2 d1 = (DataStore_2)d;
		d1.price=0;
		d1.cash=0;
		
		
	}

}
