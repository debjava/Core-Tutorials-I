//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.5-b16-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.03.19 at 12:52:39 PM IST 
//


package com.vps.dds.jax;


/**
 * Java content class for anonymous complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/E:/XMLDev/XmlJaxb_V1/src/com/vps/dds/jax/databseconfig.xsd line 6)
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="database" type="{}databaseType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface DatabaseConfigType {


    /**
     * Gets the value of the database property.
     * 
     * @return
     *     possible object is
     *     {@link com.vps.dds.jax.DatabaseType}
     */
    com.vps.dds.jax.DatabaseType getDatabase();

    /**
     * Sets the value of the database property.
     * 
     * @param value
     *     allowed object is
     *     {@link com.vps.dds.jax.DatabaseType}
     */
    void setDatabase(com.vps.dds.jax.DatabaseType value);

}
