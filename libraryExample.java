import java.util.Arrays;

public class libraryExample {
	public static void main(String[] args) {
        Library lib1 = new Library("Central", 62);
        Library lib2 = new Library("East Branch", 5709);
        Library lib3 = new Library("West Branch", 445);

        Library[] libs = {lib1, lib2, lib3};

        BookManager manager = new BookManager(libs);
        manager.processBookBorrowing(1908);

}
}

class Library {
	private String libraryName;
	private int availableBooks;
	
	public Library(String libraryName, int availableBooks ) {
		this.libraryName=libraryName;
		this.availableBooks=availableBooks;
	}
	
	public String getLibraryName() {
		return libraryName;
	}
	
	public int getAvailableBooks() {
		return availableBooks;
	}
	public void bookBooks(int n) throws Exception {
		if(n>availableBooks) {
			throw new Exception("Not enough available books"); 
		}
		availableBooks-=n;
		
	}
	
}


class BookManager {
	private Library[] libraries;
	
	public BookManager(Library[] libraries) {
		this.libraries=libraries;
	}
	
	public void processBookBorrowing(int totalBooks) {
		System.out.println("List of libraries by number of available books (most to least):");
		Arrays.sort(libraries, (a, b) -> Integer.compare(a.getAvailableBooks(), b.getAvailableBooks()));
		
		for(Library L: libraries) {
			System.out.println(L.getAvailableBooks()+ " books available in the "+L.getLibraryName()+ " Library");
		}
		System.err.println();
		int remaining = totalBooks;
		
		for(int i=0; i<libraries.length && remaining>0; i++) {
			Library selectionLibrary= libraries[i];
			int toBook= Math.min(remaining, selectionLibrary.getAvailableBooks());
			
			try {
				selectionLibrary.bookBooks(toBook);
				System.out.println(toBook+ " books were placed in the " +selectionLibrary.getLibraryName()+ " Library.");
				remaining-=toBook;
				
			}catch (Exception e)  
			{
				System.out.println("erorrrrrr");
			}
		}
		
	}
	
}
