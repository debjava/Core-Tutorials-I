
package test;

/**
 * @hibernate.class table="Tab1"
 * @author PIKU
 *
 * 
 */
public class Obj1
{
    long id;
    String fName;

    /**
     * @hibernate.property table="Tab1" column="Name" type="string"
     */
    public String getFName()
    {
        return fName;
    }
    /**
     * 
     */
    public void setFName( String name)
    {
        fName = name;
    }
    /**
     * @hibernate.id generator-class="native" table="Tab1" column="Id1" type="long"
     */
    public long getId()
    {
        return id;
    }
    /**
     * 
     */
    public void setId( long id)
    {
        this.id = id;
    }
}
