package subClasses;

import Driver.DataStore;
import Driver.DataStore_2;
public class Storecash {

	public void Storecash(DataStore d){
		DataStore_2 d2 = (DataStore_2)d;
		d2.cash = d2.temp_cash;
	}
}
