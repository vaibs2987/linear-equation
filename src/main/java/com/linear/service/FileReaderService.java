package com.linear.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderService {

	public String readFile(String path) {
		StringBuilder builder = new StringBuilder();
		BufferedReader br = null;
		FileReader reader = null;
		try {
			reader = new FileReader(path);
			br = new BufferedReader(reader);
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				builder.append(currentLine);
			}
		} catch (IOException e) {
		e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return builder.toString().replaceAll(" ", "");
	}
}
