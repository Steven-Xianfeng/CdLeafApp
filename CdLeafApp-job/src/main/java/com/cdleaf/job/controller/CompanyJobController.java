package com.cdleaf.job.controller;


import com.cdleaf.job.entity.CompanyJob;
import com.cdleaf.job.pojo.CompanyJobVO;
import com.cdleaf.job.repository.CompanyJobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CompanyJobController {

    private Logger logger = LoggerFactory.getLogger(CompanyJobController.class);

    @Autowired
    private CompanyJobRepository companyJobRepository;

    @RequestMapping(value = "/")
    public ModelAndView home() {
        logger.info("Controller :: Home Page");

        List<CompanyJob> jobList = companyJobRepository.findAll();

        jobList.stream().forEach(System.out::println);

        ModelAndView mv = new ModelAndView();
        mv.addObject("jobList", jobList);


        mv.setViewName("home");


        return mv;
    }

    @RequestMapping(value = "/listJob")
    public ModelAndView listJob() {
        logger.info("Controller :: List Job");

        List<CompanyJob> jobList = companyJobRepository.findAll();

//        jobList.stream().forEach(System.out::println);

        ModelAndView mv = new ModelAndView();
        mv.addObject("jobList", jobList);


        mv.setViewName("listJob");


        return mv;
    }

    @RequestMapping(value = "/newJob")
    public ModelAndView newJob() {
        logger.info("Controller :: New Job");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("jobForm");


        return mv;
    }

    @RequestMapping(value = "/editJob")
    public ModelAndView editJob(Long id) {
        logger.info("Controller :: Edit Job");
        ModelAndView mv = new ModelAndView();

        CompanyJob job = companyJobRepository.getOne(id);
        CompanyJobVO vo = new CompanyJobVO(job);

        mv.addObject("companyJobVO", vo);

        mv.setViewName("jobForm");

        return mv;
    }


    @RequestMapping(value = "/saveJob")
    public ModelAndView saveJob(@ModelAttribute CompanyJobVO vo) {
        logger.info("Controller :: Save or Update Job");
        System.out.println(vo);

        ModelAndView mv = new ModelAndView();


        boolean validateFlag = vo.validate();
        if(validateFlag == true){
            CompanyJob entity = companyJobRepository.findCompanyJobByCompanyName(vo.getCompanyName());
            if(entity != null && entity.getId() != vo.getId()){
                vo.setError("company.name.exist");
                validateFlag = false;

                logger.info("Controller :: Company Name Exist :: " + vo.getCompanyName());
                System.out.println(entity);
            }
        }

        if(validateFlag == false){
            System.out.println(vo.getErrors());
            logger.info("Controller :: Job Error !");

            mv.addObject("companyJobVO", vo);
            mv.setViewName("jobForm");
            return mv;
        }

        CompanyJob entity = vo.parseEntity();

        entity = companyJobRepository.save(entity);
        System.out.println(entity);

        mv.setViewName("redirect:/listJob");
        return mv;
    }

    @RequestMapping(value = "/showJob")
    public ModelAndView showJob(Long id) {
        logger.info("Controller :: Show Job");

        CompanyJob job = companyJobRepository.getOne(id);

        ModelAndView mv = new ModelAndView();
        mv.addObject("job", job);

        mv.setViewName("showJob");
        return mv;
    }

    @RequestMapping(value = "/deleteJob")
    public ModelAndView deleteJob(Long id) {
        logger.info("Controller :: Delete Job");

        companyJobRepository.deleteById(id);

        ModelAndView mv = new ModelAndView();

        mv.setViewName("redirect:/listJob");
        return mv;
    }


}
