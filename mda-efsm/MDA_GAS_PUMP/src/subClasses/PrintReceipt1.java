package subClasses;
import Driver.DataStore_1;
import Driver.DataStore;

public class PrintReceipt1 extends PrintReceipt{

	@Override
	public void PrintReceipt(DataStore d) {
		DataStore_1 d1 = (DataStore_1) d;
		
        System.out.println("-----------------------RECEIPT----------------------------------------");
        System.out.println(d1.G + " gallons of gasoline @ $" + d1.price + "/gallon");
        System.out.println("Total: $" + d1.total);
        System.out.println("--------------------THANK YOU, TRANSACTION COMPLETE-------------------");
		
	}

}
