package subClasses;

import Driver.DataStore;
import Driver.DataStore_1;
public class Setprice1 extends Setprice{


	@Override
	public void Setprice(int g, int m,DataStore d) {
		DataStore_1 d1 = (DataStore_1) d;
		switch(g){
		case 1:
			 d1.price =d1.Rprice;
			 break;
		case 4:
			d1.price = d1.Dprice;
			break;
		}
	}

}
