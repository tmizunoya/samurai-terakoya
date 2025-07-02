package baseballgame;

import java.util.HashMap;
import java.util.Map;
public class Pitcher extends Player {

	private double speed;//球速
	private Map<String, Double> pitchTypes ;

	public Pitcher() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public Pitcher(String position,String name,String pitchingSide,String battingSide,double obp,double slg,double speed)throws MyException {
		super(position,name,pitchingSide,battingSide,obp,slg);
		this.speed=speed;
		pitchTypes=new HashMap<String, Double>();
	}
	
	public void addPitchType(String pitchType) {
		switch(pitchType) {
		case "ストレート"->pitchTypes.put(pitchType,this.speed);
		case "カーブ"->pitchTypes.put(pitchType,this.speed-30);
		case "スライダー"->pitchTypes.put(pitchType,this.speed-10);
		default->System.out.println(name+"に"+pitchType+"は追加できません");
		}
		
	}
	
	public int getPitchTypeCount() {
	    return pitchTypes.size();
	}
	 // --- Getter ---

	public double getSpeed() {
	    return speed;
	}
	 // --- Setter ---
	
	public void setSpeed(double speed) {
	    this.speed = speed;
	}

}
