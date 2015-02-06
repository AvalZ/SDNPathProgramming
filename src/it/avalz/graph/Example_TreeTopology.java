/*
 * Copyright (c) 2015 Andrea Valenza <avalenza89@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package it.avalz.graph;

/**
 *
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class Example_TreeTopology {
	public static void main(String[] args) {
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		Vertex v7 = new Vertex("7");
		
		Graph g = new Graph();
		
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addVertex(v5);
		g.addVertex(v6);
		g.addVertex(v7);
		
		v1.addBidirectionalEdge(v2);
		v2.addBidirectionalEdge(v3);
		v2.addBidirectionalEdge(v4);
		
		v1.addBidirectionalEdge(v5);
		v5.addBidirectionalEdge(v6);
		v5.addBidirectionalEdge(v7);
		
		g.computePathsFrom(v3);
		
		System.out.println(g.getShortestPathTo(v4));
	}
}
