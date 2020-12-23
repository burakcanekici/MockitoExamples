public class Triangle{
  private int area;
  
  public int getArea(){ return area; }
  public void setArea(int area){ this.area = area; }
}

public class MathService {
  public void calculateMath(Triangle t){
    Triangle t1 = new Triangle();
    t1.setArea(35);
  
    t.setArea(t1.getArea());
  }
}

@RunWith(PowerMockRunner.class)
@PrepareForTest(MathService.class)
public class MathServiceTest {

  @InjectMocks
  private MathService service;

  @Mock
  private Triangle mockTriangle1;

  @Test
  public void shouldSuccessWhenCalculateMath(){
    Triangle mockTriangle2 = PowerMockito.mock(Triangle.class);
    PowerMockito.whenNew(Triangle.class).withNoArguments().thenReturn(mockTriangle2);
    PowerMockito.doNothing().when(mockTriangle2).setArea(Mockito.anyString());
    PowerMockito.doNothing().when(mockTriangle1).setArea(Mockito.anyString());
    PowerMockito.when(mockTriangle2.getArea()).thenReturn(new String());
    
    service.calculateMath(mockTriangle1);
    
    verify(mockTriangle2).setArea(Mockito.anyString());
    verify(mockTriangle2).getArea();
    verify(mockTriangle1).setArea(Mockito.anyString());
  }
}
