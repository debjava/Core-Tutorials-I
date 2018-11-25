
package test;

/**
 * @hibernate.class table="Tab3"
 * @author PIKU
 *
 */
public class Obj3
{
    long id;
    String adrs;

    /**
     * @hibernate.property table="Tab3" column="Adrs" type="string"
     * 
     */
    public String getAdrs()
    {
        return adrs;
    }
    /**
     * 
     */
    public void setAdrs( String adrs)
    {
        this.adrs = adrs;
    }
    /**
     * @hibernate.id generator-class="native" table="Tab3" column="Id3" type="long"
     * 
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
