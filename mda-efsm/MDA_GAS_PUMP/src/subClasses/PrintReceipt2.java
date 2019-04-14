package subClasses;
import Driver.DataStore;
import Driver.DataStore_2;

public class PrintReceipt2 extends PrintReceipt {

	@Override
	public void PrintReceipt(DataStore d) {
		DataStore_2 d2 = (DataStore_2) d;
		
		
		if(d2.cash>0) {
			System.out.println("-----------------------RECEIPT----------------------------------------");
    		System.out.println(d2.L + " Liters of gasoline @ $" + d2.price + "/liter");
    		System.out.println("Total: $" + (float) d2.total);
    		System.out.println("Cash inserted: $" + d2.cash);
    		System.out.println("--------------------THANK YOU, TRANSACTION COMPLETE--------------------");
    	} else {
    		System.out.println("-----------------------RECEIPT----------------------------------------");
    		System.out.println(d2.L + " liters of gasoline @ $" + d2.price + "/liter");
    		System.out.println("--------------------THANK YOU, TRANSACTION COMPLETE--------------------");
    	}
	}

}
