package com.supportportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.domain.HttpResponse;
import com.supportportal.entity.Stagier;
import com.supportportal.service.StagierService;

@RestController
@RequestMapping("/stagiers")
public class StagierController {

    @Autowired
    private StagierService stagierService;

    @GetMapping("/list")
    public List<Stagier> getAllStagiers() {
        return stagierService.getAllStagiers();
    }

    @GetMapping("/{id}")
    public Stagier getStagierById(@PathVariable Long id) {
        return stagierService.getStagierById(id);
    }

    @PostMapping("/add")
  //@PreAuthorize("hasAnyAuthority('user:create')")
	public ResponseEntity<Stagier> addNewStagier(  @RequestParam("nomPrenom") String nomPrenom ,
												   @RequestParam("institut") String institut , 
												   @RequestParam("diplome") String diplome ,
												   @RequestParam("specialite") String specialite ,
												   @RequestParam("cin") String cin ,
												   @RequestParam("tel") String tel ,
												   
												   @RequestParam("superviseurMatricule") String superviseurMatricule,
												   @RequestParam("stageRef") String stageRef){
		Stagier newStagier = stagierService.ajouterStagier(nomPrenom, institut, diplome, specialite, cin,tel, superviseurMatricule, stageRef) ;
		return new  ResponseEntity<>(newStagier,HttpStatus.OK);
	}

  
      
    
    public static final String STAGIARE_DELETED_SUCCESSFULY = " stagier Deleted Successfully " ;
    
    @DeleteMapping("/delete/{id}")
  //@PreAuthorize("hasAnyAuthority('user:delete')")
	public ResponseEntity<HttpResponse> deleteStagier (@PathVariable("id") long id){
    	stagierService.deleteStagier(id);
		return response(HttpStatus.NO_CONTENT ,STAGIARE_DELETED_SUCCESSFULY) ; 
	}
	
    private  ResponseEntity<HttpResponse> response (HttpStatus httpStatus , String message ){
		HttpResponse body = new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase()	,message.toUpperCase() )  ;
		return new  ResponseEntity<>( body , httpStatus ) ;
	}
}
