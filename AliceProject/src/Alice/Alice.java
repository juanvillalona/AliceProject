package Alice;

public class Alice {

	public Alice() {

	}

	private static int numberOfWords = 0;
	public static String[] longestWords = new String[10];

	public String displayLongestWord(String longestWord) {
		return findLongestWord(longestWord);
	}

	public static String findLongestWord(String sentence) {
			
			
		sentence = sentence.replaceAll("\\s+", " ");
		sentence = sentence.replaceAll("[^a-zA-Z ]", "");

		int longestLength = 0;
		String longestWord = "";

		String words[] = sentence.split(" ");

		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > longestLength) {
				longestLength = words[i].length();
				longestWord = words[i];
			}
		}

		return longestWord;
	}

	public static String outputResponses(String sentence) throws InvalidSentenceException{

		String word = findLongestWord(sentence);
		addToArray(word);
		String outResponse = "";
		
		if (sentence.matches("^[0-9]*$") ) {
			throw new InvalidSentenceException("Sorry, I couldn't make out what you wrote. Although I am computer, there's just some things I can't read");
		}
		else if (word.length() == 3) {
			return outResponse = "Why do you feel " + word + " is important?";
		}
		else if (word.length() == 4) {
			return outResponse = "OK, tell me more about " + word;
		}
		else if (word.length() == 5) {
			return outResponse = "How does " + word + " affect you?";
		}
		else if (word.length() > 5) {
			return outResponse = "We seem to be making great progress with " + word;
		}
		else if (word.length() < 3) {
			return outResponse = "Is there something else you would like to discuss?";
		}
		

		return outResponse;
	}

	public static String readArray() {
		String readArray = "";

		for (int i = 0; i < longestWords.length; i++) {
			if (longestWords[i] != null) {
				readArray += longestWords[i] + " ";
			}

		}

		return readArray + "\n";
	}

	public static void addToArray(String word) {
		if (longestWords.length == numberOfWords) {
			updateArrayLength(longestWords);
		}
		longestWords[numberOfWords] = word;
		numberOfWords++;
	}

	public static void updateArrayLength(String[] arrayOld) {
		int newArrayLength = arrayOld.length * 2;
		String[] newArray = new String[newArrayLength];

		for (int i = 0; i < longestWords.length; i++) {
			newArray[i] = longestWords[i];
		}

		longestWords = newArray;

	}

	public static String endMessage(String fileName) {
		String message;
		message = charismaticAliceGoodbyeMessage();
		
		
		message += ": " + fileName + "\n\t\tFile Contents \n"
				+ aliceTextFile.readFile(fileName) + "\nLongest Words pulled from sentences: \n" + Alice.readArray();
		
		message += "\nWant to hear a joke before you go?\n" + charismaticAliceGoodbyeJoke();
		
		return message;
	}
	
	public static String charismaticAliceGoodbyeMessage () {
		String message = "";
		
		if (numberOfWords < 3){
			message = "Leaving Already? Fine... this is the File containing your log";
		}
		if (numberOfWords <= 20 || numberOfWords >= 4 ) {
			message = "It's been great chatting with you! Here's the name of the file containing our log";
		}
		if (numberOfWords > 20) {
			message = "I thought you'd never stop! I mean.. Here's the file containing our extensive log";
		}
		
		return message;
	}
	
	public static String charismaticAliceGoodbyeJoke () {
		String joke = "";
		
		
		if (numberOfWords <= 3) {
			joke = "What do you call a fake noodle?\nAn Imposta!\nGet it...?\nI'm a computer not a comedian, okay.";
		}
		if (numberOfWords <= 20 && numberOfWords >= 4) {
			joke = "What do you call a kid who stood up to the bullies?\nAn Ambulance!";
		}
		
		return joke;
	}

}
