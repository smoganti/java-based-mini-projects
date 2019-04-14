package Driver;

public class S3 extends States{

	@Override
	public void SelectGas(int g){
		op.Setprice(g,mda.m);
	}
	@Override
	public void Cancel(){
		op.Cancelmsg();
		op.Returncash();
	}
	@Override
	public void Continue(){
		
	}
}
