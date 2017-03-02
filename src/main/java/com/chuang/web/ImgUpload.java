package com.chuang.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chuang.model.ResultData;

@Controller
@RequestMapping("/img")
public class ImgUpload {
	/**
	 * 图片文件上传
	 * @param file
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */

	@RequestMapping(value="/upload" ,method={RequestMethod.POST})
	  public String photoUpload(MultipartFile file,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IllegalStateException, IOException{
      //  ResultData<Object> resultData=new ResultData<>();
        // 判断用户是否登录
        /*User user=(User) session.getAttribute("user");
        if (user==null) {
            resultData.setCode(40029);
            resultData.setMsg("用户未登录");
            return resultData;
        }*/
        if (file!=null) {// 判断上传的文件是否为空
            String ImgPath=null;// 文件路径
            String type=null;// 文件类型
            String fileName=file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:"+fileName);
           // request.
            // 判断文件类型
            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
          //  System.out.println(type);
            if (type!=null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath=request.getSession().getServletContext().getRealPath("");
                    // 自定义的文件名称
                    String trueFileName=String.valueOf(System.currentTimeMillis())+"01."+type;
                    // 设置存放图片文件的路径
                    ImgPath="/upload/"+/*System.getProperty("file.separator")+*/trueFileName;
                  // path =  path.replace(" ", "");
                    System.out.println(realPath);
                    System.out.println("存放图片文件的路径:"+ImgPath);
                    // 转存文件到指定的路径
                    file.transferTo(new File(realPath+ImgPath));
                    request.setAttribute("ImgPath", ImgPath);
                    System.out.println("文件成功上传到指定目录下");
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
        return "pages/uploadS.jsp";
	}
        
        
        @RequestMapping(value="/uploads",method=RequestMethod.POST)  
        private String fildUpload(@RequestParam(value="file",required=false) MultipartFile[] file,  
                HttpServletRequest request)throws Exception{  
            //基本表单  
            
              
            //获得物理路径webapp所在路径  
            String pathRoot = request.getSession().getServletContext().getRealPath("");  
            String path="";  
            List<String> listImagePath=new ArrayList<String>();  
            for (MultipartFile mf : file) {  
                if(!mf.isEmpty()){  
                    //生成uuid作为文件名称  
                    String uuid = UUID.randomUUID().toString().replaceAll("-","");  
                    //获得文件类型（可以判断如果不是图片，禁止上传）  
                    String contentType=mf.getContentType();  
                    //获得文件后缀名称  
                    String imageName=contentType.substring(contentType.indexOf("/")+1);  
                    path="/upload/"+uuid+"."+imageName;  
                    mf.transferTo(new File(pathRoot+path));  
                    listImagePath.add(path);  
                }  
            }  
            System.out.println(path);  
            request.setAttribute("imagesPathList", listImagePath);  
            return "pages/uploadS.jsp";  
        }  
    
//        @RequestMapping("/toIndex")
//        public String toIndex(){
//        	return "photo/index.html";
//        }
}
