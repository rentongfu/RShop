package rtf.rshop.util;


public class BytesUtil {
	public static byte[] bytesAppendix(byte[] head , byte[] tail , int length){
	
		byte[] result = new byte[head.length + length ] ;
		System.arraycopy(head, 0, result, 0, head.length);
		System.arraycopy(tail, 0, result, head.length, length);
		return result;
	}
}
