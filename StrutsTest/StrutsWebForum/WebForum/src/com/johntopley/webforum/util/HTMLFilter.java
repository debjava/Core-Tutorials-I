/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : HTMLFilter.java
 * Classes      : HTMLFilter 
 */
package com.johntopley.webforum.util;

/**
 * Implements a filter for converting reserved HTML tags into their equivalent
 * HTML character entities, apart from permitted tags.
 *
 * @author John Topley
 * @version 1.0
 */
public class HTMLFilter 
{
  /**
   * The HTML markup to be filtered.
   */
  private String html;
  
  /**
   * Converts reserved HTML tags into their equivalent HTML character entities,
   * apart from the permitted tags.
   * <p />
   * The permitted tags are:
   * <ul>
   * <li>&lt;b&gt; for bold text</li>
   * <li>&lt;i&gt; for italic text</li>
   * <li>&lt;u&gt; for underlined text.</li>
   * </ul>
   * 
   * @return the filtered HTML markup.
   */
  public String getFilteredHTML()
  {
    if (this.html == null)
    {
      return this.html;
    }

    char content[] = new char[this.html.length()];
    this.html.getChars(0, this.html.length(), content, 0);

    StringBuffer result = new StringBuffer(content.length + 50);
    boolean inTag = false;

    // Loop through each character in the input string.
    for (int i = 0; i < content.length; i++) 
    {
      switch (content[i])
      {

        // Swallow line feeds.
        case '\n':
        {
          break;
        }

        // Replace carriage returns with "<br />".
        case '\r':
        {
          result.append("<br />");
          break;
        }
        case '"':
        {
          result.append("&quot;");
          break;  
        }
        case '&':
        {
          result.append("&amp;");
          break;          
        }
        case '\'':
        {
          result.append("&#39;");
          break;  
        }
        case '<':
        {
          try
          {
            char secondChar = content[i + 1];
            char thirdChar  = content[i + 2];

            // "</>" exception case. Reset the flag and append &lt;
            if ('/' == secondChar && '>' == thirdChar)
            {
              result.append("&lt;");
            }
            else
            {

              // Look at the second character to determine if we're in a tag.
              inTag = isTag(secondChar);

              // If we're in a tag then check if the third character is valid.
              if (inTag)
              {             

                // The third character is valid, so if the third character is
                // the 'r' in "<br />", check if the remaining characters
                // are valid.
                if (isValidThirdChar(thirdChar))
                {
                  if ('r' == thirdChar)
                  {
                    char fourthChar = content[i + 3];

                    // Check if the fourth, fifth and sixth characters are the
                    // remainder of the "<br />" tag. If so, append the
                    // character.
                    if (isValidFourthChar(fourthChar))
                    {
                      char fifthChar  = content[i + 4];

                      if (isValidFifthChar(fifthChar))
                      {
                        char sixthChar  = content[i + 5];

                        if (isValidSixthChar(sixthChar))
                        {
                          result.append(content[i]);    
                        }

                        // The sixth character is not '>', so we're not in
                        // a "<br />".
                        else
                        {
                          inTag = false;
                        }
                      }

                      // The fifth character is not '/', so we're not in
                      // a "<br />".
                      else
                      {
                        inTag = false;
                      }
                    }

                    // The fourth character is not ' ', so we're not in
                    // a "<br />".
                    else
                    {
                      inTag = false;
                    }
                  }                

                  // The third character is valid, so we're in a tag but not
                  // "<br />", so append the character.
                  else
                  {
                    result.append(content[i]);
                  }
                }

                // The third character is not valid, so reset the flag and
                // append &lt;
                else
                {
                  inTag = false;
                  result.append("&lt;");
                }
              }

              // We're not in a tag so append &lt;
              else
              {
                result.append("&lt;");  
              }
            }
          }
          
          // The first character indicates that we're in a tag but there aren't
          // enough characters to validate the rest of the tag, so reset the
          // flag and append &lt;
          catch (ArrayIndexOutOfBoundsException e)
          {
            inTag = false;
            result.append("&lt;");
          }
          
          break;          
        }
        case '>':
        {

          // If we're in a tag then append '>' and reset the flag,
          // else append &gt;
          if (inTag)
          {
            result.append(content[i]);
            inTag = false;
          }
          else
          {
            result.append("&gt;");
          }
         
         break;
        }
        case 'B':
        {
          if (inTag)
          {
            result.append('b');
          }
          else
          {
            result.append(content[i]);
          }

          break;  
        }
        case 'I':
        {
          if (inTag)
          {
            result.append('i');
          }
          else
          {
            result.append(content[i]);
          }

          break;  
        }

        // Capital 'R' is included because technically they can type "<BR />"
        // and have it accepted, even though the filter is designed to replace
        // new lines with line breaks and to convert tags to lower case.
        case 'R':
        {
          if (inTag)
          {
            result.append('r');
          }
          else
          {
            result.append(content[i]);
          }

          break;  
        }
        case 'U':
        {
          if (inTag)
          {
            result.append('u');
          }
          else
          {
            result.append(content[i]);
          }

          break;  
        }

        // Not an HTML entity, so just append the input character.
        default:
        {
          result.append(content[i]);
          break;  
        }
      }
    }

    return result.toString();
  } 

