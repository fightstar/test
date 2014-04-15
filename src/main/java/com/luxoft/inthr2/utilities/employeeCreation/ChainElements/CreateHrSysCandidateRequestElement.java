package com.luxoft.inthr2.utilities.employeeCreation.ChainElements;

/**
 * Created with IntelliJ IDEA.
 * User: ihnedysh
 * Date: 26.11.13
 * Time: 19:55
 * To change this template use File | Settings | File Templates.
 */
/*
public abstract class CreateHrSysCandidateRequestElement implements IEmployeeCreationChainElement {

    private EnvironmentConfiguration _configuration;

    public CreateHrSysCandidateRequestElement(EnvironmentConfiguration configuration){
        if(configuration == null){
            throw new IllegalArgumentException("configuration is null");
        }

        _configuration = configuration;
    }

    @Override
    public EmployeeData Process(EmployeeData data) {
        String sql = String.format(getSqlTemplate(), data.firstName, data.lastName);

       */
/* DB db  = DB.Create(_configuration.getMainDbConnectionString());
        db.executeSelectQuery(sql);*//*


        return data;
    }

    @Override
    public IEmployeeCreationChainElement GetNext() {
        return new ApproveHrSysCandidateRequestElement(_configuration);
    }

    private String getSqlTemplate(){
        return "INSERT INTO [IntHR2].[dbo].HRSysCandidateRequest (xxxxxx) values (xxxxxxxx)";
    }
}
*/
