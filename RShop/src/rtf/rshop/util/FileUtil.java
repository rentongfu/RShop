package rtf.rshop.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.util.Date;


public class FileUtil {
	private static void existDir(File file){
		if( !file.exists()){
			existDir(file.getParentFile());
			file.mkdir();
		}
	}
	
	/**
	 * 如果文件不存在，创建
	 * @param file
	 */
	private static void existFile(File file){
//		System.out.println("sadsad"+file.getAbsolutePath());
		if(!file.exists()){
			existDir(file.getParentFile());
			try {
				file.createNewFile();
				System.out.println(file.getName());
			} catch (IOException e) {
				if( Debug.isDebug)
					e.printStackTrace();
			}
		}
	}
	
	public static String readStringFromFile(String src){
		return new String(readCharacterFile(src)) ;
	}
	public static void appendStringToFile(String str , String src){
		File file = new File(src) ;
		existFile(file) ;
		FileWriter writer = null ;
		try {
			writer = new FileWriter(file , true) ;
		} catch (IOException e) {
			if(Debug.isDebug)
				e.printStackTrace();
		}
		
		try {
			
			writer.append(str) ;
			writer.flush();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			if(Debug.isDebug)
				e.printStackTrace();
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读取制定文件中的字符，以字符数组的形式返回，失败则返回null
	 * @param filename 文件名
	 * @return
	 */
	public static char[] readCharacterFile(String filename){
		File f = new File(filename) ;
		existFile(f);
		FileReader fr = null ;
		char[] buf = null  ;
		try {
			fr = new FileReader(f) ;
			buf = StreamUtil.readAllDataFromStream(fr);
		
		} catch (FileNotFoundException e) {
			if (Debug.isDebug)
				e.printStackTrace();
		} finally{
			if(fr!=null)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null ;
				}
		}
		return buf ;
	}

	public static byte[] readBinaryFile(File file) throws IOException{
		existFile(file);
		InputStream input = new FileInputStream(file);
		byte[] data = StreamUtil.readAllDataFromStream(input);
		input.close();
		return data ;
	}

	public static void writeBinaryFile(File file , byte[] data) throws IOException{
		existFile(file);
		FileOutputStream output = new FileOutputStream(file);
		output.write(data);
		output.flush();
		output.close();	
	}

	public static void fileCopy(String src , String dest) throws IOException{
		File srcFile = new File(src) ;
		File destFile = new File(dest) ;
		byte[] data = readBinaryFile(srcFile) ;
		writeBinaryFile(destFile, data);
	}
}
