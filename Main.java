import java.util.*;
public class Main {
	private static ArrayList<Album> albums=new ArrayList<>();
	public static void main(String[] args) {
		Album album=new Album("Album1","Artist1");
		
		album.addSong("Song1", 4.5);
		album.addSong("Song2", 3.5);
		album.addSong("Song3", 4.5);
		album.addSong("Song4", 2.6);
		album.addSong("Song5", 6.4);
		album.addSong("Song6", 5.6);
		album.addSong("Song7", 2.0);
		
		album=new Album("Album2","Artist2");
		
		album.addSong("Song8", 4.5);
		album.addSong("Song9", 3.5);
		album.addSong("Song10", 4.5);
		album.addSong("Song11", 2.6);
		album.addSong("Song12", 6.4);
		album.addSong("Song13", 5.6);
		album.addSong("Song14", 2.0);

		albums.add(album);
		
		LinkedList<Song> playlist1=new LinkedList<>();
		albums.get(0).addToPlaylsit("Song3",playlist1);
		albums.get(0).addToPlaylsit("Song6",playlist1);
		albums.get(1).addToPlaylsit("Song12",playlist1);
		albums.get(1).addToPlaylsit("Song14",playlist1);
		
		play(playlist1);
	}
	
	private static void play(LinkedList<Song> playlist) {
		Scanner sc=new Scanner(System.in);
		boolean quit=false;
		boolean forward=true;
		ListIterator<Song> li=playlist.listIterator();
		
		if(playlist.size()==0)
			System.out.println("Playlist has no songs");
		
		else {
			System.out.println("Now playing "+li.next().toString());
			printMenu();
			
		}
		
		while(!quit) {
			int action=sc.nextInt();
			sc.nextLine();
			
			switch(action) {
			
			case 0:
				System.out.println("Playlist complete");
				quit=true;
			break;
			
			case 1:
				if(!forward) {
					if(li.hasNext()) {
						li.next();
					}
					forward=true;
				}
				if(li.hasNext()) {
					System.out.println("Now playing "+li.next().toString());
				}
				else {
					System.out.println("No song available, reached the end of the playlist");
					forward=false;
				}
			break;
			
			case 2:
				if(forward) {
					if(li.hasPrevious()) {
						li.previous();
					}
					forward=false;
				}
				if(li.hasPrevious()) {
					System.out.println("Now playing "+li.previous().toString());
			}
				else {
					System.out.println("We are at the first song");
				}
			break;
			
			case 3:
				if(forward) {
					if(li.hasPrevious()) {
						System.out.println("Now playing "+li.previous().toString());
					}
					else {
						System.out.println("We are at the start of the list");
					}
				}
				else {
					if(li.hasNext()) {
						System.out.println("Now playing "+li.next().toString());
						forward=true;
					}
					else
						System.out.println("We have reached the end of the list");}
			break;
			
			case 4:
				printList(playlist);
				break;
				
			case 5:
				printMenu();
				break;
			
			case 6:
				if(playlist.size()>0) {
					li.remove();
					if(li.hasNext()) {
						System.out.println("Now playing "+li.next().toString());
					}
					else {
						if(li.hasPrevious())
						System.out.println("Now Playing "+li.previous().toString());}
				}
				}
			}
		
	}
	
	private static void printMenu() {
		System.out.println("Available options \n press");
		System.out.println("0 - quit ");
		System.out.println("1 - play next song");
		System.out.println("2 - play previous song");
		System.out.println("3 - replay the current song");
		System.out.println("4 - list all the songs");
		System.out.println("5 - print all available options");
		System.out.println("6 - delete current song");
	}
	
	private static void printList(LinkedList<Song> playlist) {
		Iterator<Song> i=playlist.iterator();
		System.out.println("------------");
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		System.out.println("------------");
	}

}
