package plugin;

/**
 * <b>Plugin</b> is like an Addon,a new features for text.
 * it has a Label, an helpMessage and his man action its to transform a String a returning the result 
 * @author smakic and perrot
 *
 */
public interface Plugin 
{
	/**
	 * Transform the String s and return the result
	 * @param s : String to transform
	 * @return the result of the transformation
	 */
	public String transform(String s);
	
	/**
	 * Get the name of the Plugin
	 * @return name of Plugin
	 */
	public String getLabel();
	
	/**
	 * Get the description of the Plugin,
	 * what is doing the transformation
	 * @return description of Plugin
	 */
	public String helpMessage();
}
