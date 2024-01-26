package Graph;

import org.junit.Assert;
import org.junit.Test;

public class NodeTest {
    @Test
    public void testDigitSums() {
        Node node = new Node(0, 12);
        Assert.assertEquals(3, node.digitSums());
        node.setValue(23);
        Assert.assertEquals(5, node.digitSums());
        node.setValue(0);
        Assert.assertEquals(0, node.digitSums());
    }
    @Test 
    public void testEquals() {
        Node node1 = new Node(0, 12);
        Node node2 = new Node(0, 12);
        Assert.assertEquals(node1, node2);
    }
}
