package playlist;

import java.util.LinkedList;

public class Playlist {
	
	private String name;
	private LinkedList<Song> songs;
	
	public Playlist (String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public LinkedList<Song> getSongs(){
		return songs;
	}
}