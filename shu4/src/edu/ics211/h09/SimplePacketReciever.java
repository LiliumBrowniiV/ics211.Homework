package edu.ics211.h09;

public class SimplePacketReciever implements PacketSenderInterface {

	@Override
	public void send(int queue, Packet p) {
		System.out.println("Received :" + p);
		
	}



}
