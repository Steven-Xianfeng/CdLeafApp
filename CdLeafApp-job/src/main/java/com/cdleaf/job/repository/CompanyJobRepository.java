package com.cdleaf.job.repository;

import com.cdleaf.job.entity.CompanyJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Table;

@RequestMapping
@Table(name = "company_job")
public interface CompanyJobRepository extends JpaRepository<CompanyJob,Long> {

//    CompanyJob findCompanyJobById(Long id);
//    CompanyJob save(CompanyJob companyJob);

    @Query("SELECT a FROM CompanyJob a WHERE a.companyName=:name")
    CompanyJob findCompanyJobByCompanyName(@Param("name") String name);
}
