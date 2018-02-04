package playlist;

import java.util.ArrayList;

public class Player {
	
	private ArrayList<Album> albums;
	
	public Player(){
		albums = new ArrayList<Album>();
	}
	
	public boolean addAlbum(Album album){
		if(!albumAlreadyExists(album)){
			albums.add(album);
			return true;
		}
		return false;
	}
	
	public ArrayList<Album> getAlbums(){
		return albums;
	}
	
	private boolean albumAlreadyExists(Album album){
		for(int i=0; i<albums.size(); i++){
			Album currentAlbum = albums.get(i);
				if(	currentAlbum.getTitle().equals(album.getTitle()) &&
					currentAlbum.getArtist().equals(album.getArtist()) &&
					currentAlbum.getSongs().size() == album.getSongs().size()){
				return true;
			}
		}
		return false;
	}
}
