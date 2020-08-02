package edu.poly.spring.helpers;

import edu.poly.spring.models.Shop;

public class UserLogin {

	public static Shop USER = null;
	
    public static void logoff() {
    	UserLogin.USER = null;
    }

    public static boolean authenticated() {
        return UserLogin.USER != null;
    }
    
}
