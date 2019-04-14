package subClasses;
import Driver.DataStore;
import Driver.DataStore_2;
public class Setinitialvalues2 extends Setinitialvalues {

	@Override
	public void Setinitialvalues(DataStore d) {
		DataStore_2 d2 = (DataStore_2) d;
		d2.L =0;
		d2.total=0;
	}

}
