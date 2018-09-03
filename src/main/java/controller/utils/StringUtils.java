package controller.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.google.common.base.CaseFormat;

public class StringUtils {

	
	public static String camelize(CaseFormat caseOrigin, String string) {
		return caseOrigin.to(CaseFormat.LOWER_CAMEL, string.toUpperCase());
	}
	
	public static String snakelize(CaseFormat caseOrigin, String string) {
		return caseOrigin.to(CaseFormat.LOWER_UNDERSCORE, string).toUpperCase();
	}
	
	public static String concat(List<String> itemList, final String start, final String end, String separator) {
		String result = "";
		
		for (int i = 0; i < itemList.size(); i++) {
			String item = itemList.get(i);
			result += start + item + end;
			if (i < itemList.size() -1 ) {
				result += separator;
			}
		}
		
		return result;
	}
	
	public static String concat(List<String> itemList, String separator) {
		return concat(itemList, "", "", separator);
	}
	
	public static String capitalize(String input) {
		return input.substring(0, 1).toUpperCase() + input.substring(1);
	}
	
	public static String crypt(String string) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] passBytes = string.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<digested.length;i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }

    }
	
}
