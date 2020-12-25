public class Rectangle{
  private int area;
  private int height;
  private int width;
  
  //getter & setter
  public int getArea(){ return area; }
  public void setArea(int area){ this.area = area; }
  ...
}

public class Calculation {
    public static Integer calculateArea(Rectangle rectangle){
        Integer area = (rectangle.getHeight() * rectangle.getWidth());
        return area;
    }
}

public class MathService {

   public Boolean checkAndCalculateArea(Rectangle rectangle){
      if(rectangle.getHeight() < 0 || rectangle.getWidth() < 0){
          return false;
      }

      // In here, the calculateArea() method is a static method and it is called
      Integer area = Calculation.calculateArea(rectangle);
      rectangle.setArea(area);
     
      return true;
   }
}

public class MathServiceTest {

  @InjectMocks
  private MathService mathService;

  @Mock
  private Rectangle rectangle;

  @Test
  public void shouldSuccessWhenCheckAndCalculateArea(){
    // during the testing checkAndCalculateArea() method, to mocking the static method Calculation.calculateArea in the MathService class,
    // the MockedStatic type should be used to handle it in try block. Also, it mocks a bit different from what we have already done. We
    // return a value whenever it called by using the MockedStatic type.
    try (MockedStatic<Calculation> mockedStatic = Mockito.mockStatic(Calculation.class)) {
      // to preventing return the false from the checkAndCalculateArea method, getters set to a value 
      doReturn(1).when(rectangle).getHeight();
      doReturn(1).when(rectangle).getWidth();
      
      // the static Calculation.calculateArea method sets to 35, which means are will be set to 35 in the checkAndCalculateArea method
      mockedStatic.when(() -> Calculation.calculateArea(rectangle)).thenReturn(35);

      Boolean result = mathService.checkAndCalculateArea(rectangle);

      // the result that return from the checkAndCalculateArea method is expected as true
      assertEquals(result, true);
    }
  }
}
