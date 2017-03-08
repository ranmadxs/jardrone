package clrobotic.drone.listener;

import com.codeminders.ardrone.NavData;
import com.codeminders.ardrone.NavDataListener;

public class NavDataBasicListenerImpl implements NavDataListener{

	private NavData navData;
	
	public void navDataReceived(NavData nd) {
		//System.out.println("XDDD : " + nd.getBattery());
		this.navData = nd;
	}

	public NavData getNavData() {
		return navData;
	}	
	

}
