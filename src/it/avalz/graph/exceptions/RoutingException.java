/*
 * Copyright (c) 2015 Andrea Valenza <avalenza89@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package it.avalz.graph.exceptions;

/**
 *
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class RoutingException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public RoutingException(String message) {
		super(message);
	}
	public RoutingException() {
		super("Routing error.");
	}
	
}
