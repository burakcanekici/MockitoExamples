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
  
  // it is essential to prevent that the rectangle object is reset to 0 (the @Spy annotation is used instead of @Mock annotation)
  @Spy
  private Rectangle rectangle;

  @Test
  public void shouldSuccessWhenCheckAndCalculateArea(){
    try (MockedStatic<Calculation> mockedStatic = Mockito.mockStatic(Calculation.class)) {
      doReturn(1).when(rectangle).getHeight();
      doReturn(1).when(rectangle).getWidth();
      
      // the return value is set to area variable in the checkAndCalculateArea method and it sets area variable of rectangle instance to 35
      mockedStatic.when(() -> Calculation.calculateArea(rectangle)).thenReturn(35);

      Boolean result = mathService.checkAndCalculateArea(rectangle);

      assertEquals(result, true);
      // the area variable of rectangle instance has already been set to 35, and it checks in here
      assertEquals(rectangle.getArea(), 35);
    }
  }
}
