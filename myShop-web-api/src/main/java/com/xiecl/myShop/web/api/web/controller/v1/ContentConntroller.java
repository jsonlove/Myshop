package com.xiecl.myShop.web.api.web.controller.v1;

import com.xiecl.myShop.commons.dto.BaseResult;
import com.xiecl.myShop.domain.Content;
import com.xiecl.myShop.web.api.service.APIContentService;
import com.xiecl.myShop.web.api.web.dto.ContentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**提供内容的api
 * @author xiecl
 */
@Controller
@RequestMapping("${api.path.v1}/contents")
public class ContentConntroller {
    @Autowired
    private APIContentService service;
    @ResponseBody
    @RequestMapping("/ppt")
    public BaseResult findPPT(){

        List<Content> contents = service.selectByCategoryId("89");
        List<ContentDTO> contentDTOS=null;
        if(contents!=null&&contents.size()>0){
            contentDTOS=new ArrayList<>();
            for (Content content:contents
                 ) {
                ContentDTO contentDTO=new ContentDTO();
                BeanUtils.copyProperties(content,contentDTO);
                contentDTOS.add(contentDTO);
            }
        }
        return BaseResult.success("得到幻灯数据",contentDTOS);
    }
}
