package Driver;
import subClasses.*;

public class GasPump2Concrete extends AbstractFactory{

	
	
	//IMPLEMENTATION OF ABSTRACT FACTORY PATTERN IS
	//AS FOLLOWING
	
	
	public DataStore_2 getDataStore2(){
		return new DataStore_2();
	}
	
	public Storeprice2 getStoreprice(){
		return new Storeprice2();
	}
	public Storecash getStorecash(){
		return new Storecash();
	}
	public Displaymenu2 getDisplaymenu(){
		return new Displaymenu2();
	}
	public Rejectmessage2 getRejectmessage(){
		return new Rejectmessage2();
	}
	public Setprice2 getSetprice(){
		return new Setprice2();
	}
	public Readymsg2 getReadymsg(){
		return new Readymsg2();
	}
	public Setinitialvalues2 getSetinitialvalues(){
		return new Setinitialvalues2();
	}
	public Pumpgasunit2 getPumpgasunit(){
		return new Pumpgasunit2();
	}
	public Gaspumpedmsg2 getGaspumpedmsg(){
		return new Gaspumpedmsg2();
	}
	public Stopmsg2 getStopmsg(){
		return new Stopmsg2();
	}
	public PrintReceipt2 getPrintreceipt(){
		return new PrintReceipt2();
	}
	public Cancelmsg2 getCancelmsg(){
		return new Cancelmsg2();
	}
	public Returncash2 getReturncash(){
		return new Returncash2();
	}
	public initializedata2 getInitiazlizedata(){
		return new initializedata2();
	}

	
	
	
	@Override
	public DataStore_1 getDataStore1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paymsg2 getPaymsg() {
		
		return new Paymsg2();
	}

	@Override
	public Wrongpinmsg getWrongPinmsg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Storepin getStorepin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enterpinmsg getEnterPinmsg() {
		// TODO Auto-generated method stub
		return null;
	}
}
