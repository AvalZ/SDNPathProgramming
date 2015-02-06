/*
 * Copyright (c) 2015 Andrea Valenza <avalenza89@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package it.avalz.opendaylight.controller;

import it.avalz.graph.Edge;
import it.avalz.graph.Graph;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class Network extends Graph {
	
	private Map<String, NetNode> vertexes;
	
	public Network() {
		super();
	}
		
	
	public void addNodesFromJSON(String nodesString) {
		JSONObject json = null;
		try {
			json = (JSONObject) new JSONParser().parse(nodesString);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		
		JSONArray nodes = (JSONArray)json.get("nodeProperties");
		
		for (int i = 0; i < nodes.size(); i++){
			JSONObject sw = (JSONObject) nodes.get(i);
			
			JSONObject node = (JSONObject) sw.get("node");
			JSONObject properties = (JSONObject) sw.get("properties");
			
			String nodeId = (String) node.get("id");
			
			this.addVertex(nodeId);
		}
	}
	
	public void addEdgesFromJSON(String edgesString) {
		JSONObject edgesJson = null;
		try {
			edgesJson = (JSONObject) new JSONParser().parse(edgesString);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		JSONArray edges = (JSONArray) edgesJson.get("edgeProperties");

		for (Object o : edges) {
			Object edge = ((JSONObject) o).get("edge");
			
			Object to = ((JSONObject) edge).get("headNodeConnector");
			Object toNode = ((JSONObject) to).get("node");
			String toNodeId = (String)((JSONObject) toNode).get("id");
			
			Object from = ((JSONObject) edge).get("tailNodeConnector");
			Object fromNode = ((JSONObject) from).get("node");
			String fromNodeId = (String)((JSONObject) fromNode).get("id");
			

			Object properties = ((JSONObject) o).get("properties");
			Object bandwidth = ((JSONObject) properties).get("bandwidth");
			Object bandwidthValue = ((JSONObject) bandwidth).get("value");
			
			double weight = 1.0 / (long)bandwidthValue;
			
			Edge e = new Edge(this.getVertex(toNodeId), weight);
			this.getVertex(fromNodeId).addEdge(e);
		}
	}
}
