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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class Flow {

  // "{"installInHw":"true", "name":"flow1", "node":
  // {"id":"00:00:00:00:00:00:00:02", "type":"OF"}, "ingressPort":"2",
  // "etherType": "0x800", "protocol": "6", "tpDst": "80", "priority":"65535",
  // "actions":["DROP"]}"
  private String name;
  private boolean installInHw;
  private Vertex node; // Uses the "id" field and sets type to default "OF"
  private int ingressPort;
  private String etherType;
  private int protocol;
  private int tpDst;
  private int priority;
  private List<String> actions;

  private static int flowNumber;

  public Flow(String name, boolean installInHw, Vertex node, int ingressPort,
    String etherType, int protocol, int tpDst, int priority,
    List<String> actions) {
    this.name = name;
    this.installInHw = installInHw;
    this.node = node;
    this.ingressPort = ingressPort;
    this.etherType = etherType;
    this.protocol = protocol;
    this.tpDst = tpDst;
    this.priority = priority;
    this.actions = actions;

  }

  public Flow(Vertex node) {
    this("flow" + ++flowNumber, true, node, 0, "0x800", 0, 0, 65535, new ArrayList<String>());

  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the installInHw
   */
  public boolean isInstallInHw() {
    return installInHw;
  }

  /**
   * @param installInHw the installInHw to set
   */
  public void setInstallInHw(boolean installInHw) {
    this.installInHw = installInHw;
  }

  /**
   * @return the node
   */
  public Vertex getNode() {
    return node;
  }

  /**
   * @param node the node to set
   */
  public void setNode(Vertex node) {
    this.node = node;
  }

  /**
   * @return the ingressPort
   */
  public int getIngressPort() {
    return ingressPort;
  }

  /**
   * @param ingressPort the ingressPort to set
   */
  public void setIngressPort(int ingressPort) {
    this.ingressPort = ingressPort;
  }

  /**
   * @return the etherType
   */
  public String getEtherType() {
    return etherType;
  }

  /**
   * @param etherType the etherType to set
   */
  public void setEtherType(String etherType) {
    this.etherType = etherType;
  }

  /**
   * @return the protocol
   */
  public int getProtocol() {
    return protocol;
  }

  /**
   * @param protocol the protocol to set
   */
  public void setProtocol(int protocol) {
    this.protocol = protocol;
  }

  /**
   * @return the tpDst
   */
  public int getTpDst() {
    return tpDst;
  }

  /**
   * @param tpDst the tpDst to set
   */
  public void setTpDst(int tpDst) {
    this.tpDst = tpDst;
  }

  /**
   * @return the priority
   */
  public int getPriority() {
    return priority;
  }

  /**
   * @param priority the priority to set
   */
  public void setPriority(int priority) {
    this.priority = priority;
  }

  /**
   * @return the actions
   */
  public List<String> getActions() {
    return actions;
  }

  /**
   * @param actions the actions to set
   */
  public void setActions(List<String> actions) {
    this.actions = actions;
  }

  public void addAction(String action) {
    // Quotes are added so we can use the default .toString() method in List
    // objects and still be JSON compliant.
    this.actions.add("\"" + action + "\"");
  }

  public void addOutputAction(int port) {
    this.addAction("OUTPUT=" + port);
  }

  /**
   * @return the flowNumber
   */
  public static int getFlowNumber() {
    return flowNumber;
  }

  /**
   * @param aFlowNumber the flowNumber to set
   */
  public static void setFlowNumber(int aFlowNumber) {
    flowNumber = aFlowNumber;
  }

  @Override
  public String toString() {
    // TODO: Finire il return della lista di azioni
    StringBuilder sb = new StringBuilder();

    sb.append("{");
    sb.append("\"installInHw\":\"").append(installInHw).append("\"");
    sb.append(",");
    sb.append("\"name\":\"").append(name).append("\"");
    sb.append(",");
    sb.append("\"node\": {\"id\":\"").append(node.getId())
      .append("\", \"type\":\"OF\"}");
    sb.append(",");

    if (this.ingressPort != 0) {
      sb.append("\"ingressPort\":\"").append(ingressPort).append("\"");
      sb.append(",");
    }
    if (this.protocol != 0) {
      sb.append("\"protocol\":\"").append(protocol).append("\"");
      sb.append(",");
    }
    if (this.tpDst != 0) {
      sb.append("\"tpDst\":\"").append(tpDst).append("\"");
      sb.append(",");
    }

    sb.append("\"priority\":\"").append(priority).append("\"");
    sb.append(",");

    sb.append("\"actions\":").append(this.actions);

    sb.append("}");

    return sb.toString();
  }

}
