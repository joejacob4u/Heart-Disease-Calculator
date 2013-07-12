
import java.util.ArrayList;
import java.util.List;


public class HeartDisease {
	List<String> lists = new ArrayList<String>();
	HeartDisease()
	{
		lists.add("typical");
		lists.add("atypical");
		lists.add("non-anginal");
		lists.add("asymptomatic");
		lists.add("nonanginal");
		
	}
	public int searchDisease(String key)
	{
		for(String list: lists)
		{
			if(list.contains(key))
			{
				if (key.contains("typical"))
				{
					return 1;
				}
				if(key.contains("atypical"))
				{
					return 2;
				}
				if(key.contains("non-anginal"))
				{
					return 3;
				}
				if(key.contains("asymptomatic"))
				{
					return 4;
				}
				if(key.contains("nonanginal"))
				{
					return 3;
				}
			}
		}
		return 0;
	}
	
}
