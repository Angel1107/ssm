package com.chuang.web;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

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

import com.chuang.model.LoginLog;
import com.chuang.model.User;
import com.chuang.service.LoginLogService;
import com.chuang.service.UserService;
import com.chuang.util.GetIP;


@Controller
@SessionAttributes("user")
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private LoginLogService logService;
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
        System.out.println(user);
        user.setImgUrl(ImgPath);
        		userService.register(user);
        return "redirect:/";
    }
  /**
   * 用户登录
   * @param username
   * @param password
   * @return
 * @throws IOException 
   */
    @RequestMapping(value="/login.do",method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password
                              ,HttpServletRequest request,
                              HttpServletResponse response) throws IOException{
        User user = userService.login(username, password);
        LoginLog log = new LoginLog();
        String s1 = request.getHeader("User-agent");
        String s2 = GetIP.getBrowserName(s1);
        String s4 = request.getRemoteHost();
        String s5 = GetIP.getOSName(s1, request);
        if(user!=null){
        log.setIp(s4);log.setUserId(user.getId());log.setOsName(s5);log.setUserAgent(s2);
        logService.insertLog(log);
        }
//        System.out.println(GetIP.getIpAddress(request));
//        boolean s3 = GetIP.isMobileDevice(request);
//        String os = System.getProperty("os.name");
//        String s4 = request.getRemoteHost();
//       
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//        System.out.println(s4);
//        System.out.println(s5);
//        System.out.println(os);
//       System.out.println(GetIP.getBrowserName(request.getHeader("User-agent")));
//       System.out.println(request.getHeader("Host"));
//       System.out.println(request.getHeader("Referer"));
       //System.out.println(request.getRemoteAddr()+":"+request.getRemotePort()+"-----"+request.getServletPath());
        ModelAndView modelAndView = new ModelAndView();
        if(user == null){
            modelAndView.addObject("message", "用户不存在或者密码错误！请重新输入");
            modelAndView.setViewName("pages/loginE.jsp");
        }else{
            modelAndView.addObject("user", user);
            System.out.println(user);
            modelAndView.setViewName("pages/loginS.jsp");
        }
        return modelAndView;
    }
    @RequestMapping("/register")
    public String  toregister(){
    	return "pages/register.jsp";
    }
}