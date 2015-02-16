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
import it.avalz.opendaylight.controller.Flow;

/**
 *
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class CreatingFlows {

  public static void main(String[] args) {
    Vertex v = new Vertex("00:00:00:00:00:00:00:01");
    Flow f = new Flow(v);
    f.addAction("DROP");
    f.addOutputAction(2);

    System.out.println(f);
  }
}
