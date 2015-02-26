package it.avalz.opendaylight.controller.examples;

import java.util.Iterator;
import java.util.List;

import it.avalz.graph.Edge;
import it.avalz.graph.Vertex;
import it.avalz.graph.exceptions.NoLinkException;
import it.avalz.opendaylight.controller.Controller;
import it.avalz.opendaylight.controller.DummyController;
import it.avalz.opendaylight.controller.Network;

/**
 *
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class NetworkFromDummyController {

  public static void main(String[] args) {

    Controller c = new DummyController();

    Network n = c.newNetwork();

    List<Vertex> sp = n.getShortestPath("00:00:00:00:00:00:00:04", "00:00:00:00:00:00:00:06");

    System.out.println(sp);

    try {
      c.installPath(sp, 1, 2);
    }
    catch (NoLinkException ex) {
      ex.printStackTrace();
    }
  }
}
