package Driver;

public class GasPump_2 {

	MDA_EFSM mdaEfsm;
	DataStore_2 d;
	AbstractFactory af;
	

		//Set reference to CF object
		public void setFactory(GasPump2Concrete concreteFactory2) {
			this.af = concreteFactory2;
		}

		//Set reference to Data object
		public void setData(DataStore_2 data) {
			this.d = data;
		}
		//set reference to MDA EFSM object
		public void setMDAEFSM(MDA_EFSM mdaEfsm2) {
			this.mdaEfsm = mdaEfsm2;
			
		}
	
	
	public void Activate(float a, float b, float c) {
		
		if ((a>0)&&(b>0)&&(c>0)) { 
			d.temp_a = a;  
			d.temp_b = b; 
			d.temp_c = c;
			mdaEfsm.Activate(); 
			}
	}

	public void PayCash(int c) {
		
		if (c>0) {
			d.temp_cash=c;
			mdaEfsm.Start();
			mdaEfsm.PayType(2); 
			} 
	}

	public void PayCredit() {
		mdaEfsm.Start();  
		mdaEfsm.PayType(1); 
		
	}

	public void Approved() {
		mdaEfsm.Approved();
		
	}

	public void Reject() {
		mdaEfsm.Reject();
		
	}

	public void Cancel() {
		mdaEfsm.Cancel();
		
	}

	public void Premium() {
		mdaEfsm.SelectGas(3); 
		mdaEfsm.Continue(); 
		
	}

	public void Regular() {
		mdaEfsm.SelectGas(1); 
		mdaEfsm.Continue(); 
		
	}

	public void Super() {
		mdaEfsm.SelectGas(2); 
		mdaEfsm.Continue(); 
		
	}

	public void startPump() {
		mdaEfsm.StartPump();
		
	}

	public void PumpLiter() {
		
		if ((d.cash>0)&&(d.cash < d.price*(d.L+1))) 
			mdaEfsm.StopPump(); 
		else 
			mdaEfsm.Pump(); 
	}

	public void Stop() {
		mdaEfsm.StopPump();
		
	}

	public void Receipt() {
		mdaEfsm.Receipt();
		
	}

	public void NoReceipt() {
		mdaEfsm.NoReceipt();
		
	}

}
