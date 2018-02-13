package playlist;

public class Song {
	
	private String artist;
	private String title;
	private String album;
	
	public Song(String artist, String title, String album){
		this.artist = artist;
		this.title = title;
		this.album = album;
	}
	
	public String getArtist(){
		return artist;
	}

	public String getTitle(){
		return title;
	}
	
	public String getAlbum(){
		return album;
	}
}