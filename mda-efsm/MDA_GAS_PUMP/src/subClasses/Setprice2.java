package subClasses;

import Driver.DataStore;
import Driver.DataStore_2;

public class Setprice2 extends Setprice {

	

	@Override
	public void Setprice(int g, int m,DataStore d) {
		DataStore_2 d1 = (DataStore_2) d;
		switch(g){
		case 1:
			 d1.price =d1.Rprice;
			 break;
		case 2:
			d1.price = d1.Sprice;
			break;
		case 3:
			d1.price = d1.Pprice;
			break;
		}
		
	}

}
