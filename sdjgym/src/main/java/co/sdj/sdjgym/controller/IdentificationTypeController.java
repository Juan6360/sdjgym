package co.sdj.sdjgym.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.sdj.crosscutting.exceptions.SdjApplicationException;
import co.sdj.sdjgym.businesslogic.facade.identificationType.impl.FindIdentificationTypeFacadeImpl;
import co.sdj.sdjgym.controller.response.GenerateResponse;
import co.sdj.sdjgym.controller.response.concrete.IdentificationTypeResponse;
import co.sdj.sdjgym.dto.IdentificationTypeDTO;

@RestController
@RequestMapping("/api/v1/identificationtypes")
public final class IdentificationTypeController {
    
    private final FindIdentificationTypeFacadeImpl findIdentificationType;
    private static final Logger logger = LoggerFactory.getLogger(IdentificationTypeController.class);

    @Autowired
    public IdentificationTypeController(FindIdentificationTypeFacadeImpl findIdentificationType) {
        this.findIdentificationType = findIdentificationType;
    }
    
    @GetMapping
    public ResponseEntity<IdentificationTypeResponse> retrieveAll() {
        var messages = new ArrayList<String>();
        List<IdentificationTypeDTO> list = new ArrayList<>();
        
        try {
            list = findIdentificationType.execute(IdentificationTypeDTO.create());
            messages.add("Los tipos de identificación se consultaron de forma satisfactoria");
        } catch (final SdjApplicationException exception) {
            messages.add(exception.getMessage());
            logger.error("Error al recuperar los tipos de identificación", exception);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new IdentificationTypeResponse());
        } catch (final Exception exception) {
            messages.add("Se ha presentado un problema inesperado al consultar los tipos de identificación");
            logger.error("Se produjo un error inesperado", exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new IdentificationTypeResponse());
        }
        
        IdentificationTypeResponse responseWithData = new IdentificationTypeResponse();
        responseWithData.setData(list);
        responseWithData.setMessages(messages);
        
        return ResponseEntity.ok(responseWithData);
    }
}
