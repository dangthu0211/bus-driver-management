package Function;

import java.util.ArrayList;
import java.util.Scanner;

import Entity.*;
import Entity.Assignment.*;

public class Handling {
	
    public static ArrayList<BusDriver> BUSDRIVERS = new ArrayList<BusDriver>();
    public static ArrayList<Route> ROUTES = new ArrayList<Route>();
    public static ArrayList<Assignment> ASSIGNMENTS = new ArrayList<Assignment>();

	public static void inputNewBusDriver() {
		// TODO Auto-generated method stub
		System.out.print("Nhập số lượng lái xe mới muốn thêm: ");
        int newBusDriverNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < newBusDriverNumber; i++) {
            System.out.println("Nhập thông tin cho lái xe thứ " + (i + 1));
            BusDriver busDriver = new BusDriver();
            busDriver.inputInfo();
            BUSDRIVERS.add(busDriver);
        }
	}

	public static void inputNewRoute() {
		// TODO Auto-generated method stub
		System.out.print("Nhập số lượng tuyến mới muốn thêm: ");
        int newRouteNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < newRouteNumber; i++) {
            System.out.println("Nhập thông tin cho tuyến thứ " + (i + 1));
            Route route = new Route();
            route.inputInfo();
            ROUTES.add(route);
        }
	}

	public static <T> void showListObjs(ArrayList<T> objs) {
		// TODO Auto-generated method stub
		for(int i = 0; i < objs.size(); i++) {
			System.out.println(objs.get(i));
		}
	}
	
	public static <T> boolean checkData(ArrayList<T> objs) {
		for(int i=0; i<objs.size(); i++) {
			if(objs.get(i) != null) {
				return true;
			}
		}
		return false;
	}
	
	public static void createAssignment() {
		// TODO Auto-generated method stub
		if(!(checkData(BUSDRIVERS)&&checkData(ROUTES))) {
			System.out.println("Chưa có dữ liệu về lái xe hoặc tuyến. Vui lòng nhập trước đã!");
			return;
		}
		System.out.print("Nhập số lượng lái xe cần phân công tuyến: ");
		int driverNumber = new Scanner(System.in).nextInt();
		
		for(int i = 0; i < driverNumber; i++) {
			Assignment assignment = new Assignment();
			BusDriver busDriver = pushObj(i, "Lái xe");
			assignment.setBusDriver(busDriver);
			ArrayList<AssignmentDetail> assignmentDetails = createAssignmentDetails(busDriver.getId());
			if(!assignmentDetails.isEmpty()) {
				assignment.setAssignmentDetail(assignmentDetails);
				ASSIGNMENTS.add(assignment);
			}
		}
	}

	private static ArrayList<AssignmentDetail> createAssignmentDetails(int idBusDriver) {

		System.out.print("Nhập số lượng tuyến của lái xe này: ");
        int routeQuantity = new Scanner(System.in).nextInt();
        ArrayList<AssignmentDetail> assignmentDetails = new ArrayList<AssignmentDetail>();
		
        for(int j = 0; j < routeQuantity; j++) {
        	AssignmentDetail assignmentDetail = new AssignmentDetail();
        	Route route = pushObj(j, "Tuyến");
        	if(!isAssignmentDetailExist(idBusDriver, route.getId(), assignmentDetails)) {
        		//check nếu Detail đã tồn tại
        		
        		assignmentDetail.setRoute(route);
            	
        		System.out.print("Nhập số lượt của tuyến này: ");
            	int driveTurns;
            	do {
            		driveTurns = new Scanner(System.in).nextInt();
                    if (driveTurns >= 0 && totalTurns(idBusDriver) + driveTurns <= 15) {
                        break;
                    }
                    System.out.print("Tổng số lượt trong ngày của lái xe không vượt quá 15, vui lòng nhập lại: ");
                    
                } while (true);
            	           	
            	assignmentDetail.setDriveTurns(driveTurns);
            	
                //save detail vao danh sach details
            	if(assignmentDetail.getDriveTurns() !=0 ) {
                	assignmentDetails.add(assignmentDetail);
            	}
                
            	if(totalTurns(idBusDriver) == 0 && driveTurns == 15) {
                	System.out.println("Lái xe đủ số lượng lượt trong ngày, không thể cần nhập thêm tuyến");
                	break;
                }
                
        	} else {
        		System.out.println("Tuyến của lái xe này đã tồn tại");
        		j--;
        	}
        }
        
		return assignmentDetails;
		
	}

	private static boolean isAssignmentDetailExist(int idBusDriver, int idRoute,
			ArrayList<AssignmentDetail> unsavedAssignmentDetails) {
		
		//check trong saved
    	for(int i=0; i < ASSIGNMENTS.size(); i++) {
    		if(ASSIGNMENTS.get(i) != null) {
    			if(ASSIGNMENTS.get(i).getBusDriver().getId() == idBusDriver) {
    				ArrayList<AssignmentDetail> assignmentDetails = ASSIGNMENTS.get(i).getAssignmentDetail();
    				for(int j = 0; j < assignmentDetails.size(); j++) {
    					if(assignmentDetails.get(j).getRoute().getId() == idRoute) {
    	    				return true; // đã tồn tại
    					}
    				}
    			}
    		}
    	}
    	
    	//check unsaved 
    	for(int j = 0; j < unsavedAssignmentDetails.size(); j++) {
			if(unsavedAssignmentDetails.get(j)!= null && unsavedAssignmentDetails.get(j).getRoute().getId() == idRoute) {
				return true; // đã tồn tại
			}
			
    	}
    	
		return false;
	}

	private static int totalTurns(int idBusDriver) {
		int sum = 0;
		if(!checkData(ASSIGNMENTS)) return 0;
		for(int i=0; i<ASSIGNMENTS.size(); i++) {
			if(ASSIGNMENTS.get(i).getBusDriver().getId() == idBusDriver) {
				ArrayList<AssignmentDetail> assignmentDetails = ASSIGNMENTS.get(i).getAssignmentDetail();
				for(int j=0; j<assignmentDetails.size(); j++) {
					sum += assignmentDetails.get(i).getDriveTurns();
				}
			}
		}
		return sum;
	}
	private static <T> T pushObj(int index, String nameObj) {

		System.out.print("Xin mời nhập ID của " +  nameObj + " thứ " + (index + 1) + " : ");
        int idObj;
        T obj;
        do {
        	idObj = new Scanner(System.in).nextInt();
        	if(nameObj.equals("Lái xe")) {
        		obj = (T) searchBusDriverById(idObj);
        	}
        	else {
        		obj = (T) searchRouteById(idObj);
        	}
        	
            if (obj != null) {
                break;
            }
            System.out.print("Không tồn tại " + nameObj + " ID là " + idObj + ", vui lòng nhập lại: ");
        } while (true);
        
        
        return obj;
	}
	
	private static BusDriver searchBusDriverById (int idBusDriver) {
        for (int i = 0; i < BUSDRIVERS.size(); i++) {
        	BusDriver busDriver = BUSDRIVERS.get(i);
            if (busDriver != null && busDriver.getId() == idBusDriver) {
                return busDriver;
            }
        }
        return null;
    }
	
	private static Route searchRouteById (int idRoute) {
        for (int i = 0; i < ROUTES.size(); i++) {
        	Route route = ROUTES.get(i);
            if (route != null && route.getId() == idRoute) {
                return route;
            }
        }
        return null;
    }

	public static void showAssignment(ArrayList<Assignment> assignments) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < assignments.size(); i++) {
			Assignment assignment = assignments.get(i);
            if (assignment != null) {
                System.out.println("Lái xe " + assignment.getBusDriver().getName() + " lái các tuyến: ");
                for (int j = 0; j < assignment.getAssignmentDetail().size() ; j++) {
                    System.out.println(assignment.getAssignmentDetail().get(j));
                }
                System.out.println("-------------------------------");
            }
        }
		
	}
	
	public static void showSortingAssignments() {
		// TODO Auto-generated method stub
		System.out.println("Sắp xếp theo:");
		System.out.println("1. Theo Họ tên lái xe");
        System.out.println("2. Số lượng tuyến đảm nhận");
        System.out.print("Xin mời nhập lựa chọn của bạn: ");
        int functionChoice = -1;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 2) {
                break;
            }
            System.out.print("Chức năng được chọn không hợp lệ, vui lòng chọn lại: ");
        } while (functionChoice > 2 || functionChoice < 1);
		
        if(functionChoice == 1) {
        	sortAssignmentsByBusDriverName(ASSIGNMENTS);
        } else sortAssignmentsByTotalTurns(ASSIGNMENTS);
        
		showAssignment(ASSIGNMENTS);
	}

	
	private static void sortAssignmentsByBusDriverName(ArrayList<Assignment> assignments) {

		if(!checkData(ASSIGNMENTS)) {
			System.out.println("Chưa có dữ liệu trong bảng phân công. Vui lòng nhập trước đã!");
			return;
		}
		for(int i=0; i<assignments.size(); i++) {
			for(int j=i+1; j<assignments.size(); j++) {
				if(assignments.get(i).getBusDriver().getName().compareTo(assignments.get(j).getBusDriver().getName()) > 0 ) {
        			Assignment tmp = assignments.get(i); 
        			assignments.set(i,assignments.get(j)); 
        			assignments.set(j,tmp);
        		}
			}
		}
	}
	
	private static void sortAssignmentsByTotalTurns(ArrayList<Assignment> assignments) {

		if(!checkData(ASSIGNMENTS)) {
			System.out.println("Chưa có dữ liệu trong bảng phân công. Vui lòng nhập trước đã!");
			return;
		}
		for(int i=0; i<assignments.size(); i++) {
			for(int j=i+1; j<assignments.size(); j++) {
				if(assignments.get(i).getAssignmentDetail().size() <  assignments.get(j).getAssignmentDetail().size()) {
        			Assignment tmp = assignments.get(i); 
        			assignments.set(i,assignments.get(j)); 
        			assignments.set(j,tmp);
        		}
			}
		}
	}


	public static void showTotalDistance() {
		// TODO Auto-generated method stub
		
		if(!checkData(ASSIGNMENTS)) {
			System.out.println("Chưa có dữ liệu về bảng phân công. Vui lòng nhập trước đã!");
			return;
		}
    	
    	for(int i = 0; i < BUSDRIVERS.size(); i++) {
             if (BUSDRIVERS.get(i) != null) {
            	 System.out.println("Lái xe id là " + BUSDRIVERS.get(i).getId() + " có tổng khoảng cách chạy xe trong ngày là: "+ calculateDistance(BUSDRIVERS.get(i)));
             }
    	}
    	
	}

	private static int calculateDistance(BusDriver busDriver) {

		int totalDistance = 0; 
		
		for(int i = 0; i < ASSIGNMENTS.size() ; i++) {
			if(ASSIGNMENTS.get(i).getBusDriver().getId() == busDriver.getId()) {
				ArrayList<AssignmentDetail> assignmentDetails = ASSIGNMENTS.get(i).getAssignmentDetail();
				for(int j = 0 ; j < assignmentDetails.size(); j++) {
					totalDistance += assignmentDetails.get(i).getRoute().getDistance() * 
							assignmentDetails.get(i).getDriveTurns();
				}
			}
		}
		
		return totalDistance;
	}


	
}
