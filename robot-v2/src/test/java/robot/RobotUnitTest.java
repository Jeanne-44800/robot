package robot;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Random;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class RobotUnitTest {

    @Test
    public void testLand() throws UnlandedRobotException {
        //---DEFINE---
        Robot robot = new Robot();
        //---WHEN---
        robot.land(new Coordinates(3,0), null);
        //---THEN---
        Assert.assertEquals(3, robot.getXposition(), 0);
        Assert.assertEquals(0, robot.getYposition(), 0);
    }

    // tester l'apparition d'une exception, l'annotation @Test intègre expected suivi de la classe de l'exception attendue
    // Attention : il est parfois nécessaire de s'assurer que l'exception n'apparaît pas avant la dernière instruction du test
    @Test (expected = UnlandedRobotException.class)
    public void testRobotMustBeLandedBeforeAnyMove() throws Exception {
        Robot robot = new Robot();
        robot.moveForward();
    }

    @Test
    public void testMoveForward0() throws Exception {
        Robot robot = new Robot();
        Random rand = new Random(13);
        LandSensor sensor = new LandSensor(rand);
        robot.land(new Coordinates(3, 0),sensor);
        int currentXposition = robot.getXposition();
        int currentYposition = robot.getYposition();
        robot.moveForward();
        Assert.assertEquals(currentXposition, robot.getXposition());
        Assert.assertEquals(currentYposition+1, robot.getYposition());

    }

    // Utilisation d'un Mock pour ne pas avoir de problème d'énergie
    private void landNoEnergyConsumeRobot(Robot robot) {
        // utilisation d'un mock pour le LandSensor
        LandSensor sensor = Mockito.mock(LandSensor.class);
        // quand on appelle la méthode getPointToPointEnergyCoefficient avec n'importe quel paramètre sur le mock
        // on obtient en retour 0
        when(sensor.getPointToPointEnergyCoefficient(any(Coordinates.class), any(Coordinates.class))).thenReturn(0.0);
        // l'objet mock est considéré comme un véritable LandSensor par le robot et invoquera les méthodes sur l'objet
        robot.land(new Coordinates(3,0), sensor);
    }

    @Test
    public void testMoveForward() throws Exception {
        Robot robot = new Robot();
        landNoEnergyConsumeRobot(robot);
        int currentXposition = robot.getXposition();
        int currentYposition = robot.getYposition();
        robot.moveForward();
        Assert.assertEquals(currentXposition, robot.getXposition());
        Assert.assertEquals(currentYposition+1, robot.getYposition());

    }


    @Test
    public void testMoveBackward() throws UnlandedRobotException {
    }

    @Test
    public void testTurnLeft() throws UnlandedRobotException {
    }

    @Test
    public void testTurnRight() throws UnlandedRobotException {

    }

    @Ignore
    @Test
    public void testFollowInstruction() throws Exception {
        Robot robot = new Robot();
        robot.land(new Coordinates(5, 7),null);
        robot.setRoadBook(new RoadBook(Arrays.asList(Instruction.FORWARD, Instruction.FORWARD, Instruction.TURNLEFT, Instruction.FORWARD)));
        robot.letsGo();
        Assert.assertEquals(4, robot.getXposition());
        Assert.assertEquals(9, robot.getYposition());
    }

}
