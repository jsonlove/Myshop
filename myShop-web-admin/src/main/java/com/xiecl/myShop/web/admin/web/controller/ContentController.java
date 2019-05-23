package com.xiecl.myShop.web.admin.web.controller;

import com.xiecl.myShop.commons.dto.ContentPage;
import com.xiecl.myShop.commons.dto.ContentResult;
import com.xiecl.myShop.commons.dto.UserPage;
import com.xiecl.myShop.domain.Content;
import com.xiecl.myShop.domain.ContentCategory;
import com.xiecl.myShop.web.admin.service.ContentCategoryService;
import com.xiecl.myShop.web.admin.service.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("content")
public class ContentController {
    @Autowired
    private ContentCategoryService contentCategoryService;
    @Autowired
    private ContentService contentService;

    /**
     * 取得所有分类，进行重新排序
     * @param model
     * @return
     */
   @RequestMapping("/content_categorylist")
    public String content_categorylist(Model model){
       List<ContentCategory> list=contentCategoryService.selectContentCatogoryList();
       List<ContentCategory> target=new ArrayList<ContentCategory>();
       forCategory(list,target,0L);
       model.addAttribute("contentcate",target);
       return "content/content_categorylist";
   }

    /**
     * 进入内容列表
     * @param model
     * @return
     */
    @RequestMapping("/contentlist")
    public String contentlist(Model model){

        return "content/contentlist";
    }

    /**
     * 取得所有内容分页
     * @param request
     * @return
     */
    @RequestMapping("/contentpage")
    @ResponseBody
    public ContentPage contentpage(HttpServletRequest request){
        String strdraw=request.getParameter("draw");
        String strstart=request.getParameter("start");
        String strlength=request.getParameter("length");
        String serachValue=request.getParameter("serachValue");
        int draw = StringUtils.isBlank(strdraw)?0: Integer.parseInt(strdraw);
        int start = StringUtils.isBlank(strstart)?0: Integer.parseInt(strstart);
        int length = StringUtils.isBlank(strlength)?0: Integer.parseInt(strlength);
        ContentPage page=new ContentPage();
        if(StringUtils.isBlank(serachValue)) {
            page = contentService.gotoPage(start, length);
        }else{
            page = contentService.serachgopage(start,length,serachValue);
        }
        page.setDraw(draw);
        page.setError("");

        return  page;
    }



    /**递归实现重新排序 发现分类元素的子目录
     * @param list
     * @param target
     * @param parentid
     */
    public void forCategory(List<ContentCategory> list,List<ContentCategory> target,Long parentid){
        for (ContentCategory ca:
             list) {
            if(ca.getParentid().equals(parentid+"")){
                target.add(ca);
                if(ca.isParent()){
                    for (ContentCategory target1:
                         list) {
                        if(target1.getParentid().equals(ca.getId())){
                            forCategory(list,target,new Long(ca.getId()));
                            break;
                        }
                    }
                }
            }
        }
    }

    /**增加或编辑内容
     *
     */
    @RequestMapping("/contentfrom")
    public String forCategory(HttpServletRequest request, Model model){
        String contentid=request.getParameter("id");
        if(StringUtils.isNotBlank(contentid)){
            ContentResult result = contentService.selectByid(contentid);
            model.addAttribute("contentfrom",result);
        }
        return  "content/contentfrom";
    }
    /**获得ztree分类异步数据
     *
     */
    @RequestMapping(value = "/categorytreedata")
    @ResponseBody
    public  List<ContentCategory> categorytreedata(@RequestParam(required = false) String id){
        if(StringUtils.isBlank(id)){
            id="0";
        }
        List<ContentCategory> contentCategories = contentCategoryService.selectContentCatogoryByid(id);
        return  contentCategories;
    }

}
