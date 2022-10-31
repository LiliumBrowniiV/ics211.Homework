package edu.ics211.h09;

public class Packet implements PacketSenderInterface {
	 private int address;
	 private double data;

	  public Packet(int destination) {
	    address = destination;
	    data = Math.random();
	  }

	  public int getAddress() {
	    return address;
	  }

	  public void send(int queue, Packet p) {
	    System.out.println ("sending on queue " + queue + " packet " + p);
	  }

	  public String toString() {
	    return "packet with destination " + address + " has data " + data;
	  }
}

