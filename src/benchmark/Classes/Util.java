package benchmark.Classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Util {
	public static void aviso(String message){
		JOptionPane.showMessageDialog(null, message);
	}
	
	public static String getInput(String message){
		String input = JOptionPane.showInputDialog(message);
		return (input != null) ? input : "" ;
	}
	
	public static int getInputInt(String message){
		try {
			String x = JOptionPane.showInputDialog(message);
			return Integer.parseInt((x == null) ? "-1" : x);
	
		} catch (NumberFormatException e) {	  
			aviso("Somente n�meros");
			return getInputInt(message);
		}
	}
	
	public static double getInputDouble(String message){
		try {
			String x = JOptionPane.showInputDialog(message);
			return Double.parseDouble((x == null) ? "-1" : x);
	
		} catch (NumberFormatException e) {	  
			aviso("Somente n�meros");
			return getInputInt(message);
		}
	}
	
	public static Date getInputData(String message){
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		
		try {
			date = (Date)formatter.parse(Util.getInput("Entre com a data:"));
			return date;
		} catch (ParseException e) {
			getInputData(message);
		}
		
		return null;
	}
}
