package MakeMeAlone;

public class Track {
	private String titleImage;
	private String startImage;
	private String gameImage;
	private String startmusic;
	private String gamemusic;
	private String titleName; // 제목
	
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getStartmusic() {
		return startmusic;
	}
	public void setStartmusic(String startmusic) {
		this.startmusic = startmusic;
	}
	public String getGamemusic() {
		return gamemusic;
	}
	public void setGamemusic(String gamemusic) {
		this.gamemusic = gamemusic;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName() {
		this.titleName=titleName;
	}
	public Track(String titleImage, String startImage, String gameImage, String startmusic, String gamemusic,String titleName) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startmusic = startmusic;
		this.gamemusic = gamemusic;
		this.titleName=titleName;
	}
	
}
