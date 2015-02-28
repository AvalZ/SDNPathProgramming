#Path Programming
## A higher level flow programming plugin for the OpenDaylight SDN Controller

The project's aim is to be able to program a path on multiple switches without having to worry about the network topology.

In normal flows, I can redirect the traffic coming into a switch from port X to port Y, but that's only for a single switch.
The project offers a higher level of abstraction in flow programming, being able to find the Shortest Path in a network.

1. With a REST API call, I can ask for redirection of traffic from port X of switch A, to port Y of switch B, without checking the actual topology.
2. The application asks the controller (through REST interface) for the network topology and creates an internal network model using those data.
3. The application then computes a Shortest Path solution (using a Dijkstra algorithm implementation through Minimum Spanning Tree computation).
4. The application then translates the internal path to single flows that can be installed in the network nodes.
5. For each new flow, the application calls the controller's REST interface and adds a flow through the Flow Programming component.

This application could also be used in the Defense4All project to simplify the task of a generic redirection to a remote AMS.

Future development should include:
- Enabling a user to set custom rules for the flows.
- Web UI (in the beginning there will only be a CLI)
