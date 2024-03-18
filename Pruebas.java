import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class Pruebas {

    private BinaryTree<String, String> binaryTree;
    private Association<String, String> association1;
    private Association<String, String> association2;
    private Association<String, String> association3;

    @Before
    public void setUp() {
        binaryTree = new BinaryTree<>();
        association1 = new Association<>("key1", "value1");
        association2 = new Association<>("key2", "value2");
        association3 = new Association<>("key3", "value3");
        binaryTree.insert("key1", "value1");
        binaryTree.insert("key2", "value2");
    }

    @Test
    public void testInsert() {
        binaryTree.insert("key3", "value3");
        assertEquals("value3", binaryTree.search("key3"));
    }

    @Test
    public void testSearchExistingKey() {
        assertEquals("value1", binaryTree.search("key1"));
    }

    @Test
    public void testSearchDifferentKey() {
        binaryTree.insert("existingKey", "existingValue");
        
        assertNull(binaryTree.search("differentKey"));
    }
    
    @Test
    public void testSetKey() {
        association1.setKey("newKey");
        assertEquals("newKey", association1.getKey());
    }

    @Test
    public void testSetValue() {
        association1.setValue("newValue");
        assertEquals("newValue", association1.getValue());
    }

    @Test
    public void testCompareToEqual() {
        assertEquals(0, association1.compareTo(association1));
    }

    @Test
    public void testCompareToLessThan() {
        assertEquals(-1, association1.compareTo(association2));
    }

    @Test
    public void testCompareToGreaterThan() {
        assertEquals(1, association2.compareTo(association1));
    } 
}