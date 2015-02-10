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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class Network extends Graph {
	
	public Network() {
		super();
	}
		
	/**
	 * Parses the output string from the /controller/nb/v2/switchmanager/default/nodes API
	 * from the OpenDaylight controller and adds the resulting nodes to this Network object.
	 * @param nodesString The JSON string result from the Controller API
	 */
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
			
			// TODO: Extract the Switch ports from the 'properties' object. 
			JSONObject properties = (JSONObject) sw.get("properties");
			
			String nodeId = (String) node.get("id");
			
			this.addVertex(nodeId);
		}
	}
	
	/**
	 * Parses the output string from the /controller/nb/v2/topology/default API from the
	 * OpenDaylight controller and adds the resulting edges to this Network nodes.
	 * NOTE: run this after adding the vertexes, or it may result in crashes.
	 * @param edgesString 
	 * @see addNodesFromJSON(String nodesString)
	 */
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
			Object fromPort = ((JSONObject) from).get("id");
			String fromNodeId = (String)((JSONObject) fromNode).get("id");
			

			Object properties = ((JSONObject) o).get("properties");
			Object bandwidth = ((JSONObject) properties).get("bandwidth");
			Object bandwidthValue = ((JSONObject) bandwidth).get("value");
			
			double weight = 1.0 / (long)bandwidthValue;
			
			Edge e = new Edge(this.getVertex(toNodeId), weight);
			int port = Integer.parseInt((String) fromPort);
			this.getVertex(fromNodeId).addEdge(e, port);
		}
	}
}
