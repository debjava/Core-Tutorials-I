//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.5-b16-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.06.27 at 09:42:16 PM IST 
//


package com.dds.test;


/**
 * Java content class for DSInfoType complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/E:/JAVA_FINAL/JAXB_Table/src/com/dds/test/db.xsd line 12)
 * <p>
 * <pre>
 * &lt;complexType name="DSInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DBName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DBPort" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DBUser" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DBPassword" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface DSInfoType {


    /**
     * Gets the value of the dbPort property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getDBPort();

    /**
     * Sets the value of the dbPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setDBPort(java.lang.String value);

    /**
     * Gets the value of the dbName property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getDBName();

    /**
     * Sets the value of the dbName property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setDBName(java.lang.String value);

    /**
     * Gets the value of the dbUser property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getDBUser();

    /**
     * Sets the value of the dbUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setDBUser(java.lang.String value);

    /**
     * Gets the value of the dbPassword property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getDBPassword();

    /**
     * Sets the value of the dbPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setDBPassword(java.lang.String value);

}
