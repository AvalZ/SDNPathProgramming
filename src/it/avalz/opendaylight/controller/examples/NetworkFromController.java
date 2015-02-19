/*
 * Copyright (c) 2015 Andrea Valenza <avalenza89@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package it.avalz.opendaylight.controller.examples;

import it.avalz.graph.Vertex;
import it.avalz.opendaylight.controller.Controller;
import it.avalz.opendaylight.controller.Network;
import java.util.List;

/**
 *
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class NetworkFromController {

  public static void main(String[] args) {

    Controller c = new Controller("127.0.0.1", "admin", "admin");

    Network n = c.newNetwork();

    List<Vertex> sp = n.getShortestPath("00:00:00:00:00:00:00:04", "00:00:00:00:00:00:00:06");
    
    System.out.println(sp);
    
    c.installPath(sp, 1);
  }
}
