package edu.ics211.h09;

import java.util.*;

public class Router implements RouterInterface {
	private final PacketQueue[] queues = new PacketQueue[8];
	private final PacketSenderInterface sender;
	private ArrayList<Packet> dropped = new ArrayList();
	
	public Router (PacketSenderInterface sender) {
		this.sender = sender;
		for(int index = 0; index < 8; index++) {
			queues[index] = new PacketQueue();
		}
		
	}
	
	
	@Override
	public void advanceTime() {
		for (PacketQueue queue : queues) {
			if(queue.peek() != null) {
				Packet p = queue.poll();
				sender.send(p.getAddress(),p);
			}
		}
		
	}

	@Override
	public boolean acceptPacket(Packet p) {
		try {
			queues[p.getAddress()].offer(p);
			return true;
		}
		catch(IllegalStateException e) {
			dropped.add(p);
			return false;
		}
	}

	@Override
	public List<Packet> getDroppedPackets() {
		ArrayList<Packet> temp = dropped;
		dropped = new ArrayList<Packet>();
		return temp;
	}

}
