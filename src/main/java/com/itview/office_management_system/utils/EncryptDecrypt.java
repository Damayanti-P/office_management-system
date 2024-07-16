package com.itview.office_management_system.utils;

import java.util.Base64;

public class EncryptDecrypt {
	public static String encrypt(String username,String password)
	{

	String encodedString = Base64.getEncoder().encodeToString((username+":"+password).getBytes());
	return encodedString;
	
	}
}
