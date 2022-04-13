package clinicaDH.service;

import clinicaDH.dto.PacienteDto;

public interface IPacienteService extends ICRUDService<PacienteDto>{
    public PacienteDto findOneByEmail(String email);
}
