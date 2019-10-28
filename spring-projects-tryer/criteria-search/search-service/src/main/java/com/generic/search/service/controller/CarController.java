package com.generic.search.service.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generic.criteria.lib.dao.SearchDao;
import com.generic.criteria.lib.filter.GenericPageSearchFilter;
import com.generic.criteria.lib.model.PageQuery;
import com.generic.criteria.lib.model.PageResult;
import com.generic.search.service.entity.CarEntity;
import com.generic.search.service.repository.CarRepository;

@RestController
@RequestMapping("car")
public class CarController {

	@Autowired
	@Qualifier("carSearchDao")
	private SearchDao<CarEntity> carSearchDao;

	@Autowired
	private CarRepository carRepository;

	@GetMapping
	public Iterable<CarEntity> getAllUsers() {
		return this.carRepository.findAll();
	}

	@GetMapping("/search")
	public ResponseEntity<?> search(@Valid @RequestBody PageQuery pageQuery, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			/* here we can create an exception or validation error object and we can use it */
			return new ResponseEntity<Object>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<PageResult>(
				this.carSearchDao.searchWihPage(new GenericPageSearchFilter<CarEntity>(pageQuery)), HttpStatus.OK);
	}

	@PostMapping("/add")
	public CarEntity add(@Valid @RequestBody CarEntity carEntity) {
		return this.carRepository.save(carEntity);
	}
}
