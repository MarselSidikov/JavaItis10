package ru.itis.restapidemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.itis.restapidemo.dto.CarModelDto;
import ru.itis.restapidemo.repositories.CarModelsRepository;

import java.util.List;

import static ru.itis.restapidemo.dto.CarModelDto.from;

@Service
public class CarsServiceImpl implements CarsService {

    @Autowired
    private CarModelsRepository carModelsRepository;

//    @Override
//    public List<CarModelDto> getCarModels(Long limit, Long offset) {
//        return from(carModelsRepository.getCarModels(limit, offset));
//    }

    @Override
    public List<CarModelDto> getCarModels(Long page, Long size) {
        Sort sort = new Sort(Sort.Direction.ASC, "model");
        PageRequest request = PageRequest.of(page.intValue(),size.intValue(), sort);
        return from(carModelsRepository.findAll(request).getContent());

    }
}
