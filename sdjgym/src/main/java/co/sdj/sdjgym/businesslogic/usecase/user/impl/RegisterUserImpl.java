package co.sdj.sdjgym.businesslogic.usecase.user.impl;


import java.util.UUID;
import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.entity.UserEntityAdapter;
import co.sdj.sdjgym.businesslogic.usecase.user.RegisterUser;
import co.sdj.sdjgym.businesslogic.usecase.user.city.rules.CityExists;
import co.sdj.sdjgym.businesslogic.usecase.user.city.rules.impl.CityExistsImpl;
import co.sdj.sdjgym.businesslogic.usecase.user.eps.rules.EpsExists;
import co.sdj.sdjgym.businesslogic.usecase.user.eps.rules.impl.EpsExistsImpl;
import co.sdj.sdjgym.businesslogic.usecase.user.identificationType.rules.IdentificationTypeExists;
import co.sdj.sdjgym.businesslogic.usecase.user.identificationType.rules.impl.IdentificationTypeExistsImpl;
import co.sdj.sdjgym.businesslogic.usecase.user.state.rules.StateExists;
import co.sdj.sdjgym.businesslogic.usecase.user.state.rules.impl.StateExistsImpl;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.domain.UserDomain;
import co.sdj.sdjgym.businesslogic.usecase.user.rules.impl.UserStringConsistencyIsValidImpl;
import co.sdj.sdjgym.businesslogic.usecase.user.rules.UserStringConsistencyIsValid;
import co.sdj.sdjgym.businesslogic.usecase.user.rules.impl.UserNumberConsistencyIsValidImpl;
import co.sdj.sdjgym.businesslogic.usecase.user.rules.UserNumberConsistencyIsValid;
import co.sdj.sdjgym.businesslogic.usecase.user.rules.impl.UserBirthdayConsistencyIsValidImpl;
import co.sdj.sdjgym.businesslogic.usecase.user.rules.UserBirthdayConsistencyIsValid;



public final class RegisterUserImpl implements RegisterUser {
    
    private DAOFactory daoFactory;

    private UserStringConsistencyIsValid userStringConsistencyIsValid = new UserStringConsistencyIsValidImpl();
    private UserNumberConsistencyIsValid userNumberConsistencyIsValid = new UserNumberConsistencyIsValidImpl();
    private UserBirthdayConsistencyIsValid userBirthdayConsistencyIsValid = new UserBirthdayConsistencyIsValidImpl();
    private CityExists cityExists = new CityExistsImpl();
    private StateExists stateExists = new StateExistsImpl();
    private IdentificationTypeExists identificationTypeExists = new IdentificationTypeExistsImpl();
    private EpsExists epsExists = new EpsExistsImpl();
    
    public RegisterUserImpl(final DAOFactory daoFactory) {
        setDaoFactory(daoFactory);
    }

    @Override
    public void execute(final UserDomain data) {
        
        userStringConsistencyIsValid.execute(data.getFirstName());
        userStringConsistencyIsValid.execute(data.getMiddleName());
        userStringConsistencyIsValid.execute(data.getFirstSurName());
        userStringConsistencyIsValid.execute(data.getSecondSurName());

        
        cityExists.execute(data.getCity().getId(), daoFactory);
        stateExists.execute(data.getState().getId(), daoFactory);
        identificationTypeExists.execute(data.getIdentificationType().getId(), daoFactory);
        epsExists.execute(data.getEps().getId(), daoFactory);
        
        
        userNumberConsistencyIsValid.execute(data.getPhoneNumber());
        userNumberConsistencyIsValid.execute(data.getEmergencyNumber());
        userNumberConsistencyIsValid.execute(data.getIdentificacion());
        
        userBirthdayConsistencyIsValid.execute(data.getBirthDate());
        
        var userDomainToMap = UserDomain.create(
            generateId(),
            data.getFirstName(),
            data.getMiddleName(),
            data.getFirstSurName(),
            data.getSecondSurName(),
            data.getPhoneNumber(),
            data.getEmergencyNumber(),
            data.getEmail(),
            data.getBirthDate(),
            data.getIdentificationType(),
            data.getIdentificacion(),
            data.getEps(),
            data.getAddress(),
            data.getState(),
            data.getCity()
        );

        var userEntity = UserEntityAdapter.getUserEntityAdapter().adaptSource(userDomainToMap);
        daoFactory.getUserDAO().create(userEntity);
    }

    private UUID generateId() {
        var id = UUIDHelper.generate();
        var userEntity = daoFactory.getUserDAO().findByID(id);
        
        if (UUIDHelper.isEqual(userEntity.getId(), id)) {
            id = generateId();
        }
        return id;
    }
    
    private void setDaoFactory(final DAOFactory daoFactory) {
        if (ObjectHelper.isNull(daoFactory)) {
            var userMessage = "Se ha presentado un problema inesperado, tratando de llevar a cabo el registro de la información de la nueva ciudad deseada. Por favor intente de nuevo y si el problema persiste, llame a Luz Mery Ríos Alzate...";
            var technicalMessage = "El dao factory requerido para crear la clase que actualiza la ciudad llegó nula...";
            throw BusinessLogicSdjException.crear(userMessage, technicalMessage);
        }

        this.daoFactory = daoFactory;
    }
}
