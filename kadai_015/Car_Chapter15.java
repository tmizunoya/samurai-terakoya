package kadai_015;

public class Car_Chapter15 {
	private int gear =1;
	private int speed = 10;
	
	public void gearChange(int afterGear) {
		int oldGear = this.gear;
		switch(afterGear) {
		case 1 -> {this.gear=1;this.speed=10;}
		case 2 -> {this.gear=2;this.speed=20;}
		case 3 -> {this.gear=3;this.speed=30;}
		case 4 -> {this.gear=4;this.speed=40;}
		case 5 -> {this.gear=5;this.speed=50;}
		default -> {this.gear=1;this.speed=10;}
		}
		if(oldGear!=this.gear) {
			System.out.println("ギア"+gear+"からギア"+this.gear+"に切り替えました");
		}
		
	}
	
	public void run() {
		
		
		System.out.println("速度は時速"+this.speed+"kmです");
	}

}
