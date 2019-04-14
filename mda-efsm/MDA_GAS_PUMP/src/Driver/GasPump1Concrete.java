package Driver;

import subClasses.*;

public class GasPump1Concrete extends AbstractFactory{

	

	//IMPLEMENTATION OF ABSTRACT FACTORY PATTERN IS
	//AS FOLLOWING
	
	public DataStore_1 getDataStore1(){
		return new DataStore_1();
	}
	public Storeprice1 getStoreprice(){
		return new Storeprice1();
	}
	public Paymsg1 getPaymsg(){
		return new Paymsg1();
	}
	public Displaymenu1 getDisplaymenu(){
		return new Displaymenu1();
	}
	public Rejectmessage1 getRejectmessage(){
		return new Rejectmessage1();
	}
	public Setprice1 getSetprice(){
		return new Setprice1();
	}
	public Readymsg1 getReadymsg(){
		return new Readymsg1();
	}
	public Pumpgasunit1 getPumpgasunit(){
		return new Pumpgasunit1();
	}
	public Gaspumpedmsg1 getGaspumpedmsg(){
		return new Gaspumpedmsg1();
	}
	public Stopmsg1 getStopmsg(){
		return new Stopmsg1();
	}
	public PrintReceipt1 getPrintreceipt(){
		return new PrintReceipt1();
	}
	public Cancelmsg1 getCancelmsg(){
		return new Cancelmsg1();
	}
	public Wrongpinmsg getWrongPinmsg(){
		return new Wrongpinmsg();
	}
	public Storepin getStorepin(){
		return new Storepin();
	}
	public Enterpinmsg getEnterPinmsg(){
		return new Enterpinmsg();
	}
	public initializedata getInitiazlizedata(){
		return new initializedata1();
	}
	public Setinitialvalues1 getSetinitialvalues(){
		return new Setinitialvalues1();
	}
	public Returncash1 getReturncash() {
		return new Returncash1();
	}
	
	@Override
	public DataStore_2 getDataStore2() {
		return null;
	}
	@Override
	public Storecash getStorecash() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
