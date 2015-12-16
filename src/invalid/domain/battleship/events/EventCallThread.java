package invalid.domain.battleship.events;

public class EventCallThread extends Thread {
	Event event;
	public EventCallThread(Event event) {
		super();
		this.event = event;
	}
	
	@Override
	public void run() {
		switch(this.event) {
		case EVENT_SPACE_CLICK:
			break;
		case EVENT_SHIP_DROP:
			break;
		default:
			break;
		}
	}
}
