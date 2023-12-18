package MakeMeAlone;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	private Image noteImage=new ImageIcon(Main.class.getResource("../images/Note.png")).getImage();
	private int x,y=580-(1000/Main.SLEEP_TIME*Main.NOTE_SPEED)*Main.REACH_TIME;
	
	
	private String noteType;
	private boolean proceeded = true;
	
	public String getNoteType() {
	return noteType;	
	}
	
	public boolean isProceeded() {
		return proceeded;
		
	}
	public void close() {
		proceeded=false;
	}
	public Note(String noteType) {
		if(noteType.equals("S"))
		{
			x=4;
		}else if(noteType.equals("D")) {
			x=108;
		}else if(noteType.equals("F")) {
			x=212;
		}else if(noteType.equals("G")) {
			x=968;
		}else if(noteType.equals("H")) {
			x=1072;
		}else if(noteType.equals("J")) {
			x=1176;
		}
		
		
		this.noteType=noteType;
		
	}
	public void screenDraw(Graphics g) {
		if(!noteType.equals("space")){
			g.drawImage(noteImage, x, y,null);
			//스페이스바 미구현
			
		}else if(noteType.equals("long")) {
			g.drawImage(noteImage, x, y,null);
			g.drawImage(noteImage, x+100, y,null);
		}
	}
	public void drop() {
		y+=Main.NOTE_SPEED;
		if(y>=635) {
			System.out.println("Miss");
			close();
		}
	}
	@Override
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}else
				{
					interrupt();
					break;
				}

			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	public String judge() {
		if(y>=630) {
			System.out.println("Miss");
			close();
			return "Miss";
		}else if(y>=610) {
			System.out.println("Good");
			close();
			return "Good";
		}else if(y>=605) {
			System.out.println("Good");
			close();
			return "Good";
		}else if(y>=580) {
			System.out.println("Perfect");
			close();
			return "Perfect";
		}else if(y>=565) {
			System.out.println("Good");
			close();
			return "Good";
		}else if(y>=555) {
			System.out.println("Good");
			close();
			return "Good";
		}else if(y>=545) {
			System.out.println("Miss");
			close();
			return "Miss";
		}
		return "none";
		}
	public int getY() {
		return y;
		}
	}


