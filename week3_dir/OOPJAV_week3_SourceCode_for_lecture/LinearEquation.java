//LINEAR EQUATION CLASS
//Y. Jing
//March 2007
//The University of Liverpool, UK

public class LinearEquation{

	//-------ATTRIBUTES-------
	private double bValue, cValue, xValue;

	//-------CONSTRUCTOR-------
	public LinearEquation(int bInput, int cInput){
		bValue = (double)bInput;
		cValue = (double)cInput;
	}

	//-------METHODS-------
	//Resolve linear equation, return true if successful and false otherwise
	public boolean resolveLinearEquation(){
		//Test for divide by 0 error; if found, return false
		if (bValue != 0.0)
		{
			//Determine xValue and return true
			xValue = (-cValue)/bValue;
			return (true);
		}
		else return(false);
	}

	//Get xValue
	public double getXValue(){
		return (xValue);
	}
}
