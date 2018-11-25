/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : PostsDAO.java
 * Classes      : PostsDAO 
 */
package com.johntopley.webforum.data;

import com.johntopley.webforum.data.BaseDAO;
import com.johntopley.webforum.model.Post;
import com.johntopley.webforum.model.Posts;
import com.johntopley.webforum.model.User;
import com.johntopley.webforum.util.HTMLFilter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import java.util.Date;

import javax.naming.NamingException;

/**
 * Data Access Object for <code>Post</code> and <code>Posts</code> objects.
 * 
 * @author John Topley
 * @version 1.0
 * 
 * @see com.johntopley.webforum.model.Post
 * @see com.johntopley.webforum.model.Posts
 */
public class PostsDAO extends BaseDAO
{
  /**
   * No argument constructor for creating a new <code>PostsDAO</code>. Calls
   * the superclass constructor.
   * 
   * @throws NamingException if thrown by the superclass.
   * 
   * @see com.johntopley.webforum.data.BaseDAO#BaseDAO()
   */
  public PostsDAO() throws NamingException
  {
    super();
  }

  /**
   * Adds a new reply to the specified parent topic and increments the reply
   * count for that topic. The atomic operations of adding the reply and
   * incrementing the reply count are contained within one transaction which is
   * rolled back if an exception is thrown.
   * 
   * @param topicID The unique ID of the topic that this is a reply to.
   * @param reply The <code>Post</code> object representing the reply.
   * @param userID The unique ID of the user posting the reply.
   * @throws SQLException if the reply could not be added.
   */
  public void addReply(Long topicID, Post reply, Long userID) throws SQLException
  {
    if (topicID == null || topicID.longValue() == 0)
    {
      throw new IllegalArgumentException("topicID cannot be null or 0.");
    }

    if (reply == null)
    {
      throw new IllegalArgumentException("post cannot be null.");
    }

    if (userID == null || userID.longValue() == 0)
    {
      throw new IllegalArgumentException("userID cannot be null or 0.");
    }

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;

    StringBuffer sql = new StringBuffer();
    sql.append("INSERT INTO posts(")
       .append("            UserID ")
       .append("          , CreationDate ")
       .append("          , Message ")       
       .append("          , ParentID) ")
       .append("VALUES      (?, ?, ?, ?)");

    try
    {
      conn = super.getConnection();
      conn.setAutoCommit(false);
      pstmt = conn.prepareStatement(sql.toString());
      pstmt.setLong(1, userID.longValue());
      pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
      pstmt.setString(3, new HTMLFilter(reply.getMessage()).getFilteredHTML());
      pstmt.setLong(4, topicID.longValue());
      pstmt.execute();
        
      sql = new StringBuffer();
      sql.append("SELECT   p.ReplyCount ")
         .append("FROM     Posts p ")
         .append("WHERE    p.PostID = ?");

      pstmt = conn.prepareStatement(sql.toString());
      pstmt.setLong(1, topicID.longValue());
      rset = pstmt.executeQuery();

      while (rset.next())
      {
        long replyCount = rset.getLong("p.ReplyCount");
        replyCount++;
          
        sql = new StringBuffer();
        sql.append("UPDATE  posts p ")
           .append("SET     p.ReplyCount = ? ")
           .append("WHERE   p.PostID = ?");

        pstmt = conn.prepareStatement(sql.toString());
        pstmt.setLong(1, replyCount);
        pstmt.setLong(2, topicID.longValue());
        pstmt.executeUpdate();
      }

      conn.commit();
    }
    catch (SQLException e)
    {
      conn.rollback();
      throw e;
    }
    finally
    {
      super.closeResources(rset, pstmt, conn);
    }    
  }

  /**
   * Adds a new topic.
   * 
   * @param topic The <code>Post</code> object representing the topic.
   * @param userID The unique ID of the user posting the topic. 
   * @throws SQLException if the topic could not be added.
   */
  public void addTopic(Post topic, Long userID) throws SQLException
  {
    if (topic == null)
    {
      throw new IllegalArgumentException("post cannot be null.");
    }

    if (userID == null || userID.longValue() == 0)
    {
      throw new IllegalArgumentException("userID cannot be null or 0.");
    }

    Connection conn = null;
    PreparedStatement pstmt = null;

    StringBuffer sql = new StringBuffer();
    sql.append("INSERT INTO posts(")
       .append("            Subject ")
       .append("          , UserID ")
       .append("          , CreationDate ")
       .append("          , Message) ")
       .append("VALUES(?, ?, ?, ?)");

    try
    {
      conn = super.getConnection();
      pstmt = conn.prepareStatement(sql.toString());
      pstmt.setString(1, topic.getSubject());      
      pstmt.setLong(2, userID.longValue());
      pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
      pstmt.setString(4, new HTMLFilter(topic.getMessage()).getFilteredHTML());
      pstmt.execute();
    }
    finally
    {
      super.closeResources(null, pstmt, conn);
    }    
  }  

