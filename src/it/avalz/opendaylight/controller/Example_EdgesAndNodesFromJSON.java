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
import it.avalz.graph.Vertex;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class Example_EdgesAndNodesFromJSON {

	public static void main(String[] args) {
		String edgesString = "{\"edgeProperties\":[{\"properties\":{\"timeStamp\":{\"value\":1423208766757,\"name\":\"creation\"},\"name\":{\"value\":\"s3-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:03\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s4-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:04\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s5-eth1\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:06\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s7-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:07\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s2-eth1\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:03\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766757,\"name\":\"creation\"},\"name\":{\"value\":\"s2-eth2\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:04\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s5-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:01\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766755,\"name\":\"creation\"},\"name\":{\"value\":\"s1-eth1\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:01\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s2-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:01\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766755,\"name\":\"creation\"},\"name\":{\"value\":\"s6-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:06\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s5-eth2\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:07\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766755,\"name\":\"creation\"},\"name\":{\"value\":\"s1-eth2\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:01\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"}}}]}";

		String nodesString = "{\"nodeProperties\":[{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765416,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:02\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765378,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:03\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:03\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765432,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"macAddress\":{\"value\":\"00:00:00:00:00:01\"},\"capabilities\":{\"value\":199},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:01\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765363,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:04\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:04\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765409,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:07\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:07\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765429,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:06\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:06\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765359,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:05\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"}}]}";

		Network net = new Network();

		net.addNodesFromJSON(nodesString);

		for (Vertex v : net.getVertexes().values()) {
			System.out.println(v);
		}

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
			Object from = ((JSONObject) edge).get("tailNodeConnector");
			Object toNode = ((JSONObject) to).get("node");
			Object fromNode = ((JSONObject) from).get("node");

			String toNodeId = (String)((JSONObject) toNode).get("id");
			String fromNodeId = (String)((JSONObject) fromNode).get("id");
			
			System.out.println(toNodeId);
			System.out.println(fromNodeId);
			

			Object properties = ((JSONObject) o).get("properties");
			Object bandwidth = ((JSONObject) properties).get("bandwidth");
			Object bandwidthValue = ((JSONObject) bandwidth).get("value");
			
			double weight = 1.0 / (long)bandwidthValue;
			
			System.out.println(weight);
			
			Edge e = new Edge(net.getVertex(toNodeId), weight);
			System.out.println(e);
			net.getVertex(fromNodeId).addEdge(e);
		}
		
		net.computePathsFrom("00:00:00:00:00:00:00:03");
		
		System.out.println(net.getShortestPathTo("00:00:00:00:00:00:00:07"));

	}
}
