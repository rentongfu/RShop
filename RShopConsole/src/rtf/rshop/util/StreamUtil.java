package rtf.rshop.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;


public class StreamUtil {
	private static int buffer_size = 1024* 100 ;
	public static byte[] readAllDataFromStream(InputStream in){
		byte[] result = new byte[0] ;
		byte[] buffer = new byte[buffer_size] ;
		int  i = 0 ;
		try {
			do{	
				i = in.read(buffer) ;	
				if(i != -1)
					result = BytesUtil.bytesAppendix(result, buffer, i);
				else
				break ;
			}while(true);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			if (Debug.isDebug)
				e.printStackTrace();
		}
		return result ;
	}
	public static char[] readAllDataFromStream(Reader reader){
		String result = new String() ;
		char[] buf = new char[buffer_size] ;
		int i = 0 ;
		try {
			do {
				i = reader.read(buf) ;
				if( i != -1)
					result  = result + new String(buf) ;
				else
					break;
			}while(true) ;
		} catch (IOException e) {
			if (Debug.isDebug)
				e.printStackTrace();
		}
		return result.toCharArray();
	}

}
