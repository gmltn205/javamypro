package MakeMeAlone;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;



public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	
	
	private ImageIcon exitButtonEnterImage=new ImageIcon(Main.class.getResource("../images/exitButtonMouse.png"));
	private ImageIcon exitButtonImage=new ImageIcon(Main.class.getResource("../images/exitButton.png"));
	private ImageIcon startButton=new ImageIcon(Main.class.getResource("../images/start.png"));
	private ImageIcon startButton2=new ImageIcon(Main.class.getResource("../images/start2.png"));
	
	//시작화면으로 돌아가는 버튼
	private ImageIcon BackToStart=new ImageIcon(Main.class.getResource("../images/BackToStart.png"));
	private ImageIcon BackToStart2=new ImageIcon(Main.class.getResource("../images/BackToStart2.png"));
	
	
	//메인화면에서 왼쪽 오른쪽 방향표를 가르키는 버튼 이미지 불러오기
	private ImageIcon left=new ImageIcon(Main.class.getResource("../images/left.png"));
	private ImageIcon left_mouse=new ImageIcon(Main.class.getResource("../images/left_mouse.png"));
	private ImageIcon right=new ImageIcon(Main.class.getResource("../images/right.png"));
	private ImageIcon right_mouse=new ImageIcon(Main.class.getResource("../images/right_mouse.png"));
	
	
	private ImageIcon moving=new ImageIcon(Main.class.getResource("../images/left.png"));
	
	private Image MainMenu = new ImageIcon(Main.class.getResource("../images/cbnunu.png")).getImage();
	
	//천년의 사랑 메인 이미지 글씨
	private Image name_1000 = new ImageIcon(Main.class.getResource("../images/music_name1.png")).getImage();
	
	//금지된 사랑 메인 이미지 글씨
	private Image M_name_for = new ImageIcon(Main.class.getResource("../images/music_name2.png")).getImage();
	
	private Image Background = new ImageIcon(Main.class.getResource("../images/k.jpg")).getImage();
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../images/bar_menu2.png")));
	
	//천년의 사랑 박완규 씨 이미지
	private Image year_of_1000 = new ImageIcon(Main.class.getResource("../images/love_of_1000y.jpg")).getImage();
	private Image wankyou = new ImageIcon(Main.class.getResource("../images/wankyou.jpg")).getImage();
	
	
	//금지된사랑 메인 이미지
	private Image forbidden = new ImageIcon(Main.class.getResource("../images/forbidden_love.jpg")).getImage();
	
	//메인화면에서 게임을 시작할 버튼이미지 불러오기 
	private ImageIcon start_button = new ImageIcon(Main.class.getResource("../images/start_game1.png"));
	private ImageIcon start_button_click = new ImageIcon(Main.class.getResource("../images/start_game_click.png"));
	
	
	
	
	//메인화면에서 게임을 시작하는 버튼 생성
	private JButton start_game=new JButton(start_button);
	
	//시작화면으로 돌아가는 버튼을 생성.
	private JButton BackTo=new JButton(BackToStart);
	
	//메인화면에서 오른쪽 , 왼쪽을 누르는 버튼 생성
	private JButton leftb=new JButton(left);
	private JButton rightb=new JButton(right);
	
	private JButton startb=new JButton(startButton);
	private JButton exitButton=new JButton(exitButtonImage);
	private int mouseX,mouseY;
	
	private boolean isMainScreen=false;
	private boolean isGameStart=false;
	private boolean GoToMain=false;
	
	//각각의 곡을 담는 트랙 리스트
	ArrayList<Track> trackList=new ArrayList<Track>();
	
	//움직이게 하기 위한 무빙 리스트
	private Image[] movingImages=new Image[32];
	private int currentFrame=0;
	private Timer movingTimer;
	
	
	
	//선택된 메인화면 이미지
	private Image selection_music;
	//선택된 메인화면 이름 이미지
	private Image title_name=name_1000;
	//선택된 노래
	private Music selectedMusic;
	
	private int nowSelected=0;
	
	//페이드 아웃 효과를 위한 페이드아웃 계수와, 타이머변수
	private float alpha = 0.0f;
	private Timer fadeOutTimer;
	
	public static Game game;
	
	public DynamicBeat()
	{
		trackList.add(new Track("music_name1.png","love_of_1000y.jpg","stage.png","minute_year.mp3","thousands_year.mp3","thousands_year"));
		
		trackList.add(new Track("mssic_name2.png","forbidden_love.jpg","stage.png","forbidden_love.mp3","forbidden_real_love.mp3","forbidden__real_love"));
		
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0,0,0,0));
		setLayout(null);
		
		addKeyListener(new KeyListener());
		
		Music introMusic = new Music("introo.mp3",true);
		introMusic.start();
		
		//움직이는 것 처럼 보이는 사진 4장을 담아놓기.
		for (int i = 0; i < 15; i++) {
			if(i==4) {
				movingImages[i]=new ImageIcon(Main.class.getResource("../movingimages/moving" + (i) + ".png")).getImage();
				
			}else {
            movingImages[i] = new ImageIcon(Main.class.getResource("../movingimages/moving" + (i + 1) + ".png")).getImage();
				}
		}
		for (int i = 0; i < 15; i++) {
			
            movingImages[i+10] = new ImageIcon(Main.class.getResource("../movingimages/moving" + (16-i) + ".png")).getImage();
        }
		//사진을 움직이게 하자!
		 movingTimer = new Timer(160, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                currentFrame = (currentFrame + 1) % 20;
	                repaint();
	            }
	        });
		 
		 //페이드아웃 구현
		 fadeOutTimer = new Timer(30, new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            alpha += 0.02f; 
		            if (alpha >= 1.0f) {
		                
		                fadeOutTimer.stop();
		            }
		            repaint();
		        }
		    });
		 	BackTo.setBounds(0,0,120,120);
			BackTo.setBorderPainted(false);
			BackTo.setContentAreaFilled(false);
			BackTo.setFocusPainted(false);
			BackTo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					BackTo.setIcon(BackToStart2);
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					BackTo.setIcon(BackToStart);
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					backMain();
				   
				}
			});
			add(BackTo);
			BackTo.setVisible(false);
		 
		
		
		
		//메인화면에서 게임 시작을 담당하는 코드 
		start_game.setBounds(200,580,250,67);
		start_game.setBorderPainted(false);
		start_game.setContentAreaFilled(false);
		start_game.setFocusPainted(false);
		start_game.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				start_game.setIcon(start_button_click);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				start_game.setIcon(start_button);
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic=new Music("beep.mp3",false);
				buttonEnteredMusic.start();
				//게임 시작 시, 버튼들을 안보이게 하고 화면을 바꿈
				gameStart(nowSelected,"normal");
			    movingTimer.start(); // 시작 버튼을 누를 때 타이머를 시작합니다.
			    isGameStart=true;
			}
		});
		add(start_game);
		start_game.setVisible(false);
		
		
		//메인메뉴에서 왼쪽 화살표 생성
		leftb.setBounds(600,600,60,60);
		leftb.setBorderPainted(false);
		leftb.setContentAreaFilled(false);
		leftb.setFocusPainted(false);
		leftb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftb.setIcon(left_mouse);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftb.setIcon(left);
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic=new Music("beep.mp3",false);
				buttonEnteredMusic.start();
				selectLeft();
			}
		});
		add(leftb);
		leftb.setVisible(false);
		
		//메인메뉴에서 오른쪽 화살표 생성
		rightb.setBounds(680,600,60,60);
		rightb.setBorderPainted(false);
		rightb.setContentAreaFilled(false);
		rightb.setFocusPainted(false);
		rightb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightb.setIcon(right_mouse);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightb.setIcon(right);
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic=new Music("beep.mp3",false);
				buttonEnteredMusic.start();
				selectRight();
				
			}
		});
		add(rightb);
		rightb.setVisible(false);
		
		//시작버튼구현
		startb.setBounds(480,250,300,300);
		startb.setBorderPainted(false);
		startb.setContentAreaFilled(false);
		startb.setFocusPainted(false);
		startb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startb.setIcon(startButton2);
				
				Music buttonEnteredMusic=new Music("beep.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startb.setIcon(startButton);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic=new Music("beep.mp3",false);
				buttonEnteredMusic.start();
				Background=MainMenu;
				selectTrack(0);
				startb.setVisible(false);
				leftb.setVisible(true);
				rightb.setVisible(true);
				start_game.setVisible(true);
				
				introMusic.close();
				
				
			
				
				//메인메뉴 시작. (노래 이미지 생성 및 노래가 재생된다)
				isMainScreen=true;
				fadeOutTimer.start();
			}
		});
		add(startb);
		
		
		//나가기 버튼 관련
		exitButton.setBounds(1245,0,30,30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		//나가기 버튼 마우스 이벤트 관련
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnterImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic=new Music("beep.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(exitButton);
		
		
		//메뉴바 (맨 위)
		menubar.setBounds(0,0,1280,30);
		menubar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX=e.getX();
				mouseY=e.getY();
				
			}
			
		});
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				setLocation(x-mouseX,y-mouseY);
			}
		});
		add(menubar);
		 
	
			
			
		
		
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
		//fade out 관련.
		
	}

	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null);
		if(isMainScreen==true) {
			g.drawImage(selection_music,50,100,null);
			g.drawImage(title_name,0,0,null);
			   
		}
		if(GoToMain==true) {
			if (alpha >= 0.0f) {
		        g.setColor(new Color(0, 0, 0, alpha));
		        g.fillRect(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		    }
		}
		//게임이 시작되면 gif 움짤 시작.
		if(isGameStart==true) {
			
			g.drawImage(movingImages[currentFrame], 550, 100, null); // Adjust the coordinates as needed
			game.screenDraw(g);
			
		}
		paintComponents(g);
		try {
			Thread.sleep(5);
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.repaint();
	}
	public void selectTrack(int nowSelected) {
		if(selectedMusic !=null)
			selectedMusic.close();
		selection_music=new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getStartImage())).getImage();
		title_name=new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getTitleImage())).getImage();
		selectedMusic=new Music(trackList.get(nowSelected).getStartmusic(),true);
		selectedMusic.start();
	}
	
	public void selectLeft() {
		if(nowSelected==0)
			nowSelected=trackList.size()-1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}
	public void selectRight() {
		if(nowSelected==trackList.size()-1)
			nowSelected=0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected,String difficulty) {
		if(selectedMusic!=null) {
			selectedMusic.close();
		}
		isMainScreen=false;
		leftb.setVisible(false);
		rightb.setVisible(false);
		start_game.setVisible(false);
		BackTo.setVisible(true);
		Background=new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getGameImage())).getImage();
		isGameStart=true;
		
		game=new Game(trackList.get(nowSelected).getTitleName(),trackList.get(nowSelected).getGamemusic());
		game.start();
		setFocusable(true);
	}
	public void backMain() {
		if(selectedMusic!=null) {
			selectedMusic.close();
		}
		isMainScreen=true;
		selectTrack(nowSelected);
		BackTo.setVisible(false);
		leftb.setVisible(true);
		rightb.setVisible(true);
		start_game.setVisible(true);
		Background=MainMenu;
		isGameStart=false;
		game.close();
	}
}
