package org.w3c.dom;

public interface Text extends CharacterData {

  public Text splitText(int offset) throws DOMException;

}