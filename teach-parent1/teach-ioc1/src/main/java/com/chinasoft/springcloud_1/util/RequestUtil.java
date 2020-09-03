package com.chinasoft.springcloud_1.util;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
	public static Map<String, Object> getQueryMap(HttpServletRequest request) {
		Map<String, Object> bm = new HashMap<String, Object>();
		Map<String, String[]> tmp = request.getParameterMap();
		if (tmp != null) {            
			for (String key : tmp.keySet()) {
				Object[] values = tmp.get(key);
				Object o = values.length == 1 ? values[0].toString().trim()
						: values;
				bm.put(key, isType(o));
			}
		}
		return bm;
	}

	//将字符串转化成数值类型
	public static Object isType(Object o) {
		Object object = o;
		try {
			object = Integer.parseInt(o.toString());
		} catch (Exception e) {
			try {
				object = Double.parseDouble(o.toString());
			} catch (Exception e1) {
				object = o.toString();
			}

		}
		return object;
	}
}
