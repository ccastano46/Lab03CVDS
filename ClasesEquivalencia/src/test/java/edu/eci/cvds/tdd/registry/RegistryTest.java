package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateDead() {
        Person person = new Person();
        person.setAlive(false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
        person.setAlive(true);
        result = registry.registerVoter(person);
        Assert.assertNotSame(RegisterResult.DEAD, result);
    }

    @Test
    public void validUnderAge(){
        Person person = new Person();
        person.setAge(17);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validInvalid_Age(){
        Person person = new Person();
        person.setAge(200);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validValid(){
        Person person = new Person();
        person.setAge(18);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validDuplicate(){
        Person person = new Person();
        person.setId(10005);
        person.setAge(18);
        RegisterResult result = registry.registerVoter(person);
        result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }


}