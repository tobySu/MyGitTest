package com.yue.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yue.entity.Toby;
import com.yue.entity.User;
import com.yue.service.TobyService;
import com.yue.service.UserService;

@Controller
public class TestController {
	
	/*private static Logger log = Logger.getLogger(TestController.class);
	
	private static Logger smslog = Logger.getLogger("sms");*/
	
	private static Logger  log = LogManager.getLogger(TestController.class);
	private static Logger  smslog = LogManager.getLogger("sms");
	private static org.apache.log4j.Logger log4j1 = org.apache.log4j.Logger.getLogger(TestController.class);
	@Autowired
	private UserService userService;
	
	@Autowired
	private TobyService tobyService;
	
	@RequestMapping(value="/testMethod",method=RequestMethod.GET)
	public void test(String name,HttpServletRequest request,HttpServletResponse reponse){
		try {
			//request.getRequestDispatcher("tobyindex").forward(request, reponse);
			reponse.sendRedirect("tobyindex");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("tobytest==>" +name);
	}
	
	@RequestMapping(value="/index")
	public String index(){
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/save")
	public User saveUser() {
		log.warn("访问--------------------" + TestController.class.getResource("/"));
		User user = new User();
		user.setUsername("mengxy");
		user.setPassword("mengxy");
		this.userService.saveUser(user);
		return user;
	}
	
	@ResponseBody
	@RequestMapping("/findbyid/{id}")
	public User findById(@PathVariable long id){
		return this.userService.findUserById(id);
	}
	
	@ResponseBody
	@RequestMapping("/findbyusername/{username}")
	public List<User> findByUsername(@PathVariable String username){
		return this.userService.findUserByUsername(username);
	}
	
	@ResponseBody
	@RequestMapping("/toby")
	public void saveToby(){
		/*for(int i = 1;i<20;i++){
			Toby toby = new Toby();
			toby.setName("toby"+i);
			toby.setSex("boy");
			tobyService.save(toby);	
		}*/
		Toby toby = new Toby();
		toby.setName("toby");
		toby.setSex("boy");
		toby.setTelephone("020 － 123456-123");
		tobyService.save(toby);
		log.info("[toby save] success!!");
	}
	
	@RequestMapping("/tobytest")
	public ModelAndView toby(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addObject(tobyService.getToby());
		return modelAndView;
	}
	
	@RequestMapping(name="/page",method=RequestMethod.GET)
	public @ResponseBody Page<Toby> page(int page,int size){
		Sort sort = new Sort(Direction.ASC, "id");
		Pageable  pageable = new PageRequest(page, size, sort);
		Page<Toby> pages = tobyService.pageBy(pageable);
		log.info("[tobytest]==>【size:"+pages.getSize()+"number:"+pages.getNumber()+"totalPages:"+pages.getTotalPages()+"sort:"+pages.getSort()+"】");
		log.info("*****************************************中文测试");
		smslog.info("tobytest log test =======================");
		//smslog.info("My name is {},这是测试{}","聪","test");
		log.debug("this is debug test!");
		for(Toby t : pages.getContent()){
			log.info("[tobytest]==>"+t.toString());	
		}
		log4j1.info("this is log4j1 test!");
		return pages;
	}
	
	@ResponseBody
	@RequestMapping("/tobytest2")
	public Toby findByIdAndName(long id,String name){
		return tobyService.findByIdAndName(id,name);
	}
	
	@ResponseBody
	@RequestMapping("/tobyxml")
	public Iterable<Toby> tobyxml(){
		return tobyService.findAll();
	}
	
	@RequestMapping("/tobyindex")
	public String tobyindex(){
		return "toby";
	}
	@RequestMapping("/logtest")
	public void tobybog(){
		log.info("this is first!");
		while(true){
			log.info("test!");
		}
	}
	@RequestMapping("/download")
	public void download(HttpServletResponse response,HttpServletRequest request){
		String fileName="toby.txt";
		System.out.println("enter");
		System.out.println("contextPath:"+request.getServletContext().getContextPath());
		System.out.println(request.getServletContext().getRealPath(fileName));
		try {
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(fileName.getBytes("GB2312"), "ISO8859-1"));
			response.setContentType(request.getServletContext().getMimeType(fileName));
			OutputStream os = response.getOutputStream();
			OutputStreamWriter ow = new OutputStreamWriter(os);
			ow.write("tobytest聪!!!!!!!!!!!!!");
			ow.flush();
			ow.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(name="/upload",method=RequestMethod.POST)
	public ModelAndView upload(@RequestParam("file")MultipartFile file,String path){
		System.out.println("enter upload");
		ModelAndView mv = new ModelAndView();
		try {
			System.out.println(file.getContentType());
			System.out.println(file.getName());
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getSize());
			File f = new File(path);
			if(!f.getParentFile().exists()){
				//createDir(f.getAbsolutePath());
				//createDir2(f.getPath()); //兼容win&linux
				f.getParentFile().mkdirs();
			}
			if(!f.exists()){
				f.createNewFile();
			}
			InputStream fi = file.getInputStream();
			FileOutputStream out = new FileOutputStream(f,true);//"f://uploadTest.txt"
			int a = 0;
			while((a = fi.read())>-1){
				out.write(a);
			}
			out.flush();
			out.close();
			fi.close();
			mv.setViewName("toby");
			mv.addObject("upload", true);
			mv.addObject("message", "upload success!");
		}
		catch (Exception e) {
			log.error("上传失败,失败信息："+e);
		}
		return mv;
	}
	
	/**
     * 创建不存在文件夹
     * @param filePath 文件路径
     */
    public static void createDir(String filePath) {
    	//window使用\\\\，linux使用File.separator
        String paths[] = filePath.split("\\\\");
        log.info("开始创建文件夹,paths的长度"+paths.length);
        String dir = paths[0];
        for (int i = 0; i < paths.length - 2; i++) {
        	log.info("第"+(i+1)+"个dir值为:"+dir);
            try {
                dir = dir + "/" + paths[i + 1];
                File dirFile = new File(dir);
                if (!dirFile.exists()) {
                    dirFile.mkdir();
                    log.info("创建目录为：" + dir);
                }
            } catch (Exception err) {
                log.error("ELS - Chart : 文件夹创建发生异常");
            }
        }
    }
    
    public static void createDir2(String path){
    	List<String> createDirs = new ArrayList<String>();
    	File file = new File(path);
    	while(true){
    		file = file.getParentFile();
    		if(file.exists() || file==null)break;
    		createDirs.add(file.getPath());
    	}
    	for(int index =createDirs.size() ;index> 0;index--){
    		new File(createDirs.get(index-1)).mkdir();
    	}
    }
}