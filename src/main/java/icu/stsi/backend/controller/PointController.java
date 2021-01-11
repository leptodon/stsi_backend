package icu.stsi.backend.controller;

import icu.stsi.backend.domain.Point;
import icu.stsi.backend.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//todo: доработать
@Controller
public class PointController {

    @Autowired
    private PointService pointService;

    @PostMapping(path="/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String put(@RequestBody Point point) {
        pointService.save(point);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody List<Point> getAll() {
        return pointService.getAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Point get(@PathVariable Long id) {
        return pointService.get(id);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody String delete(@PathVariable Long id) {
        pointService.delete(id);
        return "Delete";
    }

    @PostMapping(path="/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String update(@RequestBody Point point) {
        pointService.update(point);
        return "Update";
    }
}
