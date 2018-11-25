package com.dds.test;

public class TestSubString {


	public static void main(String[] args) 
	{
		String string = "CE=-34rft:ty67:87jkf|SE=hty76jk:ww88kl9:5yuodp";
		
		String[] stringSplit = string.split("[|]");
		System.out.println(" splited string .... "+stringSplit[0]);
		
		String secondPart = stringSplit[0].substring(stringSplit[0].indexOf("=")+1,stringSplit[0].length());
		
		String firstPart = stringSplit[0].substring(0,stringSplit[0].indexOf("="));
		
		System.out.println("First part :::  "+firstPart);
		System.out.println(" Second Part :::  "+secondPart);
		
		
		System.out.println(" splited string .... "+stringSplit[1]);
	}

}
