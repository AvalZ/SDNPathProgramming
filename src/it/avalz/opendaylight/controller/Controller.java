/*
 * Copyright (c) 2015 Andrea Valenza <avalenza89@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package it.avalz.opendaylight.controller;

import java.net.URL;

/**
 *
 * @author Andrea Valenza <avalenza89@gmail.com>
 */
public class Controller {

  private String IP;

  public Controller(String IP) {
    this.IP = IP;
  }

  public String getRawTopology() {
    String url = "http://" + this.IP + "/controller/nb/v2/topology/default";

    try {
      URL obj = new URL(url);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    // TODO: Finish the topology extractor
    return null;
  }

  public void addFlow(Flow f) {
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
