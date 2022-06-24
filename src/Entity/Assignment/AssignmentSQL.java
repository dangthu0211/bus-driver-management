package Entity.Assignment;

import java.io.Serializable;

public class AssignmentSQL implements Serializable {

	private int idBusDriver;
	private int idRoute;
	private int driveTurns;
	
	public int getIdBusDriver() {
		return idBusDriver;
	}
	
	public void setIdBusDriver(int idBusDriver) {
		this.idBusDriver = idBusDriver;
	}
	
	public int getIdRoute() {
		return idRoute;
	}
	
	public void setIdRoute(int idRoute) {
		this.idRoute = idRoute;
	}
	
	public int getDriveTurns() {
		return driveTurns;
	}
	
	public void setDriveTurns(int driveTurns) {
		this.driveTurns = driveTurns;
	}
	
	
}
