public class Rectangle{
  private int area;
  private int height;
  private int width;
  
  //getter & setter
  public int getArea(){ return area; }
  public void setArea(int area){ this.area = area; }
  ...
}

public class MathService {
  
  public Boolean isValidShape(Rectangle rectangle){
    if(rectangle.getHeight() < 0 || rectangle.getWidth() < 0){
      return false;
    }
    return true;
  }
  
  public Integer calculateArea(Rectangle rectangle){
    Integer area = (rectangle.getHeight() * rectangle.getWidth());
    return area;
  }
  
  public Integer checkAndCalculateArea(Rectangle rectangle){
    Boolean isValid = this.isValidShape(rectangle);
    if(!isValid){
      return 0;
    }
    
    Integer area = this.calculateArea(rectangle);
    return area;
  }
}

public class MathServiceTest {

  // using @InjectMocks and @Spy annotations is essential for accessing the isValidShape method in the same class
  // we mock the MathService object by using the @InjectMocks annotation
  // also, thanks to @Spy annotation, we access to the instance of MathService object for mocking the isValidShape and calculateArea methods
  @InjectMocks
  @Spy
  private MathService service;

  @Mock
  private Rectangle rectangle;

  @Test
  public void shouldSuccessWhenCalculateMath(){
    // the method above make the real isValidShape method return true without executing itself
    doReturn(true).when(service).isValidShape(rectangle);
    
    // the method above make the real calculateArea method return an integer we want - which set to 35 in here
    doReturn(35).when(service).calculateArea(rectangle);
    
    Integer area = service.calculateArea(rectangle);
    
    // since we set that return 35 when the calculateArea method is triggered, it will return 35 and we should check this value
    assertEquals(area, 35);
  }
}
