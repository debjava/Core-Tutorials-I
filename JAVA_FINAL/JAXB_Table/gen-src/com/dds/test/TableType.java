//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.5-b16-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.06.27 at 09:42:16 PM IST 
//


package com.dds.test;


/**
 * Java content class for TableType complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/E:/JAVA_FINAL/JAXB_Table/src/com/dds/test/db.xsd line 31)
 * <p>
 * <pre>
 * &lt;complexType name="TableType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TableName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FieldInfo" type="{}FieldType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface TableType {


    /**
     * Gets the value of the tableName property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getTableName();

    /**
     * Sets the value of the tableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setTableName(java.lang.String value);

    /**
     * Gets the value of the FieldInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the FieldInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFieldInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link com.dds.test.FieldType}
     * 
     */
    java.util.List getFieldInfo();

}
