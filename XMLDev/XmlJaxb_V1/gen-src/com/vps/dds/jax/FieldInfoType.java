//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.5-b16-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.03.19 at 12:52:39 PM IST 
//


package com.vps.dds.jax;


/**
 * Java content class for FieldInfoType complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/E:/XMLDev/XmlJaxb_V1/src/com/vps/dds/jax/databseconfig.xsd line 12)
 * <p>
 * <pre>
 * &lt;complexType name="FieldInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}FieldName"/>
 *         &lt;element ref="{}FieldType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface FieldInfoType {


    /**
     * Gets the value of the fieldName property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getFieldName();

    /**
     * Sets the value of the fieldName property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setFieldName(java.lang.String value);

    /**
     * Gets the value of the fieldType property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getFieldType();

    /**
     * Sets the value of the fieldType property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setFieldType(java.lang.String value);

}