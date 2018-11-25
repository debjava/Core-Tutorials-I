/*
 * Copyright (c) 2004 John Topley (www.johntopley.com)
 * Project      : Web Forum
 * File         : Posts.java
 * Classes      : Posts 
 */
package com.johntopley.webforum.model;

import com.johntopley.webforum.model.Post;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A custom collection of <code>Post</code> objects.
 *
 * @author John Topley
 * @version 1.0
 */
public class Posts 
{
  /**
   * The collection of <code>Post</code> objects.
   */
  private Collection posts;
  
  /**
   * No argument constructor for constructing a new <code>Posts</code>
   * collection.
   *
   */
  public Posts()
  {
    super();
    posts = new ArrayList();
  }

  /**
   * Adds a <code>Post</code> object to the collection of <code>Post</code>
   * objects.
   *
   * @param post The <code>Post</code> object to be added to the collection.
   */
  public void addPost(Post post)
  {
    this.posts.add(post);
  }

  /**
   * Returns the collection of <code>Post</code> objects.
   *
   * @return the collection of <code>Post</code> objects.
   */
  public Collection getPosts()
  {
    return this.posts;
  }
}
