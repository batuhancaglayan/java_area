package com.s3.io.tryer.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class FileUtil {

	public static InputStream getfile(String path) {
		Resource resource = new ClassPathResource(path);
		InputStream input = null;
		try {
			input = resource.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return input;
	}

	public static byte[] toByteArray(InputStream in) throws IOException {

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		byte[] buffer = new byte[1024];
		int len;

		// read bytes from the input stream and store them in buffer
		while ((len = in.read(buffer)) != -1) {
			// write bytes from the buffer into output stream
			os.write(buffer, 0, len);
		}

		return os.toByteArray();
	}

	public static byte[] gzip(byte[] data) throws IOException {
		
		byte[] ret = null;
		ByteArrayOutputStream bos = null;
		GZIPOutputStream gzip = null;
		try {
			bos = new ByteArrayOutputStream();
			gzip = new GZIPOutputStream(bos);
			gzip.write(data);
			gzip.finish();
			ret = bos.toByteArray();
		} finally {
			gzip.close();
			bos.close();
		}
		
		return ret;
	}

	public static byte[] ungzip(byte[] bytes) throws Exception {

		byte[] result = null;
		ByteArrayInputStream is = null;
		ByteArrayOutputStream os = null;
		GZIPInputStream gzis = null;
		try {
			is = new ByteArrayInputStream(bytes);
			os = new ByteArrayOutputStream();
			gzis = new GZIPInputStream(is);

			byte[] buffer = new byte[1024];

			int len;
			while ((len = gzis.read(buffer)) > 0) {
				os.write(buffer, 0, len);
			}

			result = os.toByteArray();
		} finally {
			gzis.close();
			is.close();
			os.close();
		}

		return result;
	}

	public static void gunzipIt(File input, File output) {

		byte[] buffer = new byte[1024];
		GZIPInputStream gzis = null;
		FileOutputStream out = null;

		try {

			gzis = new GZIPInputStream(new FileInputStream(input));
			out = new FileOutputStream(output);

			int len;
			while ((len = gzis.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}

			gzis.close();
			out.close();

			System.out.println("Done");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				out.close();
				gzis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
