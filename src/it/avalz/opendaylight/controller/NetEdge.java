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
import it.avalz.graph.Vertex;

/**
 *
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class NetEdge extends Edge {

	private final int port;

	public NetEdge(Vertex target, double weight, int port) {
		super(target, weight);
		this.port = port;
	}

	public NetEdge(Vertex target, int port) {
		super(target);
		this.port = port;
	}
	
	@Override
	public String toString() {
		return super.toString() + " port=" + this.port;
	}

}
