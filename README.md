<div dir="rtl">

# آزمایش نهم آزمایشگاه نرم‌افزار - پوشش تست

## پوشش اولیه‌ی تست

ابتدا مطابق آزمایش قبل یک تست پوشش کلی می‌گیریم که مطابق تصویر زیر می‌بینیم که 76% از کلاس‌ها و 61 از خطوط کد کاور شده است.
![9](https://github.com/Pooya2002/SoftwareLab_Az9/assets/63359673/edfc7d23-639e-4806-8e31-d1aa6216b0b2)
همگی تست‌ها نیز مطابق تصویر زیر پاس شده.
![7](https://github.com/Pooya2002/SoftwareLab_Az9/assets/63359673/15d9595f-24fd-4716-b27c-d4ad380b99bc)
اگر یک گزارش html هم بگیریم می‌توان به فرمت زیر دید که کدام خط‌ها پوشش داده نشده‌اند.
![8](https://github.com/Pooya2002/SoftwareLab_Az9/assets/63359673/3f4b5576-67a7-4eb5-bfa4-249b1e43a849)

## بررسی تست‌های اضافه شده

* تکمیل PersonService

یکی از مواردی که کلاس تستش وجود داشت ولی پوشش کامل نداشت این کلاس بود که یکی از این موارد این است که آیا کلاس service متد delete در repository را صدا می‌زند یا نه. مورد دوم هم برای بررسی این است که اگر یک null را delete کنیم آیا exception پرتاب می‌شود یا نه.

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

همانطور که در تصویر زیر می‌توان دید پوشش افزایش داشته. مطابق سمت راست تصویر زیر درواقع چون کلاس جدیدی اضافه نکردیم پوشش تست در کل کلاس‌ها ثابت است ولی 10 درصد پوشش خطوط بهتر شده.
![image](https://github.com/Pooya2002/SoftwareLab_Az9/assets/63359673/9dbd852e-6d7d-45f2-8523-bc9ac92bf438)

* تست‌های repositories

این کلاس شامل تست‌هایی برای بررسی عملکرد کلاس PersonRepository است.

 تست insertPerson: این تست بررسی می‌کند که آیا متد insert در PersonRepository به درستی یک شیء Person را ذخیره می‌کند یا نه. در اینجا، یک شیء Person با نام و سن مشخص ساخته و به متد insert ارسال می‌شود و سپس بررسی می‌شود که آیا شیء بازگشتی همان شیء ارسال شده است یا نه.

 تست getPerson:  بررسی می‌کند که آیا متد get در PersonRepository می‌تواند یک شیء Person را بر اساس نام آن پیدا کند یا نه. در اینجا، تست انتظار دارد که هیچ شیء Person با نام "Felix" در مخزن موجود نباشد و بنابراین نتیجه باید null باشد.

 تست updatePerson: این تست بررسی می‌کند که آیا متد update در PersonRepository به درستی اطلاعات یک شیء Person را به‌روزرسانی می‌کند یا نه. ابتدا یک شیء Person ذخیره می‌شود، سپس نام و سن آن تغییر می‌کند و  بررسی می‌کند که متد update بدون ایجاد خطا عمل می‌کند.


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
پوشش بعد از اعمال این تست‌ها را تصویر زیر می‌توان دید.طبق سمت راست تصویر زیر پوشش کلاس repositories که در پکیجی به همین نام است از 0 به 100 درصد رسیده.

![image](https://github.com/Pooya2002/SoftwareLab_Az9/assets/63359673/a6a7ba63-ecbb-4802-8270-bd009d4ca163)


* تست‌های models

 تست testCrossedTheCrosswalk: بررسی می‌کند که آیا یک عابر پیاده از خط عابر پیاده عبور کرده است یا نه. در اینجا، حالت عبور عابر پیاده تنظیم شده و سپس بررسی می‌شود که آیا این حالت به درستی برگردانده می‌شود یا نه.
 
 تست testAge: ین تست بررسی می‌کند که آیا متد getAge مقدار صحیح سن را که قبلاً با استفاده از setAge تنظیم شده است، برمی‌گرداند یا نه.
 
 تست testStreetDirectionFlow: این تست بررسی می‌کند که آیا جهت جریان خیابان به درستی تنظیم و بازگردانده می‌شود یا نه. ابتدا جهت خیابان به ONE_WAY تنظیم شده و بررسی می‌شود، سپس به TWO_WAY تغییر داده شده و مجدداً بررسی می‌شود.
 
 تست testCurrentTrafficLight:  بررسی می‌کند که آیا چراغ راهنمایی به درستی تنظیم و بازگردانده می‌شود یا نه. سه حالت مختلف چراغ راهنمایی (زرد، سبز، قرمز) تنظیم و سپس بررسی می‌شود که مقدار صحیح بازگردانده می‌شود.
 
 تست testIntenseCarTraffic: بررسی می‌کند که آیا وضعیت ترافیک شدید خودروها به درستی تنظیم و بازگردانده می‌شود یا نه.
 
 تست testMinSpeedAllowed: بررسی می‌کند که آیا حداقل سرعت مجاز به درستی تنظیم و بازگردانده می‌شود یا نه.
 
 تست testMaxSpeedAllowed:این تست بررسی می‌کند که آیا حداکثر سرعت مجاز به درستی تنظیم و بازگردانده می‌شود یا نه.
 

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
پوشش نهایی هم در تصویر زیر قابل مشاهده‌ است که 96% خطوط پوشش داده شده‌اند. در اینجا همانطور که در سمت چپ تصویر می‌بینیم  تمام کلاس‌های پکیج model پوشش داده‌شده‌اند که قبل از این، یکی از آن‌ها پوشش داده نشده بود و همچنین پوشش خطوط هم به 100 درصد رسیده.
![image](https://github.com/Pooya2002/SoftwareLab_Az9/assets/63359673/af5eb577-4f55-4162-a848-60f83ec0c9bd)


</div>
