package Entity.Assignment;

import java.io.Serializable;

import Entity.Route;

public class AssignmentDetail implements Serializable{

	private Route route;
	private int driveTurns;
	
	public Route getRoute() {
		return route;
	}
	
	public void setRoute(Route route) {
		this.route = route;
	}
	
	public int getDriveTurns() {
		return driveTurns;
	}
	
	public void setDriveTurns(int driveTurns) {
		this.driveTurns = driveTurns;
	}
	
    public String toString() {
        return "AssignmentDetail{" +
                "route=" + route +
                ", driveTurns=" + driveTurns +
                '}';
    }
	
}
