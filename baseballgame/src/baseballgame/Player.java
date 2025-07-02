package baseballgame;

public class Player {
	protected String position;//ポジション
	protected String name; //選手名
	protected String battingSide;//左打ちL、右打ちR、両打S
	protected String pitchingSide;//左投げL、右投げR
	protected double obp;//出塁率
	protected double slg;//長打率
    
	protected int base;//今いる塁　０の時はバッター
    public Player() {
    	//無名コンストラクタ
    }

	public Player(String position,String name,String pitchingSide,String battingSide,double obp,double slg) throws MyException{
		//コンストラクタ
		this.position=position;
		this.name=name;
		
			switch(battingSide) {
			case "L"->this.battingSide=battingSide;
			case "R"->this.battingSide=battingSide;
			case "S"->this.battingSide=battingSide;
			default->throw new MyException("利き腕のキーが違います");
			}
			switch(pitchingSide) {
			case "L"->this.pitchingSide=pitchingSide;
			case "R"->this.pitchingSide=pitchingSide;
			default->throw new MyException("利き腕のキーが違います");
			}
			
		this.obp=obp;
		this.slg=slg;
		
	}
	 // --- Getter ----------------------------------------------------------------
	public String getPosition() {
        return position;
    }
	
    public String getName() {
        return name;
    }

    public String getBattingSide() {
        return battingSide;
    }

    public String getPitchingSide() {
        return pitchingSide;
    }
    
    public double getObp() {
        return obp;
    }

    public double getSlg() {
        return slg;
    }

    public int getBase() {
        return base;
    }

    // --- Setter ----------------------------------------------------------------
    public void setPosition(String position) {
        this.position = position;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setBattingSide(String battingSide) {
        this.battingSide = battingSide;
    }

    public void setPitchingSide(String pitchingSide) {
        this.pitchingSide = pitchingSide;
    }
    
    public void setObp(double obp) {
        this.obp = obp;
    }

    public void setSlg(double slg) {
        this.slg = slg;
    }

    public void setBase(int base) {
        this.base = base;
    }

}
