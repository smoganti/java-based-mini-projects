package Driver;

public class S4 extends States{

	@Override
	public void StartPump(){
		op.Setinitialvalues();
		op.Readymsg();
	}
}
