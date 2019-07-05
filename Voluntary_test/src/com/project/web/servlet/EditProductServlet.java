package com.project.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.project.constant.Constant;
import com.project.domain.Category;
import com.project.domain.College;
import com.project.service.CollegeService;
import com.project.utils.BeanFactory;
import com.project.utils.UUIDUtils;
import com.project.utils.UploadUtils;

public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Map<String,Object> map=new HashMap<>();
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem fi : list) {
				String key = fi.getFieldName();
				if(fi.isFormField()){
					map.put(key, fi.getString("utf-8"));
				}else{
					String name = fi.getName();
					String realName = UploadUtils.getRealName(name);
					String uuidName = UploadUtils.getUUIDName(realName);
					String dir = UploadUtils.getDir();
					InputStream is = fi.getInputStream();
					String productPath = getServletContext().getRealPath("/products");
					File dirFile = new File(productPath,dir);
					if(!dirFile.exists()){
						dirFile.mkdirs();
					}
					FileOutputStream os = new FileOutputStream(new File(dirFile,uuidName));
					IOUtils.copy(is, os);
					
					//h.释放资源
					os.close();
					is.close();
					
					//i.删除临时文件
					fi.delete();
					map.put(key, "products"+dir+"/"+uuidName);
				}
			}
			College p = new College();
			BeanUtils.populate(p, map);
			Category c = new Category();
			c.setCid((String)map.get("cid"));
			p.setCategory(c);
			CollegeService ps = (CollegeService) BeanFactory.getBean("ProductService");
			System.out.println(p);
			ps.update(p);
			response.sendRedirect(request.getContextPath()+"/adminProduct?method=findAll");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("保存商品失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
