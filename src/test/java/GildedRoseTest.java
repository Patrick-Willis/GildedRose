import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.swing.*;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class GildedRoseTest {
    
    private Item item;
    private int newSellIn;
    private int newQuality;


    public GildedRoseTest(Item item, int newSellIn, int newQuality) {
        this.item = item;
        this.newSellIn = newSellIn;
        this.newQuality = newQuality;
    }
    
    @Parameterized.Parameters
    public static Collection gildedRose() {
        return Arrays.asList(new Object[][]{
            {new Item("+5 Dexterity Vest", 10, 10), 9, 9},
            {new Item("+5 Dexterity Vest", -1, 10), -2, 8},
            {new Item("+5 Dexterity Vest", 10, 0), 9, 0},
            {new Item("+5 Dexterity Vest", -1, 1), -2, 0},
            {new Item("Aged Brie", 20, 10), 19, 11},
            {new Item("Aged Brie", 20, 50), 19, 50},
            {new Item("Sulfuras, Hand of Ragnaros", 10, 20), 10, 20},
            {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20), 9, 22},
            {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20), 4, 23},
            {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49), 4, 50},
            {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20), -1, 0},
        });
    }

	@Test
	public void testTheTruth() {
        List<Item> items = new ArrayList<Item>();
        items.add(item);
        GildedRose.updateQuality(items);
        assertThat(item.getSellIn(), is(equalTo(newSellIn)));
        assertThat(item.getQuality(), is(equalTo(newQuality)));
	}
}
