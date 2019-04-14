package subClasses;

import Driver.DataStore;
import Driver.DataStore_2;

public class Storeprice2 extends Storeprice {

	@Override
	public void storeprice(DataStore data) {
		DataStore_2 d1 = (DataStore_2) data;
		d1.Sprice = d1.temp_a;
		d1.Rprice =  d1.temp_b;
		d1.Pprice = d1.temp_c;
	}

}
