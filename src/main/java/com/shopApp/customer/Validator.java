package com.shopApp.customer;

import com.shopApp.dbHandler.DataFetcher;

public class Validator {
	public static Boolean isValid(String uname, String pass) {
		String dbPass=DataFetcher.fetchPassword(uname);
			if(pass.equals(dbPass)) 
				return true;	
			else 
				return false;
			
	}
}
