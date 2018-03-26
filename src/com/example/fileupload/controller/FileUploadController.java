package com.example.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileupload.service.FileUploadService;

@Controller
public class FileUploadController {
    @Autowired
    FileUploadService fileUploadService;
    
    @RequestMapping( "/form" )
    public String form() {
	return "form";
    }

    @RequestMapping( "/upload" )
    public String upload( @RequestParam( "email" ) String email, @RequestParam( "file1" ) MultipartFile multipartFile,
	    Model model ) {

	String url = fileUploadService.restore( multipartFile );
	model.addAttribute( "url", url );
	return "result";
    }
}
