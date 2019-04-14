package Driver;

public class S2 extends States{

	@Override
	public void Reject( ){
		op.Rejectmessage();
	}
	@Override
	public void Approved( ){
		op.Displaymenu();
	}
}
