package com.lc.thread;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/**����ͼƬ
 * 
 * @author Trail
 *
 */
public class WebDownloader {
	public void download(String url,String name)  {
		try {
			FileUtils.copyURLToFile(new URL(url),new File(name));
		} catch (MalformedURLException e ) {
			e.printStackTrace();
			System.out.println("�Ƿ�URL");
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("����ʧ��");
		}
		
	}
}
