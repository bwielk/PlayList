package playlist;

import java.util.ArrayList;

public class Album {
	
	private boolean isCompilation;
	private String title;
	private String artist;
	private ArrayList<Song> songs;
	
	public Album(boolean isCompilation, String artist, String title){
		this.isCompilation = isCompilation;
		this.artist = artist;
		this.title = title;
		this.songs = new ArrayList<Song>();
	}

	public boolean addSong(Song song) {
		if(isCompilation()){
			songs.add(song);
			return true;
		}else{
			if(song.getAlbum().equals(getTitle()) && song.getArtist().equals(getArtist())){
				songs.add(song);
				return true;
			}else{
				return false;
			}
		}
	}
	
	public ArrayList<Song> getSongs(){
		return songs;
	}
	
	private String getTitle() {
		return title;
	}
	
	private String getArtist(){
		return artist;
	}

	private boolean isCompilation(){
		return isCompilation;
	}
}
