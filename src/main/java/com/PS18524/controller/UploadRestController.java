package com.PS18524.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.PS18524.entity.Category;
import com.PS18524.service.CategoryService;
import com.PS18524.service.UploadService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


@CrossOrigin("*")
@RestController
public class UploadRestController {
	@Autowired
	UploadService service;
	
	@PostMapping("/rest/upload/{folder}")
	public JsonNode upload(@PathVariable("file") MultipartFile file,@PathVariable("folder") String folder) {
		File savedFile = service.save(file,folder);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		node.put("name", savedFile.getName());
		node.put("size", savedFile.length());
		return node;
	}
}
