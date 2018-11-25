/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : Post.java
 * Classes      : Post 
 */
package com.johntopley.webforum.model;

import java.util.Date;

/**
 * Class representing an individual post.
 * 
 * @author John Topley
 * @version 1.0
 */
public class Post 
{
  /**
   * The name of the author of the post.
   */
  private String author;

  /**
   * The date the author of the post joined the forum.
   */
  private Date authorJoinedDate;

  /**
   * The number of posts the author of the post has made.
   */
  private String authorPostCount;

  /**
   * The text of the post.
   */
  private String message;

  /**
   * The unique ID of the post.
   */
  private String postID;

  /**
   * The number of replies to the post.
   */
  private String replyCount;

  /**
   * The subject of the post.
   */
  private String subject;

  /**
   * The date and time the post was made.
   */
  private Date timestamp;
  
  /**
   * No argument constructor for creating a new <code>Post</code>.
   */
  public Post()
  {
    super();
  }

  /**
   * Overloaded constructor for creating a new <code>Post</code> object from the
   * passed arguments.
   * 
   * @param postID The unique ID of the post.
   * @param subject The subject of the post.
   * @param replyCount The number of replies to the post.
   * @param author The name of the author of the post.
   * @param timestamp The date and time the post was made.
   */
  public Post(String postID,
              String subject,
              String replyCount,
              String author,
              Date timestamp)
  {
    this(postID, subject, author, null, null, timestamp, null);
    setReplyCount(replyCount);
  }

  /**
   * Overloaded constructor for creating a new <code>Post</code> object from the
   * passed arguments.
   * 
   * @param postID The unique ID of the post.
   * @param subject The subject of the post.
   * @param author The name of the author of the post.
   * @param authorPostCount The number of posts the author of the post has made.
   * @param authorJoinedDate The date the author of the post joined the forum.
   * @param timestamp The date and time the post was made.
   * @param message The text of the post.
   */
  public Post(String postID,
              String subject,
              String author,
              String authorPostCount,
              Date authorJoinedDate,
              Date timestamp,
              String message)
  {
    this();
    setPostID(postID);
    setSubject(subject);
    setAuthor(author);
    setAuthorPostCount(authorPostCount);
    setAuthorJoinedDate(authorJoinedDate);
    setTimestamp(timestamp);
    setMessage(message);
  }  

  /**
   * Returns the name of the author of the post.
   * 
   * @return the name of the author of the post.
   */
  public String getAuthor()
  {
    return this.author;
  }

  /**
   * Sets the name of the author of the post.
   * 
   * @param author The name of the author of the post.
   */
  public void setAuthor(String author)
  {
    this.author = author;
  }

  /**
   * Returns the date the author of the post joined the forum.
   * 
   * @return the date the author of the post joined the forum.
   */
  public Date getAuthorJoinedDate()
  {
    return this.authorJoinedDate;
  }

  /**
   * Sets the date the author of the post joined the forum.
   * 
   * @param authorJoinedDate The date the author of the post joined the forum.
   */
  public void setAuthorJoinedDate(Date authorJoinedDate)
  {
    this.authorJoinedDate = authorJoinedDate;
  }

  /**
   * Returns the number of posts the author of the post has made.
   * 
   * @return the number of posts the author of the post has made.
   */
  public String getAuthorPostCount()
  {
    return this.authorPostCount;
  }

  /**
   * Sets the number of posts the author of the post has made.
   * 
   * @param authorPostCount The number of posts the author of the post has made.
   */
  public void setAuthorPostCount(String authorPostCount)
  {
    this.authorPostCount = authorPostCount;
  }

  /**
   * Returns the text of the post.
   * 
   * @return the text of the post.
   */
  public String getMessage()
  {
    return this.message;
  }

  /**
   * Sets the text of the post.
   * 
   * @param text The text of the post.
   */
  public void setMessage(String message)
  {
    this.message = message;
  }
  
  /**
   * Returns of unique ID of the post.
   * 
   * @return the unique ID of the post.
   */
  public String getPostID()
  {
    return this.postID;
  }

  /**
   * Sets the unique ID of the post.
   * 
   * @param postID The unique ID of the post.
   */
  public void setPostID(String postID)
  {
    this.postID = postID;
  }

  /**
   * Returns the number of replies to the post.
   * 
   * @return the number of replies to the post.
   */
  public String getReplyCount()
  {
    return this.replyCount;
  }

  /**
   * Sets the number of replies to the post.
   * 
   * @param replyCount The number of replies to the post.
   */
  public void setReplyCount(String replyCount)
  {
    this.replyCount = replyCount;
  }

  /**
   * Returns the subject of the post.
   * 
   * @return the subject of the post.
   */
  public String getSubject()
  {
    return this.subject;
  }

  /**
   * Sets the subject of the post.
   * 
   * @param subject The subject of the post.
   */
  public void setSubject(String subject)
  {
    this.subject = subject;
  }

  /**
   * Returns the date and time the post was made.
   * 
   * @return the date and time the post was made.
   */
  public Date getTimestamp()
  {
    return this.timestamp;
  }

  /**
   * Sets the date and time the post was made.
   * 
   * @param timestamp The date and time the post was made.
   */
  public void setTimestamp(Date timestamp)
  {
    this.timestamp = timestamp;
  }
}