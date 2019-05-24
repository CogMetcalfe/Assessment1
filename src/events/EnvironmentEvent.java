package events;

import maths.Vector;

public class EnvironmentEvent extends LocationEvent{
	
	
	public EnvironmentEvent() {
		generateEvent();
	}
	
	void generateEvent(int type);
	
	
	@Override
	public void runEvent() {
	}


}
