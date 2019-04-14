package subClasses;
import Driver.DataStore_2;
import Driver.DataStore;

public class Pumpgasunit2 extends Pumpgasunit{

	@Override
	public void Pumpgasunit(DataStore d) {
		DataStore_2 d2 = (DataStore_2)d;
		
		/*
        Increment the appropriate data values
    */
    d2.L++;
    d2.total = d2.price * d2.L;
		
	}

}
