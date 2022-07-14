package peaksoft.mapper;

import org.springframework.stereotype.Component;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.model.Company;

import java.util.ArrayList;
import java.util.List;
@Component
public class CompanyMapper {


    public Company saveCompany(CompanyRequest companyRequest) {
        if (companyRequest == null){
            return null;
        }
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        return company;
    }


    public CompanyResponse viewCompany(Company company) {
        if (company == null) {
            return null;
        }
        CompanyResponse companyResponse = new CompanyResponse();
        if (company.getId() != null) {
            companyResponse.setId(String.valueOf(company.getId()));
        }
        companyResponse.setCompanyName(company.getCompanyName());
        companyResponse.setLocatedCountry(company.getLocatedCountry());
        return companyResponse;
    }


    public List<CompanyResponse> viewCompanies(List<Company> companies) {
        List<CompanyResponse> companyResponses = new ArrayList<>();
        for (Company c : companies) {
            companyResponses.add(viewCompany(c));
        }
        return companyResponses;
    }


    public void updateCompany(Company company, CompanyRequest companyRequest) {
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());

    }
}
