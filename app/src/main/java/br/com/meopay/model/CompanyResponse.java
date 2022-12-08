package br.com.meopay.model;

public class CompanyResponse {

    public CompanyResponse() {}

    private CompanyData company;

    public CompanyData getCompany() {
        return company;
    }

    public void setCompany(CompanyData company) {
        this.company = company;
    }
}
