package com.chuang.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.chuang.model.User;
import com.chuang.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    /**
     * 用户名检测
     */
    @RequestMapping("/check")
    @ResponseBody
    public String checkName(@RequestParam("username") String username){
    	String message=null;
    	User user = userService.checkName(username);
    	if(user!=null){
    		message="N";
    	}
    	return message;
    }
    
    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @RequestMapping(value="/register.do",method={RequestMethod.POST})
    public String register(@RequestParam("username") String username,
    		@RequestParam("password") String password,@RequestParam("phone") String phone,
    		MultipartFile file,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IllegalStateException, IOException{
    	String ImgPath=null;// 文件路径
    	if (file!=null) {// 判断上传的文件是否为空
            String type=null;// 文件类型
            String fileName=file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:"+fileName);
            // 判断文件类型
            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if (type!=null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath=request.getSession().getServletContext().getRealPath("");
                    // 自定义的文件名称
                    String trueFileName=String.valueOf(System.currentTimeMillis())+"."+type;
                    // 设置存放图片文件的路径
                    ImgPath="/upload/"+/*System.getProperty("file.separator")+*/trueFileName;
                  // path =  path.replace(" ", "");
                    System.out.println("存放图片文件的路径:"+ImgPath);
                    // 转存文件到指定的路径
                    file.transferTo(new File(realPath+ImgPath));
                    request.setAttribute("ImgPath", ImgPath);
                    System.out.println("文件成功上传到指定目录下"+realPath);
                }else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    return null;
                }
            }else {
                System.out.println("文件类型为空");
                return null;
            }
        }else {
            System.out.println("没有找到相对应的文件");
            return null;
        }
    	User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setImgUrl(ImgPath);
        		userService.register(user);
        return "redirect:/";
    }
  
    @RequestMapping(value="/login.do",method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password){
        User user = userService.login(username, password);
        
        ModelAndView modelAndView = new ModelAndView();
        if(user == null){
            modelAndView.addObject("message", "用户不存在或者密码错误！请重新输入");
            modelAndView.setViewName("pages/loginE");
        }else{
            modelAndView.addObject("user", user);
            modelAndView.setViewName("pages/loginS");
        }
        return modelAndView;
    }
    @RequestMapping("/register")
    public String  toregister(){
    	return "pages/register";
    }
}