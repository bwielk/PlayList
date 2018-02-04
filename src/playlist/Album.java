package playlist;

import java.util.LinkedList;

public class Album {
	
	private boolean isCompilation;
	private String title;
	private String artist;
	private LinkedList<Song> songs;
	
	public Album(boolean isCompilation, String artist, String title){
		this.isCompilation = isCompilation;
		this.artist = artist;
		this.title = title;
		this.songs = new LinkedList<Song>();
	}

	public boolean addSong(Song song) {
		if(isCompilation() && !songAlreadyExists(song)){
			songs.add(song);
			return true;
		}else{
			if(song.getAlbum().equals(getTitle()) && song.getArtist().equals(getArtist()) && !songAlreadyExists(song)){
				songs.add(song);
				return true;
			}else{
				return false;
			}
		}
	}
	
	private boolean songAlreadyExists(Song song){
		for(int i=0; i<songs.size(); i++){
			Song currentSong = songs.get(i);
			if(currentSong.getTitle().equals(song.getTitle()) && currentSong.getArtist().equals(song.getArtist())){
				return true;
			}
		}
		return false;
	}
	
	public LinkedList<Song> getSongs(){
		return songs;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist(){
		return artist;
	}

	private boolean isCompilation(){
		return isCompilation;
	}
}
