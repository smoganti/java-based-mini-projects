package Driver;

public class S1 extends States{

	@Override
	public void PayType(int t){
		if(t==1){
			//No action to be performed
		}
		else if(t==2){
			op.Storecash();
			op.Displaymenu();
		}
		else{
			op.Enterpinmsg();
			op.Storepin();
		}
	}
}
