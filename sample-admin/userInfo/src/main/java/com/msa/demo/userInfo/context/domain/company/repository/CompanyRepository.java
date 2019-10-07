package com.msa.demo.userInfo.context.domain.company.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.msa.demo.userInfo.context.domain.company.model.Company;
import com.msa.demo.userInfo.context.domain.company.model.CompanyType;

@RepositoryRestResource
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long>, QuerydslPredicateExecutor<Company>, JpaRepository<Company, Long>{
	List<Company> findByCompanyType(CompanyType companyType);
}
