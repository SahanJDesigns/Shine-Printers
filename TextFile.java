import java.io.*;

class TextFile {
    private String content;

    public TextFile(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    
}

/*public class Main {
    public static void main(String[] args) {
        TextFile textFile = TextFile.readFromFile("path_to_your_file.txt");
        System.out.println("File content: ");
        System.out.println(textFile.getContent());
    }
}*/