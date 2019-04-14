package subClasses;
import Driver.DataStore_1;
import Driver.DataStore;

public class Pumpgasunit1 extends Pumpgasunit {

	@Override
	public void Pumpgasunit(DataStore d) {
		
		DataStore_1 d1 = (DataStore_1)d;
		
		/*
        Increment the appropriate data values
    */
		d1.G++;
        d1.total = d1.price * d1.G;
		
	}

}
