package br.com.lucassolutions.schoolbus.util;

public class RepleceAll {
	
	public static void main(String args[]){
	      String Str = new String("Welcome to Tutorialspoint.com");

	      System.out.print("Return Value :" );
	      System.out.println(Str.replaceAll("o", org.apache.commons.lang.StringUtils.EMPTY));

	      System.out.print("Return Value :" );
	      System.out.println(Str.replace('l', 'D'));
	   }

}
