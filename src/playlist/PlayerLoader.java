package playlist;

import java.util.Scanner;

public class PlayerLoader {
	
	private static Scanner scanner = new Scanner(System.in);
	private static Player player = new Player();
	
	public static void main(String args[]){
		
		Album album1 = new Album(false, "Nirvana", "Nevermind");
		album1.addSong(new Song("Nirvana", "Smells Like Teen Spirit", "Nevermind"));
		album1.addSong(new Song("Nirvana", "Polly", "Nevermind"));
		album1.addSong(new Song("Nirvana", "Come As You Are", "Nevermind"));
		album1.addSong(new Song("Nirvana", "Breed", "Nevermind"));
		album1.addSong(new Song("Nirvana", "Lithium", "Nevermind"));
		album1.addSong(new Song("Nirvana", "The Man Who Sold The World", "Nevermind"));
		Album album2 = new Album(false, "David Bowie", "Aladdin Sane");
		album2.addSong(new Song("David Bowie", "Lady Grinning Soul", "Aladdin Sane"));
		album2.addSong(new Song("David Bowie", "Time", "Aladdin Sane"));
		album2.addSong(new Song("David Bowie", "The Prettiest Star", "Aladdin Sane"));
		player.addAlbum(album1);
		player.addAlbum(album2);
		player.createPlaylist("Rock");
		player.createPlaylist("Bowie");
		player.addSongToPlaylist(new Song("Nirvana", "The Man Who Sold The World", "Nevermind"), "Bowie");
		player.addSongToPlaylist(new Song("David Bowie", "Lady Grinning Soul", "Aladdin Sane"), "Bowie");
		player.addSongToPlaylist(new Song("David Bowie", "Time", "Aladdin Sane"), "Bowie");
		player.addSongToPlaylist(new Song("David Bowie", "The Prettiest Star", "Aladdin Sane"), "Bowie");
		
		boolean quit = false;
		int choice = 0;
		printMenu();
		while(!quit){
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice){
			case 0:
				printMenu();
				break;
			case 1:
				showPlaylists();
				break;
			case 2:
				showAlbums();
				break;
			}
		}
	}
	
	private static void showAlbums(){
		System.out.println("Here are your albums");
		System.out.println("\tARTIST\t\tTITLE\t\tNUMBER OF SONGS");
		for(int i=0; i<player.getAlbums().size(); i++){
			Album currentAlbum = player.getAlbums().get(i);
			System.out.println("\t"+currentAlbum.getArtist()+"\t\t"+currentAlbum.getTitle()+"\t\t"+currentAlbum.getSongs().size());
			for(int n=0; n<currentAlbum.getSongs().size(); n++){
				Song currentSong = currentAlbum.getSongs().get(n);
				System.out.println("\t"+(n+1)+"\t"+currentSong.getTitle());
			}
		}
	}
	
	private static void showPlaylists(){
		System.out.println("\tHere are the playlists: ");
		System.out.println("\tNAME\tNUMBER OF SONGS");
		for(int i=0; i<player.getPlaylists().size(); i++){
			Playlist currentPlaylist = player.getPlaylists().get(i);
			System.out.println("\t" + currentPlaylist.getName()+ "\t" + currentPlaylist.getSongs().size());
			for(int n=0; n<currentPlaylist.getSongs().size(); n++){
				Song currentSong = currentPlaylist.getSongs().get(n);
				System.out.println("\t"+(n+1)+"\t"+currentSong.getArtist()+"\t"+currentSong.getTitle()+"\t"+currentSong.getAlbum());
			}
		}
	}
	
	private static void printMenu(){
		System.out.println("\nWelcome! Enter a number to select and action");
		System.out.println("\tPress 0: to print instructions");
		System.out.println("\tPress 1: to show existing playlists");
		System.out.println("\tPress 2: to show existing albums and their songs");
	}	
}
