package plugin;

public class TestPlugin implements Plugin
{

	public String transform(String s) 
	{
		return s.toUpperCase();
	}

	public String getLabel() 
	{
		
		return "GET EVERYTHING UPPER";
	}

	public String helpMessage() 
	{
		
		return "RTFM";
	}

}
