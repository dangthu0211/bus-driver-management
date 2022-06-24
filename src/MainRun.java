
import java.util.Scanner;

import Function.*;

public class MainRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showMenu();

	}
	
	private static void showMenu() {
        while (true) {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    Handling.inputNewBusDriver();
                    break;
                case 2:
                	Handling.showListObjs(Handling.BUSDRIVERS);
                    break;
                case 3:
                	Handling.inputNewRoute();
                    break;
                case 4:
                	Handling.showListObjs(Handling.ROUTES);
                    break;
                case 5:
                	Handling.createAssignment();
                	System.out.println("-----Bảng phân công-----");
                	Handling.showAssignment(Handling.ASSIGNMENTS);
                    break;
                case 6:
                    Handling.showSortingAssignments();
                    break;
                case 7:
                	Handling.showTotalDistance();
                    break;
                case 8:
                	BinaryIO.writeToFile(Handling.BUSDRIVERS, "busDriver.dat");
                	BinaryIO.readBusDriver();
                	break;
                case 9:
                	BinaryIO.writeToFile(Handling.ROUTES, "route.dat");
                	BinaryIO.readRoute();
                	break;
                case 10:
                	BinaryIO.writeToFile(Handling.ASSIGNMENTS, "assignment.dat");
                	BinaryIO.readAssignment();
                	break;
                case 0:
                    System.out.println("Xin cảm ơn đã sử dụng phần mềm của chúng tôi!");
                    return;
            }
        }
    }
	

	private static int functionChoice() {
        System.out.println("\n\n===== PHẦN MỀM QUẢN LÝ PHÂN CÔNG LÁI XE BUÝT =====\n\n");
        System.out.println("1. Nhập danh sách lái xe mới.");
        System.out.println("2. In ra danh sách lái xe trong hệ thống.");
        System.out.println("3. Nhập danh sách tuyến mới.");
        System.out.println("4. In ra danh sách tuyến trong hệ thống.");
        System.out.println("5. Lập bảng phân công cho mỗi lái xe.");
        System.out.println("6. Sắp xếp danh sách bảng phân công.");
        System.out.println("7. Lập bảng kê tổng khoảng cách chạy xe trong ngày của mỗi lái xe.");
        System.out.println("8. Đọc ghi file cho danh sách lái xe");
        System.out.println("9. Đọc ghi file cho danh sách tuyến.");
        System.out.println("10. Đọc ghi file cho danh sách bảng phân công.");
        System.out.println("0. Thoát chương trình");
        System.out.println("--------------------------------------");
        System.out.print("Xin mời nhập lựa chọn của bạn: ");
        int functionChoice = -1;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 0 && functionChoice <= 10) {
                break;
            }
            System.out.print("Chức năng được chọn không hợp lệ, vui lòng chọn lại: ");
        } while (functionChoice > 10 || functionChoice < 0);
        return functionChoice;
    }
	
}
