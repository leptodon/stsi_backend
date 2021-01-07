package icu.stsi.backend.service;

import icu.stsi.backend.domain.Point;
import icu.stsi.backend.exception.PointNotFoundException;
import icu.stsi.backend.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PointService {

    @Autowired
    private PointRepository pointRepository;

    public void save(Point point) {
        point.setCreateTime(new Date());
        pointRepository.save(point);
    }

    public List<Point> getAll() {
        return pointRepository.findAll();
    }

    public Point get(Long id) {
        return pointRepository.findById(id).orElseThrow(() -> new PointNotFoundException("Point with id : " + id + " doesn't exist"));
    }

    public void delete(Long id) {
        try {
            pointRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new PointNotFoundException("Point with id : " + id + " doesn't exist");
        }
    }

    public void update(Point point) { //todo доделать/подумать, что можно изменять в точке, кроме даты обновления
        Long idPoint = point.getId(); //todo может ли быть null?
        Point pointFromDB = get(idPoint);

        pointFromDB.setDescription(point.getDescription());
        pointFromDB.setUpdateTime(new Date());
        pointFromDB.setPointType(point.getPointType());

        pointRepository.save(pointFromDB);
    }
}
