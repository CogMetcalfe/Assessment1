package events;
import java.util.ArrayList;

import maths.RandomGod;
import maths.Vector;

public class WorldEvents {
	ArrayList<LocationEvent> eventArray;
	
	public WorldEvents(){
		eventArray = new ArrayList<LocationEvent>();
	}
	
	public LocationEvent addLocation(LocationEvent newLoc) {
		eventArray.add(newLoc);
		return newLoc;
	}
	
	public LocationEvent findOrCreateLocationEvent(Vector position) {
		
		LocationEvent searchResult = findLocation(position);
		if(searchResult!=null) {
			return searchResult;
		}else {
			return addLocation(generateEvent(position));
		}
	}
	
	private LocationEvent generateEvent(Vector position) {
		if(RandomGod.nextInt(10)==0) {
			return new CombatEvent(position);
		}else if (RandomGod.nextInt(30)==0){
			return new InteractiveEvent(position);
		}else {
			
			return new EnvironmentEvent(position);
		}
	}

	public LocationEvent findLocation(Vector position) {
		for(LocationEvent le:eventArray) {
			if(le.getPosition().equals(position)) {
				return le;
			}
		}
		return null;
	}
	
	//pathetic attempt at a non object binary search approach, very poorly structured, id have to repeat for adding. resorting to arrayList
//	public LocationEvent findLocation(Vector position) {
//		int i = (eventArray.size()-eventArray.size()%4)/2;
//		int step=i/2;
//		int leftOrRight=0;
//		while(step>1&&i>=0&&i<eventArray.size()) {
//			if(step>1&&(i<0||i>=eventArray.size())) {
//				if(leftOrRight!=0) {
//					return null;
//				}else {
//					step=1;
//					i=Math.min(i, eventArray.size()-1);
//					i=Math.max(i, 0);
//				}
//			}
//			//I wasn't lying, it's poorly written, why are you reading this?
//			//Why don't you check out the nice encounter event system? #LocationEvent
//			switch(position.compareTo(eventArray.get(i).position)) {
//			case -1:
//				i-=step;
//				if(step==1) {
//					if(leftOrRight==0) {
//						leftOrRight=-1;
//					}else if(leftOrRight==1) {
//						return null;
//					}
//				}
//				break;
//			case 0:
//				return eventArray.get(i);
//			case 1:
//				i+=step;
//				if(step==1) {
//					if(leftOrRight==0) {
//						leftOrRight=1;
//					}else if(leftOrRight==-1) {
//						return null;
//					}
//				}
//				break;
//				default:
//					return null;
//			}
//
//			if(step>1) {
//				step=Math.max(1, step/2);
//			}
//		}
//		return null;
//	}
}
