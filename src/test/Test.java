package test;
import mybeans.*;


public class Test {

	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    
	mybeans.LoginBean log1 = new mybeans.LoginBean();
    String email = log1.getEmail();
    System.out.println(email);
}
}