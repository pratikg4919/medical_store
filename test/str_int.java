class str_int
{
	public static boolean isNumber(String s)
	{
		try
		{
        		 Integer.parseInt(s);
    		}
    		catch (NumberFormatException nfe)
    		{
        		return false;
    		}
    		return true;
	}
	public static void main(String[] args)
	{
		String str = "100";
		String st = "abc";
		if(isNumber(str))
		{
			int i = Integer.parseInt(str);
			System.out.println(i);
		}
		if(isNumber(st))
		{
			int a = Integer.parseInt(st);
			System.out.println(a);
		}
		else
		{
			System.out.println(st+" is not a Number");
		}
	}
	
}
