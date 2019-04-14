package Driver;

public class S5 extends States{

	@Override
	public void Pump( ){
		op.Pumpgasunit();
		op.Gaspumpedmsg();
	}
	@Override
	public void StopPump( ){
	op.Stopmsg();	
	}
}
