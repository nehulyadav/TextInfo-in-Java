import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount
{
    enum State
    {
        START,
        WORD,
        DELIM,
    }

    private static TextInfo analyzeText(String fileName) throws IOException
    {
        try (BufferedReader reader = new BufferedReader(
            new FileReader(fileName)))
        {
            long charCount = 0;
            long wordCount = 0;
            long lineCount = 0;

            State state = State.START;
            int c;

            while ((c = reader.read()) != -1)
            {
                charCount++;
                char ch = (char) c;
                switch (state)
                {
                    case START:
                        lineCount++;
                        if (Character.isLetterOrDigit(ch))
                        {
                            state = State.WORD;
                            wordCount++;
                        }
                        else
                        {
                            state = State.DELIM;
                            if (ch == '\n') {lineCount++;}
                        }
                        break;
                    case WORD:
                        if (!Character.isLetterOrDigit(ch))
                        {
                            state = State.DELIM;
                            if (ch == '\n') {lineCount++;}
                        }
                        break;
                    case DELIM:
                        if (Character.isLetterOrDigit(ch))
                        {
                            state = State.WORD;
                            wordCount++;
                        }
                        else if (ch == '\n')
                        {
                            lineCount++;
                        }
                        break;
                }
            }

            return new TextInfo(fileName, charCount, wordCount, lineCount);
        }
    }

    public static void main(String[] args)
    {
        if (args.length < 1)
        {
            System.err.println("you must specify at least one filename");
        }

        for (String fileName : args)
        {
            try
            {
                TextInfo data = analyzeText(fileName);
                System.out.println(data);
            }
            catch (IOException exception)
            {
                System.err.printf("%s: unable to process the file\n",
                    fileName);
            }
        }

    }
}
