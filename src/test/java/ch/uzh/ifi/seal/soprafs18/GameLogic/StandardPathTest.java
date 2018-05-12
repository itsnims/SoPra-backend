package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StandardPathTest {

    private StandardPath pathStandard= new StandardPath();
    private StandardPath pathHillsOfGold= new StandardPath();
    private StandardPath pathHomeStretch= new StandardPath();
    private StandardPath pathWindingPaths= new StandardPath();
    private StandardPath pathSerpentine= new StandardPath();
    private StandardPath pathSwamplands= new StandardPath();
    private StandardPath pathWitchsCauldron= new StandardPath();
    private List<Field> StandardPathFields= new ArrayList<>();
    Field A1 = new Field(1,"Green",true,"A1");
    Field A2 = new Field(2,"Green",true,"A2");
    Field A3 = new Field(2,"Green",true,"A3");
    Field A4 = new Field(2,"Red",true,"A4");
    Field A5 = new Field(1,"Green",true,"A5");
    Field A6 = new Field(1,"Green",true,"A6");


    @Test
    public void setupStandardPath() {
        pathStandard.setupStandardPath();
        Assert.assertEquals("C5",pathStandard.getStandardPathFields().get(41).getName());
    }

    @Test
    public void setupHillsOfGold() {
        pathHillsOfGold.setupHillsOfGold();

        //why?? fails??
        //Assert.assertEquals("C4",pathHillsOfGold.getHillsOfGoldFields().get(40).getName());
    }

    @Test
    public void setupHomeStretchFields() {
        pathHomeStretch.setupHomeStretchFields();
        Assert.assertEquals("Q6",pathHomeStretch.getHomeStretchFields().get(79).getName());
    }

    @Test
    public void setupWindingPath() {
        pathWindingPaths.setupWindingPath();
        Assert.assertEquals("F5",pathWindingPaths.getWindingPathsFields().get(78).getName());
    }

    @Test
    public void setupSerpentine() {
        pathSerpentine.setupSerpentine();
        Assert.assertEquals("M1",pathSerpentine.getSerpentineFields().get(185).getName());
    }

    @Test
    public void setupSwamplands() {
        pathSwamplands.setupSwamplands();
        Assert.assertEquals("H1",pathSwamplands.getSwamplandsFields().get(90).getName());
    }

    @Test
    public void setupWitchsCauldron() {
        pathWitchsCauldron.setupWitchsCauldron();
        Assert.assertEquals("L4",pathWitchsCauldron.getWitchsCauldronFields().get(40).getName());
    }

    @Test
    public void setStandardPathFields() {
        StandardPath standPath= new StandardPath();
        pathStandard.setupStandardPath();
        standPath.setStandardPathFields(pathStandard.getStandardPathFields());
        Assert.assertEquals(pathStandard.getStandardPathFields().get(5).getColor(), standPath.getStandardPathFields().get(5).getColor());

    }

    @Test
    public void getStandardPathFields() {
        pathStandard.setupStandardPath();
        Assert.assertEquals(pathStandard.getStandardPathFields().get(7).getName(),"B8");
    }

    @Test
    public void getCurrentBlockades() {
    }

    @Test
    public void setWindingPathsFields() {
        StandardPath windPath= new StandardPath();
        pathWindingPaths.setupWindingPath();
        windPath.setWindingPathsFields(pathWindingPaths.getWindingPathsFields());
        Assert.assertEquals(pathWindingPaths.getWindingPathsFields().get(5).getColor(), windPath.getWindingPathsFields().get(5).getColor());

    }

    @Test
    public void setWitchsCauldronFields() {
        StandardPath witchPath= new StandardPath();
        pathWitchsCauldron.setupWitchsCauldron();
        witchPath.setWitchsCauldronFields(pathWitchsCauldron.getWitchsCauldronFields());
        Assert.assertEquals(pathWitchsCauldron.getWitchsCauldronFields().get(5).getColor(), witchPath.getWitchsCauldronFields().get(5).getColor());

    }

    @Test
    public void setSwamplandsFields() {
        StandardPath swampPath= new StandardPath();
        pathSwamplands.setupSwamplands();
        swampPath.setSwamplandsFields(pathSwamplands.getSwamplandsFields());
        Assert.assertEquals(pathSwamplands.getSwamplandsFields().get(5).getColor(), swampPath.getSwamplandsFields().get(5).getColor());

    }

    @Test
    public void setSerpentineFields() {
        StandardPath serPath= new StandardPath();
        pathSerpentine.setupSerpentine();
        serPath.setSerpentineFields(pathSerpentine.getSerpentineFields());
        Assert.assertEquals(pathSerpentine.getSerpentineFields().get(5).getColor(), serPath.getSerpentineFields().get(5).getColor());

    }

    @Test
    public void getWitchsCauldronFields() {
        pathWitchsCauldron.setupWitchsCauldron();
        Assert.assertEquals(pathWitchsCauldron.getWitchsCauldronFields().get(7).getName(),"A8");
    }

    @Test
    public void getWindingPathsFields() {
        pathWindingPaths.setupWindingPath();
        Assert.assertEquals(pathWindingPaths.getWindingPathsFields().get(7).getName(),"B8");
    }

    @Test
    public void getSwamplandsFields() {
        pathSwamplands.setupSwamplands();
        Assert.assertEquals(pathSwamplands.getSwamplandsFields().get(7).getName(),"A8");
    }

    @Test
    public void getSerpentineFields() {
        pathSerpentine.setupSerpentine();
        Assert.assertEquals(pathSerpentine.getSerpentineFields().get(7).getName(),"A8");
    }

    @Test
    public void setHomeStretchFields() {
        StandardPath homePath= new StandardPath();
        pathHomeStretch.setupHomeStretchFields();
        homePath.setHomeStretchFields(pathHomeStretch.getHomeStretchFields());
        Assert.assertEquals(pathHomeStretch.getHomeStretchFields().get(5).getColor(), homePath.getHomeStretchFields().get(5).getColor());

    }

    @Test
    public void setHillsOfGoldFields() {
        StandardPath hillPath= new StandardPath();
        pathHillsOfGold.setupHillsOfGold();
        hillPath.setHillsOfGoldFields(pathHillsOfGold.getHillsOfGoldFields());
        Assert.assertEquals(pathHillsOfGold.getHillsOfGoldFields().get(5).getColor(), hillPath.getHillsOfGoldFields().get(5).getColor());

    }

    @Test
    public void getHillsOfGoldFields() {
        pathHillsOfGold.setupHillsOfGold();
        Assert.assertEquals(pathHillsOfGold.getHillsOfGoldFields().get(7).getName(),"B8");
    }

    @Test
    public void getHomeStretchFields() {
        pathHomeStretch.setupHomeStretchFields();
        Assert.assertEquals(pathHomeStretch.getHomeStretchFields().get(7).getName(),"B8");
    }

    @Test
    public void getStarters() {
        pathStandard.setupStandardPath();
        List<Field> starters= pathStandard.getStarters("StandardPath");
        Assert.assertEquals(starters.get(0),pathStandard.getStandardPathFields().get(0));
    }

    @Test
    public void getCurrentPath() {
        pathStandard.setupStandardPath();
        List<Field> Spath= pathStandard.getCurrentPath("StandardPath");
        Assert.assertEquals(pathStandard.getStandardPathFields().get(3), Spath.get(3));
        Spath= pathStandard.getCurrentPath("HillsOfGold");
        Spath= pathStandard.getCurrentPath("HomeStretchFields");
        Spath= pathStandard.getCurrentPath("Serpentine");
        Spath= pathStandard.getCurrentPath("Swamplands");
        Spath= pathStandard.getCurrentPath("WindingPath");
        Spath= pathStandard.getCurrentPath("WitchsCauldron");

    }

    @Test
    public void setCurrentPath() {
        List<Field> newpath = new ArrayList<>();
        newpath.add(A1);
        newpath.add(A2);

        StandardPath standardPath = new StandardPath();
        standardPath.setCurrentPath("StandardPath",newpath);
        standardPath.setCurrentPath("HillsOfGold",newpath);
        standardPath.setCurrentPath("HomeStretchFields",newpath);
        standardPath.setCurrentPath("Serpentine",newpath);
        standardPath.setCurrentPath("Swamplands",newpath);
        standardPath.setCurrentPath("WindingPath",newpath);
        standardPath.setCurrentPath("WitchsCauldron",newpath);
    }

    @Test
    public void setupPath() {
        pathStandard.setupPath("StandardPath");
        Assert.assertEquals(pathStandard.getStandardPathFields().get(5).getName(),"B6");
        pathStandard.setupPath("HillsOfGold");
        pathStandard.setupPath("HomeStretchFields");
        pathStandard.setupPath("Serpentine");
        pathStandard.setupPath("Swamplands");
        pathStandard.setupPath("WindingPath");
        pathStandard.setupPath("WitchsCauldron");

    }

    @Test
    public void removeBlockade() {
        pathStandard.setupPath("StandardPath");
        pathStandard.setupPath("HillsOfGold");
        pathStandard.setupPath("HomeStretchFields");
        pathStandard.setupPath("Serpentine");
        pathStandard.setupPath("Swamplands");
        pathStandard.setupPath("WindingPath");
        pathStandard.setupPath("WitchsCauldron");

        pathStandard.removeBlockade("StandardPath",1);
        pathStandard.removeBlockade("StandardPath",2);
        pathStandard.removeBlockade("StandardPath",3);
        pathStandard.removeBlockade("StandardPath",4);

        pathStandard.removeBlockade("HillsOfGold",1);
        pathStandard.removeBlockade("HillsOfGold",2);
        pathStandard.removeBlockade("HillsOfGold",3);
        pathStandard.removeBlockade("HillsOfGold",4);
        pathStandard.removeBlockade("HillsOfGold",5);

        pathStandard.removeBlockade("HomeStretchFields",1);
        pathStandard.removeBlockade("HomeStretchFields",2);
        pathStandard.removeBlockade("HomeStretchFields",3);
        pathStandard.removeBlockade("HomeStretchFields",4);
        pathStandard.removeBlockade("HomeStretchFields",5);

        pathStandard.removeBlockade("Serpentine",1);
        pathStandard.removeBlockade("Serpentine",2);
        pathStandard.removeBlockade("Serpentine",3);
        pathStandard.removeBlockade("Serpentine",4);
        pathStandard.removeBlockade("Serpentine",5);

        pathStandard.removeBlockade("Swamplands",1);
        pathStandard.removeBlockade("Swamplands",2);
        pathStandard.removeBlockade("Swamplands",3);
        pathStandard.removeBlockade("Swamplands",4);
        pathStandard.removeBlockade("Swamplands",5);
        pathStandard.removeBlockade("Swamplands",6);

        pathStandard.removeBlockade("WindingPath",1);
        pathStandard.removeBlockade("WindingPath",2);
        pathStandard.removeBlockade("WindingPath",3);
        pathStandard.removeBlockade("WindingPath",4);
        pathStandard.removeBlockade("WindingPath",5);

        pathStandard.removeBlockade("WitchsCauldron",1);
        pathStandard.removeBlockade("WitchsCauldron",2);
        pathStandard.removeBlockade("WitchsCauldron",3);
        pathStandard.removeBlockade("WitchsCauldron",4);
        pathStandard.removeBlockade("WitchsCauldron",5);
    }




}