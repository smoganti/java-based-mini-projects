package subClasses;

import Driver.DataStore;
import Driver.DataStore_1;

public class Storeprice1 extends Storeprice {


	@Override
	public void storeprice(DataStore data) {
		DataStore_1 d1 = (DataStore_1) data;
		d1.Rprice = d1.temp_a;
		d1.Dprice =  d1.temp_b;
	}

}
