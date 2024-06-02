<div dir="rtl">

# آزمایش نهم آزمایشگاه نرم‌افزار - پوشش تست

## پوشش اولیه‌ی تست


![9](https://github.com/Pooya2002/SoftwareLab_Az9/assets/63359673/edfc7d23-639e-4806-8e31-d1aa6216b0b2)

![7](https://github.com/Pooya2002/SoftwareLab_Az9/assets/63359673/15d9595f-24fd-4716-b27c-d4ad380b99bc)

![8](https://github.com/Pooya2002/SoftwareLab_Az9/assets/63359673/3f4b5576-67a7-4eb5-bfa4-249b1e43a849)

## بررسی تست‌های اضافه شده

* تکمیل PersonService

```java


	@Test
	public void testDeletePerson() {
		String name = "Name";
		doNothing().when(repository).delete(any(String.class));
		service.delete(name);
		verify(repository, times(1)).delete(name);
	}

	@Test
	public void testDeleteNull() {
		String name = null;
		assertThatThrownBy(() -> service.delete(name))
				.isInstanceOf(PersonException.class)
				.hasMessage("Name is required");
	}


```

![image](https://github.com/Pooya2002/SoftwareLab_Az9/assets/63359673/9dbd852e-6d7d-45f2-8523-bc9ac92bf438)

* تست‌های repositories


```java

public class PersonRepositoryTest {

    private PersonRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new PersonRepository();
    }

    @Test
    public void testInsertPerson() {
        Person person = new Person();
        person.setName("Felix");
        person.setAge(7);
        Person p = repository.insert(person);
        assertEquals(person, p);
    }


    @Test
    public void testGetPerson() {
        String name = "Felix";
        Person result = repository.get(name);
        assertNull(result);
    }


    @Test
    public void testUpdatePerson() {
        Person person = new Person();
        person.setName("Felix");
        person.setAge(7);

        Person p = repository.insert(person);
        p.setName("Feli");
        p.setAge(8);
        assertDoesNotThrow(() -> repository.update(p));
    }
    
}

```

![image](https://github.com/Pooya2002/SoftwareLab_Az9/assets/63359673/a6a7ba63-ecbb-4802-8270-bd009d4ca163)

* تست‌های models

```java

public class FootpassengerTest {
    @Test
    void testCrossedTheCrosswalk() {
        Footpassenger footpassenger = new Footpassenger();
        footpassenger.setCrossedTheCrosswalk(true);

        boolean result = footpassenger.crossedTheCrosswalk();

        assertTrue(result, "Footpassenger should have crossed the crosswalk.");
    }
}

public class PersonTest {

    @Test
    public void testAge() {
        Person person = new Person();
        person.setAge(7);
        assertEquals(person.getAge(), 7);
    }
}

public class StreetDirectionFlowTest {
    private Traffic traffic;

    @BeforeEach
    public void initiate() {
        traffic = new Traffic();
    }


    @Test
    public void testStreetDirectionFlow() {
        StreetDirectionFlow expected = StreetDirectionFlow.ONE_WAY;
        traffic.setStreetDirectionFlow(expected);
        assertEquals(expected, traffic.getStreetDirectionFlow());
        traffic.setStreetDirectionFlow(StreetDirectionFlow.TWO_WAY);
        assertEquals(StreetDirectionFlow.TWO_WAY,  traffic.getStreetDirectionFlow());
    }

}


public class TrafficLightTest {

    private Traffic traffic;

    @BeforeEach
    public void initiate() {
        traffic = new Traffic();
    }

    @Test
    public void testCurrentTrafficLight() {
        TrafficLigth expected = TrafficLigth.YELLOW;
        traffic.setCurrentTrafficLight(expected);
        assertEquals(expected, traffic.getCurrentTrafficLight());
        expected = TrafficLigth.GREEN;
        traffic.setCurrentTrafficLight(expected);
        assertEquals(expected, traffic.getCurrentTrafficLight());
        expected = TrafficLigth.RED;
        traffic.setCurrentTrafficLight(expected);
        assertEquals(expected, traffic.getCurrentTrafficLight());
    }
}


public class TrafficTest {

    private Traffic traffic;

    @BeforeEach
    public void initiate() {
        traffic = new Traffic();
    }


    @Test
    public void testIntenseCarTraffic() {
        traffic.setIntenseCarTraffic(true);
        assertTrue(traffic.intenseCarTraffic());
    }

    @Test
    public void testMinSpeedAllowed() {
        short expected = 30;
        traffic.setMinSpeedAllowed(expected);
        assertEquals(expected, traffic.getMinSpeedAllowed());
    }

    @Test
    public void testMaxSpeedAllowed() {
        short expected = 80;
        traffic.setMaxSpeedAllowed(expected);
        assertEquals(expected, traffic.getMaxSpeedAllowed());
    }

}

```

![image](https://github.com/Pooya2002/SoftwareLab_Az9/assets/63359673/af5eb577-4f55-4162-a848-60f83ec0c9bd)


</div>
