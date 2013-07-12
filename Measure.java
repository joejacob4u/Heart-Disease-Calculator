
public class Measure {
	public int measurePress(int num)
	{
		if(num>=90 && num<=200)
		{
			return num;
		}
		return 0;
	}
	public int measureChol(int num)
	{
		if(num>=126 && num<=564)
		{
			return num;
		}
		
		return 0;
	}
	public int measureSugar(int num)
	{
		if(num<121)
		{
			return 0;
		}
	 
	  return 1;
	}
}
