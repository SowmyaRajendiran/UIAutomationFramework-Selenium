package com.mytestproduct.utilities;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson {

	/*
	 * Function Description: Method to read the data from the JSON file
	 * 
	 * @param key
	 */
	public static String readJSONValue(String key) {
		String expectedDataValue = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			// Read JSON file
			JsonNode rootNode = mapper
					.readTree(new File(System.getProperty("user.dir") + "/src/test/resources/testData/testData.json"));

			// Access data
			expectedDataValue = rootNode.path(key).asText();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return expectedDataValue;
	}
}
