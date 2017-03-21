package robot;

import org.junit.Assert;
import org.junit.Test;

import static robot.Direction.*;

public class MapToolsUnitTest {

    @Test
    public void testNextForwardPositionNorth() {
        Coordinates position = MapTools.nextForwardPosition(new Coordinates(0, 0), NORTH);
        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(1, position.getY());
    }

    @Test
    public void testNextBackwardPositionNorth() {
        Coordinates position = MapTools.nextBackwardPosition(new Coordinates(0, 0), NORTH);
        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(-1, position.getY());
    }

    @Test
    public void testCounterclockwise() {
        Assert.assertEquals(WEST, MapTools.counterclockwise(NORTH));
        Assert.assertEquals(SOUTH, MapTools.counterclockwise(WEST));
        Assert.assertEquals(NORTH, MapTools.counterclockwise(EAST));
        Assert.assertEquals(EAST, MapTools.counterclockwise(SOUTH));
    }

}

