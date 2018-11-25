import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TestTreeMap 
{
	TreeMap treeMap = new TreeMap();
	
	public void putData()
	{
		treeMap.put("Name","Mana");
		treeMap.put("Adrs","Blr");
		treeMap.put("Desgn","Eng");
	}
	
	public void showData()
	{
		putData();
		Set set = treeMap.entrySet();
		Iterator itr = set.iterator();
		while(itr.hasNext())
		{
			Map.Entry me = (Map.Entry)itr.next();
			System.out.println("Key==  "+me.getKey()+"Value ===  "+me.getValue());
		}
	}
	public static void main(String[] args) 
	{
		new TestTreeMap().showData();
	}

}
