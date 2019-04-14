package Driver;

import subClasses.*;

public abstract class AbstractFactory {

	
	public abstract DataStore_1 getDataStore1();
	public abstract Storeprice getStoreprice();
	public abstract Paymsg getPaymsg();
	public abstract Displaymenu getDisplaymenu();
	public abstract Rejectmessage getRejectmessage();
	public abstract Setprice getSetprice();
	public abstract Readymsg getReadymsg();
	public abstract Pumpgasunit getPumpgasunit();
	public abstract Gaspumpedmsg getGaspumpedmsg();
	public abstract Stopmsg getStopmsg();
	public abstract PrintReceipt getPrintreceipt();
	public abstract Cancelmsg getCancelmsg();
	public abstract Wrongpinmsg getWrongPinmsg();
	public abstract Storepin getStorepin();
	public abstract Enterpinmsg getEnterPinmsg();
	public abstract initializedata getInitiazlizedata();
	public abstract DataStore_2 getDataStore2();
	public abstract Storecash getStorecash();
	public abstract Setinitialvalues getSetinitialvalues();
	public abstract Returncash getReturncash();

}
