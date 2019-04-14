package Driver;

public class S6 extends States{

	@Override
	public void Receipt( ){
		op.PrintReceipt();
		op.Returncash();
	}
	@Override
	public void NoReceipt( ){
		op.Returncash();
	}
}
