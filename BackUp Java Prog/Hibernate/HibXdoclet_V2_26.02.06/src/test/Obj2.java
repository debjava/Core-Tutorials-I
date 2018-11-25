
package test;

/**
 * @hibernate.class table="Tab2"
 * @author PIKU
 *
 * 
 * 
 */
public class Obj2
{
    long id;
    String lName;
    /**
     * @hibernate.id generator-class="native" table="Tab2" column="Id2" type="long"
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
    /**
     * @hibernate.property table="Tab2" column="LName" type="string"
     */
    public String getLName()
    {
        return lName;
    }
    /**
     * 
     */
    public void setLName( String name)
    {
        lName = name;
    }
}
