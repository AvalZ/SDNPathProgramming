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
public class Edge {
	private Vertex target;
	private double weight;

	public Edge(Vertex target, double weight) {
		this.target = target;
		this.weight = weight;
	}
	public Edge(Vertex target) {
		this(target, 1);
	}

	/**
	 * @return the target
	 */
	public Vertex getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(Vertex target) {
		this.target = target;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		Vertex t = this.target;
		String s = this.target.getPrevious() + "->" + t + " w=" + this.weight;
		return s;
	}
}