  /**
   * Checks if the character passed as a parameter is valid as the second
   * character in the permitted HTML tags.
   *
   * @param c The character to check.
   * @return <code>true</code> if the character is valid, else
   * <code>false</code>.
   */
  private boolean isTag(char c)
  {
    boolean found = false;
    char[] validSecondChars = {'/', 'B', 'I', 'U', 'b', 'i', 'u'};

    for (int i = 0; i < validSecondChars.length; i++) 
    {
      if (validSecondChars[i] == c)
      {
        found = true;
        break;
      }      
    }

    return found;
  }  

  /**
   * Checks if the character passed as a parameter is valid as the third
   * character in the permitted HTML tags.
   *
   * @param c The character to check.
   * @return <code>true</code> if the character is valid, else
   * <code>false</code>.
   */
  private boolean isValidThirdChar(char c)
  {
    boolean found = false;

    // Capital 'R' is included because technically they can type <BR /> and have
    // it accepted, even though the filter is designed to replace new lines
    // with line breaks and to convert tags to lower case.
    char[] validThirdChars = {'>', 'B', 'I', 'R', 'U', 'b', 'i', 'r', 'u'};

    for (int i = 0; i < validThirdChars.length; i++) 
    {
      if (validThirdChars[i] == c)
      {
        found = true;
        break;
      }
    }

    return found;
  }

  /**
   * Checks if the character passed as a parameter is valid as the fourth
   * character in the permitted HTML tags.
   *
   * @param c The character to check.
   * @return <code>true</code> if the character is valid, else
   * <code>false</code>.
   */
  private boolean isValidFourthChar(char c)
  {
    return (' ' == c);
  }

  /**
   * Checks if the character passed as a parameter is valid as the fifth
   * character in the permitted HTML tags.
   *
   * @param c The character to check.
   * @return <code>true</code> if the character is valid, else
   * <code>false</code>.
   */
  private boolean isValidFifthChar(char c)
  {
    return ('/' == c);
  }

  /**
   * Checks if the character passed as a parameter is valid as the sixth
   * character in the permitted HTML tags.
   *
   * @param c The character to check.
   * @return <code>true</code> if the character is valid, else
   * <code>false</code>.
   */
  private boolean isValidSixthChar(char c)
  {
    return ('>' == c);
  }

  /**
   * No argument constructor for constructing a new <code>HTMLFilter</code>.
   *
   * @param html The HTML markup to be filtered.
   */
  public HTMLFilter(String html)
  {
    super();
    this.html = html;   
  } 
}
