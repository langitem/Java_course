//Trip class
//Geng Liu
//July 2013
//University of Liverpool, UK
import java.text.*;
public class Trip
{

	//-------FIELDS-------
	//The trip distance
	private double _distance=0;
	//The traval time
	private double _time=0;

	private DecimalFormat df = new DecimalFormat("#.##");

	//-------CONSTRUCTORS-------
	public Trip(double distance,double time)
	{

		_distance=distance;
		_time=time;

	}

	//-------METHODS-------
	public double GetSpeed()
	{
		 double speed=0;
		 if(_distance>0 && _time>0)
		 {
			 speed=Double.valueOf(df.format(_distance/_time));
		 }
		 return speed;
	}
}
