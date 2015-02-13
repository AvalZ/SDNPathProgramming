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
import it.avalz.graph.exceptions.NoLinkException;
import it.avalz.opendaylight.controller.Network;
import java.util.List;

/**
 *
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class EdgesAndNodesFromJson {

    public static void main(String[] args) {
        String edgesString = "{\"edgeProperties\":[{\"properties\":{\"timeStamp\":{\"value\":1423208766757,\"name\":\"creation\"},\"name\":{\"value\":\"s3-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:03\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s4-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:04\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s5-eth1\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:06\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s7-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:07\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s2-eth1\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:03\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766757,\"name\":\"creation\"},\"name\":{\"value\":\"s2-eth2\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:04\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s5-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:01\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766755,\"name\":\"creation\"},\"name\":{\"value\":\"s1-eth1\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:01\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s2-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:01\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766755,\"name\":\"creation\"},\"name\":{\"value\":\"s6-eth3\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"1\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:06\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766756,\"name\":\"creation\"},\"name\":{\"value\":\"s5-eth2\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:07\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"}}},{\"properties\":{\"timeStamp\":{\"value\":1423208766755,\"name\":\"creation\"},\"name\":{\"value\":\"s1-eth2\"},\"state\":{\"value\":1},\"config\":{\"value\":1},\"bandwidth\":{\"value\":10000000000}},\"edge\":{\"tailNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"},\"id\":\"3\",\"type\":\"OF\"},\"headNodeConnector\":{\"node\":{\"id\":\"00:00:00:00:00:00:00:01\",\"type\":\"OF\"},\"id\":\"2\",\"type\":\"OF\"}}}]}";

        String nodesString = "{\"nodeProperties\":[{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765416,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:02\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:02\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765378,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:03\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:03\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765432,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"macAddress\":{\"value\":\"00:00:00:00:00:01\"},\"capabilities\":{\"value\":199},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:01\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765363,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:04\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:04\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765409,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:07\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:07\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765429,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:06\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:06\",\"type\":\"OF\"}},{\"properties\":{\"tables\":{\"value\":-2},\"forwarding\":{\"value\":0},\"timeStamp\":{\"value\":1423208765359,\"name\":\"connectedSince\"},\"buffers\":{\"value\":256},\"description\":{\"value\":\"None\"},\"capabilities\":{\"value\":199},\"macAddress\":{\"value\":\"00:00:00:00:00:05\"},\"supportedFlowActions\":{\"value\":\"[Controller, Drop, Enqueue, HwPath, Output, PopVlan, SetDlDst, SetDlSrc, SetNwDst, SetNwSrc, SetNwTos, SetTpDst, SetTpSrc, SetVlanId, SetVlanPcp, SwPath]\"}},\"node\":{\"id\":\"00:00:00:00:00:00:00:05\",\"type\":\"OF\"}}]}";

        Network net = new Network();

        net.addNodesFromJSON(nodesString);

        net.addEdgesFromJSON(edgesString);

        try {
            int port = net.getVertex("00:00:00:00:00:00:00:01").getPortTo("00:00:00:00:00:00:00:05");
            System.out.println(port);
        } catch (NoLinkException ex) {
            ex.printStackTrace();
        }
        net.computePathsFrom("00:00:00:00:00:00:00:03");

        StringBuilder sb = new StringBuilder();

        /*
         for (Vertex v : net.getVertexes().values()) {

         sb.append("Node ");
         sb.append(v);
         sb.append("\n");
         sb.append("has ports: ");
         sb.append(v.getPorts());
         sb.append(" to nodes: ");
         sb.append(v.getAdjacences());
         sb.append("\n");
         }
         */
        System.out.print(sb.toString());

        List<Vertex> path = net.getShortestPathTo("00:00:00:00:00:00:00:07");
        System.out.println(path);

        net.computePathsFrom("00:00:00:00:00:00:00:06");

        List<Vertex> path2 = net.getShortestPathTo("00:00:00:00:00:00:00:07");
        System.out.println(path2);

        List<Vertex> pathFromTo = net.getShortestPath("00:00:00:00:00:00:00:03", "00:00:00:00:00:00:00:07");
        System.out.println(pathFromTo);
    }
}
