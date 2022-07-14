package peaksoft.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.mapper.CompanyMapper;
import peaksoft.model.Company;
import peaksoft.repository.CompanyRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;


    @Override
    public CompanyResponse saveCompany(CompanyRequest company) {
        return companyMapper.viewCompany(companyRepository.save(companyMapper.saveCompany(company)));
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company>companies=companyRepository.findAll();
        return companies;
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.getById(id);
    }

    @Override
    public void deleteCompany(Long id) {
        Company company = companyRepository.findById(id).get();
        companyRepository.deleteById(id);
        companyMapper.viewCompany(company);

    }

    @Override
    public CompanyResponse updateCompany(Long id, CompanyRequest company) {
        Company company1 = companyRepository.findById(id).get();
        companyMapper.updateCompany(company1, company);
       return companyMapper.viewCompany(companyRepository.save(company1));
    }
}
