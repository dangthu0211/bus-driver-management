package Entity;

import java.io.Serializable;
import java.util.Scanner;

public class BusDriver implements Serializable {
	
    private static int AUTO_ID = -1;
	
	private int id;
    private String name;
    private String address;
    private String phoneNumber; 
    private String degree;

    public BusDriver() {
        if (AUTO_ID == -1) {
            AUTO_ID = 100;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
    }
    
	public BusDriver(String name, String address, String phoneNumber, String degree) {
    	if (AUTO_ID == -1) {
            AUTO_ID = 100;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.degree = degree;
    }
    
    public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String toString() {
        return "entity.BusDriver{" +
                "id=" + id +
                ", name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' + 
                ", degree='" + this.getDegree() + '\'' +'}';
    }
	
	public void inputInfo() {
		System.out.print("Nhập tên: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.print("Nhập SĐT: ");
        this.phoneNumber = new Scanner(System.in).nextLine();
        System.out.print("Nhập trình độ (nhập 1-6 : mức A-F): ");        
        int choice = -1;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 6) {
                break;
            }
            System.out.print("Lựa chọn trình độ không hợp lệ, vui lòng chọn lại: ");
        } while (choice > 6 || choice < 1);
        
        this.degree = Character.toString(choice + '0' + 16);

    }
    
}
