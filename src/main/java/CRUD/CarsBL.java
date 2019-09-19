package CRUD;

public class CarsBL {

    private CarsRepository carsRepository;

    public CarsBL(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }


    public boolean createCar(Car car) throws BusinessException {
        if(car.getPlate().isEmpty()) {
            throw new BusinessException();
        }

        return true;
    }
}