  /**
   * Gets the replies for the specified topic.
   * 
   * @param topicID The unique ID of the topic to get the replies for.
   * @return a <code>Posts</code> object containing the replies for the
   * specified topic.
   * @throws NamingException if thrown by the <code>UsersDAO</code> constructor.
   * @throws SQLException if the replies could not be retrieved.
   * 
   * @see com.johntopley.webforum.data.UsersDAO#UsersDAO()
   */
  public Posts getReplies(Long topicID) throws NamingException, SQLException
  {
    if (topicID == null || topicID.longValue() == 0)
    {
      throw new IllegalArgumentException("topicID cannot be null or 0.");
    }    

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    Posts replies = new Posts();

    StringBuffer sql = new StringBuffer();
    sql.append("SELECT   p.PostID ")
       .append("       , p.Subject ")
       .append("       , p.UserID ")
       .append("       , p.CreationDate ")
       .append("       , p.Message ")
       .append("       , u.Forenames ")
       .append("       , u.Surname ")
       .append("       , u.CreationDate ")
       .append("FROM     Posts p ")
       .append("       , Users u ")
       .append("WHERE   (p.PostID = ? OR p.ParentID = ?) AND p.UserID = u.UserID ")
       .append("ORDER BY p.CreationDate");
    
    try
    {
      conn = super.getConnection();
      pstmt = conn.prepareStatement(sql.toString());
      pstmt.setLong(1, topicID.longValue());
      pstmt.setLong(2, topicID.longValue());      
      rset = pstmt.executeQuery();

      while (rset.next())
      {
        Long postID = new Long(rset.getLong("p.PostID"));
        String subject = rset.getString("p.Subject");
        Long userID = new Long(rset.getLong("p.UserID"));

        UsersDAO usersDAO = new UsersDAO();
        User user = usersDAO.getUser(userID);
        String author = user.getDisplayName();
        String authorPostCount = user.getPostCount();
          
        Date creationDate
          = new Date(rset.getTimestamp("p.CreationDate").getTime());

        Date authorJoinedDate = rset.getDate("u.CreationDate");
        String message = rset.getString("p.Message");

        Post post = new Post(postID.toString(),
                             subject,
                             author,
                             authorPostCount,
                             authorJoinedDate,
                             creationDate,
                             message);
                             
        replies.addPost(post);
      }      
    }    
    finally
    {
      super.closeResources(rset, pstmt, conn);
    }

    return replies;
  }

  /**
   * Gets the subject text for the specified topic.
   * 
   * @param topicID The unique ID of the topic to get the subject text for.
   * @return a <code>String</code> containing the subject text.
   * @throws SQLException if the subject text could not be retrieved.
   */
  public String getSubject(Long topicID) throws SQLException
  {
    if (topicID == null || topicID.longValue() == 0)
    {
      throw new IllegalArgumentException("topicID cannot be null or 0.");
    }    

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    String subject = null;

    StringBuffer sql = new StringBuffer();
    sql.append("SELECT   p.Subject ")
       .append("FROM     Posts p ")
       .append("WHERE    p.PostID = ?");
    
    try
    {
      conn = super.getConnection();
      pstmt = conn.prepareStatement(sql.toString());
      pstmt.setLong(1, topicID.longValue());
      rset = pstmt.executeQuery();

      while (rset.next())
      {
        subject = rset.getString("p.Subject");
      }      
    }    
    finally
    {
      super.closeResources(rset, pstmt, conn);
    }

    return subject;  
  }

  /**
   * Gets the collection of topics.
   * 
   * @return a <code>Posts</code> object containing the topics.
   * @throws NamingException if thrown by the <code>UsersDAO</code> constructor.
   * @throws SQLException if the topics could not be retrieved.
   * 
   * @see com.johntopley.webforum.data.UsersDAO#UsersDAO()
   */
  public Posts getTopics() throws NamingException, SQLException
  {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;
    Posts topics = new Posts();

    StringBuffer sql = new StringBuffer();
    sql.append("SELECT   p.PostID ")
       .append("       , p.Subject ")
       .append("       , p.ReplyCount ")
       .append("       , p.UserID ")
       .append("       , p.CreationDate ")
       .append("FROM     Posts p ")
       .append("WHERE    p.ParentID = 0 ")
       .append("ORDER BY p.CreationDate DESC");
    
    try
    {
      conn = super.getConnection();
      stmt = conn.createStatement();
      rset = stmt.executeQuery(sql.toString());

      while (rset.next())
      {
        Long postID = new Long(rset.getLong("p.PostID"));
        String subject = rset.getString("p.Subject");
        Long replyCount = new Long(rset.getLong("p.ReplyCount"));
        Long userID = new Long(rset.getLong("p.UserID"));

        UsersDAO usersDAO = new UsersDAO();        
        User user = usersDAO.getUser(userID);
        String author = user.getDisplayName();       
          
        Date creationDate
          = new Date(rset.getTimestamp("p.CreationDate").getTime());

        Post post = new Post(postID.toString(),
                             subject,
                             replyCount.toString(),
                             author,
                             creationDate);
                             
        topics.addPost(post);
      }      
    }    
    finally
    {
      super.closeResources(rset, stmt, conn);
    }

    return topics;
  }
}