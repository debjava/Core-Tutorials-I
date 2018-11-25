package org.w3c.dom;

public interface Document extends Node {
  
  public Element createElement(String tagName)
   throws DOMException;
  public Element createElementNS(String namespaceURI,
   String qualifiedName) throws DOMException;
  public Text createTextNode(String data);
  public Comment createComment(String data);
  public CDATASection createCDATASection(String data)
   throws DOMException;
  public ProcessingInstruction createProcessingInstruction(
   String target, String data) throws DOMException;
  public Attr createAttribute(String name) throws DOMException;
  public Attr createAttributeNS(String namespaceURI, 
   String qualifiedName) throws DOMException;
  public DocumentFragment createDocumentFragment();
  public EntityReference createEntityReference(String name)
   throws DOMException;

  public DocumentType      getDoctype();
  public DOMImplementation getImplementation();
  public Element           getDocumentElement();
  public Node              importNode(Node importedNode, 
                               boolean deep) throws DOMException;
  public NodeList          getElementsByTagName(String tagname);
  public NodeList          getElementsByTagNameNS(
                          String namespaceURI, String localName);
  public Element           getElementById(String elementId);

}