package Entity.Assignment;

import java.io.Serializable;
import java.util.ArrayList;

import Entity.BusDriver;

public class Assignment implements Serializable {
	
	private BusDriver busDriver;
	private ArrayList<AssignmentDetail> assignmentDetail;
	
	public BusDriver getBusDriver() {
		return busDriver;
	}
	
	public void setBusDriver(BusDriver busDriver) {
		this.busDriver = busDriver;
	}
	
	public ArrayList<AssignmentDetail> getAssignmentDetail() {
		return assignmentDetail;
	}
	
	public void setAssignmentDetail(ArrayList<AssignmentDetail> assignmentDetail) {
		this.assignmentDetail = assignmentDetail;
	}
	
	
}
