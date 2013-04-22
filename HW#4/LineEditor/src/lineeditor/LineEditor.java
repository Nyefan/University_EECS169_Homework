package lineeditor;

/*--------------------------------------------------------------*
 *  File Name: Fighter.java					|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Homework Number: 03						|
 *  Description: TODO - WRITE DESCRIPTION OF THE PROGRAM HERE	|
 *  File Created: Apr 6, 2013					|
 *  Last Changed: Apr 12, 2013					|
 ---------------------------------------------------------------*/

public class LineEditor {
    private int maxChars;
    private int length;
    private char[] text;
    
    public LineEditor(int maxChar) {
        maxChars = maxChar;
        text = new char[maxChars];
        length = 0;
    }
    
    public boolean insert_text(char[] newText, int beginIndex) {
        int insertionLength = newText.length;
        if(insertionLength + length > maxChars) {return false;}
        
        for(int textIndex = length - 1; textIndex >= beginIndex; textIndex--) {
            text[textIndex + insertionLength] = text[textIndex];
        }
        for(int textIndex = beginIndex, newTextIndex = 0;
                textIndex < beginIndex + insertionLength;
                textIndex++, newTextIndex++) {
            text[textIndex] = newText[newTextIndex];
        }
        this.length += insertionLength;
        System.out.print(length);
        return true;
    }
    
    public boolean delete_text(int beginIndex, int endIndex) {
        if(beginIndex < 0 
        || beginIndex > endIndex 
        || endIndex > maxChars) {return false;}
        
        int deletionLength = endIndex - beginIndex;
        length -= deletionLength;
        
        for(int currentIndex = beginIndex; currentIndex < length; currentIndex++) {
            text[currentIndex] = text[currentIndex + deletionLength];
        }
        for(int currentIndex = length; currentIndex < maxChars; currentIndex++) {
            text[currentIndex] = ' ';
        }
        System.out.print(length);
        
        return true;
    }
    public boolean replace_text(char[] newText, int beginIndex, int endIndex) {
        int replacedLength = beginIndex - endIndex;
        
        if(beginIndex < 0 
        || beginIndex > endIndex 
        || endIndex >= maxChars 
        || newText.length + this.length - replacedLength > maxChars) {return false;}
        
        delete_text(beginIndex, endIndex);
        insert_text(newText, beginIndex);
        
        return true;
    }
    
    protected void printDebugging(char[] newText) {
        System.out.println("text is " + new String(text));
        System.out.println("newText is " + new String(newText));
    }
    
    protected void printDebugging(String newText) {
        System.out.println("text is " + new String(text));
        System.out.println("newText is " + newText);
    }

    public char[] getText() {
        return text;
    }
    
}


/**--------------------------------NOTES----------------------------------------
 * 
 */