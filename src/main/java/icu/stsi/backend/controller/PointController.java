package icu.stsi.backend.controller;

import icu.stsi.backend.domain.Point;
import icu.stsi.backend.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Optional;

//todo: доработать
@Controller
public class PointController {

    @Autowired
    private PointRepository pointRepository;

    @PostMapping(path="/add")
    public @ResponseBody String put(@RequestParam Point point) {
        Point newPoint = new Point();
        newPoint.setDescription(point.getDescription());
        newPoint.setLatitude(point.getLatitude());
        newPoint.setLongitude(point.getLongitude());
        newPoint.setPointType(point.getPointType());
        newPoint.setCreateTime(new Date());
        pointRepository.save(newPoint);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Point> getAll() {
        return pointRepository.findAll();
    }

    @GetMapping(path="/get")
    public @ResponseBody Optional<Point> get(@RequestParam Long id) {
        return pointRepository.findById(id);
    }

    @PostMapping(path="/delete")
    public @ResponseBody String delete(@RequestParam Long id) {
        pointRepository.deleteById(id);
        return "Delete";
    }
}
