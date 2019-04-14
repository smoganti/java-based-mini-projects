package subClasses;
import Driver.DataStore;
import Driver.DataStore_1;

public class Setinitialvalues1 extends Setinitialvalues {

	@Override
	public void Setinitialvalues(DataStore d) {
		DataStore_1 d2 = (DataStore_1) d;
		d2.G =0;
		d2.total=0;
		
	}

}
