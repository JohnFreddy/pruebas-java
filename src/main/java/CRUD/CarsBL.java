package CRUD;

public class CarsBL {

    private CarsRepository carsRepository;
    private UtilsRepository utilsRepository;

    public CarsBL(CarsRepository carsRepository, UtilsRepository utilsRepository) {
        this.carsRepository = carsRepository;
        this.utilsRepository = utilsRepository;
    }


    public boolean createCar(Car car) throws BusinessException {
        if (car.getPlate().isEmpty() || car.getBrandId().isEmpty() ||
                car.getModel() < 1900 || car.getReference().isEmpty()) {
            throw new BusinessException();
        }

        return true;
    }

    public boolean validateModel(Car car) {
        Integer currentYear = utilsRepository.getCurrentYear();
        if (car.getModel() > currentYear) {
            throw new BusinessException();
        }
        return true;
    }
}
