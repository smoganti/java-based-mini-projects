package Driver;

public abstract class States {

	public void Activate( ){};
	public void Start( ){};
	public  void PayType(int t ){};
	public void Reject( ){};
	public void Cancel( ){};
	public void Approved( ){};
	public void StartPump( ){};
	public void Pump( ){};
	public void StopPump( ){};
	public void SelectGas(int g ){};
	public void Receipt( ){};
	public void NoReceipt( ){};
	public void CorrectPin( ){};
	public void IncorrectPin( ){};
	public void Continue( ){};

	int stateid;
	OP op;
	MDA_EFSM mda;
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	public void setOutputProcessor(OP outputProcessor) {
		this.op = outputProcessor;
	}
	public void setMDAContext(MDA_EFSM mda_EFSM) {
		this.mda = mda_EFSM;
		
	}
	
}
