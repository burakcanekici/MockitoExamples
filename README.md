# MockitoExamples

| Java File | Description |
| :-------- | :---------- |
| `01_MockMethodInTheSameClass.java` | Let's assume that the method, which we want to test, calls another method(s) in the same class and we are supposed to set what returns from this method. We need to get instance of the class, which we want to test, to call the relevant method instead of mocking it again. <br /> **The `@Spy` annotation provides us to get instance of mocked object and this file shows how to use `@InjectMocks` and `@Spy` annotations together.**  |
| `02_CallStaticMethod.java` | Let's assume that the method, which we want to test, calls static method(s) and we are supposed to mock this static method. <br /> **The `MockedStatic` keyword helps to mocking the static method you want.** |
| `03_MockAndSpyDifference.java` | Let's assume that you check the value that has been altered inside of the method you want to test. The `AssertEqual` helps to check whether the variable you want is equal to a spesific value you define. <br /> *The problem is, after method is finished, the mocked object is cleared and it seems different from what you expected if it was correct.* <br /> *Error : Expected :0 Actual   :35* <br /> **Therefore, we are supposed to use `@Spy` annotation instead of `@Mock` annotation to keep the result after test method was executed.** |
