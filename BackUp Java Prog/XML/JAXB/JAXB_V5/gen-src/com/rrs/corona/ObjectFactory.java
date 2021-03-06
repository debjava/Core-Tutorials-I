//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.5-b16-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.02.20 at 11:32:48 AM IST 
//


package com.rrs.corona;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rrs.corona package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
public class ObjectFactory
    extends com.rrs.corona.impl.runtime.DefaultJAXBContextImpl
{

    private static java.util.HashMap defaultImplementations = new java.util.HashMap(16, 0.75F);
    private static java.util.HashMap rootTagMap = new java.util.HashMap();
    public final static com.rrs.corona.impl.runtime.GrammarInfo grammarInfo = new com.rrs.corona.impl.runtime.GrammarInfoImpl(rootTagMap, defaultImplementations, (com.rrs.corona.ObjectFactory.class));
    public final static java.lang.Class version = (com.rrs.corona.impl.JAXBVersion.class);

    static {
        defaultImplementations.put((com.rrs.corona.ContactType.class), "com.rrs.corona.impl.ContactTypeImpl");
        defaultImplementations.put((com.rrs.corona.AddressBookType.class), "com.rrs.corona.impl.AddressBookTypeImpl");
        defaultImplementations.put((com.rrs.corona.AddressBook.class), "com.rrs.corona.impl.AddressBookImpl");
        defaultImplementations.put((com.rrs.corona.Contact.class), "com.rrs.corona.impl.ContactImpl");
        rootTagMap.put(new javax.xml.namespace.QName("", "contact"), (com.rrs.corona.Contact.class));
        rootTagMap.put(new javax.xml.namespace.QName("", "addressBook"), (com.rrs.corona.AddressBook.class));
    }

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rrs.corona
     * 
     */
    public ObjectFactory() {
        super(grammarInfo);
    }

    /**
     * Create an instance of the specified Java content interface.
     * 
     * @param javaContentInterface
     *     the Class object of the javacontent interface to instantiate
     * @return
     *     a new instance
     * @throws JAXBException
     *     if an error occurs
     */
    public java.lang.Object newInstance(java.lang.Class javaContentInterface)
        throws javax.xml.bind.JAXBException
    {
        return super.newInstance(javaContentInterface);
    }

    /**
     * Get the specified property. This method can only be
     * used to get provider specific properties.
     * Attempting to get an undefined property will result
     * in a PropertyException being thrown.
     * 
     * @param name
     *     the name of the property to retrieve
     * @return
     *     the value of the requested property
     * @throws PropertyException
     *     when there is an error retrieving the given property or value
     */
    public java.lang.Object getProperty(java.lang.String name)
        throws javax.xml.bind.PropertyException
    {
        return super.getProperty(name);
    }

    /**
     * Set the specified property. This method can only be
     * used to set provider specific properties.
     * Attempting to set an undefined property will result
     * in a PropertyException being thrown.
     * 
     * @param value
     *     the value of the property to be set
     * @param name
     *     the name of the property to retrieve
     * @throws PropertyException
     *     when there is an error processing the given property or value
     */
    public void setProperty(java.lang.String name, java.lang.Object value)
        throws javax.xml.bind.PropertyException
    {
        super.setProperty(name, value);
    }

    /**
     * Create an instance of ContactType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.rrs.corona.ContactType createContactType()
        throws javax.xml.bind.JAXBException
    {
        return new com.rrs.corona.impl.ContactTypeImpl();
    }

    /**
     * Create an instance of AddressBookType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.rrs.corona.AddressBookType createAddressBookType()
        throws javax.xml.bind.JAXBException
    {
        return new com.rrs.corona.impl.AddressBookTypeImpl();
    }

    /**
     * Create an instance of AddressBook
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.rrs.corona.AddressBook createAddressBook()
        throws javax.xml.bind.JAXBException
    {
        return new com.rrs.corona.impl.AddressBookImpl();
    }

    /**
     * Create an instance of Contact
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public com.rrs.corona.Contact createContact()
        throws javax.xml.bind.JAXBException
    {
        return new com.rrs.corona.impl.ContactImpl();
    }

}
