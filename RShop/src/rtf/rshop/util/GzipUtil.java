package rtf.rshop.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class GzipUtil {

	/**
	 * 使用gzip格式对数据进行压缩
	 * @param data
	 * @return
	 * @throws DataException 
	 */
	public static byte[] gzipCompress(byte[] data){
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		GZIPOutputStream stream = null ;
		
		try {
			 stream = new GZIPOutputStream(buffer);
			 stream.write(data);
			 stream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("数据压缩错误");
			if(Debug.isDebug)
				e.printStackTrace();
		}finally{
			try {
				if(stream!=null)
					stream.close();
				if(buffer!=null)
					buffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return buffer.toByteArray() ;
	}
	
	/**
	 * 将以gzip格式压缩的数据还原
	 * @param data
	 * @return
	 * @throws DataException 
	 */
	public static byte[] gzipDecompress(byte[] data){
		ByteArrayInputStream buffer = new ByteArrayInputStream( data ) ;
		GZIPInputStream stream = null ;
		byte[] result = null ;
		try {
			stream = new GZIPInputStream(buffer) ;
			result = StreamUtil.readAllDataFromStream(stream);
		} catch (IOException e) {
			System.out.println("数据解压错误");
			if(Debug.isDebug)
				e.printStackTrace();
		}finally{
			try {
				if(stream != null)
					stream.close();
				if(buffer!=null)
					buffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result ;
	}
}
