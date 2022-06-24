package Entity;

import java.io.Serializable;
import java.util.Scanner;

public class Route implements Serializable {

private static int AUTO_ID = -1;
	
	private int id;
    private int distance;
    private int numberOfStops;

    public Route() {
        if (AUTO_ID == -1) {
            AUTO_ID = 100;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
    }
    
	public Route(int distance, int numberOfStops) {
    	if (AUTO_ID == -1) {
            AUTO_ID = 100;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
        this.distance = distance;
        this.numberOfStops = numberOfStops;
    }

	public int getId() {
		return id;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getNumberOfStops() {
		return numberOfStops;
	}

	public void setNumberOfStops(int numberOfStops) {
		this.numberOfStops = numberOfStops;
	}
	
	public String toString() {
        return "entity.Route{" +
                "id=" + id +
                ", distance='" + distance + '\'' +
                ", numberOfStops='" + numberOfStops + '\'' + '}';
    }
	
	public void inputInfo() {
        System.out.print("Nhập khoảng cách: ");
        this.distance = new Scanner(System.in).nextInt();
        System.out.print("Nhập số điểm dừng: ");
        this.numberOfStops = new Scanner(System.in).nextInt();
	}
	
}
