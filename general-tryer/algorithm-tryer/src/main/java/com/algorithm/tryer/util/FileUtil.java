package com.algorithm.tryer.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileUtil {

	public static Integer[] readFileLine(String fileName) {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classloader.getResourceAsStream(fileName);
		
		InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		BufferedReader reader = new BufferedReader(streamReader);
		
		Set<Integer> aq = new HashSet<>();
		List<Integer> result = new ArrayList<>();
		try {
			for (String line; (line = reader.readLine()) != null;) {
				String[] numberStr = line.split(" ");
				for (int i = 0; i < numberStr.length; i++) {
					aq.add(Integer.parseInt(numberStr[i]));
					result.add(Integer.parseInt(numberStr[i]));
				}		    
			}
			
		
			Integer[] numberArr = new Integer[result.size()];
			return result.toArray(numberArr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
