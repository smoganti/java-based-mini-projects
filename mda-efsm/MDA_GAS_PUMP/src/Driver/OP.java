package Driver;
import subClasses.*;

public class OP {

	DataStore d;
	AbstractFactory af;
	MDA_EFSM mdaEfsm;
	
	//pointers to other classes
	Storeprice sp;
	Paymsg pm;
	Storecash sc;
	Displaymenu dm;
	Rejectmessage r;
	Setprice sp1;
	Readymsg rm;
	Setinitialvalues siv;
	Pumpgasunit pgu;
	Gaspumpedmsg gpm;
	Stopmsg sm;
	PrintReceipt pr;
	Cancelmsg cm;
	Returncash rc;
	Wrongpinmsg wpm;
	Storepin sp2;
	Enterpinmsg epm;
	initializedata id;
	
	//Set reference to CF object
			public void setFactory(AbstractFactory af) {
				this.af = af;
			}

			//Set reference to Data object
			public void setData(DataStore data) {
				this.d = data;
			}

			public void setMDAEFSM(MDA_EFSM mdaEfsm) {
				this.mdaEfsm = mdaEfsm;
				
			}
			
	//methods towards the subclasses
			public void Storeprice(){
				sp = af.getStoreprice();
				sp.storeprice(d);
			}
			public void Paymsg(){
				pm = af.getPaymsg();
				pm.Paymsg();
			}
			public void Storecash(){
				sc = af.getStorecash();
				sc.Storecash(d);
			}
			public void Displaymenu(){
				dm = af.getDisplaymenu();
				dm.displaymenu(d);
			}
			public void Rejectmessage(){
				r = af.getRejectmessage();
				r.Rejectmessage();
			}
			public void Setprice(int g, int m){
				sp1 = af.getSetprice();
				sp1.Setprice(g,m,d);
			}
			public void Readymsg(){
				rm = af.getReadymsg();
				rm.Readymsg();
			}
			public void Setinitialvalues(){
				siv = af.getSetinitialvalues();
				siv.Setinitialvalues(d);
			}
			public void Pumpgasunit(){
				pgu = af.getPumpgasunit();
				pgu.Pumpgasunit(d);
			}
			public void Gaspumpedmsg(){
				gpm = af.getGaspumpedmsg();
				gpm.Gaspumpedmsg(d);
			}
			public void Stopmsg(){
				sm = af.getStopmsg();
				sm.Stopmsg();
			}
			public void PrintReceipt(){
				pr = af.getPrintreceipt();
				pr.PrintReceipt(d);
			}
			public void Cancelmsg(){
				cm = af.getCancelmsg();
				cm.Cancelmsg();
			}
			public void Returncash(){
				rc = af.getReturncash();
				rc.Returncash(d);
			}
			public void Wrongpinmsg(){
				wpm = af.getWrongPinmsg();
				wpm.Wrongpinmsg();
			}
			public void Storepin(){
				sp2 = af.getStorepin();
				sp2.Storepin(d);
			}
			public void Enterpinmsg(){
				epm = af.getEnterPinmsg();
				epm.Enterpinmsg();
			}
			public void initializedata(){
				id = af.getInitiazlizedata();
				id.initializedata(d);
			}
			
			
			
}
