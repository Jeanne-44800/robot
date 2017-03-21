package robot;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class RoadBookCalculatorUnitTest {

    RoadBook book;
    Coordinates startPosition;
    ArrayList<Instruction> instructions;

    @Before
    public void setUp(){
        book = null;
        startPosition = new Coordinates(1,1);
        instructions = new ArrayList<Instruction>();
    }


    @Test
    public void testCalculateAtDestination() {
    }

    @Test
    public void testCalculateOneInstructionNorthRoad() {
    }

    @Test
    public void testCalculateStraightForwardRoad() {
    }

}
