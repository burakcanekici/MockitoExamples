# MockitoExamples

| Java File | Description |
| :-------- | :---------- |
| `01_MockMethodInTheSameClass.java` | Let's assume that the method, which we want to test, calls another method(s) in the same class and we are supposed to set what returns from this method. We need to get instance of the class, which we want to test, to call the relevant method instead of mocking it again. <br /> **The `@Spy` annotation provides us to get instance of mocked object and this file shows how to use `@InjectMocks` and `@Spy` annotations together.**  |
| `02_CallStaticMethod.java` | |
| `03_MockAndSpyDifference.java` | Expected :0 <br />Actual   :35 |
