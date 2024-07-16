package com.itview.office_management_system.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations
{
	public static Boolean isValidNumber(String phoneNumber) {

        Pattern p = Pattern.compile("^[0-9]{10}$");
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }
    public static Boolean isValidEmail(String email) {

        Pattern p = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

}
