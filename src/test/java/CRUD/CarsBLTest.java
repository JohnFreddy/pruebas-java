package CRUD;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CarsBLTest {

    @Mock
    private CarsRepository repository;

    private CarsBL carsBL;

    @Before
    public void setUp() throws Exception {
        carsBL = new CarsBL(repository);
    }

    @Test(expected = BusinessException.class)
    public void createCarShouldReturnErrorWhenPlateIsEmpty() throws BusinessException {
       Car car = Car.builder()
               .plate("")
               .brandId("1")
               .reference("Spark")
               .model("2014")
               .build();

       carsBL.createCar(car);
    }
}