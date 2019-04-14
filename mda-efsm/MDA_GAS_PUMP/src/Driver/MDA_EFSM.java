package Driver;

import java.util.ArrayList;

public class MDA_EFSM {

	OP op;
	static int m;
	States[] stateList = new States[9];
	States current;
	
	//State Changes are indicated in the following for a CENTRALIZED STATE PATTERN
	
	
	
	//list of states which get passed as parameters and this function stores the states in a list
		public void initializeStates(States s0,States s1,States s2,States s3,States s4,States s5,States s6,States s8,States start){
			stateList[0] = s0;
			stateList[1] = s1;
			stateList[2] = s2;
			stateList[3] = s3;
			stateList[4] = s4;
			stateList[5] = s5;
			stateList[6] = s6;
			stateList[7] = s8;
			stateList[8] = start;
			this.current = stateList[8];
		}
	
	public void Activate( ){
		int curr = current.getStateid();
		switch(curr)
		{
	case 0: 
	case 1:  
	case 2: 
	case 3: 
	case 4: 
	case 5: 
	case 6:  
	case 7: 
		System.out.println("Invalid Selection of Operation");
		break;
	case 8:
			current.Activate();
			current = stateList[0];
		break;
		};
	}
	
	
	
	public void Start( ){
		int curr = current.getStateid();
		switch(curr)
		{
	case 0: 
		current.Start();
		current = stateList[1];
		m=1;
		break;
	case 1:  
	case 2: 
	case 3: 
	case 4: 
	case 5: 
	case 6:  
	case 7: 
	case 8:
		System.out.println("Invalid Selection of Operation");
		break;
		};
		
	}
	
	
	
	public void PayType(int t){
		
		int curr = current.getStateid();
		switch(curr)
		{
	case 0:
		System.out.println("Invalid Selection of Operation");
		break;
	case 1: 
		if(t==1){
			current.PayType(1);
			current = stateList[2];
		}	
		else if(t==2){
			current.PayType(2);
			current = stateList[3];
			m=0;
		}
		else{
			current.PayType(3);
			current = stateList[7];
		}
		break; 
	case 2: 
	case 3: 
	case 4: 
	case 5: 
	case 6:  
	case 7: 
	case 8:
		System.out.println("Invalid Selection of Operation");
		break;
		};
	}
	public void Reject( ){
		int curr = current.getStateid();
		switch(curr)
		{
	case 0: 
	case 1:
		System.out.println("Invalid Selection of Operation");
		break; 
	case 2: 
		current.Reject();
		current = stateList[0];
		break;
	case 3: 
	case 4: 
	case 5: 
	case 6:  
	case 7: 
	case 8:
		System.out.println("Invalid Selection of Operation");
		break;
		};
	}
	public void Cancel( ){
		
		int curr = current.getStateid();
		switch(curr)
		{
	case 0: 
	case 1:  
	case 2: 
		System.out.println("Invalid Selection of Operation");
		break;
	case 3: 
		current.Cancel();
		current = stateList[0];
		break;
	case 4: 
	case 5: 
	case 6:  
	case 7: 
	case 8:
		System.out.println("Invalid Selection of Operation");
		break;
		};
	}
	public void Approved( ){
		
		int curr = current.getStateid();
		switch(curr)
		{
	case 0: 
	case 1: 
		System.out.println("Invalid Selection of Operation");
		break; 
	case 2: 
		current.Approved();
		current = stateList[3];
		break; 
	case 3: 
	case 4: 
	case 5: 
	case 6:  
	case 7: 
	case 8:
		System.out.println("Invalid Selection of Operation");
		break;
		};
	}
	
	public void StartPump( ){
		int curr = current.getStateid();
		switch(curr)
		{
	case 0: 
	case 1:  
	case 2: 
	case 3: 
		System.out.println("Invalid Selection of Operation");
		break;
	case 4:  
		current.StartPump();
		current = stateList[5];
		break;
	case 5: 
	case 6:  
	case 7: 
	case 8:
		System.out.println("Invalid Selection of Operation");
		break;
		};
	}
	
	public void Pump( ){
		int curr = current.getStateid();
		switch(curr)
		{
	case 0: 
	case 1:  
	case 2:  
	case 3: 
	case 4: 
		System.out.println("Invalid Selection of Operation");
		break;
	case 5:   
		current.Pump();
		break;
	case 6:  
	case 7: 
	case 8:
		System.out.println("Invalid Selection of Operation");
		break;
		};
	}
	public void StopPump( ){
		int curr = current.getStateid();
		switch(curr)
		{
	case 0: 
	case 1:  
	case 2:  
	case 3: 
	case 4: 
		System.out.println("Invalid Selection of Operation");
		break;
	case 5:   
		current.StopPump();
		current = stateList[6];
		break;
	case 6:  
	case 7: 
	case 8:
		System.out.println("Invalid Selection of Operation");
		break;
		};
	}
	public void SelectGas(int g ){
		int curr = current.getStateid();
		switch(curr)
		{
	case 0: 
	case 1:  
	case 2: 
		System.out.println("Invalid Selection of Operation");
		break; 
	case 3:    
		current.SelectGas(g);
		break;
	case 4: 
	case 5: 
	case 6:  
	case 7: 
	case 8:
		System.out.println("Invalid Selection of Operation");
		break;
		};
	}
	public void Receipt( ){
		int curr = current.getStateid();
		switch(curr)
		{
	case 0: 
	case 1:  
	case 2:  
	case 3: 
	case 4: 
	case 5: 
		System.out.println("Invalid Selection of Operation");
		break;
	case 6:     
		current.Receipt();
		current = stateList[0];
		break; 
	case 7: 
		System.out.println("Invalid Selection of Operation");
		break;
	case 8:
		System.out.println("Invalid Selection of Operation");
		break;
		};
	}
	public void NoReceipt( ){
		int curr = current.getStateid();
		switch(curr)
		{
	case 0: 
	case 1:  
	case 2:  
	case 3: 
	case 4: 
	case 5: 
		System.out.println("Invalid Selection of Operation");
		break;
	case 6:     
		current.NoReceipt();
		current = stateList[0];
		break; 
	case 7: 
		System.out.println("Invalid Selection of Operation");
		break;
	case 8:
		System.out.println("Invalid Selection of Operation");
		break;
		};
	}
	public void CorrectPin( ){
		int curr = current.getStateid();
		switch(curr)
		{
	case 0: 
	case 1:  
	case 2:  
	case 3: 
	case 4: 
	case 5: 
	case 6: 
		System.out.println("Invalid Selection of Operation");
		break; 
	case 7:     
		current.CorrectPin();
		current = stateList[3];
		break;
	case 8: break;
		};
	}
	public void IncorrectPin( ){
		int curr = current.getStateid();
		switch(curr)
		{
	case 0: 
	case 1:  
	case 2:  
	case 3: 
	case 4: 
	case 5: 
	case 6: 
		System.out.println("Invalid Selection of Operation");
		break; 
	case 7:     
		current.IncorrectPin();
		current = stateList[0];
		break;
	case 8: 
		System.out.println("Invalid Selection of Operation");
		break;
		};
	}
	public void Continue( ){
		int curr = current.getStateid();
		switch(curr)
		{
	case 0: 
	case 1:  
	case 2: 
		System.out.println("Invalid Selection of Operation");
		break; 
	case 3:     
		current.Continue();
		current = stateList[4];
		break;
	case 4: 
	case 5: 
	case 6:  
	case 7: 
	case 8: 
		System.out.println("Invalid Selection of Operation");
		break;
		};
	}
	
}
