public class Triangle{
  private int area;
  
  //getter & setter
}

public class MathService {
  public void calculateMath(Triangle t){
    Triangle t1 = new Triangle();
    t1.setArea(35);
  
    t.setArea(t1.getArea())
  }
}

public class MathServiceTest {

  @InjectMocks
  private MathService service;

  @Mock
  private Triangle triangle;

  @Test
  public void shouldSuccessWhenCalculateMath(){
    when(triangle.getArea()).thenReturn(35);
    service.calculateMath(triangle);
    assertEquals(triangle.getArea(), 35);
  }
}
