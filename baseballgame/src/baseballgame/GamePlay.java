package baseballgame;
import java.util.Random;
public class GamePlay {

	public static void main(String[] args) {
		
		Team Giants =new Team("読売ジャイアンツ","G ");
		Team Fighters =new Team("北海道日本ハムファイターズ","F ");
		//ジャイアンツのラインナップ-----------------------------------------------------
		Giants.addPlayer("ピッチャー","大勢","R","R",0.1,0.2,150);
		Giants.addPlayer("キャッチャー","岸田","R","R",0.25,0.4,0);
		Giants.addPlayer("ファースト","増田","R","R",0.27,0.5,0);
		Giants.addPlayer("セカンド","吉川","R","L",0.3,0.4,0);
		Giants.addPlayer("サード","坂本","R","R",0.2,0.3,0);
		Giants.addPlayer("ショート","泉口","R","L",0.3,0.4,0);
		Giants.addPlayer("レフト","中山","R","L",0.24,0.5,0);
		Giants.addPlayer("センター","オコエ","R","R",0.27,0.5,0);
		Giants.addPlayer("ライト","丸","R","L",0.27,0.5,0);
		
		Giants.addPitchType("大勢","ストレート");
		//Giants.changePlayerPosition("坂本", "ショート");
		
		Giants.dicideLineup("丸","オコエ","泉口","吉川","増田","中山","坂本","岸田","大勢");
		
		//ファイターズのラインナップ-----------------------------------------------------
		Fighters.addPlayer("ピッチャー","大勢","R","R",0.1,0.2,150);
		Fighters.addPlayer("キャッチャー","岸田","R","R",0.25,0.4,0);
		Fighters.addPlayer("ファースト","増田","R","R",0.27,0.5,0);
		Fighters.addPlayer("セカンド","吉川","R","L",0.3,0.4,0);
		Fighters.addPlayer("サード","坂本","R","R",0.2,0.3,0);
		Fighters.addPlayer("ショート","泉口","R","L",0.3,0.4,0);
		Fighters.addPlayer("レフト","中山","R","L",0.24,0.5,0);
		Fighters.addPlayer("センター","オコエ","R","R",0.27,0.5,0);
		Fighters.addPlayer("ライト","丸","R","L",0.27,0.5,0);
		
		Fighters.addPitchType("大勢","カーブ");
		//Fighters.changePlayerPosition("坂本", "ショート");
		
		Fighters.dicideLineup("丸","オコエ","泉口","吉川","増田","中山","坂本","岸田","大勢");
		
		
		
		
		
		Team teamA = Giants;
        Team teamB = Fighters;

        Random rand = new Random();
        Team offense = rand.nextBoolean() ? teamA : teamB;
        Team defense = (offense == teamA) ? teamB : teamA;

        System.out.println("⚾️ " + offense.getName() + " が先攻です！");


        for (int inning = 1; inning <= 9; inning++) {
            System.out.println("=====  " + inning + "回表：" + offense.getName() + " 攻撃 =====");
            playHalfInning(offense, defense.getPitcher());
            System.out.println("=====  " + inning + "回裏：" + defense.getName() + " 攻撃 =====");
            playHalfInning(defense, offense.getPitcher());

//            Team temp = offense;
//            offense = defense;
//            defense = temp;
//            pitcher = defense.getPitcher(); // 攻守交代
        }
    }

    public static int playHalfInning(Team battingTeam, Pitcher pitcher) {
        Player[] lineup = battingTeam.getFieldPlayers(); // 9人
        int outs = 0;
        int runs = 0;
        int batterIndex = 0;

        while (outs < 3) {
        	Player batter = lineup[batterIndex % 9];
        	batter.setBase(0);
            batterIndex++;

            double matchupBonus = getMatchupBonus(batter.getBattingSide(), pitcher.getPitchingSide());
            double baseOnProbability = batter.getObp() - ((pitcher.getPitchTypeCount() - 3) * 0.03) + matchupBonus;

            double dice = Math.random() * 10;
            if (dice < baseOnProbability * 10) {
                System.out.print("✅ 出塁成功 - ");

                double slgComponent = (batter.getSlg() - ((pitcher.getSpeed() - 150) * 0.01)) * 4;
                double result = slgComponent + Math.random() * 10;

                if (result >= 9) {
                	System.out.println("本塁打！");
                	for(Player p:battingTeam.getFieldPlayers()) {
                		if(p.getBase()!=null) {
                			p.setBase(p.getBase()+4);
                		}
                	}
                } else if (result >= 8) {
                	System.out.println("三塁打！");
                	for(Player p:battingTeam.getFieldPlayers()) {
                		if(p.getBase()!=null) {
                			p.setBase(p.getBase()+3);
                		}
                	}
                }else if (result >= 6) {
                	System.out.println("二塁打！");
                	for(Player p:battingTeam.getFieldPlayers()) {
                		if(p.getBase()!=null) {
                			p.setBase(p.getBase()+2);
                		}
                	}
                }else {
                	System.out.println("シングルヒット！");
                	for(Player p:battingTeam.getFieldPlayers()) {
                		if(p.getBase()!=null) {
                			p.setBase(p.getBase()+1);
                		}
                	}
                }
               
                for(Player p:battingTeam.getFieldPlayers()) {
                	if(p.getBase()!=null) {
                		if(p.getBase()>=4) {
                    		runs++; // 
                    		p.setBase(null);
                		}
                	}
                	
                }
            } else {
                outs++;
                System.out.println("❌ アウト！ " + outs + "アウト");
                batter.setBase(null);
            }
        }

        System.out.println("🛑 3アウト、チェンジ！（得点：" + runs + " 点）");
        for(Player p:battingTeam.getFieldPlayers()){
        	p.setBase(null);
        }
        return runs;

	}
    public static double getMatchupBonus(String batterSide, String pitcherSide) {
        return switch (batterSide + "-" + pitcherSide) {
            case "R-R" -> 0.00;
            case "R-L" -> 0.05;
            case "L-R" -> 0.15;
            case "L-L" -> -0.05;
            case "S-R" -> 0.15; // 両打ち vs 右
            case "S-L" -> 0.05; // 両打ち vs 左
            default -> 0.00;
        };
    }
    

}
