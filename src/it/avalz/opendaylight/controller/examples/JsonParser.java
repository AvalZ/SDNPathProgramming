/*
 * Copyright (c) 2015 Andrea Valenza <avalenza89@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package it.avalz.opendaylight.controller.examples;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class JsonParser {

	public static void main(String[] args) {

		String s = "{\"ids\":[\"00:00:00:00:00:00:00:01\", \"00:00:00:00:00:00:00:02\"], \"width\":200, \"height\":100}";

		JSONObject json = null;
		try {
			json = (JSONObject) new JSONParser().parse(s);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		
		System.out.println(json.get("ids"));
		
		JSONArray array = (JSONArray) json.get("ids");
		System.out.println(array.get(0));
		System.out.println(json.get("width"));
		System.out.println(json.get("height"));
    
        List<String> l = new ArrayList<String>();
        
        l.add("\"DROP\"");
        l.add("\"OUTPUT=2\"");
        System.out.println(l);
	}


}
