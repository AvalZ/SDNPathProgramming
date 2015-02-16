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
import it.avalz.opendaylight.controller.Network;

/**
 *
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class NodesFromJson {

  public static void main(String[] args) {
    String jsonString = "{\"nodeProperties\":[{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765416,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:02\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765378,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:03\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:03\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765432,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"macAddress\":{\"value\":\"00:00:00:00:00:01\"},\"capabilities\":{\"value\":199},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:01\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765363,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:04\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:04\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765409,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:07\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:07\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765429,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:06\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:06\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765359,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:05\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"}}]}";

    Network net = new Network();

    net.addNodesFromJSON(jsonString);

    for (Vertex n : net.getVertexes().values()) {
      System.out.println(n);
    }
  }
}
