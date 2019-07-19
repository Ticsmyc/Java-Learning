package cn.lc.IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1.封装拷贝
 * 2.封装释放资源
 * @author Trail
 *
 */
public class FileUtils {
	public static void main(String[] args) {
		//文件到文件
		try {
			InputStream is = new FileInputStream("a.txt");
			OutputStream os = new FileOutputStream("a_copy.txt");
			copy(is,os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//文件到字节数组
		byte[] datas=null;
		try {
			InputStream is = new FileInputStream("a.jpeg");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			copy(is,os);
			datas=os.toByteArray();
			System.out.println(datas.length);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//字节数组到文件
		try {
			ByteArrayInputStream is = new ByteArrayInputStream(datas);
			OutputStream os = new FileOutputStream("a_byte.jpg");
			copy(is,os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void copy(InputStream is , OutputStream os)
	{
		try {
			byte[] flush=new byte[1024*10];
			int len=-1;
			while((len = is.read(flush))!=-1){
				os.write(flush,0,len);
			}
			os.flush(); 
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			close(is,os);
		}
	}
	
	public static void close(InputStream is, OutputStream os)
	{
		/**
		 * 释放资源
		 */
		try {
			if(null != os ) {
				os.close();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		try {
			if(null != is ) {
				is.close();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Closeable... ios) {  //可变参数
		//关闭多个流
		for(Closeable io : ios) {
			try {
				if ( null != io){
					io.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
}
