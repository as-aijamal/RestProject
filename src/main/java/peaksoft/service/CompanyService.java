package peaksoft.service;

import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

  CompanyResponse saveCompany(CompanyRequest company);

    List<Company> getAllCompanies();

    Optional <Company>findById(Long id);

    Company getCompanyById(Long id);

   void deleteCompany(Long id);

   CompanyResponse updateCompany(Long id,CompanyRequest company);

}
