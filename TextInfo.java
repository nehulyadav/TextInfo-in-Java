public class TextInfo
{

    private String fileName;
    private long charCount;
    private long wordCount;
    private long lineCount;

    public TextInfo()
    {
        this(null, 0, 0, 0);
    }

    public TextInfo(String newFileName, long newCharCount,
        long newWordCount, long newLineCount)
    {
        setFileName(newFileName);
        setCharCount(newCharCount);
        setWordCount(newWordCount);
        setLineCount(newLineCount);
    }

    @Override
    public String toString()
    {
        return String.format("%s:\t%d\t%d\t%d", getFileName(),
            getCharCount(), getWordCount(), getLineCount());
    }

    public void setFileName(String newFileName)
    {
        fileName = newFileName;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setCharCount(long newCharCount)
    {
        charCount = newCharCount;
    }

    public long getCharCount()
    {
        return charCount;
    }

    public void setWordCount(long newWordCount)
    {
        wordCount = newWordCount;
    }

    public long getWordCount()
    {
        return wordCount;
    }

    public void setLineCount(long newLineCount)
    {
        lineCount = newLineCount;
    }

    public long getLineCount()
    {
        return lineCount;
    }

}