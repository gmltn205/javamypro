package MakeMeAlone;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{ // 하나의 프로그램 안에서 실행되는 작은 프로그램이다! =thread
	
	
	private Image NoteRoad=new ImageIcon(Main.class.getResource("../images/NoteLoad.png")).getImage();
	private Image Line = new ImageIcon(Main.class.getResource("../images/Line.png")).getImage();
	
	//게임 시작 시 아래에 뜨는, 게임 바 이미지
	private Image GameBar = new ImageIcon(Main.class.getResource("../images/GameBar.png")).getImage();
	//게임 시작 시, 게임을 구성하는 노트 이미지
	
	//게임 시작 시, 노트를 터치하는 센서 바 이미지
	private Image SensorBar = new ImageIcon(Main.class.getResource("../images/SensorBar.png")).getImage();
	private Image NoteRoadS=new ImageIcon(Main.class.getResource("../images/NoteLoad.png")).getImage();
	private Image NoteRoadD=new ImageIcon(Main.class.getResource("../images/NoteLoad.png")).getImage();
	private Image NoteRoadF=new ImageIcon(Main.class.getResource("../images/NoteLoad.png")).getImage();
	private Image NoteRoadG=new ImageIcon(Main.class.getResource("../images/NoteLoad.png")).getImage();
	private Image NoteRoadH=new ImageIcon(Main.class.getResource("../images/NoteLoad.png")).getImage();
	private Image NoteRoadJ=new ImageIcon(Main.class.getResource("../images/NoteLoad.png")).getImage();
	private Image NoteRoadK=new ImageIcon(Main.class.getResource("../images/NoteLoad.png")).getImage();
	
	private Image effect=new ImageIcon(Main.class.getResource("../images/effect.png")).getImage();
	private Image Good=new ImageIcon(Main.class.getResource("../images/Good.png")).getImage();
	private Image Perfect=new ImageIcon(Main.class.getResource("../images/Perfect.png")).getImage();
	private Image Miss=new ImageIcon(Main.class.getResource("../images/Miss.png")).getImage();
	
	private Image current;
	
	private int combo;
	private int combofontsize=50;
	private int score=0;
	private String titleName;
	private String musicTitle;
	private Music gameMusic;
	ArrayList<Note> noteList=new ArrayList<Note>();
	
	public Game(String titleName,String musicTitle) {
		this.titleName=titleName;
		
		this.combo=0;
		
		this.musicTitle=musicTitle;
		
		gameMusic=new Music(this.musicTitle,false);
	
		
	}
	
	public void screenDraw(Graphics g) {
		if(DynamicBeat.game==null) {
			return;
		}
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString(titleName, 20, 702);
		
		g.drawImage(GameBar, 0, 660, null);
		
		
		g.drawImage(Line, 0, 30, null);
		g.drawImage(NoteRoadS, 4, 30, null);
		g.drawImage(Line, 104, 30, null);
		g.drawImage(NoteRoadD, 108, 30, null);
		g.drawImage(Line, 208, 30, null);
		g.drawImage(NoteRoadF, 212, 30, null);
		g.drawImage(Line, 312, 30, null);
		
		g.drawImage(Line, 964, 30, null);
		g.drawImage(NoteRoadG, 968, 30, null);
		g.drawImage(Line, 1068, 30, null);
		g.drawImage(NoteRoadH, 1072, 30, null);
		g.drawImage(Line, 1172, 30, null);
		g.drawImage(NoteRoadJ, 1176, 30, null);
		g.drawImage(Line, 1276, 30, null);
		
		g.drawImage(current, 460, 420, null);
		g.setFont(new Font("Arial", Font.BOLD, combofontsize));
		
		if(combo < 5)
			{combofontsize=40;
			g.setColor(Color.green);}
			
		else if(combo >= 5 && combo <10)
			{combofontsize=50;
			g.setColor(Color.blue);}
		else {
			combofontsize=60;
			g.setColor(Color.red);}
        g.drawString("Combo: " + combo, 0, 720);
		
        g.setFont(new Font("Arial", Font.BOLD, 25));
		g.setColor(Color.white);
		g.drawString("Score: " + score, 580, 700);
		
		for(int i=0;i<noteList.size();i++) {
			Note note = noteList.get(i);
			if(!note.isProceeded()) {
				if(note.getY()>=635) {
				noteList.remove(i);
				i--;
				score-=100;
				current=Miss;
				combo=0;
				}else {
					noteList.remove(i);
					i--;
				}
				
			}else {
			note.screenDraw(g);
			}		
		}	
		g.drawImage(SensorBar, 0, 620, null);
		
	}
	public void pressS() {
		judge("S");
		NoteRoadS=new ImageIcon(Main.class.getResource("../images/Pressed_note.png")).getImage();
		
	}
	public void releaseS() {
		
		NoteRoadS=new ImageIcon(Main.class.getResource("../images/NoteLoad.png")).getImage();
		
	}
	public void pressD() {
		judge("D");
		NoteRoadD=new ImageIcon(Main.class.getResource("../images/Pressed_note.png")).getImage();
		
	}
	public void releaseD() {
		NoteRoadD=new ImageIcon(Main.class.getResource("../images/NoteLoad.png")).getImage();
		
	}
	public void pressF() {
		judge("F");
		NoteRoadF=new ImageIcon(Main.class.getResource("../images/Pressed_note.png")).getImage();
		
	}
	public void releaseF() {
		NoteRoadF=new ImageIcon(Main.class.getResource("../images/NoteLoad.png")).getImage();
		
	}
	public void pressG() {
		judge("G");
		NoteRoadG=new ImageIcon(Main.class.getResource("../images/Pressed_note.png")).getImage();
		
		
	}
	public void releaseG() {
		NoteRoadG=new ImageIcon(Main.class.getResource("../images/NoteLoad.png")).getImage();
		
		
	}
	public void pressH() {
		judge("H");
		NoteRoadH=new ImageIcon(Main.class.getResource("../images/Pressed_note.png")).getImage();
		
	}
	public void releaseH() {
		NoteRoadH=new ImageIcon(Main.class.getResource("../images/NoteLoad.png")).getImage();
		
	}
	public void pressJ() {
		judge("J");
		NoteRoadJ=new ImageIcon(Main.class.getResource("../images/Pressed_note.png")).getImage();
		
	}
	public void releaseJ() {
		NoteRoadJ=new ImageIcon(Main.class.getResource("../images/NoteLoad.png")).getImage();
		
	
	}
	@Override
	public void run() {
		dropNote(this.titleName);
		showFinishPopup();
	}
	private void showFinishPopup() {
		
        try {
            Thread.sleep(10000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        Finish.showPopup(score);
        }
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	public void dropNote(String titleName) {
		Beat[] beats= null;
		
		if(titleName.equals("thousands_year")) {
			score=0;
			combo=0;
			int startTime=4100-Main.REACH_TIME*1000;
			int gap=112;
			beats=new Beat[] { // 반박자 =gap *2 
					//1박자 gap*8
					//통으로 한박자 gap*16
				new Beat(startTime+gap*0,"S"),
				new Beat(startTime+gap*4,"D"),
				new Beat(startTime+gap*8,"F"),
				new Beat(startTime+gap*12,"G"),
				new Beat(startTime+gap*16,"H"),
			//0~32
			//한 마디당 gap * 32 , 반박자 4 한박자 8
				
				//반박자 5개 총 gap 10개?
				new Beat(startTime+gap*32,"S"),
				new Beat(startTime+gap*36,"D"),
				new Beat(startTime+gap*40,"F"),
				new Beat(startTime+gap*44,"H"),
				new Beat(startTime+gap*48,"G"),
				//32~64
				new Beat(startTime+gap*64,"S"),
				new Beat(startTime+gap*68,"D"),
				new Beat(startTime+gap*72,"F"),
				new Beat(startTime+gap*76,"H"),
				new Beat(startTime+gap*80,"G"),
				//64~96
				new Beat(startTime+gap*96,"S"),
				new Beat(startTime+gap*100,"D"),
				new Beat(startTime+gap*104,"F"),
				new Beat(startTime+gap*108,"H"),
				new Beat(startTime+gap*112,"G"),
				//96~128
				new Beat(startTime+gap*128,"S"),
				new Beat(startTime+gap*132,"D"),
				new Beat(startTime+gap*136,"F"),
				new Beat(startTime+gap*140,"H"),
				new Beat(startTime+gap*144,"G"),
				//128~160
				new Beat(startTime+gap*160,"S"),
				new Beat(startTime+gap*164,"D"),
				new Beat(startTime+gap*168,"F"),
				new Beat(startTime+gap*172,"H"),
				new Beat(startTime+gap*176,"G"),
				//160~192
				new Beat(startTime+gap*192,"S"),
				new Beat(startTime+gap*196,"D"),
				new Beat(startTime+gap*200,"F"),
				new Beat(startTime+gap*204,"H"),
				new Beat(startTime+gap*208,"G"),
				//192~224
				new Beat(startTime+gap*224,"S"),
				new Beat(startTime+gap*228,"D"),
				new Beat(startTime+gap*232,"F"),
				new Beat(startTime+gap*236,"H"),
				new Beat(startTime+gap*240,"G"),
				//224~256
				new Beat(startTime+gap*256,"S"),
				new Beat(startTime+gap*260,"D"),
				new Beat(startTime+gap*264,"F"),
				new Beat(startTime+gap*268,"H"),
				new Beat(startTime+gap*272,"G"),
				//256~288
				new Beat(startTime+gap*288,"S"),
				new Beat(startTime+gap*290,"D"),
				new Beat(startTime+gap*292,"F"),
				new Beat(startTime+gap*294,"D"),
				new Beat(startTime+gap*296,"S"),
				new Beat(startTime+gap*298,"D"),
				new Beat(startTime+gap*300,"F"),
				
				
				
				
				
				
				//288~320
				//가사시작 이 대로~~
				new Beat(startTime+gap*320,"S"),
				new Beat(startTime+gap*328,"F"),
				new Beat(startTime+gap*332,"D"),
				new Beat(startTime+gap*348,"D"),
				//320~352
					//보낼수는 없다고
				new Beat(startTime+gap*352,"D"),
				new Beat(startTime+gap*356,"H"),
				new Beat(startTime+gap*360,"H"),
				new Beat(startTime+gap*364,"G"),
				new Beat(startTime+gap*368,"F"),
				new Beat(startTime+gap*372,"J"),
				new Beat(startTime+gap*374,"J"),
				new Beat(startTime+gap*374,"S"),
				
				//352~384
					//밤 을 새워 간
				new Beat(startTime+gap*384,"F"),
				new Beat(startTime+gap*392,"J"),
				new Beat(startTime+gap*396,"J"),
				new Beat(startTime+gap*400,"S"),
				new Beat(startTime+gap*412,"S"),
				
				//384~416
					//절히 기도 했지만
				new Beat(startTime+gap*416,"D"),
				new Beat(startTime+gap*420,"H"),
				new Beat(startTime+gap*424,"H"),
				new Beat(startTime+gap*428,"G"),
				new Beat(startTime+gap*432,"F"),
				new Beat(startTime+gap*436,"J"),
				
				new Beat(startTime+gap*438,"J"),
				new Beat(startTime+gap*438,"S"),
				
				
				//416~448
					//더 이상 널
				new Beat(startTime+gap*448,"J"),
				new Beat(startTime+gap*456,"G"),
				new Beat(startTime+gap*460,"F"),
				new Beat(startTime+gap*460,"H"),
				new Beat(startTime+gap*476,"F"),
				new Beat(startTime+gap*476,"H"),
				
				//448~480
				//사랑할수없다면 차라리
				new Beat(startTime+gap*480,"D"),
				new Beat(startTime+gap*484,"H"),
				new Beat(startTime+gap*488,"H"),
				new Beat(startTime+gap*492,"S"),
				new Beat(startTime+gap*496,"D"),
				new Beat(startTime+gap*498,"F"),
				new Beat(startTime+gap*450,"F"),
				
				new Beat(startTime+gap*506,"G"),
				new Beat(startTime+gap*508,"H"),
				new Beat(startTime+gap*510,"J"),
				
				//480~512
				//나도 데려
				new Beat(startTime+gap*516,"J"),
				new Beat(startTime+gap*518,"G"),
				new Beat(startTime+gap*532,"G"),
				new Beat(startTime+gap*540,"F"),
				new Beat(startTime+gap*540,"G"),
				
				//512~544
				//가
				
				
				new Beat(startTime+gap*544,"H"),
				//544~576
				
				
				
				//내 마지막
				new Beat(startTime+gap*576,"J"),
				
				new Beat(startTime+gap*596,"J"),
				new Beat(startTime+gap*600,"J"),
				new Beat(startTime+gap*604,"H"),
				//576~608
				
				
				
				new Beat(startTime+gap*608,"G"),
	
				new Beat(startTime+gap*612,"G"),
				new Beat(startTime+gap*614,"F"),
				new Beat(startTime+gap*614,"D"),
				//소원을
				//608~640
				
				//하늘이 끝내 모른척
				new Beat(startTime+gap*640,"D"),
			
				new Beat(startTime+gap*644,"D"),
				new Beat(startTime+gap*646,"D"),
				new Beat(startTime+gap*652,"F"),
				new Beat(startTime+gap*654,"G"),
				
				new Beat(startTime+gap*660,"H"),
				new Beat(startTime+gap*662,"G"),
				new Beat(startTime+gap*666,"F"),
				
				//640~672
				
				//저 버린 대도 불꽃 처럼
				new Beat(startTime+gap*672,"F"),
				
				new Beat(startTime+gap*676,"D"),
				new Beat(startTime+gap*678,"F"),
				new Beat(startTime+gap*682,"G"),
				new Beat(startTime+gap*684,"G"),
				
				new Beat(startTime+gap*692,"D"),
				new Beat(startTime+gap*696,"F"),
				new Beat(startTime+gap*700,"G"),
				
				//672~704
				//럼 꺼지지 않는 사랑
				new Beat(startTime+gap*704,"H"),
				
				new Beat(startTime+gap*716,"H"),
				new Beat(startTime+gap*718,"J"),
				new Beat(startTime+gap*720,"H"),
			
				new Beat(startTime+gap*724,"G"),
				new Beat(startTime+gap*726,"G"),
				
				new Beat(startTime+gap*732,"F"),
				new Beat(startTime+gap*734,"F"),
				//704~736
				
				//으로
				new Beat(startTime+gap*740,"D"),
				new Beat(startTime+gap*742,"D"),
				
				//736~768
				
				
				new Beat(startTime+gap*768,"D"),
				
				new Beat(startTime+gap*772,"D"),
				new Beat(startTime+gap*774,"F"),
				new Beat(startTime+gap*780,"G"),
			
				new Beat(startTime+gap*782,"J"),
				new Beat(startTime+gap*784,"J"),
				
				new Beat(startTime+gap*790,"H"),
				new Beat(startTime+gap*792,"G"),
				
				new Beat(startTime+gap*796,"F"),
				//영원히 넌 가 슴 속 에 
				//768~800
				
				
				new Beat(startTime+gap*804,"D"),
				new Beat(startTime+gap*806,"D"),
				new Beat(startTime+gap*808,"F"),
				
				new Beat(startTime+gap*812,"D"),
				new Beat(startTime+gap*816,"F"),
				
				new Beat(startTime+gap*828,"D"),
				
				//타오를 테니 나
				
				//800-832
				
				new Beat(startTime+gap*832,"J"),
				
				new Beat(startTime+gap*840,"J"),
				
				new Beat(startTime+gap*844,"H"),
				new Beat(startTime+gap*846,"G"),
				
				new Beat(startTime+gap*860,"G"),
				
				
				
				//를 위해서 눈
				
				//832-864
				
				
				new Beat(startTime+gap*864,"G"),
				new Beat(startTime+gap*868,"F"),
				new Beat(startTime+gap*872,"D"),
				
				new Beat(startTime+gap*876,"D"),
				new Beat(startTime+gap*880,"F"),
				
				new Beat(startTime+gap*884,"D"),
				new Beat(startTime+gap*886,"F"),
				//물도 참 아 야 했던
				//864-896
				
				new Beat(startTime+gap*896,"F"),
				new Beat(startTime+gap*900,"F"),
				new Beat(startTime+gap*902,"G"),
				
				new Beat(startTime+gap*908,"H"),
				new Beat(startTime+gap*910,"D"),
				
				new Beat(startTime+gap*916,"D"),
				new Beat(startTime+gap*918,"F"),
				new Beat(startTime+gap*924,"G"),
				
				//그동안에 넌 얼마나
				
				//896-928
				new Beat(startTime+gap*932,"H"),
				new Beat(startTime+gap*934,"H"),
				new Beat(startTime+gap*936,"G"),
				
				new Beat(startTime+gap*940,"F"),
				new Beat(startTime+gap*942,"G"),
				new Beat(startTime+gap*942,"J"),
				
				new Beat(startTime+gap*956,"F"),
				//힘이들었니
				//928-960
				
				new Beat(startTime+gap*960,"H"),
				new Beat(startTime+gap*968,"H"),
				new Beat(startTime+gap*972,"G"),
				
				new Beat(startTime+gap*974,"F"),
				new Beat(startTime+gap*988,"G"),
				
				
				//년이가도 난
				//960-992
				
				new Beat(startTime+gap*992,"J"),
				new Beat(startTime+gap*996,"H"),
				new Beat(startTime+gap*1000,"G"),
				
				new Beat(startTime+gap*1004,"F"),
				new Beat(startTime+gap*1008,"D"),
				new Beat(startTime+gap*1012,"F"),
				
				new Beat(startTime+gap*1014,"F"),
				new Beat(startTime+gap*1014,"H"),
				//너를 잊을 수 없어
				//992-1024
				new Beat(startTime+gap*1024,"G"),
				new Beat(startTime+gap*1028,"G"),
				new Beat(startTime+gap*1032,"H"),
				
				new Beat(startTime+gap*1036,"J"),
				new Beat(startTime+gap*1040,"J"),
				new Beat(startTime+gap*1048,"H"),
				new Beat(startTime+gap*1048,"F"),
				
				
				
				//사랑했기 때 문 
				//1024-1056
				new Beat(startTime+gap*1056,"G"),
				//에~~
				
				
				
				
				
				
			};
		}
		
		int i=0;
		gameMusic.start();
		while(i<beats.length && !isInterrupted()) {
			boolean dropped=false;
			if(beats[i].getTime()<=gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);	
				i++;
				dropped=true;
				}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void judge(String input) {
		for(int i=0;i<noteList.size();i++) {
			Note note = noteList.get(i);
			
			if(input.equals(note.getNoteType())) {
				Evaluate(note.judge());
				break;
			}
		}
	
	}
	
	
	public void Evaluate(String judge) {
		if(judge.equals("Miss")) {
			current= Miss;
			score-=100;
			combo=0;
		}else if(judge.equals("Perfect")) {
			current=Perfect;
			if(combo>=5)
				score+=1500;
			else if(combo>=10)
				score+=2000;
			else 
				score+=1000;
			combo++;
		}else if(judge.equals("Good")) {
			current=Good;
			if(combo>=5)
				score+=750;
			else if(combo>=10)
				score+=1000;
			else 
				score+=500;
			combo++;
		}
	}
}
	
	