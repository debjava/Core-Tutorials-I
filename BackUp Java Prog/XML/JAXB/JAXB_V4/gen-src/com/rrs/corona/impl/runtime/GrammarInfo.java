//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.5-b16-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.02.19 at 11:52:33 PM IST 
//

package com.rrs.corona.impl.runtime;

import javax.xml.bind.JAXBException;

/**
 * Keeps the information about the grammar as a whole.
 * 
 * Implementation of this interface is provided by the generated code.
 *
 * @author
 *  <a href="mailto:kohsuke.kawaguchi@sun.com">Kohsuke KAWAGUCHI</a>
 */
public interface GrammarInfo
{
    /**
     * Creates an unmarshaller that can unmarshal a given element.
     * 
     * @param namespaceUri
     *      The string needs to be interned by the caller
     *      for a performance reason.
     * @param localName
     *      The string needs to be interned by the caller
     *      for a performance reason.
     * 
     * @return
     *      null if the given name pair is not recognized.
     */
    UnmarshallingEventHandler createUnmarshaller(
        String namespaceUri, String localName, UnmarshallingContext context );
    
    /**
     * Creates an instance for the root element.
     * 
     * @return
     *      null if the given name pair is not recognized.
     */
    Class getRootElement(String namespaceUri, String localName);
    
    /**
     * Return the probe points for this GrammarInfo, which are used to detect 
     * {namespaceURI,localName} collisions across the GrammarInfo's on the
     * schemaPath.  This is a slightly more complex implementation than a simple
     * hashmap, but it is more flexible in supporting additional schema langs.
     */
    String[] getProbePoints();
    
    /**
     * Returns true if the invocation of the createUnmarshaller method
     * will return a non-null value for the given name pair.
     * 
     * @param nsUri
     *      The string needs to be interned by the caller
     *      for a performance reason.
     * @param localName
     *      The string needs to be interned by the caller
     *      for a performance reason.
     */
    boolean recognize( String nsUri, String localName );

    /**
     * Gets the default implementation for the given public content
     * interface. 
     *
     * @param javaContentInterface
     *      the Class object of the public interface.
     * 
     * @return null
     *      If the interface is not found.
     */
    Class getDefaultImplementation( Class javaContentInterface );

    /**
     * Gets the MSV AGM which can be used to validate XML during
     * marshalling/unmarshalling.
     */
    com.sun.msv.grammar.Grammar getGrammar() throws JAXBException;

    
    XMLSerializable castToXMLSerializable( Object o );
    
    
    ValidatableObject castToValidatableObject(Object o);
}
