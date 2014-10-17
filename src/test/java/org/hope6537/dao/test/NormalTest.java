package org.hope6537.dao.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class NormalTest {

	@Test
	public void testMap() {
		Map<String, String> map = new HashMap<String, String>();
		String mapValue = "{重要程度=非常重要,难易程度=非常难}";
		mapValue = mapValue.substring(1, mapValue.length() - 1).trim();
		String[] keyValue = mapValue.split(",");
		for (String str : keyValue) {
			String[] values = str.split("=");
			String key = values[0];
			String value = values[1];
			map.put(key, value);
		}
		System.out.println(map.toString());

	}
}
