package com.rrs.corona.solutionsacceleratorstudio.dragdrop;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.logging.Logger;


public class DatabaseBean
{
    private ArrayList fieldMap = null;
    private HashMap fieldType = null;
    private String fieldName = null;
    private String tableName = null;
    private String typeofData = null;
   // Logger logger = Logger.getLogger("DatabaseBean.class");

    public ArrayList getFieldMap ()
    {
        return fieldMap;
    }

    public void setFieldMap (ArrayList fieldMap)
    {
        this.fieldMap = fieldMap;
    }

    public String getTableName ()
    {
        
    	return tableName;
    }

    public void setTableName (String tableName)
    {
    	this.tableName = tableName;
    }

    public HashMap getFieldType ()
    {
        return fieldType;
    }

    public void setFieldType (HashMap fieldType)
    {
        this.fieldType = fieldType;
    }

    public String getFieldName ()
    {
        return fieldName;
    }

    public void setFieldName (String fieldName)
    {
        this.fieldName = fieldName;
    }

    public String getTypeofData ()
    {
        return typeofData;
    }

    public void setTypeofData (String typeofData)
    {
        this.typeofData = typeofData;
    }
}
