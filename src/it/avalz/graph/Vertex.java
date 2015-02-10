/*
 * Copyright (c) 2015 Andrea Valenza <avalenza89@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package it.avalz.graph;

import it.avalz.graph.exceptions.NoLinkException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class Vertex implements Comparable<Vertex> {
	private String id;
	private Vertex previous;
	private Map<Integer, Edge> adjacences;
	private double minDistance;
	
	public Vertex(String id) {
		this.id = id;
		this.adjacences = new HashMap<>();
		this.previous = null;
		this.minDistance = Double.POSITIVE_INFINITY;
	}
	
	public String getId() {
		return id;
	}
	public Vertex getPrevious() {
		return previous;
	}
	public List<Edge> getAdjacences() {
		return new ArrayList<>(adjacences.values());
	}

	/**
	 * Get the node's ports to adjacent nodes.
	 * @return The node's ports
	 */
	public List<Integer> getPorts() {
		return new ArrayList<>(adjacences.keySet());
	}

	/**
	 * Gets the port leading to a target adjacent vertex.
	 * @param v Target vertex.
	 * @return The port to a target adjacent vertex.
	 * @throws NoLinkException When vertex doesn't exist or is not adjacent.
	 */
	public int getPortTo(Vertex v) throws NoLinkException {
		for (Integer i : adjacences.keySet()) {
			if ( adjacences.get(i).getTarget().getId().equals(v.getId()) ) {
				return i;
			}
		}
		throw new NoLinkException("Node " + v + " is not connected to node " + this);
	}

	/**
	 * A wrapper for the getPortTo(Vertex v) method.
	 * @param id Target vertex ID.
	 * @return The port to a target adjacent vertex
	 * @throws NoLinkException When vertex doesn't exist or is not adjacent.
	 * @see getPortTo(Vertex v)
	 */
	public int getPortTo(String id) throws NoLinkException {
		return getPortTo(new Vertex(id));
	}
	
	/**
	 *  
	 * @return The minimum distance to this node from the root node.
	 */
	public double getMinDistance() {
		return minDistance;
	}
	
	/**
	 * Add an Edge object, exiting from a port in the vertex.
	 * @param e The Edge object
	 * @param port The port from which it exits
	 */
	public void addEdge(Edge e, int port){
		this.adjacences.put(port, e);
	}

	/**
	 * Add an Edge object, exiting from the next available port on the vertex.
	 * @param e
	 * @see addEdge(Edge e, int port)
	 */
	public void addEdge(Edge e){
		this.addEdge(e, adjacences.size());
	}

	/**
	 * Creates an Edge object using target and weight, then adds it to the vertex on selected port.
	 * @param target The target vertex
	 * @param weight The edge's weight
	 * @param port The selected port on the vertex from which the edge exits
	 * @see addEdge(Edge e, int port)
	 */
	public void addEdge(Vertex target, double weight, int port) {
		Edge e = new Edge(target, weight);
		this.addEdge(e, port);
	}
	
	/**
	 * Creates an Edge object using target and weight, then adds it to the next available port on the vertex.
	 * @param target
	 * @param weight
	 * @see addEdge(Vertex target, double weight, int port)
	 */
	public void addEdge(Vertex target, double weight) {
		this.addEdge(target, weight, adjacences.size());
	}
	public void addEdge(Vertex target) {
		this.addEdge(target, 1);
	}
	
	/**
	 * Creates and adds an Edge object to this vertex, then a symmetrical edge coming from the target vertex
	 * to this vertex.
	 * @param target The target vertex
	 * @param weight The weight of both edges
	 */
	public void addBidirectionalEdge(Vertex target, double weight ) {
		Edge e1 = new Edge(target, weight);
		Edge e2 = new Edge(this, weight);
		
		this.addEdge(e1);
		target.addEdge(e2);
	}
	/**
	 * Creates and adds an Edge object with default weight, then a symmetrical edge coming from the target
	 * vertex to this vertex.
	 * @param target The target vertex
	 * @see addBidirectionalEdge(Vertex target, double weight)
	 */
	public void addBidirectionalEdge(Vertex target) {
		this.addBidirectionalEdge(target, 1);
	}
	
	@Override
	public String toString() {
		return this.getId();
	}

	@Override
	public int compareTo(Vertex t) {
		return Double.compare(this.getMinDistance(), t.getMinDistance());
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(Vertex previous) {
		this.previous = previous;
	}

	/**
	 * @param adjacences the adjacences to set
	 */
	public void setAdjacences(List<Edge> adjacences) {
		for (Edge e : adjacences) {
			this.adjacences.put(this.adjacences.size(), e);
		}
	}

	/**
	 * @param minDistance the minDistance to set
	 */
	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}
	
	
}
