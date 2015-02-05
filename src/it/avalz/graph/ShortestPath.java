/*
 * Copyright (c) 2015 Andrea Valenza <avalenza89@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package it.avalz.graph;

import java.util.List;

/**
 *
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class ShortestPath {
	public static void main(String args[]){
		Graph g = new Graph();
		
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		
		v1.addEdge(v2, 1);
		v1.addEdge(v4, 10);
		
		v2.addEdge(v3, 4);
		v2.addEdge(v4, 1);
		
		v3.addEdge(v4, 2);
		
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		
		g.computePathsFrom(v1);
		
		Vertex v = v3;
		List<Vertex> sp = g.getShortestPathTo(v);
		System.out.println(sp);
		System.out.println("Distance: " + v.getMinDistance());
	}
}
