//package team.chenshu.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.java.Log;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.awt.image.RescaleOp;
//import java.io.*;
//import java.util.List;
//
///**
// * @author yu
// * @date 2021/11/29 - 22:45
// * @Content: 为博客管理页面做一个文件上传下载的接口，目标：用多种不同的方法实现文件的上传和下载
// */
//@RestController
//@Slf4j
//public class fileController {
//
//
//		@Value("${file.upload.url}")
//		private String uploadFilePath;
//
//		//用文件流的形式上传文件
//		public void uploadFile(HttpServletRequest request, HttpServletResponse response)
//		throws Exception, IOException {
//
//			//得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
//			//1.先存在E:\files
//			String savePath  = "E:\\files";
//			File file = new File(savePath);
//			//2.判断文件上传目录是否存在
//			if(!file.exists() && !file.isDirectory()){
//				System.out.println(savePath+"目录不存在，快去创建目录把");
//				//创建一个目录
//				file.mkdir();
//			 }
//			//错误消息提示
//			String  message = "";
//			try {
//				//a.使用Apache文件上传组件处理文件上传步骤
//				DiskFileItemFactory factory = new DiskFileItemFactory();
//				//b. 创建一个文件上传解析器
//				ServletFileUpload upload = new ServletFileUpload();
//				//c. 解决文件上传名的中文乱码问题
//				upload.setHeaderEncoding("utf-8");
//				//d. 判断上传的数据是否是上传表单的数据
//				if(!ServletFileUpload.isMultipartContent(request)){
//					//按照传统方式获取数据
//					return ;
//				}
//				//e.使用ServletFileUpload解析器解析上传数据，
//				// 解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
//				List<FileItem> list = upload.parseRequest(request);
//				for(FileItem item : list){
//					//如果fileitem中封装的是普通输入项的数据
//					if(item.isFormField()){
//						String name = item.getFieldName();
//						//解决普通输入项的数据的中文乱码问题
//						String value = item.getString("utf-8");
//						System.out.println(name + "" +value);
//					}else{
//						//如果fileItem中封装的是上传文件
//						//得到上传文件的名字
//						//trim() 方法用于删除字符串的头尾空白符。
//						String fileName = item.getName();
//						System.out.println(fileName);
//						if(fileName == null  || fileName.trim().equals("")){
//							continue;
//						}
//						//注意：不同的浏览器提交的文件名是不一样的，
//						// 有些浏览器提交上来的文件名是带有路径的，如
//						// ：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
//						 //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
//						//lastIndexOf返回指定子字符串在此字符串中最右边出现处的索引，
//						// 如果此字符串中没有这样的字符，则返回 -1
//						fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
//						//获取item中的上传文件的输入流
//						InputStream in = item.getInputStream();
//						//创建一个文件输出流
//						FileOutputStream out = new FileOutputStream(savePath+"\\"+fileName);
//						//创建一个缓冲区
//						byte buffer[] = new byte[1024];
//						//判断输入流中的数据是否已经读完的标识
//						int len = 0 ;
//						//循环将输入流读入到缓冲区当中，
//						// (len=in.read(buffer))>0就表示in里面还有数据
//						while((len = in.read(buffer))>0){
//							//使用FileOutputStream输出流将缓冲区的数据
//							// 写入到指定的目录(savePath + "\\" + filename)当中
//							out.write(buffer,0,len);
//						}
//						//关闭输入流
//						in.close();
//						//关闭输出流
//						out.close();
//						//删除处理文件上传时生成的临时文件
//						item.delete();
//						message = "文件上传成功！";
//					}
//				}
//			}catch (Exception e){
//				message = "文件上传失败！";
//				e.printStackTrace();
//			}
//			request.setAttribute("message",message);
//
//			//代码来自 https://www.cnblogs.com/xdp-gacl/p/4200090.html
//
//
//
//		}
//
//
//		@RequestMapping("/upload")
//		public String httpUpload(@RequestParam("files")MultipartFile files[]){
//
//			JSONObject jsonObject = new JSONObject();
//			for(MultipartFile file : files){
//
//				String fileName = file.getOriginalFilename();
//				File dest = new File(uploadFilePath + '/' +fileName);
//				if(!dest.getParentFile().exists()){
//					dest.getParentFile().mkdirs();
//				}
//
//				try{
//					file.transferTo(dest);
//				} catch (Exception e){
//					log.error("{}",e);
//					jsonObject.put("success",2);
//					jsonObject.put("result","程序错误，请重新上传");
//					return jsonObject.toString();
//				}
//			}
//
//			jsonObject.put("success",1);
//			jsonObject.put("result","文件上传成功");
//			return jsonObject.toString();
//		}
//
//
//
//		@RequestMapping("/download")
//		public String fileDownload(HttpServletResponse response, @RequestParam("fileName") String fileName){
//
//			File file = new File(uploadFilePath + '/' + fileName);
//
//			if(!file.exists()){
//
//				return "该文件不存在";
//
//			}
//
//			response.reset();
//			response.setContentType("application/octet-stream");
//			response.setCharacterEncoding("utf-8");
//			response.setContentLength((int) file.length());
//			response.setHeader("Content-Disposition", "attachment;filename=" + fileName );
//
//
//			try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));){
//				byte[] buff = new byte[1024];
//				OutputStream os  = response.getOutputStream();
//				int i = 0;
//				while ((i = bis.read(buff)) != -1){
//					os.write(buff, 0, i);
//					os.flush();
//				}
//			}catch (IOException e){
//				log.error("{}",e);
//				return "下载失败";
//			}
//
//
//			return "下载成功";
//		}
//
//
//
//
//
//}
