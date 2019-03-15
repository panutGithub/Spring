package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Model.StudentModel1;
import com.example.demo.Model.StdentModel;
import com.example.demo.service.StudentService;

import hello.FileUploadController;
import hello.storage.StorageService;

@RestController
public class StudentController {
  
	private StorageService storageService; 
	
	@Autowired
	StudentService studentService;

	@RequestMapping(value = { "/insert" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String search(@RequestBody StdentModel stdentModel) {
		studentService.insert(stdentModel);
		System.out.println("Test : /insert");
		return null;
	}

//	@GetMapping("/searchAll")
	@RequestMapping(value = "/searchAll", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<StudentService> serchAll(StdentModel stdentModel) {
//		studentService.searchAll(user);		@RequestBody(required = false)
		return studentService.searchAll(stdentModel);
	}

	@PostMapping("/searchby")
	@ResponseBody
	public  List searchby(@RequestParam("column")String namecolumn , @RequestParam("value")String valueColumn) {
		System.out.println("searchby : "+namecolumn);
		String sout = "searchby : Success";
//		studentService.searchby(namecolumn, valueColumn);
		return studentService.searchby(namecolumn,valueColumn);
	}

	@PostMapping("/showcolumn")
	@ResponseBody
	public List<StudentService> showcolumn(@RequestParam("column")String namecolumn) {
		return studentService.showcolumn(namecolumn);
	}
	
	
	
	@GetMapping("/testget")
	public List getTest(@RequestBody String name) {
		return null;
	}
	
	@RequestMapping(value = "/showcolumns", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String test1(@RequestParam("id")String id,@RequestParam String password) {
//		System.out.println("column: " + column);
		String column="";
		return "id: "+id+" password: "+password;
	}

	@PostMapping("/updatecell")
	@ResponseBody
	public String updatecell(@RequestParam("username") String username ,@RequestParam("newName") String valueName ) {
		studentService.updateCell(username,valueName);
		return "Success";
	}
 
	@RequestMapping(value = "/test", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String test(@RequestParam("id") String id,@RequestParam("password") String password) {
		System.out.println("id: " + id);
		System.out.println("password: " + password);
 
		return "success";
	}
	
	@RequestMapping(value = "/email/authenticate", method = RequestMethod.POST,produces = "application/json")
//	@ResponseBody
	public String authenticate(@RequestParam("column") String column,@RequestBody StudentModel1 requestModel,Model model) {
		StdentModel stdentModel = new StdentModel();
		stdentModel.setNameColumn(column);
		model.addAttribute(requestModel);
	    return "Ok";
	} 
	
	// upload file ===================
	
//    @GetMapping("/")
//    public String listUploadedFiles(Model model) throws IOException {
//
//        model.addAttribute("files", storageService.loadAll()
//        		.map(path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,"serveFile", path.getFileName().toString()).build().toString()).collect(Collectors.toList()));
//
//        return "uploadForm";
//    }
//
//    @GetMapping("/files/{filename:.+}")
//    @ResponseBody
//    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
//        Resource file = storageService.loadAsResource(filename);
//        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + file.getFilename() + "\"").body(file);
//    }

//    @PostMapping("/")
//    public String handleFileUpload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) {
//        storageService.store(file);
//        redirectAttributes.addFlashAttribute("message","You successfully uploaded " + file.getOriginalFilename() + "!");
//        return "redirect:/";
//    }
    
    //======================sections 1
	/*
	 * @PostMapping("/uploadFile") public UploadFileResponse
	 * uploadFile(@RequestParam("file") MultipartFile file) { String fileName =
	 * fileStorageService.storeFile(file);
	 * 
	 * String fileDownloadUri =
	 * ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").
	 * path(fileName).toUriString();
	 * 
	 * return new UploadFileResponse(fileName,
	 * fileDownloadUri,file.getContentType(), file.getSize()); }
	 */
    //======================sections 2
    
	
	  @RequestMapping(value = "/uploadsection2" , method = RequestMethod.POST ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE) 
	  public ResponseEntity<Object>uploadFile(@RequestParam("file")MultipartFile file) throws IOException { 
		  File converFile = new File("D:\\TestUploadfile"+file.getOriginalFilename());
		  converFile.createNewFile(); 
		  FileOutputStream fout = new FileOutputStream(converFile); fout.write(file.getBytes()); fout.close();
		  return new ResponseEntity<>("File is uploaded successfully",HttpStatus.OK); 
	  }
	 
	
	// end upload file 

}
