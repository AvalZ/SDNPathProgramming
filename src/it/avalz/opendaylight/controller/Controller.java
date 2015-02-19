/*
 * Copyright (c) 2015 Andrea Valenza <avalenza89@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package it.avalz.opendaylight.controller;

import it.avalz.graph.Vertex;
import it.avalz.graph.exceptions.NoLinkException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class Controller {

  private String IP;
  private String username;
  private String password;

  public Controller(String IP, String username, String password) {
    this.IP = IP;
    this.username = username;
    this.password = password;
  }

  public String getRawEdges() {
    /*
    String url = "http://" + this.IP + "/controller/nb/v2/topology/default";

    try {
      URL obj = new URL(url);
    } catch (Exception e) {
      e.printStackTrace();
    }
    */
    
    String edgesString = "{\"edgeProperties\":[{\"properties\":{\"timeStamp\":{\"value\":1423208766757,\"name\":\"creation\"},\"name\":{\"value\":\"s3-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:03\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s4-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:04\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s5-eth1\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:06\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s7-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:07\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s2-eth1\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:03\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766757,\"name\":\"creation\"},\"name\":{\"value\":\"s2-eth2\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:04\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s5-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:01\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766755,\"name\":\"creation\"},\"name\":{\"value\":\"s1-eth1\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:01\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s2-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:01\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766755,\"name\":\"creation\"},\"name\":{\"value\":\"s6-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:06\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s5-eth2\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:07\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766755,\"name\":\"creation\"},\"name\":{\"value\":\"s1-eth2\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:01\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"}}}]}";

    // TODO: Finish the topology extractor
    return edgesString;
  }
  public String getRawNodes() {
    String nodesString = "{\"nodeProperties\":[{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765416,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:02\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765378,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:03\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:03\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765432,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"macAddress\":{\"value\":\"00:00:00:00:00:01\"},\"capabilities\":{\"value\":199},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:01\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765363,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:04\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:04\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765409,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:07\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:07\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765429,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:06\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:06\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765359,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:05\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"}}]}";
    
    return nodesString;
  }
  
  /**
   * Factory method for creating a graph from the controller object.
   * @return 
   */
  public Network newNetwork(){
    Network n = new Network();
    n.addNodesFromJSON(this.getRawNodes());
    n.addEdgesFromJSON(this.getRawEdges());
    
    return n;
  }

  public void addFlow(Flow f) {
    Vertex v = f.getNode();

    // TODO: implement installing flow
    System.out.println("Flow installed on vertex " + v);
    System.out.println(f);
  }

  public void installPath(List<Vertex> sp, int outputPort) {
    Iterator<Vertex> i = sp.listIterator(0);
    
    Vertex v = i.next();
    while (i.hasNext()) {
      Flow f = new Flow(v);

      int port = 0;
      try {
        port = v.getPortTo(v = i.next());
      } catch (NoLinkException ex) {
        ex.printStackTrace();
      }
      
      f.addOutputAction(port);
      
      this.addFlow(f);
    }
    
    Flow f = new Flow(v);
    f.addOutputAction(outputPort);
    
    this.addFlow(f);
  }
  /**
   * @return the IP
   */
  public String getIP() {
    return IP;
  }

  /**
   * @param IP the IP to set
   */
  public void setIP(String IP) {
    this.IP = IP;
  }
}
