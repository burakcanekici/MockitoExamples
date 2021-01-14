class Rectangle{
    private int area;
    private int height;
    private int width;

    //getter & setter
    public int getArea(){ return area; }
    public void setArea(int area){ this.area = area; }
    ...
}

class MathService {
    public Integer checkAndCalculateArea(Rectangle rectangle){
        if(rectangle.getHeight() < 0 || rectangle.getWidth() < 0) {
            return null;
        }

        Integer area = (rectangle.getHeight() * rectangle.getWidth());
        return area;
    }
}

class MathServiceTest {

    /@InjectMocks
    private MathService service;

    @Mock
    private Rectangle rectangle;

    private Rectangle setRectangleParams(int height, int width){
        Rectangle r = new Rectangle();
        r.setHeight(height);
        r.setWidth(width);
        return r;
    }

    // In this case, the rectangle object was only mocked above with @Mock annotation, it's height and weight
    // parameters were not set a value. Therefore, we should use when-thenReturn structure to set a value when
    // they called.
    @Test
    public void case1MockedObjectWithWhenThenReturn(){
        // Since the two lines below, when either getHeight or getWidth of rectangle object is called, the value that
        // set in thenReturn() will be returned. In here, since they were set 11 and 3, the area will be calculated
        // as 33.
        when(rectangle.getHeight()).thenReturn(11);
        when(rectangle.getWidth()).thenReturn(3);

        Integer area = service.checkAndCalculateArea(rectangle);

        assertEquals(Optional.of(33), Optional.of(area));
    }

    // In this case, the parameters of rectangle object was set with setRectangleParams() method and there is not need
    // to when-thenReturn structure to set a value when they called in the method that wnat to be tested. When either
    // getHeight or getWidth are called, they will automatically continue.
    @Test
    public void case2MockedObjectWithSetThemWithMethod(){
        // Since both height and width parameters of rectangle object consumed are set in the setRectangleParams()
        // method, we can ignore the when-thenReturn structure in the test method below. In here, since they were
        // set 11 and 3, the area will be calculated as 33.
        rectangle = setRectangleParams(11,3);

        Integer area = service.checkAndCalculateArea(rectangle);

        assertEquals(Optional.of(33), Optional.of(area));
    }
}
