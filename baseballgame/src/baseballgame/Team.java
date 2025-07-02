package baseballgame;
import java.util.ArrayList;
import java.util.List;

public class Team {
	
	private String name;//チーム名
	private List<Player> players ;//選手リスト
	private Player[] fieldPlayers;//出場選手リスト
	
	int score;//点数

	public Team() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public Team(String name) {
		//コンストラクタ
		this.name=name;
		players=new ArrayList<Player>();
		fieldPlayers=new Player[9];
	}
	
	public void addPlayer(String position,String name,String battingSide,String pitchingSide,double obp,double slg,double speed) {
		//選手を追加する　ピッチャー、バッターで区別
		try{
			switch(position) {
			case "ピッチャー"->players.add(new Pitcher(position,name,battingSide,pitchingSide,obp,slg,speed));
			default->players.add(new Batter(position,name,battingSide,pitchingSide,obp,slg));
			}
			
		}catch(MyException e){
			e.getMessage();
		}
	}
	
	public void dicideLineup(String b1,String b2,String b3,String b4,String b5,String b6,String b7,String b8,String b9) {
		//スタメンを決める
		String[] names = { b1, b2, b3, b4, b5, b6, b7, b8, b9 };
		//選手の重複がないか確認
		for(int i = 0; i < 9; i++) {
			for(int j = i+1; j < 9; j++) {
				if(names[i].equals(names[j])) {
					System.out.println("選手が重複しています。スタメンを決めなおしてください");
					return;
				}
			}
		}
		
		//配列にセット
		for (int i = 0; i < 9; i++) {
	        boolean found = false;
	        for (Player p : players) {
	            if (p.getName().equals(names[i])) {
	                fieldPlayers[i] = p;
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("エラー：選手 " + names[i] + " が登録選手に見つかりません。スタメンを決めなおしてください.");
	            fieldPlayers = new Player[9]; //  選手決めなおし
	            return;
	        }    
	    }
		//ポジションの重複がないか確認
		for(int i = 0; i < 9; i++) {
			for(int j = i+1; j < 9; j++) {
				if(fieldPlayers[i].getPosition().equals(fieldPlayers[j].getPosition())) {
					System.out.println("ポジションが重複しています。スタメンを決めなおしてください");
					return;
				}
			}
		}
		
		System.out.println(getName()+"のスターティングラインナップを紹介します");
		for(int i=0; i < 9; i++) {
			
			System.out.println((i+1)+"番 "+fieldPlayers[i].getPosition()+" "+fieldPlayers[i].getName());
		}
	}
	
	public void changePlayerPosition(String playerName, String newPosition) {
		//ポジションを変更する
	    for (Player p : players) {
	        if (p.getName().equals(playerName)) {
	            p.setPosition(newPosition);
	            System.out.println(playerName + " のポジションを " + newPosition + " に変更しました。");
	            return;
	        }
	    }
	    System.out.println("選手 " + playerName + " が見つかりませんでした。");
	}
	
	public void addPitchType(String name,String pitchType){
		//ピッチャーに球種を追加する
		Pitcher pitcher =null;
		for (Player p : players) {
	        if (p.getName().equals(name)) {
	            pitcher= (Pitcher)p;
	        }
	    }
		pitcher.addPitchType(pitchType);
		
	}
	
	 // --- Getter ---
	public String getName() {
	    return name;
	}

	public List<Player> getPlayers() {
	    return players;
	}

	public Player[] getFieldPlayers() {
	    return fieldPlayers;
	}
	
	public Player getPlayer(String name) {
	    for (Player p : players) {
	        if (p.getName().equals(name)) {
	            return p;
	        }
	    }
	    return null; // 該当なしの場合は null を返す
	}
	
	public Pitcher getPitcher() {
	    for (Player p : fieldPlayers) {
	    	if(p.getPosition().equals("ピッチャー")) {
		        return (Pitcher)p;
	    	}
	        
	    }
	    return null; // 該当なしの場合は null を返す
	}


	public int getScore() {
	    return score;
	}
	 // --- Setter ---
	public void setName(String name) {
	    this.name = name;
	}

	public void setPlayers(List<Player> players) {
	    this.players = players;
	}

	public void setFieldPlayers(Player[] fieldPlayers) {
	    this.fieldPlayers = fieldPlayers;
	}

	public void setScore(int score) {
	    this.score = score;
	}

}
