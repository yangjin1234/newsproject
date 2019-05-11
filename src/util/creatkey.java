package util;

import java.util.Date;

public class creatkey {

	public static int getCeartKey(){
		return (int) ( new Date().getTime());
	}
}
