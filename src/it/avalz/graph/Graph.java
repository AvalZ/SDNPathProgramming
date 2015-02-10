/*
 * Copyright (c) 2015 Andrea Valenza <avalenza89@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package it.avalz.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class Graph {

	private Map<String, Vertex> vertexes;

	public Graph() {
		this.vertexes = new HashMap<>();
	}

	public void addVertex(Vertex v) {
		this.vertexes.put(v.getId(), v);
	}

	public void addVertex(String id) {
		this.vertexes.put(id, new Vertex(id));
	}

	public Vertex getVertex(String Id) {
		return this.vertexes.get(Id);
	}

	public Map<String, Vertex> getVertexes() {
		return this.vertexes;
	}

	/**
	 * Computes all the paths to the root.
	 * TODO: implement caching for every node.
	 * @param root The nodes from which it computes all the minimum paths
	 */
	public void computePathsFrom(Vertex root) {
		// Setup
		for (Vertex v : vertexes.values()) {
			v.setMinDistance(Double.POSITIVE_INFINITY);
			v.setPrevious(null);
		}
		root.setMinDistance(0);
		Queue<Vertex> border = new PriorityQueue<>();
		border.add(root);

		// Expand the border by visiting the vertexes adjacent to the ones in the border
		while (!border.isEmpty()) {
			Vertex u = border.poll();

			// Visit each candidate edge exiting borderNode
			for (Edge e : u.getAdjacences()) {
				Vertex v = e.getTarget();
				double candidateWeight = e.getWeight();
				double distanceThroughCandidate = u.getMinDistance() + candidateWeight;

				if (distanceThroughCandidate < v.getMinDistance()) {
					// Update node's properties (minDistance and previous vertex)
					border.remove(v);
					v.setMinDistance(distanceThroughCandidate);
					v.setPrevious(u);
					border.add(v);
				}
			}
		}
	}

	public void computePathsFrom(String rootId) {
		Vertex root = this.vertexes.get(rootId);
		computePathsFrom(root);
	}

	public List<Vertex> getShortestPathTo(Vertex target) {
		List<Vertex> shortestPath = new ArrayList<>();
		for (Vertex v = target; v != null; v = v.getPrevious()) {
			shortestPath.add(v);
		}
		Collections.reverse(shortestPath);
		return shortestPath;
	}

	public List<Vertex> getShortestPathTo(String targetId) {
		Vertex target = this.vertexes.get(targetId);
		return getShortestPathTo(target);
	}
	
	/**
	 * The shortest path between two vertexes in the graph.
	 * @param from Starting point of the path
	 * @param to Ending point of the graph
	 * @return List of vertexes in the path (in order)
	 * 
	 * @see computePathsFrom(Vertex root)
	 * @see getShortestPathTo(Vertex target)
	 */
	public List<Vertex> getShortestPath(Vertex from, Vertex to) {
		computePathsFrom(from);
		return getShortestPathTo(to);
	}
	/**
	 * The shortest path between two vertexes in the graph.
	 * It automatically gets the vertexes from the graph (if they exist)
	 * @param fromId Starting vertex ID
	 * @param toId Ending vertex ID
	 * @return List of vertexes in the path (in order)
	 * @see getShortestPath(Vertex from, Vertex to)
	 */
	public List<Vertex> getShortestPath(String fromId, String toId) {
		Vertex from = this.vertexes.get(fromId);
		Vertex to = this.vertexes.get(toId);
		
		return getShortestPath(from, to);
	}
}
