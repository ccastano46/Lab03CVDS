package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateDead() {
        Person person1 = new Person("Camilo",1000271422,22,Gender.MALE,true);
        Person person2 = new Person("Felipe",1000271422,22,Gender.MALE,false);
        Person person3 = new Person("Maria Paula",1000,22,Gender.FEMALE,true);
        Person person4 = new Person("Andres",1001,22,Gender.MALE,false);
        RegisterResult result = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.DEAD, result);
        result = registry.registerVoter(person1);
        Assert.assertNotSame(RegisterResult.DEAD, result);
        result = registry.registerVoter(person3);
        Assert.assertNotSame(RegisterResult.DEAD, result);
        result = registry.registerVoter(person4);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void validUnderAge(){
    	Person person1 = new Person("Camilo",1,22,Gender.MALE,true);
        Person person2 = new Person("Felipe",2,15,Gender.MALE,true);
        Person person3 = new Person("Maria Paula",3,3,Gender.FEMALE,true);
        Person person4 = new Person("Andres",4,1,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(person1);
        Assert.assertNotSame(RegisterResult.UNDERAGE, result);
        result = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
        result = registry.registerVoter(person3);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
        result = registry.registerVoter(person4);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validInvalid_Age(){
    	Person person1 = new Person("Camilo",5,22,Gender.MALE,true);
        Person person2 = new Person("Felipe",6,-4,Gender.MALE,true);
        Person person3 = new Person("Maria Paula",7,130,Gender.FEMALE,true);
        Person person4 = new Person("Andres",8,18,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(person1);
        Assert.assertNotSame(RegisterResult.INVALID_AGE, result);
        result = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
        result = registry.registerVoter(person3);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
        result = registry.registerVoter(person4);
        Assert.assertNotSame(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validValid(){
    	Person person1 = new Person("Camilo",9,22,Gender.MALE,true);
        Person person2 = new Person("Felipe",10,99,Gender.MALE,true);
        Person person3 = new Person("Maria Paula",11,18,Gender.FEMALE,true);
        Person person4 = new Person("Andres",12,17,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(person1);
        Assert.assertEquals(RegisterResult.VALID, result);
        result = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.VALID, result);
        result = registry.registerVoter(person3);
        Assert.assertEquals(RegisterResult.VALID, result);
        result = registry.registerVoter(person4);
        Assert.assertNotSame(RegisterResult.VALID, result);
    }

    @Test
    public void validDuplicate(){
    	Person person1 = new Person("Camilo",9,22,Gender.MALE,true);
        Person person2 = new Person("Felipe",9,99,Gender.MALE,true);
        Person person3 = new Person("Maria Paula",9,18,Gender.FEMALE,true);
        Person person4 = new Person("Andres",12,55,Gender.MALE,false);
        RegisterResult result = registry.registerVoter(person1);
        result = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
        result = registry.registerVoter(person3);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
        result = registry.registerVoter(person4);
        Assert.assertNotSame(RegisterResult.DUPLICATED, result);
    }


}