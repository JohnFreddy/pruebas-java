package CRUD;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CarsBLTest {

    @Mock
    private CarsRepository repository;

    @Mock
    private UtilsRepository utilsRepository;

    private CarsBL carsBL;
    private Car car;

    @Before
    public void setUp() throws Exception {
        carsBL = new CarsBL(repository, utilsRepository);

        car = Car.builder()
                .plate("EIN689")
                .brandId("1")
                .reference("Spark")
                .model(2014)
                .build();

    }

    @Test(expected = BusinessException.class)
    public void createCarShouldReturnErrorWhenPlateIsEmpty() throws BusinessException {
       car = car.toBuilder()
               .plate("")
               .build();
       carsBL.createCar(car);
    }

    @Test(expected = BusinessException.class)
    public void createCarShouldReturnErrorWhenBrandIsEmpty() throws BusinessException {
        car = car.toBuilder()
                .brandId("")
                .build();
        carsBL.createCar(car);
    }

    @Test(expected = BusinessException.class)
    public void createCarShouldReturnErrorWhenModelIsEmpty() throws BusinessException {
        car = car.toBuilder()
                .model(0)
                .build();
        carsBL.createCar(car);
    }

    @Test(expected = BusinessException.class)
    public void createCarShouldReturnErrorWhenReferenceIsEmpty() throws BusinessException {
        car = car.toBuilder()
                .reference("")
                .build();
        carsBL.createCar(car);
    }

    @Test(expected = BusinessException.class)
    public void createCarShouldReturnErrorWhenModelIsMoreCurrentYear() {
        car.setModel(2020);
        carsBL.createCar(car);
        Mockito.when(utilsRepository.getCurrentYear()).thenReturn(2019);

        boolean isValidated = carsBL.validateModel(car);
        Mockito.verify(utilsRepository).getCurrentYear();
        Assert.assertTrue(isValidated);

    }

}