package com.UtilsLayer;

import org.json.simple.JSONObject;

public class UtilsClass {
	
	public static String addNewUsers(String email, String fname, String lname, String avatar) {
		JSONObject json = new JSONObject();
		
		json.put("email", email);
		json.put("first_name", fname); 
		json.put("last_name", lname); 
		json.put("avatar", avatar);
		return json.toString();
		
	
	}

	

}
