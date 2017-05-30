import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import cn.edu.cumt.ec.entity.Builder;
import cn.edu.cumt.ec.entity.Guitar;
import cn.edu.cumt.ec.entity.GuitarSpec;
import cn.edu.cumt.ec.entity.Inventory;
import cn.edu.cumt.ec.entity.Type;
import cn.edu.cumt.ec.entity.Wood;

public class guitarSearchTest {

	@Test
	public void test() {
	

		
		    // Set up Rick's guitar inventory
		    Inventory inventory = new Inventory();
		    initializeInventory(inventory);

		    GuitarSpec whatErinLikes = 
		      new GuitarSpec(Builder.FENDER, "Stratocastor", 
		                     Type.ELECTRIC, Wood.INDIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD);
		    List matchingGuitars = inventory.search(whatErinLikes);
		    if (!matchingGuitars.isEmpty()) {
		      System.out.println("Erin, you might like these guitars:");
		      for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
		        Guitar guitar = (Guitar)i.next();
		        GuitarSpec spec = guitar.getSpec();
		        System.out.println("  We have a " +
		          spec.getBuilder() + " " + spec.getModel() + " " +
		          spec.getType() + " guitar:\n     " +
		          spec.getBackWood() + " back and sides,\n     " +
		          spec.getTopWood() + " top.\n  You can have it for only $" +
		          guitar.getPrice() + "!\n  ----");
		      }
		    } else {
		      System.out.println("Sorry, Erin, we have nothing for you.");
		    }
		  }

		  private static void initializeInventory(Inventory inventory){
		    inventory.addGuitar("001", 123, 
		      new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 
		                     Wood.SITKA, Wood.SITKA));
		    inventory.addGuitar("002", 1499.95, 
		      new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 
		                     Wood.ALDER, Wood.ALDER));
		    inventory.addGuitar("V9512", 1549.95, 
		      new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 
		                     Wood.ALDER, Wood.ALDER));
		    inventory.addGuitar("122784", 5495.95, 
		      new GuitarSpec(Builder.MARTIN, "D-18", Type.ACOUSTIC, 
		                     Wood.MAHOGANY, Wood.ADIRONDACK));
		    inventory.addGuitar("76531", 6295.95, 
		      new GuitarSpec(Builder.MARTIN, "OM-28", Type.ACOUSTIC,
		                     Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK));
		    inventory.addGuitar("70108276", 2295.95, 
		      new GuitarSpec(Builder.GIBSON, "Les Paul", Type.ELECTRIC, 
		                     Wood.MAHOGANY, Wood.MAHOGANY));
		    inventory.addGuitar("82765501", 1890.95, 
		      new GuitarSpec(Builder.GIBSON, "SG '61 Reissue", Type.ELECTRIC, 
		                     Wood.MAHOGANY, Wood.MAHOGANY));
		    inventory.addGuitar("77023", 6275.95, 
		      new GuitarSpec(Builder.MARTIN, "D-28", Type.ACOUSTIC, 
		                     Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK));
		    inventory.addGuitar("1092", 123, 
		      new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC,
		                     Wood.INDIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD));
		    inventory.addGuitar("566-62", 8999.95, 
		      new GuitarSpec(Builder.RYAN, "Cathedral", Type.ACOUSTIC, 
		                     Wood.COCOBOLO, Wood.CEDAR));
		    inventory.addGuitar("6 29584", 2100.95, 
		      new GuitarSpec(Builder.PRS, "Dave Navarro Signature", Type.ELECTRIC, 
		                      Wood.MAHOGANY, Wood.MAPLE));
		  }
	

	}


