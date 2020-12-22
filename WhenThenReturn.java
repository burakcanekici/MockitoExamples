public class Triangle{
  private int area;
  
  public int getArea(){ return area; }
  public void setArea(int area){ this.area = area; }
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
    
    // unit test getter & setter
    //when(triangle.getArea()).thenReturn(55);
    //doCallRealMethod().when(triangle).setArea(55);
    
    assertEquals(triangle.getArea(), 35);
  }
}
