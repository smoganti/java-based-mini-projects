package Driver;

public class GasPump_1 {

	MDA_EFSM mdaEfsm;
	DataStore_1 d;
	AbstractFactory af;
	

		//Set reference to CF object
		public void setFactory(GasPump1Concrete concreteFactory1) {
			this.af = concreteFactory1;
		}

		//Set reference to Data object
		public void setData(DataStore_1 data) {
			this.d = data;
		}
		//set reference to MDA EFSM object
		public void setMDAEFSM(MDA_EFSM mdaEfsm2) {
			this.mdaEfsm = mdaEfsm2;
			
		}
		
	public void Activate(float a, float b) {

		if ((a>0)&&(b>0)) { 
			d.temp_a = a;  
			d.temp_b = b;   
			mdaEfsm.Activate(); 
			}
		
	}

	public void start() {
		mdaEfsm.Start();
		
	}

	public void PayCredit() {
		mdaEfsm.PayType(1);
		
	}

	public void Reject() {
		mdaEfsm.Reject();
		
	}

	public void PayDebit(String pin) {
		d.temp_p = pin;
		mdaEfsm.PayType(3);
		
	}

	public void Pin(String x) {
		
		if (d.pin.equals(x))
			mdaEfsm.CorrectPin();  
		else 
			mdaEfsm.IncorrectPin(); 
	}

	public void Cancel() {
		mdaEfsm.Cancel();
	}

	public void Approved() {
		mdaEfsm.Approved();		
	}

	public void Diesel() {
		
		mdaEfsm.SelectGas(4);
	}

	public void Regular() {
		
		mdaEfsm.SelectGas(1);
	}

	public void StartPump() {
		
		if (d.price>0) { 
			mdaEfsm.Continue(); 
			mdaEfsm.StartPump();  
			} 
	}
	
	public void PumpGallon(){
		mdaEfsm.Pump();
	}

	public void StopPump() {
		
		mdaEfsm.StopPump();
		mdaEfsm.Receipt();
	}

	public void FullTank() {
		mdaEfsm.StopPump();
		mdaEfsm.Receipt();
	}

	


}
