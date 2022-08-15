package com.empresa.linguagens.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.linguagens.model.Linguagens;

@RestController
@RequestMapping(value = "/all")
public class LinguagensController {


	private List<Linguagens> linguagens = List.of(
			new Linguagens("java", null, 1);
			
			);
}
