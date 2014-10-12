package com.babyduncan;

import com.google.common.collect.Lists;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * User: guohaozhao (guohaozhao116008@sohu-inc.com)
 * Date: 10/12/14 15:12
 */
@Controller
public class ImageController {

    private static final Logger logger = Logger.getLogger(ImageController.class);
    private static final String IMAGE_PREFIX = "image";
    private static final String IMAGE_DIR = "/opt/image";

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("code", 0);
        return modelAndView;
    }

    /**
     * 文件上传
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ModelAndView uploadMultiPartImage(@RequestParam MultipartFile[] myfiles, HttpServletRequest request, HttpServletResponse response) throws FileUploadException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("image");
        modelAndView.addObject("code", 0);
        List<String> filenames = Lists.newArrayList();
        for (MultipartFile myfile : myfiles) {
            if (myfile.isEmpty()) {
                continue;
            }
            String fileName = processUploadedFile(myfile);
            filenames.add(fileName);
        }
        modelAndView.addObject("data", filenames);
        return modelAndView;
    }

    private String processUploadedFile(MultipartFile myfile) {
        String fileName__ = new StringBuilder().append(IMAGE_PREFIX).append(System.currentTimeMillis()).append(myfile.getOriginalFilename()).toString();
        File uploadedFile = new File(new StringBuilder().append(IMAGE_DIR).append("/o/").append(fileName__).toString());
        try {
            FileUtils.copyInputStreamToFile(myfile.getInputStream(), uploadedFile);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return fileName__;
    }


    @RequestMapping(value = "uploadStream", method = RequestMethod.POST)
    public ModelAndView uploadImageStream(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }


}
