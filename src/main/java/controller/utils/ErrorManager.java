package controller.utils;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



import controller.exception.enums.ErrorCode;

public class ErrorManager {
	

	private static Map<ErrorCode, String[]> errorList = new HashMap<ErrorCode, String[]> ();
	
	public static void registerError(ErrorCode error, String...args) {
		errorList.put(error, args);
	}
	
	public static void clearErrors() {
		errorList.clear();
	}
	
	public static List<String> getErrorMessageList() 
	{
		List<String> errorMessageList = new ArrayList<String>();
		for (Entry<ErrorCode, String[]> entry: errorList.entrySet())
		{	
			String[] args = entry.getValue();
			for (String value : args) {
				String errorMessage = value;
				errorMessageList.add(errorMessage);
			}
		}
		errorList.clear();
		return errorMessageList;
	}
	
	public static boolean isEmpty() {
		return errorList.isEmpty();
	}
}
