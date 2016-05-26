import java.util.*;

public class Learn2 {
	public static void main(String[] args) {
		Menu menu = new Menu();
	}
}

class Menu {
	private Notebook notebook;

	public Menu() {
		notebook = new Notebook();
		runMenu();
	}

	public void runMenu() {
		Scanner in = new Scanner(System.in);
		String input;
		System.out.println("Welcome!");
		do {
			System.out.print("Enter input: ");
			input = in.next();
			menuChoice(input);
		} while (!input.equals("quit"));
		
	}

	private void menuChoice(String input) {
	    Scanner in = new Scanner(System.in); //new Scanner
	    
	    String text;
	    int index;
	    
	    switch (input){ //java 7 can handle Strings in switch
	        case "new":
	            System.out.println("Enter the text for your note");                
	            text = in.nextLine();
	            Note note = new Note(text);
	            notebook.addNote(note);
	            System.out.println("Note created");
	            break;
	        case "get":
	            System.out.println("Enter the index of the note you want");
	             if(in.hasNextInt()){
	                index = in.nextInt();                    
	                if(index < notebook.numNotes() ){
	                      System.out.println( notebook.getNote(index).getContent() );
	                 }
	            }
	            break;
	        case "search":
	            System.out.println("Enter the text to search"); 
	            text = in.nextLine();
	            index = notebook.search(text);
	            if(index >= 0){
	                System.out.println("Note found: " + index);
	                System.out.println(notebook.getNote(index)); 
	            }
	            else{
	                System.out.println("Text not found"); 
	            }
	            break;
	        case "delete":
	            System.out.println("enter number of note to delete");
	            if(in.hasNextInt()){
	                index = in.nextInt();
	                notebook.deleteNote(index);
	                System.out.println("Note deleted");
	            }
	            break;
	        case "help":
	            System.out.println("Enter a keyword for an action: \n" + "new: create new note. print: print all notes. get: get a note.\n" +
	            "delete: delete a note. search: search for a note." );
	            break;
	         case "quit":
	            //quits in loop
	            break;
	        default:
	            System.out.println("unknown command. Type 'help' for instructions or 'quit' to quit.");
	            break;
	    }
	}
}

class Notebook {
	private ArrayList<Note> notes;

	public Notebook() {
		notes = new ArrayList<Note>();
	}

	public void addNote(Note note) {
		notes.add(note);
	}

	public Note getNote(int index) {
		return notes.get(index);
	}

	public int numNotes() {
		return notes.size();
	}

	public Note getLastNote() {
		return notes.get(notes.size() - 1);
	}

	public void deleteNote(int index) {
		notes.remove(index);
	}

	public int search(String str) {
		for (Note note : notes) {
			if (note.find(str) != -1) return note.find(str);
		}
		return -1;
	}

	public void printSummaries() {
		for (Note note : notes) {
			System.out.println(note.summarize());
		}
	}

	public void returnSummaries() {
		for (int i = 0; i < notes.size(); i++) {
			System.out.println(i + ". " + notes.get(i).summarize());
		}
	}

}

class Note
{
    private String content;
    
    //complete the constructor for Note
    public Note(String content)
    {
        this.content = content;
    }
    
    //complete this accessor method
    public String getContent()
    {
        return content;
    }
    
    //create a new method to return the content length
    public int noteLength() {
    	return content.length();
    }

    //adds parameter to the note content
    public void addToNote(String more) {
    	content += more;
    }

    //returns a String containing the first 20 characters
    public String summarize() {
    	if (content.length() < 20) return content;
    	return content.substring(0, 20);
    }

    //returns the first location of the found String
    public int find(String lookFor) {
    	return content.indexOf(lookFor);
    }

    //replaces oldText with newText
    public String replace(String oldText, String newText) {
    	StringBuilder sb = new StringBuilder();

    	for (int i = 0; i < content.length(); i++) {
    		if (i <= content.length() - oldText.length() && content.substring(i, i + oldText.length()).equals(oldText)) {
    			sb.append(newText);
    			i = i + oldText.length() - 1;
    		} else {
    			sb.append(content.charAt(i));
    		}
    	}
    	return sb.toString();
    }

    //counts occurrences of word in the content
    public int wordCount(String word) {
    	int count = 0;
    	for (int i = 0; i <= content.length() - word.length(); i++) {
    		if (content.substring(i, i + word.length()).equals(word)) count++;
    	}
    	return count;
    }
}