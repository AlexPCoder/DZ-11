import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WomanManTest {
    private Man man;
    private Woman woman;

    @BeforeMethod
    public void setUp() {
        man = new Man("John", "Doe", 66);
        woman = new Woman("Jane", "Roe", 30);
    }

    @Test(groups = {"all"})
    public void testIsRetiredTrue() {
        Assert.assertTrue(man.isRetired(), "Man should be retired when age is over 65");
    }

    @Test(groups = {"all"})
    public void testIsRetiredFalse() {
        Man youngMan = new Man("Johnny", "Doe", 60);
        Assert.assertFalse(youngMan.isRetired(), "Man should not be retired when age is 65 or less");
    }

    @Test(groups = {"all"})
    public void testRegisterPartnership() {
        man.registerPartnership(woman);
        Assert.assertEquals(woman.getLastName(), "Doe", "Woman should take the last name of the man after partnership registration");
        Assert.assertEquals(woman.getPartner(), man, "Woman's partner should be set to man after partnership registration");
    }

    @Test(groups = {"all"})
    public void testDeregisterPartnershipWithoutRevertingLastName() {
        man.registerPartnership(woman);
        man.deregisterPartnership(false);
        Assert.assertEquals(woman.getLastName(), "Doe", "Woman should keep the man's last name after partnership deregistration without revert");
        Assert.assertNull(woman.getPartner(), "Woman's partner should be null after partnership deregistration");
    }

    @Test(groups = {"all"})
    public void testDeregisterPartnershipWithRevertingLastName() {
        man.registerPartnership(woman);
        man.deregisterPartnership(true);
        Assert.assertEquals(woman.getLastName(), "Roe", "Woman should revert to her original last name after partnership deregistration with revert");
        Assert.assertNull(woman.getPartner(), "Woman's partner should be null after partnership deregistration");
    }

    @Test(groups = {"all", "gettersAndSetters"})
    public void testGetLastName() {
        Assert.assertEquals(woman.getLastName(), "Roe", "The last name should be 'Roe'");
    }

    @Test(groups = {"all", "gettersAndSetters"})
    public void testSetLastName() {
        man.setLastName("Rives");
        Assert.assertEquals(man.getLastName(), "Rives", "The last name should be 'Rives'");
    }

    @Test(groups = {"all", "gettersAndSetters"})
    public void testGetFirstName() {
        Assert.assertEquals(man.getFirstName(), "John", "The last name should be 'John'");
    }

    @Test(groups = {"all", "gettersAndSetters"})
    public void testSetFirstName() {
        woman.setLastName("Cat");
        Assert.assertEquals(woman.getFirstName(), "Cat", "The last name should be 'Cat'");
    }

    @Test(groups = {"all", "gettersAndSetters"})
    public void testGetAge() {
        Assert.assertEquals(man.getAge(), 66, "The last name should be '66'");
    }

    @Test(groups = {"all", "gettersAndSetters"})
    public void testSetAge() {
        woman.setAge(18);
        Assert.assertEquals(man.getAge(), 18, "The last name should be '18'");
    }

    @Test(groups = {"all", "gettersAndSetters"})
    public void testSetGetPartner(){
        woman.setPartner(man);
        Assert.assertEquals(woman.getPartner(), man, "The partner should be set and retrieved correctly for Woman");
    }
}
