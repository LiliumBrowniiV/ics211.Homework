package edu.ics211.h09;

public class GenTest {
	public static final int TIME_STEPS = 11;
	public static void main(String[] args) {
		SimplePacketReciever rec = new SimplePacketReciever();
		Router rt = new Router (rec);
		for(int i = 0; i < TIME_STEPS; i++) {
			System.out.println(rt.acceptPacket(new Packet(0)));
			
			
		}
		
		for (int i = 0; i < TIME_STEPS; i++) {
			rt.advanceTime();
		}
		
		System.out.println(rt.getDroppedPackets());
	}
}
