package com.supportportal.service;

import java.util.Date;
import java.util.List;

import com.supportportal.entity.Candidat;



public interface CandidatService {

    List<Candidat> getAllCandidats();

    Candidat getCandidatById(Long idCandidats);

    void deleteCandidat(Long idCandidats);

	Candidat addCandidat(String nomPrenom, String cin, String tel, String adresse, String niveau, String diplome,
			String famille, String postPropose, String contact, String observation, Date date,
			List<Long> offresEmploiIds);

	Candidat updateCandidat(Long idCandidat, String nomPrenom, String cin, String tel, String adresse, String niveau,
			String diplome, String famille, String postPropose, String contact, String observation, Date date,
			List<Long> offresEmploiIds);
}
